package com.remedios.api.controller;

import com.remedios.api.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class RemedioController {

    @Autowired // todos nossos metodos podem ser usados tranquilamente aqui
    private RemedioRepository repository; //instanciamos nosso repository

    @PostMapping("/remedios")
    @Transactional
    public ResponseEntity<MessageResponse> create( @Valid @RequestBody  DataCreateDrug dados){
        var save = repository.save(new Remedio(dados));

        if(save != null){
            var response = new MessageResponse("Usuario cadastrado", null);
            return ResponseEntity.created(null).body(response);
        } else {
            var response = new MessageResponse("Falha ao cadastrar o usuário", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/remedios")
    public ResponseEntity<MessageResponse> listar(){
        var lista =  repository.findAll().stream().map(DadosListagemRemedios::new).toList();
        var response = new MessageResponse("Sucesso", lista);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/remedios")
    @Transactional //salva automaticamente se a transação for concluida
    public ResponseEntity<MessageResponse> update(@Valid @RequestBody DtoUpdateDrug dados){
        var remedio = repository.getReferenceById(dados.id());
        if(remedio != null){
            remedio.update(dados);
            var response = new MessageResponse("Item Atualizado: " + remedio + " ",null );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } else {
            var response = new MessageResponse("Erro", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @DeleteMapping("/remedios/{id}")
    @Transactional
    public ResponseEntity<MessageResponse> delete(@PathVariable long  id) { //PathVariable serve para pegar o informação passada na rota dinamica
        if (!repository.existsById(id)) {
            var response = new MessageResponse("ID não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        try {
            repository.deleteById(id);
            var response = new MessageResponse("Deletado com sucesso",null);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new MessageResponse("Erro ao deletar:" + e.getMessage(), null);
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }


    }

}
