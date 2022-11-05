package amd.padroesprojeto.padroes.repository;

import amd.padroesprojeto.padroes.domain.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
