package com.sisuaplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisuaplication.models.sistemalogin.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
