package Controller;

import Model.Covid_Info;
import Model.Location;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReadFileController {
    private static final String COVID_FILE = "owid-covid-data.csv";

    private List<Location> location_List;
    private List<Covid_Info> covid_info_List;

    public ReadFileController() {
        this.location_List = new ArrayList<>();
        this.covid_info_List = new ArrayList<>();
    }

    public boolean carregarInformação() throws  RuntimeException {
        this.location_List = new ArrayList<>();
        this.covid_info_List = new ArrayList<>();



        try {
            lerLocations();
          /*   for (Location l : location_List) {
                System.out.println(l);
            }*/
            lerCovidInfo();
           /* for (Covid_Info l : covid_info_List) {
                System.out.println(l);
            }*/

        } catch (FileNotFoundException ex) {
            System.out.println("Localização de algum ficheiro e invalida!");
            return false;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }


    private void lerCovidInfo() throws FileNotFoundException, ParseException {
        // Le e guarda as informacoes referentes ao ficheiro de competencias tecnicas
        String[] aux;
        Scanner sc = new Scanner(new FileReader(COVID_FILE));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                Location location = getLocation(aux[2].trim());
                if (location == null) {
                    throw new RuntimeException("A tarefa com o código " + aux[1].trim() + " não foi encontrada");
                }
                for (int i = 4; i <= 9; i++) {
                    if (aux[i].equals("NA")) {
                        aux[i] = "0";
                    }
                }
                /* location|date-3| total_casos-4 | novos_casos-5 | total_mortes-6 | novas_mortes-7 | total_testes-9 | novos_testes-8 */
                covid_info_List.add(new Covid_Info(location,new SimpleDateFormat("yyyy-MM-dd").parse(aux[3].trim()), aux[4].trim(), aux[5].trim(), aux[6].trim(), aux[7].trim(), aux[9].trim(), aux[8].trim()));
            }
        }
        sc.close();
      //  System.out.println("Ficheiro Covid lido");
    }

    private void lerLocations() throws FileNotFoundException, ParseException {
        // Le e guarda as informacoes referentes ao ficheiro de competencias tecnicas
        String[] aux;
        Scanner sc = new Scanner(new FileReader(COVID_FILE));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                for (int i = 0; i <= 15; i++) {
                    if (aux[i].equals("NA")) {
                        aux[i] = "0";
                    }
                }
                /*continente-1|iso_code-0|pais-2|population-10|total_fumadores-14+15|*/
                location_List.add(new Location(aux[1].trim(), aux[0].trim(), aux[2].trim(),
                        Integer.parseInt(aux[10].trim()), Double.parseDouble(aux[14].trim()) + Double.parseDouble((aux[15].trim())),0));
            }
        }
        sc.close();
       // System.out.println("Ficheiro Locations lido");
    }

    private Location getLocation(String pais) {
        for (Location location:location_List) {
            if (location.getPais().equals(pais)) {
                return location;
            }
        }
        return null;
    }

    public List<Covid_Info> getCovid_info_List() {
        return covid_info_List;
    }
}

