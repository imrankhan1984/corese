package fr.inria.corese.sparql.cg.datatype;

import fr.inria.corese.sparql.api.IDatatype;

public  class CoreseMonth extends CoreseInteger {
	static final CoreseURI datatype=new CoreseURI(RDF.xsdmonth);

	public CoreseMonth(String value) {
		super(value);
	}
	
        @Override
	 public IDatatype getDatatype(){
	       return datatype;
	     }
}