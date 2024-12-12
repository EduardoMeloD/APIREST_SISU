package com.sisuaplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisuaplication.models.Notas.NotasDoUsuario;

import java.util.List;



@Repository
public interface NotasRepository extends JpaRepository<NotasDoUsuario, Long> {

    List<NotasDoUsuario> findByUsuario_login(String login);
}
