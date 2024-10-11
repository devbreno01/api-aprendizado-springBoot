package com.remedios.api;

import java.time.LocalDate;

public record DadosListagemRemedios(
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio,
        LocalDate validade ) {

        public DadosListagemRemedios(Remedio remedio){
            this(   remedio.getId(),
                    remedio.getNome(),
                    remedio.getVia(),
                    remedio.getLaboratorio(),
                    remedio.getValidade());
        }
}
