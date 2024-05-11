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
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idMensaje" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="generarPDF" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
    "idUsuario",
    "idMensaje",
    "generarPDF"
})
@XmlRootElement(name = "ObtenerTokenRequest")
public class ObtenerTokenRequest {

    @XmlElement(required = true)
    protected String idUsuario;
    protected int idMensaje;
    protected Boolean generarPDF;

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUsuario(String value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad idMensaje.
     * 
     */
    public int getIdMensaje() {
        return idMensaje;
    }

    /**
     * Define el valor de la propiedad idMensaje.
     * 
     */
    public void setIdMensaje(int value) {
        this.idMensaje = value;
    }

    /**
     * Obtiene el valor de la propiedad generarPDF.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGenerarPDF() {
        return generarPDF;
    }

    /**
     * Define el valor de la propiedad generarPDF.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGenerarPDF(Boolean value) {
        this.generarPDF = value;
    }

}
