package com.remedios.api;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Remedio") //desmonstra que a classe é uma entidade
@Table(name = "remedios") // sinaliza a tabela do banco de dados remedios
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Remedio {



    public Remedio(DataCreateDrug dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.quantidade = dados.quantidade();
        this.preco = dados.preco();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o id automaticamente e identifica-o como chave primaria
    private long id;

    private String nome;
    private int quantidade;
    private  double preco;
    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Via via;

    @Enumerated(EnumType.STRING)
    Laboratorio laboratorio;

    public void update( @Valid  DtoUpdateDrug dados){
            if(dados.nome() != null){
                this.nome = dados.nome();
            }

            if(dados.via() != null){
                this.via = dados.via();
            }
            if(dados.laboratorio() != null){
                this.laboratorio = dados.laboratorio();
            }
    }
}
