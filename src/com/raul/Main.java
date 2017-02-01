package com.raul;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //Imprimimos la bienvenida

        System.out.println(
                " JavAgenda\n" +
                        " CopyLeft - Raúl Valencia Casado\n" +
                        " Málaga - 2017\n" +
                        " Bienvenido\n"
        );

        //crear la lista vacia

        List<Contact> agenda = new ArrayList<>();


        //creacion de dos contactos en la memoria
        /*

        Contact c1 = new Contact ();
        c1.setName("Chiquito");
        c1.setPhone("617617277");

        Contact c2 = new Contact();
        c2.setName("Carmen de Maierana");
        c2.setPhone("617617777");


        //añado contactos a la lista

        agenda.add(c1);
        agenda.add(c2);
        */

        // imprimir la lista
        System.out.println("This is the contacts list "+ agenda);





        
        for (Contact c: agenda){
            System.out.println("Name: " + c.getName());
            System.out.println("Phone: " + c.getPhone());
            System.out.println("_____");
        }

        for (int i = 0; i < agenda.size(); i++) {       //ejecutamos bucle for como tantos elementos tenga la lista
            Contact c = agenda.get(i);                  //esto saca el elemento de la lista que toca

            System.out.println("Name: " + c.getName());
            System.out.println("Phone: " + c.getPhone());
            System.out.println("_____");


        }
        System.out.print("(" + agenda.size() +") > ");                          //ESTE es eL LOGO DEL PROMPT, con el numero de elementos de la lista
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.print("(" + agenda.size() +") > ");                          //Con esto impirmo name primero y phone depsues
        String phone = scanner.nextLine();


        Contact newContact = new Contact();                                     //cramos nuevo contacto
        newContact.setName(name);
        newContact.setPhone(phone);

        agenda.add(newContact);                                                 //con esto metemos el contacto en la lista

        for (int i = 0; i < agenda.size(); i++) {       //ejecutamos bucle for como tantos elementos tenga la lista
            Contact c = agenda.get(i);                  //esto saca el elemento de la lista que toca

            System.out.println("Name: " + c.getName());
            System.out.println("Phone: " + c.getPhone());
            System.out.println("_____");                    //asi imprimimos la lista

        }
        //vamos a crear el archivo donde guardar la lista, vamos a hacerlo de las dos formas posbles, con un archivo  con dos

        grabaListaUSandoDosFicheros(agenda);
        cargaDosFicherosEImprime();                         //esto leera el archivo que estuviera creado

        System.out.println("Borrar: ");
        try {
            int contactoABorrar = scanner.nextInt();
            if (contactoABorrar <0 || contactoABorrar > agenda.size()){
                System.out.println("NOOOORLLL");
            }else {
                agenda.remove(contactoABorrar);
            }
        }catch (InputMismatchException e){
            System.out.println("Aprende a escribir un numero, su tabaco, gracias");
        }

        //con esto borramos de la lista

    }

    public static void grabaListaUSandoDosFicheros(List<Contact> contacts) {
        List<String> names = new ArrayList<>();                 //lista nombres y lista telefonos
        List<String> phones = new ArrayList<>();

        for(Contact c: contacts){
            names.add(c.getName());
            phones.add(c.getPhone());
        }

        try {                                                   //lo metemos en un try catch para ver la excepcion y si va ok q pase a siguiente tarea
            createFile("names.txt", names );              //con esto creamos el archivo names.tx, lleno de names
            createFile("phones.txt", phones );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void cargaDosFicherosEImprime(){                  //con esto hace carga dos archivos e imprime
        List<String> names = readFile("names.txt");
        List<String> phones = readFile("phones.txt");

        List<Contact> contacts = new ArrayList<>();                 //esto crea array lista con los contactos

        for (int i = 0; i < names.size(); i++) {                    //esto recorre todos los nobmres de arriba
            Contact c= new Contact();
            c.setName(names.get(i));                                //con esto creamos el conacto para montar la lista
            c.setPhone(phones.get(i));

            contacts.add(c);                                        //esto genera el contacto

        }

        for (Contact c: contacts) {
            System.out.println("Name from disk: " + c.getName());
            System.out.println("Phone from disk: " + c.getPhone());
            System.out.println("---***----");

        }


    }



        public static void createFile(String file, List<String> arrData)
            throws IOException {
            FileWriter writer = new FileWriter(file);
            int size = arrData.size();
            for (int i=0;i<size;i++) {
                String str = arrData.get(i).toString();
                writer.write(str);
                if(i < size-1) {                                                    //This prevent creating a blank
                    //like at the end of the file**
                    writer.write("\n");
                }
            }
            writer.close();
        }
        public static List<String>readFile(String fileName) {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new
                    BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null)
                {
                    lines.add(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        }

    }