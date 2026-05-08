package br.com.fiap3espa.auto_escola_3espa.application.core.usecase;

import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.mapper.EnderecoMapper;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.mapper.InstrutorMapper;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrutor.DadosAtualizacaoInstutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.fiap3espa.auto_escola_3espa.application.port.out.InstrutorRepository;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrutor;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrutor.InstrutorNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {
    @Autowired
    private InstrutorMapper mapper;

    @Autowired
    private InstrutorRepository repository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    // DTO recebe do front os dados, mapper traz para domain, repository salva no bd, mapper devolve para DTO, que envia para o front
    @Transactional
    public DadosDetalhamentoInstrutor cadastrarInstrutor(DadosCadastroInstrutor dados) {
        Instrutor instrutor = mapper.toDomain(dados);
        repository.save(instrutor);
        return mapper.toDetailsDTO(instrutor);
    }

    public Page<DadosListagemInstrutor> listarInstrutores(Pageable paginacao) {
        // method reference = não precisa de instanciação, faz automático
        return  repository.findAllByAtivoTrue(paginacao).map(mapper::toListDTO);
    }

    @Transactional
    public DadosDetalhamentoInstrutor atualizarInstrutor(DadosAtualizacaoInstutor dados) {
        Instrutor instrutor = repository.findById(dados.id()).orElseThrow(() ->
                new InstrutorNotFoundException("ID do instrutor informado não existe!")
        );
        instrutor.atualizarInformacoes(
                dados.nome(),
                dados.telefone(),
                enderecoMapper.toDomain(dados.endereco())
        );
        repository.save(instrutor);
        return mapper.toDetailsDTO(instrutor);


    }

    @Transactional
    public void excluirInstrutor(Long id) {
        Instrutor instrutor = repository.findById(id).orElseThrow(() ->
                new InstrutorNotFoundException("ID do instrutor informado não existe!")
        );
        instrutor.excluir();
        repository.save(instrutor);
    }

    public DadosDetalhamentoInstrutor detalharInstrutor(Long id) {
        Instrutor instrutor = repository.findById(id).orElseThrow(() ->
                new InstrutorNotFoundException("ID do instrutor informado não existe!")
        );
        return mapper.toDetailsDTO(instrutor);
    }
}
