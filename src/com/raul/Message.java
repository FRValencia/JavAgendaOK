package com.raul;


import java.util.Random;

public class Message {
    public static void printHelp() {
        System.out.println("Ayuda de la JavAgenda");    //Mensajes de la ayuda


        System.out.println("(Q)UIT \t\t - Salir\n" +
                "(L)IST\t\t - Muestra los contactos con la posición en lista\n" +
                "(H)ELP \t\t - Muestra los comandos \n" +
                "(D)ELETE \t - Borra el contacto\n" +
                "(A)DD \t\t - Añade un contacto\n");

    }
}
    /*
    public static int printUnknownCommand(int errorCounter){    //contador de errores al meter letras no reconocidas
        String[] messages = {
                "Tecla no reconocida",

        };
        Random randomGenerator = new Random();                  //extraido de aventura
        int index = randomGenerator.nextInt(messages.length);
        System.out.println(messages[index]);

        if (errorCounter > 2){
            printHelp();
            return 0;

        }
        return errorCounter;
    }
}
*/
