package Controller;

import Model.Country.Border;
import Model.Country.Country;
import Model.Country.SeaDists;
import Model.Point.Point;
import Model.Port.Port;
import Services.NetWorkData;
import Services.PortData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class NetWorkGeneratorController {
    private static final String FILE_PORTS_SMALL = "data-ships&ports//sports.csv";
    private static final String FILE_PORTS_BIG = "data-ships&ports//bports.csv";
    private static final String FILE_COUNTRIES = "data-ships&ports//countries.csv";
    private static final String FILE_BORDERS = "data-ships&ports//borders.csv";
    private static final String FILE_SEADISTS = "data-ships&ports//seadists.csv";

    List<Border> borders = new LinkedList<>();
    List<SeaDists> seaDists = new LinkedList<>();

    private static final boolean USE_BIG_FILES = true;

    public NetWorkGeneratorController() {
    }

    public void load() {
        try {
            //   System.out.println("========================================" + "\n|------ Start Loading File Info --------|");
            readCountries();
            readPorts();
            readBorders();
            readSeaDists();
            NetWorkData.getInstance().addCapitalPortBorder();
            NetWorkData.getInstance().addPortsNBorders(5);
           // System.out.println(NetWorkData.getInstance().getNetWork());

            //     System.out.println("|- End Loading Files Info With Success -|" + "\n========================================");

        } catch (Exception ex) {
            ex.printStackTrace();
            //   System.out.println("File localization is invalid!");

        }
    }

    private void readCountries() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_COUNTRIES));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");

                NetWorkData.getInstance().insertVertexes(new Point(new Country(aux[0].trim(), aux[1].trim(), aux[2].trim(), aux[3].trim(), Double.parseDouble(aux[4].trim()), aux[5].trim(), Double.parseDouble(aux[6].trim()), Double.parseDouble(aux[7].trim()))));
            }
        }
        sc.close();
    }

    private void readPorts() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader((USE_BIG_FILES ? FILE_PORTS_BIG : FILE_PORTS_SMALL)));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                if (getCountryByName(aux[1].trim()) == null) {
                    System.out.println(aux[1].trim());
                }
                if (getCountryByName(aux[1].trim()) != null) {
                    NetWorkData.getInstance().insertVertexes(new Point(new Port(aux[0].trim(), getCountryByName(aux[1].trim()), Integer.parseInt(aux[2].trim()), aux[3].trim(), Double.parseDouble(aux[4].trim()), Double.parseDouble(aux[5].trim()))));
                }
            }
        }
        sc.close();
    }

    private void readBorders() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_BORDERS));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                if (getPointByCountryName(aux[0].trim()) != null && getPointByCountryName(aux[1].trim()) != null) {
                    borders.add(new Border(getPointByCountryName(aux[0].trim()), getPointByCountryName(aux[1].trim())));
                }
            }
        }
        NetWorkData.getInstance().addCapitalBorders(borders);
        sc.close();
    }

    private void readSeaDists() throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_SEADISTS));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(",");
                if (getCountryByName(aux[0].trim()) != null && getCountryByName(aux[3].trim()) != null && getCountryByName(aux[3].trim()) != null && getCountryByName(aux[3].trim()) != null && getCountryByName(aux[5].trim()) != null) {
                    seaDists.add(new SeaDists(getCountryByName(aux[0].trim()), Integer.parseInt(aux[1].trim()), getPortByCityName(aux[2].trim()), getCountryByName(aux[3].trim()), Integer.parseInt(aux[4].trim()), getPortByCityName(aux[5].trim()), Integer.parseInt(aux[6].trim())));
                }
            }
        }
        NetWorkData.getInstance().addPortsSameCountryBorders(seaDists);
        sc.close();
    }

    public Point getPointByCountryName(String country) {
        return NetWorkData.getInstance().getPointByCountryName(country);
    }

    public Country getCountryByName(String country) {
        if (NetWorkData.getInstance().getPointByCountryName(country) != null) {
            return NetWorkData.getInstance().getPointByCountryName(country).getCountry();
        }
        return null;
    }

    public Port getPortByCityName(String city) {
        return NetWorkData.getInstance().getPortByCityName(city);
    }

    public static boolean isUseBigFiles() {
        return USE_BIG_FILES;
    }

}



