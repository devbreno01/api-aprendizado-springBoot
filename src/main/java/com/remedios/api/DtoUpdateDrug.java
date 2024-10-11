package com.remedios.api;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateDrug(
        @NotNull
        long id,

        String nome,
        Via via,
        Laboratorio laboratorio

) {
}
