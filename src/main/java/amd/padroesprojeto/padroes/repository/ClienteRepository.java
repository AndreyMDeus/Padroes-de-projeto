package amd.padroesprojeto.padroes.repository;

import amd.padroesprojeto.padroes.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * O CrudRepository é uma Strategy que implementa o CRUD
 */

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
