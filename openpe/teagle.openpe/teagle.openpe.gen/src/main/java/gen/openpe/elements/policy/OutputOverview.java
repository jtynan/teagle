//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.01 at 03:44:55 PM MESZ 
//


package gen.openpe.elements.policy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for outputOverview complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="outputOverview">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="decision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originatortype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targettype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="event" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="evaluationOutput" type="{http://gen/openpe/elements/policy}evaluationOutput" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outputOverview", propOrder = {
    "decision",
    "originator",
    "originatortype",
    "target",
    "targettype",
    "event",
    "time",
    "id",
    "evaluationOutput"
})
public class OutputOverview {

    @XmlElement(required = true)
    protected String decision;
    @XmlElement(required = true)
    protected String originator;
    @XmlElement(required = true)
    protected String originatortype;
    @XmlElement(required = true)
    protected String target;
    @XmlElement(required = true)
    protected String targettype;
    @XmlElement(required = true)
    protected String event;
    @XmlElement(required = true)
    protected String time;
    protected long id;
    @XmlElement(required = true)
    protected List<EvaluationOutput> evaluationOutput;

    /**
     * Gets the value of the decision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecision() {
        return decision;
    }

    /**
     * Sets the value of the decision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecision(String value) {
        this.decision = value;
    }

    /**
     * Gets the value of the originator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * Sets the value of the originator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginator(String value) {
        this.originator = value;
    }

    /**
     * Gets the value of the originatortype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatortype() {
        return originatortype;
    }

    /**
     * Sets the value of the originatortype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatortype(String value) {
        this.originatortype = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the targettype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargettype() {
        return targettype;
    }

    /**
     * Sets the value of the targettype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargettype(String value) {
        this.targettype = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the evaluationOutput property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evaluationOutput property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvaluationOutput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvaluationOutput }
     * 
     * 
     */
    public List<EvaluationOutput> getEvaluationOutput() {
        if (evaluationOutput == null) {
            evaluationOutput = new ArrayList<EvaluationOutput>();
        }
        return this.evaluationOutput;
    }

}