package com.sisuaplication.controllers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

public class CalcularNotas {
    private double media, nota1, nota2, nota3, nota4, nota5, mediaPonderada;
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=Sisu_Api;encrypt=true;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "2+2Ubuntu24";
    

 

    public double calcularNotas(double nota1, double nota2, double nota3, double nota4, double nota5) {
    
        media = (nota1 + nota2 + nota3 + nota4 + nota5)/5;
        
        salvarNotaNoBanco();
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

   

        sc.close();                                  
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



    private void salvarNotaNoBanco() {

        String query = "INSERT INTO Notas_do_usuario (user_login, matematica, ciencias_da_natureza, linguagens, humanas, redacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setDouble(1, this.getNota1());
                stmt.setDouble(2, this.getNota2());
                stmt.setDouble(3, this.getNota3());
                stmt.setDouble(4, this.getNota4());
                stmt.setDouble(5, this.getNota5());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário no banco: " + e.getMessage());
        }
    }



    public List<String> CarregarDados(String campus) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CarregarDados'");
    }

}


    