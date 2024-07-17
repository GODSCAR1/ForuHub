package com.aluracursos.Forohub.Forohub.domain.topicos;
import com.aluracursos.Forohub.Forohub.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Long usuarioId
) {
}
