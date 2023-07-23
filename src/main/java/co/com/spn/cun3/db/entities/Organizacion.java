package co.com.spn.cun3.db.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "organizacion")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id", nullable = false)
    private Integer org_id;

    @Column(name = "org_nombre", nullable = false)
    private String org_nombre;

    @Column(name = "org_dominiodeemicion")
    private String org_dominiodeemicion;

    @Column(name = "org_subdominio")
    private String org_subdominio;

    @Column(name = "org_usuariosubdominio", nullable = false)
    private String org_usuariosubdominio;

    @Column(name = "org_clave", nullable = false)
    private String org_clave;

    @Column(name = "org_creado", nullable = false)
    @Builder.Default
    private Instant org_creado = Instant.now();

    @Column(name = "org_actualizado", nullable = false)
    @Builder.Default
    private Instant org_actualizado = Instant.now();

    @Column(name = "org_estado", nullable = false)
    private Integer org_estado;

    @Column(name = "org_nit", nullable = false)
    private String org_nit;
}

