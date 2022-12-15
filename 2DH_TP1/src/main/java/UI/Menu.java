package UI;

import Controller.ReadFileController;
import Services.PaisDecrescenteByNewPositiveCases;
import Services.PaisesFumadores;
import Services.PaisesSortedByCases_Deaths;
import Services.PaisesSortedByMinDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {


    public static void shownMenu() throws ParseException {
        ReadFileController readFileController = new ReadFileController();
        readFileController.carregarInformação();
        PaisesSortedByMinDay paisesSorted = new PaisesSortedByMinDay();
        PaisesSortedByCases_Deaths paisesSortedByCases_deaths = new PaisesSortedByCases_Deaths();
        PaisDecrescenteByNewPositiveCases paisDecrescenteByNewPositiveCases = new PaisDecrescenteByNewPositiveCases();
        PaisesFumadores paisesFumadores = new PaisesFumadores();
        Scanner in = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("=============================");
            System.out.println(" Menu: ");
            System.out.println("=============================\n");
            System.out.println("1.Ex1");
            System.out.println("2.Ex2");
            System.out.println("3.Ex3");
            System.out.println("4.Ex4");
            System.out.println("0-Exit");
            option = in.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    paisesSorted.executa(readFileController.getCovid_info_List());
                    break;
                case 2:
                    paisesSortedByCases_deaths.executa(readFileController.getCovid_info_List());
                    break;
                case 3:
                 /*   System.out.println("Insert a Continent");
                    String continent = '"' + in.nextLine() + '"';
                    System.out.println("Insert The A Month (Use this format -> Example1: 05; Example2: 09)");
                    int month = in.nextInt();

                    System.out.println("Insert The day of the Month");
                    int day = in.nextInt();*/
                    paisDecrescenteByNewPositiveCases.executa(readFileController.getCovid_info_List(), "\"Europe\"", 1, 9);
                    break;
                case 4:
                    paisesFumadores.executa(readFileController.getCovid_info_List());
                    break;

                default:
                    System.out.println("Option does not exist!");
                    break;
            }
        } while (option != 0);
    }

}
