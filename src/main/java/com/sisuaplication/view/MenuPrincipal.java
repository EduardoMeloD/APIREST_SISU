package com.sisuaplication.view;



import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner sc;

    public MenuPrincipal() {
        sc = new Scanner(System.in);
    }

    public String ExibirMenu() {
        System.out.println("\nQual das opções abaixo deseja utilizar");
        System.out.println("\n1.Fazer login");
        System.out.println("2.Criar uma conta");
        System.out.println("3.Sair");
        System.out.print("\nEscolha uma das opções acima: ");
        return sc.nextLine();
    }

    public Scanner getScanner(){
        return sc;
    }
}