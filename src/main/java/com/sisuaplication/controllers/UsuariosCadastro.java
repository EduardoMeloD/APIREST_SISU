package com.sisuaplication.controllers;

import java.sql.*;
//import java.util.ArrayList;
import java.util.Scanner;

import com.sisuaplication.models.sistemalogin.Usuario;

public class UsuariosCadastro extends Usuario {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=Sisu_Api;encrypt=true;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "thones434";

    public String escolha;
    public String novoDado;

    public UsuariosCadastro(String login, String senha) {
        super(login, senha);
    }

    public UsuariosCadastro() {
        // Construtor padrão
    }

    public void informacoesDoUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        this.setNome(sc.nextLine());
        System.out.print("Digite seu genero: ");
        this.setGenero(sc.nextLine());
        System.out.println("Digite seu cpf: ");
        this.setCpf(sc.nextLine());
        System.out.print("Digite sua idade: ");
        this.setIdade(sc.nextLine());
        System.out.print("Digite seu e-mail: ");
        this.setEmail(sc.nextLine());
        System.out.print("Digite seu telefone: ");
        this.setTelefone(sc.nextLine());
        System.out.println("Digite seu endereço: ");
        this.setEndereco(sc.nextLine());
    }

    public String toString() {
        return super.getLogin() + " | " + super.getSenha() + " | " +
                super.getNome() + " | " + super.getIdade() + " | " +
                super.getEmail() + " | " + super.getTelefone() + " | " +
                super.getEndereco();
    }

    public void adicionarNovoUsuario(String login, String senha) {
        
        if (verificarUsuarioExistente(login)) {
            System.out.println("Usuário existente!");
        } else {
            this.setLogin(login);
            this.setSenha(senha);
            informacoesDoUsuario();
            salvarUsuarioNoBanco();
            System.out.println("Conta cadastrada com sucesso!");
        }

    }

    public boolean verificarUsuario(String login, String senha) {
        String query = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar usuário: " + e.getMessage());
            return false;
        }
    }

    public boolean verificarUsuarioExistente(String login) {
        String query = "SELECT * FROM usuarios WHERE login = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar usuário existente: " + e.getMessage());
            return false;
        }
    }

    private void salvarUsuarioNoBanco() {
        String query = "INSERT INTO usuario (login, senha, nome, genero, cpf, idade, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, this.getLogin());
            stmt.setString(2, this.getSenha());
            stmt.setString(3, this.getNome());
            stmt.setString(4, this.getGenero());
            stmt.setString(5, this.getCpf());
            stmt.setString(6, this.getIdade());
            stmt.setString(7, this.getEmail());
            stmt.setString(8, this.getTelefone());
            stmt.setString(9, this.getEndereco());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário no banco: " + e.getMessage());
        }
    }

    public void atualizarInformacoesDoUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Você deseja atualizar um dado específico? (sim/nao): ");
        escolha = sc.nextLine();

        if (escolha.equalsIgnoreCase("sim")) {
            do {
                System.out.print("\nQual dado você deseja atualizar? (nome, idade, email, telefone)");
                novoDado = sc.nextLine();

                switch (novoDado.toLowerCase()) {
                    case "nome":
                        System.out.print("\nDigite seu novo nome: ");
                        this.setNome(sc.nextLine());
                        break;

                    case "genero":
                        System.out.print("\nDigite seu novo genero: ");
                        this.setGenero(sc.nextLine());
                        break;

                    case "cpf":
                        System.out.print("\nDigite seu novo cpf: ");
                        this.setCpf(sc.nextLine());
                        break;

                    case "idade":
                        System.out.print("Digite sua nova idade: ");
                        this.setIdade(sc.nextLine());
                        break;

                    case "email":
                        System.out.print("Digite seu novo e-mail: ");
                        this.setEmail(sc.nextLine());
                        break;

                    case "telefone":
                        System.out.print("Digite seu novo telefone: ");
                        this.setTelefone(sc.nextLine());
                        break;

                    case "endereco":
                        System.out.println("Digite seu novo endereço: ");
                        this.setEndereco(sc.nextLine());
                        break;

                    default:
                        System.out.println("Dado inválido. Tente novamente.");
                        continue;
                }

                System.out.print("\nVocê deseja atualizar outro dado? (sim/nao): ");
                escolha = sc.nextLine();
            } while (escolha.equalsIgnoreCase("sim"));

            atualizarUsuarioNoBanco();
        } else {
            System.out.println("Nenhum dado foi alterado.");
        }
    }

    private void atualizarUsuarioNoBanco() {
        String query = "UPDATE usuarios SET nome = ?, genero = ?, cpf = ?, idade = ?, email = ?, telefone = ?, endereco = ? WHERE login = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getGenero());
            stmt.setString(3, this.getCpf());
            stmt.setString(4, this.getIdade());
            stmt.setString(5, this.getEmail());
            stmt.setString(6, this.getTelefone());
            stmt.setString(7, this.getEndereco());
            stmt.setString(8, this.getLogin());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário no banco: " + e.getMessage());
        }
    }
}