package Controller;

import Services.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFilesController {

    private static final String FILE_PERIODIC_TABLE_INFO = "Periodic Table of Elements.csv";

    public ReadFilesController() {
    }

    public void load() {
        try {
          /*  System.out.println("========================================");
            System.out.println("|------ Start Loading File Info --------|");*/

            readPeriodicTable();

          /*  System.out.println("|- End Loading Files Info With Success -|");
            System.out.println("========================================");*/

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Localizacao de algum ficheiro e invalida!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro Tipo RunTime");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("System Error");
        }
    }

    private void readPeriodicTable() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader((FILE_PERIODIC_TABLE_INFO)));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                Data.getInstance().createTrees(parseInt(aux[0].trim()),
                        aux[1].trim(),
                        aux[2].trim(),
                        parseDouble(aux[3].trim()), parseDouble(aux[4].trim()),
                        parseInt(aux[5].trim()), parseInt(aux[6].trim()), aux[7].trim(),
                        aux[8].trim(), aux[9].trim(), parseDouble(aux[10].trim()),
                        parseDouble(aux[11].trim()), parseDouble(aux[12].trim()),
                        parseDouble(aux[13].trim()), parseDouble(aux[14].trim()),
                        parseDouble(aux[15].trim()),parseDouble(aux[16].trim()),
                        parseInt(aux[17].trim()), aux[18].trim(), parseInt(aux[19].trim()),
                        parseDouble(aux[20].trim()), aux[21].trim(), parseInt(aux[22].trim()),
                        parseInt(aux[23].trim()));
            }
        }
        sc.close();
     //   System.out.println("->The Periodic table File has been read<-");
    }

    public static double parseDouble(String test) {
        if (test.equalsIgnoreCase("")) {
            return  0;
        } else {
            return Double.parseDouble(test);
        }
    }

    public static Integer parseInt(String test) {
        if (test.equalsIgnoreCase("")) {
            return 0;
        } else {
            return Integer.parseInt(test);
        }
    }

}
