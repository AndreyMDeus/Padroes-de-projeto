package amd.padroesprojeto.padroes.service.implementa;


import amd.padroesprojeto.padroes.domain.Cliente;
import amd.padroesprojeto.padroes.domain.Endereco;
import amd.padroesprojeto.padroes.repository.ClienteRepository;
import amd.padroesprojeto.padroes.repository.EnderecoRepository;
import amd.padroesprojeto.padroes.service.ClienteService;
import amd.padroesprojeto.padroes.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>
 *
 * @author Andrey
 *
 * Obs: TODO (coisas para fazer) FIXME (coisas para resolver)
 */

@Service
public class ClienteServiceImplementa implements ClienteService {

    // TODO Singleton: Injetar os componentes do Spring com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    // TODO Singleton: Injetar a dependência do cliente HTTP para consumir a API viaCEP
    @Autowired
    private ViaCepService viaCepService;

    // TODO Strategy: Implementar os métodos definidos na interface
    // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // FIXME Buscar Cliente por Id.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // FIXME Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        /* Se o endereço não existir irá cair no call back que retornará null */
        // FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno.
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // FIXME Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // FIXME Buscar Cliente por Id, caso exista;
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            // FIXME Verificar se o Endereco do Cliente já existe (pelo CEP).
            // FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno.
            // FIXME Alterar Cliente, vinculando o Endereco (novo ou existente).
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        // FIXME Deletar Cliente por Id.
        clienteRepository.deleteById(id);

    }



}
