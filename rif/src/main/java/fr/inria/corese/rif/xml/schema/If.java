//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.24 at 10:15:40 AM CEST 
//


package fr.inria.corese.rif.xml.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.w3.org/2007/rif#}FORMULA"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"and",
		"or",
		"exists",
		"atom",
		"equal",
		"member",
		"subclass",
		"frame",
		"external"
})
@XmlRootElement(name = "if")
public class If {

	@XmlElement(name = "And")
	protected And and;
	@XmlElement(name = "Or")
	protected Or or;
	@XmlElement(name = "Exists")
	protected Exists exists;
	@XmlElement(name = "Atom")
	protected Atom atom;
	@XmlElement(name = "Equal")
	protected Equal equal;
	@XmlElement(name = "Member")
	protected Member member;
	@XmlElement(name = "Subclass")
	protected Subclass subclass;
	@XmlElement(name = "Frame")
	protected Frame frame;
	@XmlElement(name = "External")
	protected ExternalFORMULAType external;

	/**
	 * Gets the value of the and property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link And }
	 *     
	 */
	public And getAnd() {
		return and;
	}

	/**
	 * Sets the value of the and property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link And }
	 *     
	 */
	public void setAnd(And value) {
		this.and = value;
	}

	/**
	 * Gets the value of the or property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Or }
	 *     
	 */
	public Or getOr() {
		return or;
	}

	/**
	 * Sets the value of the or property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Or }
	 *     
	 */
	public void setOr(Or value) {
		this.or = value;
	}

	/**
	 * Gets the value of the exists property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Exists }
	 *     
	 */
	public Exists getExists() {
		return exists;
	}

	/**
	 * Sets the value of the exists property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Exists }
	 *     
	 */
	public void setExists(Exists value) {
		this.exists = value;
	}

	/**
	 * Gets the value of the atom property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Atom }
	 *     
	 */
	public Atom getAtom() {
		return atom;
	}

	/**
	 * Sets the value of the atom property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Atom }
	 *     
	 */
	public void setAtom(Atom value) {
		this.atom = value;
	}

	/**
	 * Gets the value of the equal property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Equal }
	 *     
	 */
	public Equal getEqual() {
		return equal;
	}

	/**
	 * Sets the value of the equal property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Equal }
	 *     
	 */
	public void setEqual(Equal value) {
		this.equal = value;
	}

	/**
	 * Gets the value of the member property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Member }
	 *     
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * Sets the value of the member property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Member }
	 *     
	 */
	public void setMember(Member value) {
		this.member = value;
	}

	/**
	 * Gets the value of the subclass property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Subclass }
	 *     
	 */
	public Subclass getSubclass() {
		return subclass;
	}

	/**
	 * Sets the value of the subclass property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Subclass }
	 *     
	 */
	public void setSubclass(Subclass value) {
		this.subclass = value;
	}

	/**
	 * Gets the value of the frame property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Frame }
	 *     
	 */
	public Frame getFrame() {
		return frame;
	}

	/**
	 * Sets the value of the frame property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Frame }
	 *     
	 */
	public void setFrame(Frame value) {
		this.frame = value;
	}

	/**
	 * Gets the value of the external property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link ExternalFORMULAType }
	 *     
	 */
	public ExternalFORMULAType getExternal() {
		return external;
	}

	/**
	 * Sets the value of the external property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link ExternalFORMULAType }
	 *     
	 */
	public void setExternal(ExternalFORMULAType value) {
		this.external = value;
	}

	public fr.inria.corese.rif.api.IFormula XML2AST() {
		if(this.and != null) {
    		// FORMULA is a conjunction
    		return this.and.XML2AST() ;
    	} else if(this.or != null) {
    		// FORMULA is a disjunction
    		return this.or.XML2AST() ;
    	} else if(this.exists != null) {
    		// FORMULA is an existentially quantified FORMULA
    		return this.exists.XMl2AST() ;
    	} else if(this.external != null) {
    		// FORMULA is an external predicate
    		return this.external.XML2AST() ;
    	} else {
    		// FORMULA is an ATOMIC (Atom, Equal, Member, Subclass, Frame)
    		// ATOMIC ::= (Atom | Equal | Member | Subclass | Frame)
    		if(this.atom != null) {
    			// ATOMIC is an Atom
    			return null ; // TODO
    		} else if(this.equal != null) {
    			// ATOMIC is a "=" binary operator
    			return this.equal.XML2AST() ;
    		} else if(this.member != null) {
    			// ATOMIC is a "#" binary operator 
    			return this.member.XML2AST() ;
    		} else if(this.subclass != null) {
    			// ATOMIC is a "##" binary operator
    			return this.subclass.XML2AST() ;
    		} else if(this.frame !=  null) {
    			// ATOMIC is a Frame
    			return this.frame.XML2AST() ;
    		}
    	}
    	return null ; // Something is wrong if we get there. Likely the XML doesn't validate against XSD.
    }

}