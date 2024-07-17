package com.aluracursos.Forohub.Forohub.domain.topicos;

import com.aluracursos.Forohub.Forohub.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long usuarioId
        ) {
}
