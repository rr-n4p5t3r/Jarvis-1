package co.com.spn.cun3.db.repositories;

import co.com.spn.cun3.db.entities.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizacionRepository extends JpaRepository<Organizacion, Integer> {
    @Query("SELECT O FROM Organizacion O WHERE O.org_usuariosubdominio = :usuario")
    Organizacion findByorg_usuariosubdominio(@Param("usuario") String usuario);

    @Query("SELECT O FROM Organizacion O WHERE O.org_dominiodeemicion = :dominio")
    List<Organizacion> organizacionesPorDominio(@Param("dominio") String dominio);

    @Query("SELECT O FROM Organizacion O WHERE O.org_dominiodeemicion = :dominio AND O.org_subdominio = :subdominio")
    Organizacion organizacionesPorDominioYSubdominio(@Param("dominio") String dominio, @Param("subdominio") String subdominio);

}