package com.remedios.api;

import java.util.List;

public class MessageResponse {
    private String message;
    private List<DadosListagemRemedios> lista;

    public MessageResponse(String message, List<DadosListagemRemedios> lista) {
        this.message = message;
        this.lista = lista;
    }

    public String getMessage() {
        return message;
    }

    public List<DadosListagemRemedios> getLista() {
        return lista;
    }
}
