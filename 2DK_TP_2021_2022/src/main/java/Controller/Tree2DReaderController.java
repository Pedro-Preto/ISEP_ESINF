package Controller;

import Model.Country.Country;
import Model.Point.Point;
import Services.NetWorkData;
import Services.PortData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tree2DReaderController {
    private static final String FILE_PORTS_SMALL = "data-ships&ports//sports.csv";
    private static final String FILE_PORTS_BIG = "data-ships&ports//bports.csv";
    private static final String FILE_COUNTRIES = "data-ships&ports//countries.csv";

    List<Country> countries = new LinkedList<>();
    private static final boolean USE_BIG_FILES = true;

    public Tree2DReaderController() {
    }

    public void load() {
        try {
            //   System.out.println("========================================" + "\n|------ Start Loading File Info --------|");
            PortData.getInstance().reset2DPortTree();
            readCountries();
            readPorts();

            //     System.out.println("|- End Loading Files Info With Success -|" + "\n========================================");

        } catch (Exception ex) {
            ex.printStackTrace();
            //   System.out.println("File localization is invalid!");

        }
    }

    private void readPorts() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader((USE_BIG_FILES ? FILE_PORTS_BIG : FILE_PORTS_SMALL)));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                PortData.getInstance().fillPortNodeList(aux[0], getCountryByName(aux[1]), Integer.parseInt(aux[2]), aux[3], BigDecimal.valueOf(Double.parseDouble(aux[4])).setScale(3, RoundingMode.HALF_EVEN).doubleValue(), BigDecimal.valueOf(Double.parseDouble(aux[5])).setScale(3, RoundingMode.HALF_EVEN).doubleValue());
            }
        }
        sc.close();
        PortData.getInstance().build2DPortTree();
        //  System.out.println("The Port File has been read");
    }

    private void readCountries() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_COUNTRIES));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                countries.add(new Country(aux[0].trim(), aux[1].trim(), aux[2].trim(), aux[3].trim(), Double.parseDouble(aux[4].trim()), aux[5].trim(), Double.parseDouble(aux[6].trim()), Double.parseDouble(aux[7].trim())));
            }
        }
        sc.close();
    }

    public Country getCountryByName(String country) {
        for (Country c : this.countries) {
            if (c.getCountry().equals(country)) {
                return c;
            }
        }
        return null;
    }

    public static boolean isUseBigFiles() {
        return USE_BIG_FILES;
    }

}
