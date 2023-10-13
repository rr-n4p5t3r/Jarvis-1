//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.08.23 a las 07:48:55 PM COT 
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
 *         &lt;element name="Texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Celular" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Flash" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Certificado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Adjunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NombreArchivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "texto",
    "celular",
    "flash",
    "certificado",
    "adjunto",
    "nombreArchivo"
})
@XmlRootElement(name = "RegistrarMensajeSMSRequest")
public class RegistrarMensajeSMSRequest {

    @XmlElement(required = true)
    protected String idUsuario;
    @XmlElement(name = "Texto", required = true)
    protected String texto;
    @XmlElement(name = "Celular", required = true)
    protected String celular;
    @XmlElement(name = "Flash")
    protected boolean flash;
    @XmlElement(name = "Certificado")
    protected boolean certificado;
    @XmlElement(name = "Adjunto")
    protected String adjunto;
    @XmlElement(name = "NombreArchivo")
    protected String nombreArchivo;

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
     * Obtiene el valor de la propiedad texto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Define el valor de la propiedad texto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTexto(String value) {
        this.texto = value;
    }

    /**
     * Obtiene el valor de la propiedad celular.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Define el valor de la propiedad celular.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCelular(String value) {
        this.celular = value;
    }

    /**
     * Obtiene el valor de la propiedad flash.
     * 
     */
    public boolean isFlash() {
        return flash;
    }

    /**
     * Define el valor de la propiedad flash.
     * 
     */
    public void setFlash(boolean value) {
        this.flash = value;
    }

    /**
     * Obtiene el valor de la propiedad certificado.
     * 
     */
    public boolean isCertificado() {
        return certificado;
    }

    /**
     * Define el valor de la propiedad certificado.
     * 
     */
    public void setCertificado(boolean value) {
        this.certificado = value;
    }

    /**
     * Obtiene el valor de la propiedad adjunto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjunto() {
        return adjunto;
    }

    /**
     * Define el valor de la propiedad adjunto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjunto(String value) {
        this.adjunto = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreArchivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Define el valor de la propiedad nombreArchivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreArchivo(String value) {
        this.nombreArchivo = value;
    }

}
