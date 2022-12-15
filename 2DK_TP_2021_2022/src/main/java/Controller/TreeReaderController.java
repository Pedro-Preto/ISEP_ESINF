package Controller;

import Services.ShipData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TreeReaderController {
    private static final String FILE_SHIPS_BIG = "data-ships&ports//bships.csv";
    private static final String FILE_SHIPS_SMALL = "data-ships&ports//sships.csv";


    private static final boolean USE_BIG_FILES = true;

    public TreeReaderController() {
    }

    public void load() {
        try {
            //   System.out.println("========================================" + "\n|------ Start Loading File Info --------|");

            ShipData.getInstance().resetShipTrees();
            readShips();
            ShipData.getInstance().generateTrees();

            //     System.out.println("|- End Loading Files Info With Success -|" + "\n========================================");

        } catch (Exception ex) {
            ex.printStackTrace();
            //   System.out.println("File localization is invalid!");

        }
    }

    private void readShips() throws FileNotFoundException, ParseException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader((USE_BIG_FILES ? FILE_SHIPS_BIG : FILE_SHIPS_SMALL)));
        sc.nextLine();


        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                ShipData.getInstance().fillMaps(Integer.parseInt(aux[0]), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(aux[1]), checkLat(aux[2]), checkLon(aux[3]), Double.parseDouble(aux[4]), Double.parseDouble(aux[5]), checkHeading(aux[6]), aux[7], aux[8], aux[9], Integer.parseInt(aux[10]), Integer.parseInt(aux[11]), Integer.parseInt(aux[12]), Double.parseDouble(aux[13]), checkCargo(aux[14]), aux[15], aux[16]);
            }
        }
        sc.close();

    }

    public Integer checkCargo(String cargo) {
        if (cargo.equals("NA")) {
            return 0;
        } else return Integer.parseInt(cargo);
    }


    public Double checkLat(String lat) {
        //[-90,90]
        double lati = Double.parseDouble(lat);
        if (lati < -90) {
            return -90.0;
        } else if (lati > 90) {
            return 90.0;
        }
        return lati;
    }


    public Double checkLon(String lon) {
        //[-180,180]
        double longi = Double.parseDouble(lon);
        if (longi < -180) {
            return -180.0;
        } else if (longi > 180) {
            return 180.0;
        }
        return longi;
    }


    public int checkHeading(String head) {
        //[0,359]
        int heady = Integer.parseInt(head);
        if (heady < 0) {
            return 0;
        } else if (heady > 359) {
            return 359;
        }
        return heady;
    }

    public static boolean isUseBigFiles() {
        return USE_BIG_FILES;
    }
}
