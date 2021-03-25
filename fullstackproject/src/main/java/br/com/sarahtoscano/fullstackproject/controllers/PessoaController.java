package br.com.sarahtoscano.fullstackproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sarahtoscano.fullstackproject.domain.Pessoa;
import br.com.sarahtoscano.fullstackproject.repository.PessoaRepository;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }
    
    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);

    }

    @PutMapping("{codigo}")
    public Pessoa atualizar (@PathVariable("codigo") Long codigo, 
    @RequestBody Pessoa pessoa){
        return pessoaRepository.findById(codigo).map(
            record -> {
                record.setCpf(pessoa.getCpf());
                record.setDataNascimento(pessoa.getDataNascimento());
                record.setEmail(pessoa.getEmail());
                record.setNome(pessoa.getNome());
                record.setTelefone(pessoa.getTelefone());
                record.setIdade(pessoa.getIdade());
                return pessoaRepository.save(record);
            }).orElse(null);
    }




}