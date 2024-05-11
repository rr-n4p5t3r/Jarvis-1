//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.03.22 a las 02:38:54 PM COT 
//


package co.com.spn.cun3.webService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datetime" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="messagelog" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datetime",
    "idUsuario",
    "messagelog",
    "messageid"
})
@XmlRootElement(name = "GuardarLogRequest")
public class GuardarLogRequest {

    protected int datetime;
    protected int idUsuario;
    @XmlElement(required = true)
    protected String messagelog;
    @XmlElement(required = true)
    protected String messageid;

    /**
     * Obtiene el valor de la propiedad datetime.
     * 
     */
    public int getDatetime() {
        return datetime;
    }

    /**
     * Define el valor de la propiedad datetime.
     * 
     */
    public void setDatetime(int value) {
        this.datetime = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     */
    public void setIdUsuario(int value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad messagelog.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessagelog() {
        return messagelog;
    }

    /**
     * Define el valor de la propiedad messagelog.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessagelog(String value) {
        this.messagelog = value;
    }

    /**
     * Obtiene el valor de la propiedad messageid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageid() {
        return messageid;
    }

    /**
     * Define el valor de la propiedad messageid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageid(String value) {
        this.messageid = value;
    }

}
