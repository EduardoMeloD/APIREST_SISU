package com.sisuaplication;
import com.sisuaplication.controllers.CalcularNotas;
import com.sisuaplication.controllers.ListarCursos;
import com.sisuaplication.controllers.UsuariosCadastro;
import com.sisuaplication.models.sistemalogin.Usuario;
import com.sisuaplication.view.MenuPrincipal;
import com.sisuaplication.view.MenuSecundario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

//import com.sisuaplication.controllers.UsuariosCadastro;

@SpringBootApplication
public class SisuMainapplication {

	public static void main(String[] args) {
		SpringApplication.run(SisuMainapplication.class, args);

		MenuPrincipal menu = new MenuPrincipal();
		MenuSecundario tela = new MenuSecundario();
		UsuariosCadastro sistema = new UsuariosCadastro();
		Usuario user = new Usuario();
		CalcularNotas calc = new CalcularNotas();
		String opcao;

		boolean sair = false;

		do {
			opcao = menu.ExibirMenu();

			switch (opcao) {
				case "1":
					System.out.print("\nDigite seu login: ");
					String login = menu.getScanner().next();
					System.out.print("Digite sua senha: ");
					String senha = menu.getScanner().next();

					if (sistema.verificarUsuario(login, senha)) {
						System.out.println("\nBem-vindo ao sistema!");
						String subOpcao;
						do {
							subOpcao = tela.Exibirtela();

							switch (subOpcao) {
								case "1":
									ListarCursos listar = new ListarCursos();
									listar.listarCursosPorCampus();
									break;

								case "2":
									Scanner sc = new Scanner(System.in);
									System.out.println("Calcule sua média ponderada!!!");
								

									System.out.println("\nDigite suas notas:");

									System.out.print("\nNota de Redação: ");
									double nota1 = sc.nextDouble();

									System.out.print("Nota de Matemática e suas Tecnologias: ");
									double nota2 = sc.nextDouble();

									System.out.print("Nota de Linguagens, Código e suas Tecnologias: ");
									double nota3 = sc.nextDouble();

									System.out.print("Nota de Ciências Humanas e suas Tecnologias: ");
									double nota4 = sc.nextDouble();

									System.out.print("Nota de Ciências da Natureza e suas Tecnologias: ");
									double nota5 = sc.nextDouble();

									double media = calc.calcularNotas(nota1, nota2, nota3, nota4, nota5);

									if (media > 0) {
										System.out.printf("\nSua média é: %.2f", media);
									} else {
										System.out.println("\nErro: Model.Curso não encontrado.");
									}
									break;

								case "3":
									if (login.equals(login)) {
										System.out.println("\nInformações do usuário:");
										System.out.println("Nome: " + user.getNome());
										System.out.println("Genero: " + user.getGenero());
										System.out.println("cpf: " + user.getCpf());
										System.out.println("Email: " + user.getEmail());
										System.out.println("Idade: " + user.getIdade());
										System.out.println("Telefone: " + user.getTelefone());
										System.out.println("endereco: " + user.getEndereco());
									}
									
									break;

								case "4":
									System.out.println("atualize suas informaçoes");
									
									if (user.getLogin().equals(login)) {
										sistema.atualizarInformacoesDoUsuario();
										System.out.println("suas informacoes foram atualizadas");
									}
									
									break;

								case "5":
									System.out.println("Saindo do sistema...");
									sair = true;
									break;

								default:
									System.out.println("\nOpção inválida!");
									break;
							}
						} while (!subOpcao.equals("5"));
					} else {
						System.out.println("\nUsuário não encontrado!");
					}
					break;

				case "2":
					System.out.print("\nCadastre seu login: ");
					String novoLogin = menu.getScanner().next();
					System.out.print("Digite sua senha: ");
					String novaSenha = menu.getScanner().next();

					menu.getScanner().nextLine();

					sistema.adicionarNovoUsuario(novoLogin, novaSenha);
					break;

				case "3":
					System.out.println("\nSaindo...");
					sair = true;
					break;

				default:
					System.out.println("\nOpção inválida!");
					break;
			}
		} while (!sair);
	}
}

