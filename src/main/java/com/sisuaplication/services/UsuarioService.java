package com.sisuaplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisuaplication.repositories.NotasRepository;
import com.sisuaplication.repositories.UsuarioRepository;
import com.sisuaplication.models.Notas.NotasDoUsuario;
import com.sisuaplication.models.sistemalogin.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NotasRepository notasRepository;

    public Usuario findById(Long id) {
        
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        
        return usuario.orElseThrow(() -> new RuntimeException(
            "Usuario não encontrado! Id: "+id+", Tipo: "+Usuario.class.getName()
        ));
            
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll(); 
    }

    public List<NotasDoUsuario> findByUsuario_login(String login) {
        List<NotasDoUsuario> notas = notasRepository.findByUsuario_login(login);
    
        if (notas.isEmpty()) {
            throw new RuntimeException("Nenhuma nota encontrada para o login fornecido");
        }
    
        return notas; 
    }
}

    
