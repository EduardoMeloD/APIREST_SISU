package com.sisuaplication.view;

import java.util.Scanner;

public class MenuSecundario {
    private static Scanner choose;

    public MenuSecundario() {
        choose = new Scanner(System.in);
    }

    public String Exibirtela() {
        System.out.println("\nQual das opções abaixo deseja utilizar");
        System.out.println("1.Calcular Média");
        System.out.println("2.Informacoes do usuario");
        System.out.println("3.Atualizar informações");
        System.out.println("4.Sair");
        System.out.print("\nEscolha uma das opções acima: ");
        return choose.nextLine();
    }
}