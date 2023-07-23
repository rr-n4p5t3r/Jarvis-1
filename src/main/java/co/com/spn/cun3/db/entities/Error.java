package co.com.spn.cun3.db.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "error")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Error {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "err_id", nullable = false)
    private Integer err_id;

    @Column(name = "err_andesid", nullable = false)
    private Integer err_andesid;

    @Column(name = "err_idmensaje")
    private Integer err_idmensaje;

    @Column(name = "err_observacion")
    private String err_observacion;

    @Column(name = "err_timestamp", nullable = false)
    private Instant err_timestamp;
}

