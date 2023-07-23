package co.com.spn.cun3.db.repositories;

import co.com.spn.cun3.db.entities.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error, Integer> {

}