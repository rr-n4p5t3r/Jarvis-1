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
 *         &lt;element name="NombreIdentidad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EmailIdentidad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NombreGrupo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TipoDocAsociado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DocumentoAsociado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NombreAsociado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ApellidoAsociado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "nombreIdentidad",
    "emailIdentidad",
    "nombreGrupo",
    "tipoDocAsociado",
    "documentoAsociado",
    "nombreAsociado",
    "apellidoAsociado",
    "idUsuario"
})
@XmlRootElement(name = "CrearIdentidadRequest")
public class CrearIdentidadRequest {

    @XmlElement(name = "NombreIdentidad", required = true)
    protected String nombreIdentidad;
    @XmlElement(name = "EmailIdentidad", required = true)
    protected String emailIdentidad;
    @XmlElement(name = "NombreGrupo", required = true)
    protected String nombreGrupo;
    @XmlElement(name = "TipoDocAsociado")
    protected int tipoDocAsociado;
    @XmlElement(name = "DocumentoAsociado", required = true)
    protected String documentoAsociado;
    @XmlElement(name = "NombreAsociado", required = true)
    protected String nombreAsociado;
    @XmlElement(name = "ApellidoAsociado", required = true)
    protected String apellidoAsociado;
    @XmlElement(required = true)
    protected String idUsuario;

    /**
     * Obtiene el valor de la propiedad nombreIdentidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreIdentidad() {
        return nombreIdentidad;
    }

    /**
     * Define el valor de la propiedad nombreIdentidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreIdentidad(String value) {
        this.nombreIdentidad = value;
    }

    /**
     * Obtiene el valor de la propiedad emailIdentidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailIdentidad() {
        return emailIdentidad;
    }

    /**
     * Define el valor de la propiedad emailIdentidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailIdentidad(String value) {
        this.emailIdentidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreGrupo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    /**
     * Define el valor de la propiedad nombreGrupo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreGrupo(String value) {
        this.nombreGrupo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocAsociado.
     * 
     */
    public int getTipoDocAsociado() {
        return tipoDocAsociado;
    }

    /**
     * Define el valor de la propiedad tipoDocAsociado.
     * 
     */
    public void setTipoDocAsociado(int value) {
        this.tipoDocAsociado = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoAsociado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoAsociado() {
        return documentoAsociado;
    }

    /**
     * Define el valor de la propiedad documentoAsociado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoAsociado(String value) {
        this.documentoAsociado = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAsociado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAsociado() {
        return nombreAsociado;
    }

    /**
     * Define el valor de la propiedad nombreAsociado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAsociado(String value) {
        this.nombreAsociado = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoAsociado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoAsociado() {
        return apellidoAsociado;
    }

    /**
     * Define el valor de la propiedad apellidoAsociado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoAsociado(String value) {
        this.apellidoAsociado = value;
    }

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

}
