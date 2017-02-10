/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.inria.edelweiss.kgraph.query;

import fr.inria.acacia.corese.api.IDatatype;
import fr.inria.acacia.corese.cg.datatype.DatatypeMap;
import fr.inria.acacia.corese.triple.parser.Context;
import fr.inria.acacia.corese.triple.parser.NSManager;
import fr.inria.edelweiss.kgram.api.core.Entity;
import fr.inria.edelweiss.kgram.api.core.Expr;
import fr.inria.edelweiss.kgram.api.core.Node;
import fr.inria.edelweiss.kgram.api.query.Environment;
import fr.inria.edelweiss.kgram.api.query.Producer;
import fr.inria.edelweiss.kgraph.core.Graph;
import fr.inria.edelweiss.kgtool.load.Load;
import fr.inria.edelweiss.kgtool.load.LoadException;
import fr.inria.edelweiss.kgtool.load.QueryLoad;
import fr.inria.edelweiss.kgtool.transform.TemplateVisitor;
import fr.inria.edelweiss.kgtool.transform.Transformer;
import java.io.IOException;
import java.util.HashMap;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Manage extended named graph 
 * 
 * @author Olivier Corby, Wimmics INRIA I3S, 2014
 *
 */
public class ExtendGraph {
    static Logger logger = LogManager.getLogger(ExtendGraph.class);
    
    private static final String KGEXT     = NSManager.KGEXT;
    private static final String KGEXTQUERY = NSManager.KGEXTCONS;    
    private static final String QUERY = "/query/";
    private static final String STL_DATASET = Context.STL_DATASET;

    private static final int EXT_DESCRIBE = 0;
    private static final int EXT_QUERY    = 1;
    private static final int EXT_QUERIES  = 2;
    private static final int EXT_ENGINE   = 3;
    private static final int EXT_RECORD   = 4;
    private static final int EXT_STACK    = 5;
    private static final int EXT_VISITED  = 6;
    private static final int EXT_DATASET  = 7;
    
    HashMap<String, Integer> map;
    PluginImpl plugin;

    ExtendGraph(PluginImpl p){
        plugin = p;
        init();
    }
    
     void init(){
        map = new HashMap();
        map.put(KGEXT + "describe", EXT_DESCRIBE);
        map.put(KGEXT + "system",   EXT_DESCRIBE);
        map.put(KGEXT + "query",    EXT_QUERY);
        map.put(KGEXT + "queries",  EXT_QUERIES);
        map.put(KGEXT + "engine",   EXT_ENGINE);
        map.put(KGEXT + "record",   EXT_RECORD);
        map.put(KGEXT + "stack",    EXT_STACK);
        map.put(KGEXT + "visited",  EXT_VISITED);
        map.put(KGEXT + "dataset",  EXT_DATASET);
    }
    
     /**
     * graph eng:describe {}
     * ->
     * bind (kg:extension(eng:describe) as ?g)
     * graph ?g { }
     */
     Object extension(Producer p, Expr exp, Environment env, IDatatype dt) {
         if (dt.getLabel().startsWith(KGEXTQUERY)){
             return eval(p, exp, env, dt);
         }
         switch (map.get(dt.getLabel())){
             case EXT_DESCRIBE: return describe(p, exp, env);
             case EXT_QUERY:    return query(p, exp, env, null);
             case EXT_QUERIES:  return query(p, exp, env, DatatypeMap.MINUSONE);
             case EXT_ENGINE:   return engine(p, exp, env);
             case EXT_RECORD:   return record(p, exp, env);
             case EXT_STACK:    return stack(p, exp, env);
             case EXT_VISITED:  return visited(p, exp, env);
             case EXT_DATASET:  return plugin.getPluginTransform().get(exp, env, p, STL_DATASET);
         }        
         return null;
    }
    
    
    
      IDatatype create(String name, Object obj, String sdt){
        return DatatypeMap.createObject(name, obj, sdt);
    }
    
    /**
     * 
     * Take a picture of the memory stack as a Graph
     */
     Object stack(Producer p, Expr exp, Environment env){
        Graph g = Graph.create();
        for (Entity e : env.getEdges()){
            if (e != null){
                g.copy(e);
            }
        }
        IDatatype dt = create("stack", g, IDatatype.GRAPH);
        return dt;
    }
    
    /**
     * SPIN graph of rules of a rule engine  
     */
    Object engine(Producer p, Expr exp, Environment env) {
        Graph g = getGraph(p);
        Node q = g.getContext().getRuleEngineNode();
        return q;
    }
    
    Object visited(Producer p, Expr exp, Environment env) {
        TemplateVisitor vis = plugin.getVisitor(env, p);
        if (vis == null){
            return null;
        }
        return vis.visitedGraphNode();
    }

   
     Object record(Producer p, Expr exp, Environment env) {
        Graph g = getGraph(p);
        Node q = g.getContext().getRecordNode();       
        return q;
    }
   
    Object query(Producer p, Expr exp, Environment env, IDatatype dt) {
        Graph g = getGraph(p);
        Node q;
        if (dt == null){
            q = g.getContext().getQueryNode();
        }
        else {
           q = g.getContext().getQueryNode(dt.intValue()); 
        }
        if (q == null){
            q = create("query", env.getQuery(), IDatatype.QUERY);
        }
        return q;
    }

      Object load(Producer p, Expr exp, Environment env, IDatatype dt) {
         Graph g = Graph.create();
         Load ld = Load.create(g);
         try {
             if (PluginImpl.readWriteAuthorized){
                ld.parse(dt.getLabel(), Load.TURTLE_FORMAT);
             }
         } catch (LoadException ex) {
             logger.error("Load error: " + dt);
         }
        IDatatype res = create("load", g, IDatatype.GRAPH);
        return res;
    }
    
     Object describe(Producer p, Expr exp, Environment env) {
        Graph g = (Graph) p.getGraph();
        IDatatype res = create("index", g.describe(), IDatatype.GRAPH);
        return res;
    }
         

    /**
     * obj has getObject() which is Graphable
     * store the graph has an extended named graph
     */
     Object store(Producer p, Environment env, IDatatype name, IDatatype obj) {
        if (p.isProducer(obj)){
            Producer pp = p.getProducer(obj, env);
            Graph g = (Graph) p.getGraph();
            g.setNamedGraph(name.getLabel(), (Graph) pp.getGraph());        
        }
        return obj;
    }
    
    
     Graph getGraph(Producer p) {
        if (p.getGraph() instanceof Graph) {
            return (Graph) p.getGraph();
        }
        return null;
    }

    private Object eval(Producer p, Expr exp, Environment env, IDatatype dt) {
       try {
            String q = load(dt.getLabel());
            Node res = plugin.kgram(env, getGraph(p), q, null);
            return res;
        } catch (IOException ex) {
            return null;
        }
        
    }
    
    String load(String label) throws IOException {
        String str = label.substring(KGEXTQUERY.length()) + ".rq";
        QueryLoad ql = QueryLoad.create();
        return ql.getResource(QUERY + str);
    }
    
    
}
