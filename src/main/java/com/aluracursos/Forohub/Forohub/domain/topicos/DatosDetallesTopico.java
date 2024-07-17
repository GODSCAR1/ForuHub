package com.aluracursos.Forohub.Forohub.domain.topicos;

import java.time.LocalDateTime;

public record DatosDetallesTopico(
        Long id,
        String titulo,
        String mensaje,
        Long usuarioId) {

    public DatosDetallesTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getUsuario().getId()

        );
    }
}
