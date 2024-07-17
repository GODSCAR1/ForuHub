package com.aluracursos.Forohub.Forohub.controller;

import com.aluracursos.Forohub.Forohub.domain.topicos.*;
import com.aluracursos.Forohub.Forohub.domain.usuarios.Usuario;
import com.aluracursos.Forohub.Forohub.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;


    @PostMapping
    public ResponseEntity<DatosDetallesTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        var response = topicoService.creaTopico(datosRegistroTopico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<DatosDetallesTopico> listadoTopico(){
        return this.topicoService.findAll();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosDetallesTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        return ResponseEntity.ok(this.topicoService.actualizarTopico(datosActualizarTopico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.borrarTopico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetallesTopico> retornaDatosTopico(@PathVariable Long id){
        return ResponseEntity.ok(this.topicoService.encontrarTopico(id));
    }



}