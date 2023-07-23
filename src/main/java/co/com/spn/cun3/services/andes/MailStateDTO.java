package co.com.spn.cun3.services.andes;

import co.com.spn.cun3.services.mail.MailAttachment;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.StringTokenizer;

@Data
@ToString
public class MailStateDTO {
    Integer idMensaje;
    String estado;
    String observacion;
    Instant fecha;
    @ToString.Exclude MailAttachment mailAttachment;
    @ToString.Exclude byte[] xmlAttachment;

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
        switch (this.idMensaje) {
            case 0:
            case 1:
            case 10:
            case 11:
            case 12:
            case 13:
            case 31:
                this.estado = "INDEFINIDO";
                break;
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
                this.estado = "ENTREGADO";
                break;
            default:
                this.estado = "NO ENTREGADO";
        }
    }

    public void setObservacion(String observacion) {
        if (this.estado.equals("ENTREGADO")) {
            StringTokenizer stringTokenizer = new StringTokenizer(observacion, "|");
            long timestamp = Long.parseLong(stringTokenizer.nextToken()) * 1000L;
            this.fecha = Instant.ofEpochMilli(timestamp);
            this.observacion = stringTokenizer.nextToken();
        } else {
            this.observacion = observacion;
        }
    }
}
