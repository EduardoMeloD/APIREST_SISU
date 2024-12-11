package com.sisuaplication.models.Notas;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jakarta.persistence.Id;

public class CalcularNotas {
    private double media, nota1, nota2, nota3, nota4, nota5, mediaPonderada;
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=Sisu_Api;encrypt=true;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "thones434";
    

 

    public double calcularNotas(double nota1, double nota2, double nota3, double nota4, double nota5) {
    
        media = (nota1 + nota2 + nota3 + nota4 + nota5)/5;

        return media;
        
        
    }

    
    
    public void solicitarNotas() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite sua nota de matemática:");
        nota1 = sc.nextDouble();

        System.out.println("Digite sua nota de ciências da natureza:");
        nota2 = sc.nextDouble();

        System.out.println("Digite sua nota de linguagens:");
        nota3 = sc.nextDouble();

        System.out.println("Digite sua nota de humanas:");
        nota4 = sc.nextDouble();

        System.out.println("Digite sua nota de redação:");
        nota5 = sc.nextDouble();

        

        mediaPonderada = calcularNotas(nota1, nota2, nota3, nota4, nota5);
        if (mediaPonderada > 0) {
            System.out.println("A média ponderada é: " + mediaPonderada);
        }
    }

    public double getMedia() {
        return media;
    }

    public double getNota1() {return nota1;}
    public void setNota1(double nota1) {this.nota1 = nota1;}

    public double getNota2() {return nota2;}
    public void setNota2(double nota2) {this.nota2 = nota2;}

    public double getNota3() {return nota3;}
    public void setNota3(double nota3) {this.nota3 = nota3;}
    
    public double getNota4() {return nota4;}
    public void setNota4(double nota4) {this.nota4 = nota4;}

    public double getNota5() {return nota5;}
    public void setNota5(double nota5) {this.nota5 = nota5;}

    public double getmedia() {return media;}
    public void setmedia(double media) {this.media = media;}



    private void salvarUsuarioNoBanco() {
        String query = "INSERT INTO usuario (login, senha, nome, genero, cpf, idade, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setDouble(1, this.getNota1());
                stmt.setDouble(2, this.getNota2());
                stmt.setDouble(3, this.getNota3());
                stmt.setDouble(4, this.getNota4());
                stmt.setDouble(5, this.getNota5());
                stmt.setDouble(6, this.getmedia());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário no banco: " + e.getMessage());
        }
    }

}


    