package com.aluracursos.Forohub.Forohub.domain.topicos;

import com.aluracursos.Forohub.Forohub.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public DatosDetallesTopico creaTopico(DatosRegistroTopico datosRegistroTopico) {
        var titulo = datosRegistroTopico.titulo();
        var mensaje = datosRegistroTopico.mensaje();
        var autor = usuarioRepository.getReferenceById(datosRegistroTopico.usuarioId());

        var topico = new Topico(titulo, mensaje, autor);

        topicoRepository.save(topico);

        return new DatosDetallesTopico(topico);
    }

    public List<DatosDetallesTopico> findAll(){
        return this.topicoRepository.findAll().stream().map(DatosDetallesTopico::new).collect(Collectors.toList());
    }

    public DatosDetallesTopico actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        if (!topicoRepository.existsById(datosActualizarTopico.id())) {
            throw new RuntimeException("Tópico inexistente");
        }
        if (datosActualizarTopico.titulo().isEmpty() && datosActualizarTopico.mensaje().isEmpty()) {
            throw new RuntimeException("No se recibió ningún dato para realizar modificación");
        }
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);

        return new DatosDetallesTopico(topico);
    }

    public void borrarTopico(Long id){
        var topico = this.topicoRepository.findById(id);
        if(topico.isPresent()){
            this.topicoRepository.delete(topico.get());
        }
        else{
            throw new RuntimeException("El topico no existe en la base de datos");
        }

    }

    public DatosDetallesTopico encontrarTopico(Long id){
        Topico topico = this.topicoRepository.getReferenceById(id);
        if(topico == null){
            throw new RuntimeException("El topico no existe en la base de datos");
        }
        return new DatosDetallesTopico(topico);
    }
}
