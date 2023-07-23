package co.com.spn.cun3.db.repositories;

import co.com.spn.cun3.db.entities.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperacionRepository extends JpaRepository<Operacion, Integer> {

    @Query("SELECT O FROM Operacion O WHERE O.opr_correoemisor = :idUsuario")
    List<Operacion> operacionesPorUsuario(@Param("idUsuario") String idUsuario);

    @Query("SELECT O FROM Operacion O LEFT JOIN Organizacion OG ON O.fopr_id = OG.org_id WHERE OG.org_nit = :nit")
    List<Operacion> operacionesPorNit(@Param("nit") String nit);

    @Query("SELECT O FROM Operacion O WHERE O.org_estado = 1")
    List<Operacion> operacionesActivas();

    @Query("SELECT O FROM Operacion O WHERE O.opr_asunto = :asunto AND O.opr_destinatario = :correoDestinatario AND DATE_TRUNC('day', O.opr_creado) = DATE_TRUNC('day', now())")
    List<Operacion> checkIfExists(@Param("asunto") String asunto, @Param("correoDestinatario") String correoDestinatario);

    @Query(value = "SELECT o.opr_idientificadoranddes FROM operacion o WHERE o.opr_idientificadorcliente = :operacionId AND o.opr_correoorganizacion = :usuarioId", nativeQuery = true)
    String traslateOperacionIdToAndesId(@Param("operacionId") String operacionId, @Param("usuarioId") String usuarioId);

}