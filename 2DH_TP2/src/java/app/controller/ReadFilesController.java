package app.controller;

import app.Services.Data;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFilesController {

    private static final String FILE_USERS_BIG = "FicheirosTextoBig//busers.txt";
    private static final String FILE_RELATIONSHIPS_BIG = "FicheirosTextoBig//brelationships.txt";
    private static final String FILE_COUNTRIES_BIG = "FicheirosTextoBig//bcountries.txt";
    private static final String FILE_BOARDERS_BIG = "FicheirosTextoBig//bborders.txt";

    private static final String FILE_USERS_SMALL = "FicheirosTextoSmall//susers.txt";
    private static final String FILE_RELATIONSHIPS_SMALL = "FicheirosTextoSmall//srelationships.txt";
    private static final String FILE_COUNTRIES_SMALL = "FicheirosTextoSmall//scountries.txt";
    private static final String FILE_BOARDERS_SMALL = "FicheirosTextoSmall//sborders.txt";

    private static final boolean USE_BIG_FILES = false;

    public ReadFilesController() {
    }

    public boolean load() {
        try {
            System.out.println("|------ Start Loading Files Info ------|");
            System.out.println("|______________________________________|");
            readCountries();
            readBorders();
            readUsers();
            readRelationships();

          //  System.out.println(Data.getInstance().getUsers().getRelationsMap());
        //    System.out.println(Data.getInstance().getCities().getDistancesMap());
            System.out.println("|______________________________________|");
            System.out.println("|- End Loading Files Info With Sucess -|");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Localizacao de algum ficheiro e invalida!");
            return false;

        } catch (RuntimeException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro Tipo RunTime");
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("System Error");
            return false;
        }
        return true;
    }

    private void readCountries() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader((USE_BIG_FILES ? FILE_COUNTRIES_BIG : FILE_COUNTRIES_SMALL)));
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                Data.getInstance().addCountry(aux[0].trim(),
                        aux[1].trim(),
                        Double.parseDouble(aux[2].trim()),
                        aux[3].trim(),
                        Double.parseDouble(aux[4].trim()),
                        Double.parseDouble(aux[5].trim()));
            }
        }
        sc.close();
        System.out.println("The Countries File has been read");
    }

    private void readUsers() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(USE_BIG_FILES ? FILE_USERS_BIG : FILE_USERS_SMALL));
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                Data.getInstance().addUser(aux[0].trim(),
                        Integer.parseInt(aux[1].trim()),
                        aux[2].trim());
            }
        }

        sc.close();
        System.out.println("The Users File has been read");

    }

    private void readRelationships() throws Exception {

        String[] aux;
        Scanner sc = new Scanner(new FileReader(USE_BIG_FILES ? FILE_RELATIONSHIPS_BIG : FILE_RELATIONSHIPS_SMALL));
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                Data.getInstance().addRelationship(aux[0].trim(), aux[1].trim());
            }
        }
        sc.close();
        System.out.println("The Relationships File has been read");
    }

    private void readBorders() throws FileNotFoundException {

        String[] aux;
        Scanner sc = new Scanner(new FileReader(USE_BIG_FILES ? FILE_BOARDERS_BIG : FILE_BOARDERS_SMALL));
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                Data.getInstance().addBorder(aux[0].trim(),
                        aux[1].trim());

            }
        }
        sc.close();
        System.out.println("The Boarders File has been read");
    }

}
