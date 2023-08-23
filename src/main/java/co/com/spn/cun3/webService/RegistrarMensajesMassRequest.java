//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.08.22 a las 09:25:09 PM COT 
//


package co.com.spn.cun3.webService;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Asunto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Texto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NombreDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CorreoDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Adjuntos" type="{http://www.sealmail.co/}adjuntos" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Alertas" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Recordatorio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CorreoCertificado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "asunto",
    "texto",
    "nombreDestinatario",
    "correoDestinatario",
    "adjuntos",
    "alertas",
    "recordatorio",
    "correoCertificado",
    "fechaVencimiento"
})
@XmlRootElement(name = "RegistrarMensajesMassRequest")
public class RegistrarMensajesMassRequest {

    @XmlElement(required = true)
    protected String idUsuario;
    @XmlElement(name = "Asunto", required = true)
    protected String asunto;
    @XmlElement(name = "Texto", required = true)
    protected String texto;
    @XmlElement(name = "NombreDestinatario", required = true)
    protected String nombreDestinatario;
    @XmlElement(name = "CorreoDestinatario", required = true)
    protected String correoDestinatario;
    @XmlElement(name = "Adjuntos")
    protected List<Adjuntos> adjuntos;
    @XmlElement(name = "Alertas")
    protected boolean alertas;
    @XmlElement(name = "Recordatorio")
    protected Integer recordatorio;
    @XmlElement(name = "CorreoCertificado")
    protected Boolean correoCertificado;
    @XmlElement(name = "FechaVencimiento")
    protected String fechaVencimiento;

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
     * Obtiene el valor de la propiedad asunto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Define el valor de la propiedad asunto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsunto(String value) {
        this.asunto = value;
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
     * Obtiene el valor de la propiedad nombreDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    /**
     * Define el valor de la propiedad nombreDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDestinatario(String value) {
        this.nombreDestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad correoDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreoDestinatario() {
        return correoDestinatario;
    }

    /**
     * Define el valor de la propiedad correoDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreoDestinatario(String value) {
        this.correoDestinatario = value;
    }

    /**
     * Gets the value of the adjuntos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adjuntos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdjuntos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Adjuntos }
     * 
     * 
     */
    public List<Adjuntos> getAdjuntos() {
        if (adjuntos == null) {
            adjuntos = new ArrayList<Adjuntos>();
        }
        return this.adjuntos;
    }

    /**
     * Obtiene el valor de la propiedad alertas.
     * 
     */
    public boolean isAlertas() {
        return alertas;
    }

    /**
     * Define el valor de la propiedad alertas.
     * 
     */
    public void setAlertas(boolean value) {
        this.alertas = value;
    }

    /**
     * Obtiene el valor de la propiedad recordatorio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecordatorio() {
        return recordatorio;
    }

    /**
     * Define el valor de la propiedad recordatorio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecordatorio(Integer value) {
        this.recordatorio = value;
    }

    /**
     * Obtiene el valor de la propiedad correoCertificado.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCorreoCertificado() {
        return correoCertificado;
    }

    /**
     * Define el valor de la propiedad correoCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCorreoCertificado(Boolean value) {
        this.correoCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVencimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Define el valor de la propiedad fechaVencimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaVencimiento(String value) {
        this.fechaVencimiento = value;
    }

}
