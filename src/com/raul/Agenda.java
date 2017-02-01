package com.raul;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class Agenda {

    public static void grabaListaUSandoDosFicheros(List<Contact> agenda) {
        List<String> names = new ArrayList<>();                 //lista nombres y lista telefonos
        List<String> phones = new ArrayList<>();

        for(Contact c: agenda){
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

    public void cargaDosFicherosEImprime(){                  //con esto hace carga dos archivos e imprime
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