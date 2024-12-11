package com.sisuaplication;
import com.sisuaplication.models.sistemalogin.UsuariosCadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		UsuariosCadastro user = new UsuariosCadastro();

		//user.adicionarNovoUsuario("ribamar", "123");

	}

}
