package co.com.spn.cun3.db.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "operacion")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Operacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opr_id", nullable = false)
    private Integer opr_id;

    @Column(name = "fopr_id", nullable = false)
    private Integer fopr_id;

    @Column(name = "opr_idientificadorcliente")
    private String opr_idientificadorcliente;

    @Column(name = "opr_idientificadoranddes")
    private String opr_idientificadoranddes;

    @Column(name = "opr_correoemisor", nullable = false)
    private String opr_correoemisor;

    @Column(name = "opr_creado", nullable = false)
    @Builder.Default
    private Instant opr_creado = Instant.now();

    @Column(name = "opr_actualizado", nullable = false)
    @Builder.Default
    private Instant opr_actualizado = Instant.now();

    @Column(name = "opr_estado", nullable = false)
    @Builder.Default
    private Integer org_estado = 1;

    @Column(name = "opr_asunto", nullable = false)
    private String opr_asunto;

    @Column(name = "opr_correoorganizacion", nullable = false)
    private String opr_correoorganizacion;

    @Column(name = "opr_destinatario", nullable = false)
    @Builder.Default
    private String opr_destinatario = "No Disponible";

    @Override
    public String toString() {
        return String.format("Cargado de %s el correo con asunto %s hacia el destinatario %s con id andes: %s", this.getOpr_correoorganizacion(), this.opr_asunto, this.opr_destinatario, this.opr_idientificadoranddes);
    }
}

