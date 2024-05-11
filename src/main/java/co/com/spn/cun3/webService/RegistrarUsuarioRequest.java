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
 *         &lt;element name="TipoDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NumeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Nombres" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Apellidos" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Correo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TipoPersona" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="TipoRegimen" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Ciudad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Direccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NoFactura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Cupo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "tipoDocumento",
    "numeroDocumento",
    "nombres",
    "apellidos",
    "correo",
    "tipoPersona",
    "tipoRegimen",
    "ciudad",
    "direccion",
    "telefono",
    "noFactura",
    "cupo"
})
@XmlRootElement(name = "RegistrarUsuarioRequest")
public class RegistrarUsuarioRequest {

    @XmlElement(required = true)
    protected String idUsuario;
    @XmlElement(name = "TipoDocumento")
    protected int tipoDocumento;
    @XmlElement(name = "NumeroDocumento", required = true)
    protected String numeroDocumento;
    @XmlElement(name = "Nombres", required = true)
    protected String nombres;
    @XmlElement(name = "Apellidos", required = true)
    protected String apellidos;
    @XmlElement(name = "Correo", required = true)
    protected String correo;
    @XmlElement(name = "TipoPersona")
    protected int tipoPersona;
    @XmlElement(name = "TipoRegimen")
    protected int tipoRegimen;
    @XmlElement(name = "Ciudad")
    protected int ciudad;
    @XmlElement(name = "Direccion", required = true)
    protected String direccion;
    @XmlElement(name = "Telefono", required = true)
    protected String telefono;
    @XmlElement(name = "NoFactura", required = true)
    protected String noFactura;
    @XmlElement(name = "Cupo")
    protected int cupo;

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
     * Obtiene el valor de la propiedad tipoDocumento.
     * 
     */
    public int getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumento.
     * 
     */
    public void setTipoDocumento(int value) {
        this.tipoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Define el valor de la propiedad numeroDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad nombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Define el valor de la propiedad nombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombres(String value) {
        this.nombres = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Define el valor de la propiedad apellidos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidos(String value) {
        this.apellidos = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreo(String value) {
        this.correo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoPersona.
     * 
     */
    public int getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Define el valor de la propiedad tipoPersona.
     * 
     */
    public void setTipoPersona(int value) {
        this.tipoPersona = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoRegimen.
     * 
     */
    public int getTipoRegimen() {
        return tipoRegimen;
    }

    /**
     * Define el valor de la propiedad tipoRegimen.
     * 
     */
    public void setTipoRegimen(int value) {
        this.tipoRegimen = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     */
    public int getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     */
    public void setCiudad(int value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad noFactura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoFactura() {
        return noFactura;
    }

    /**
     * Define el valor de la propiedad noFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoFactura(String value) {
        this.noFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad cupo.
     * 
     */
    public int getCupo() {
        return cupo;
    }

    /**
     * Define el valor de la propiedad cupo.
     * 
     */
    public void setCupo(int value) {
        this.cupo = value;
    }

}
