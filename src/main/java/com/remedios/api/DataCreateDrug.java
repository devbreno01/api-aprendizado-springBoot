package com.remedios.api;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;


public record DataCreateDrug(

        @NotEmpty
        String nome,

        int quantidade,

        double preco,

        @Future
        LocalDate validade,

        @Enumerated
        Via via,
        @Enumerated
        Laboratorio laboratorio)
    {


    }
