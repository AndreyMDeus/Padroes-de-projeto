package amd.padroesprojeto.padroes.service;

import amd.padroesprojeto.padroes.domain.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com isso,
 * se necessário, podemos ter multiplas implementações dessa mesma interface.
 *
 * @author Andrey
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long Id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
