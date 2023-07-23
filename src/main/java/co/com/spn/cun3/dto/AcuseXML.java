package co.com.spn.cun3.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "acuse")
public class AcuseXML {

    private String fechaenvio;
    private String asunto;
    private String destinatario;
    private String fecharecepcion;
    private String estadoacuse;
    private String fechavisualizacion;
    private String estadovisualizacion;

    public AcuseXML() {
    }

    @XmlElement
    public void setFechaenvio(String fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    @XmlElement
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @XmlElement
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @XmlElement
    public void setFecharecepcion(String fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    @XmlElement
    public void setEstadoacuse(String estadoacuse) {
        this.estadoacuse = estadoacuse;
    }

    @XmlElement
    public void setFechavisualizacion(String fechavisualizacion) {
        this.fechavisualizacion = fechavisualizacion;
    }

    @XmlElement
    public void setEstadovisualizacion(String estadovisualizacion) {
        this.estadovisualizacion = estadovisualizacion;
    }

    public String getFechaenvio() {
        return fechaenvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getFecharecepcion() {
        return fecharecepcion;
    }

    public String getEstadoacuse() {
        return estadoacuse;
    }

    public String getFechavisualizacion() {
        return fechavisualizacion;
    }

    public String getEstadovisualizacion() {
        return estadovisualizacion;
    }
}
