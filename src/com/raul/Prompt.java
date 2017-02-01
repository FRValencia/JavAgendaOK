package com.raul;

import java.util.Scanner;

public class Prompt {                           //Aqui creamos el puntero del prompt

    public static String read(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("");

        return scanner.nextLine();
    }
}
