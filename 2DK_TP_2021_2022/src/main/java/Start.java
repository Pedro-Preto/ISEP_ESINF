import Controller.NetWorkGeneratorController;
import Controller.Tree2DReaderController;
import Controller.TreeReaderController;
import Model.Point.Point;
import Services.NetWorkData;
import Services.PortData;
import Services.ShipData;
import Solution.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws ParseException {
        TreeReaderController treeReaderController = new TreeReaderController();
        treeReaderController.load();
        Tree2DReaderController tree2DReaderController = new Tree2DReaderController();
        tree2DReaderController.load();
        NetWorkGeneratorController netWorkGeneratorController = new NetWorkGeneratorController();
        netWorkGeneratorController.load();

        SearchByAttribute searchByAttribute = new SearchByAttribute();
        PositionalMessages messages = new PositionalMessages();
        ShipResume shipResume = new ShipResume();
        ShipListDetails shipListDetails = new ShipListDetails();
        TopNShips topNShips = new TopNShips();
        PairOfShips pairOfShips = new PairOfShips();
        ClosestPort_Ship closestPort_ship = new ClosestPort_Ship();

        ColorNetWork colorNetWork = new ColorNetWork();
        ClosestCitiesAndPorts closestCitiesAndPorts = new ClosestCitiesAndPorts();
        CriticalPorts criticalPorts = new CriticalPorts();
        PathBtwnTwoPoints pathBtwnTwoPoints = new PathBtwnTwoPoints();
        HeuristicCircuit heuristicCircuit = new HeuristicCircuit();


        do {

            switch (showOptions()) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    switch (showSearchOptions()) {
                        case 0:
                            break;
                        case 1:
                            searchByAttribute.searchByMMSI(210950000, ShipData.getInstance().getTreeShipMMSI());
                            break;
                        case 2:
                            searchByAttribute.searchByIMO("IMO9395044", ShipData.getInstance().getTreeShipIMO());
                            break;
                        case 3:
                            searchByAttribute.searchByCallSign("C4SQ2", ShipData.getInstance().getTreeShipCallSign());
                            break;
                        default:
                            break;
                    }
                    break;

                case 2:
                    switch (showPositionalMessagesOptions()) {
                        case 0:
                            break;
                        case 1:
                            messages.getPositionalMessagesByPeriod(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 210950000, ShipData.getInstance().getTreeShipMMSI());
                            break;
                        case 2:
                            messages.getPositionalMessagesByDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), 210950000, ShipData.getInstance().getTreeShipMMSI());
                            break;
                        default:
                            break;
                    }
                    break;

                case 3:
                    shipResume.getShipResume(210950000, ShipData.getInstance().getTreeShipMMSI());
                    break;

                case 4:
                    shipListDetails.shipDetails(ShipData.getInstance().getTreeShipMMSI());
                    break;

                case 5:
                    topNShips.topNShips(10, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 14:32"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"), ShipData.getInstance().getTreeShipMMSI());
                    break;
                case 6:
                    pairOfShips.getPairOfShips(ShipData.getInstance().getTreeShipMMSI());
                    break;
                case 7:
                    closestPort_ship.getNearestPort(PortData.getInstance().getPort2dTree(), "WDD4527", ShipData.getInstance().getTreeShipCallSign(), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03"));

                    break;
                case 8:
                    colorNetWork.colorVertices(NetWorkData.getInstance().getNetWork());
                    break;
                case 9:
                    closestCitiesAndPorts.getClosestPlaces(NetWorkData.getInstance().getNetWork(), NetWorkData.getInstance().getPointByCountryName("Portugal"), 5);
                    break;
                case 10:
                    criticalPorts.getPortsCriticality(NetWorkData.getInstance().getNetWork(), 4);
                    break;
                case 11:
                    switch (showPathBtwTwoPointsOptions()) {
                        case 1:
                            pathBtwnTwoPoints.landPath(NetWorkData.getInstance().getNetWork(), NetWorkData.getInstance().getPointByCountryName("Portugal"), NetWorkData.getInstance().getPointByCountryName("Armenia"), new LinkedList<>(Arrays.asList(NetWorkData.getInstance().getPointByCountryName("Serbia"), NetWorkData.getInstance().getPointByCountryName("Bosnia"))));
                            NetWorkData.getInstance().resetMap();
                            netWorkGeneratorController.load();
                            break;
                        case 2:
                            pathBtwnTwoPoints.maritimePath(NetWorkData.getInstance().getNetWork(), NetWorkData.getInstance().getPointByPortCityName("Cutuco"), NetWorkData.getInstance().getPointByPortCityName("Barcelona"), new LinkedList<>(Arrays.asList(NetWorkData.getInstance().getPointByPortCityName("St Petersburg"), NetWorkData.getInstance().getPointByPortCityName("Piraeus"))));
                            NetWorkData.getInstance().resetMap();
                            netWorkGeneratorController.load();
                            break;
                        case 3:
                            pathBtwnTwoPoints.pathWithMandatoryLocations(NetWorkData.getInstance().getNetWork(), NetWorkData.getInstance().getPointByCountryName("Portugal"), NetWorkData.getInstance().getPointByPortCityName("Balboa"), new LinkedList<>(Arrays.asList(NetWorkData.getInstance().getPointByPortCityName("St Petersburg"), NetWorkData.getInstance().getPointByCountryName("Serbia"))));
                            NetWorkData.getInstance().resetMap();
                            netWorkGeneratorController.load();
                            break;
                    }
                    break;
                case 12:
                    heuristicCircuit.heuristicCircuit(NetWorkData.getInstance().getNetWork());
                    break;

                default:
                    System.out.println("Option does not exist!");
                    break;
            }
        } while (showOptions() != 0);
    }

    private static int showOptions() {
        Scanner in = new Scanner(System.in);
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Menu: ");
        System.out.println("=============================");
        System.out.println("1.Search By Attribute");
        System.out.println("2.PositionalMessages");
        System.out.println("3.ShipResume");
        System.out.println("4.ShipListDetails");
        System.out.println("5.TopNShips");
        System.out.println("6.PairOfShips");
        System.out.println("7.ClosestPort_Ship");
        System.out.println("8.ColorNetWork");
        System.out.println("9.ClosestCitiesAndPorts");
        System.out.println("10.CriticalPorts");
        System.out.println("11.PathBtwnTwoPoints");
        System.out.println("12.HeuristicCircuit");

        System.out.println("=============================");
        System.out.println("0.Exit\n\n");
        System.out.println("\nPlease select an option");
        option = in.nextInt();
        return option;
    }

    private static int showSearchOptions() {
        Scanner in = new Scanner(System.in);
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Search Menu: ");
        System.out.println("=============================");
        System.out.println("1.Search By MMSI");
        System.out.println("2.Search By IMO");
        System.out.println("3.Search By Call Sign");

        System.out.println("=============================");
        System.out.println("0.Exit\n\n");
        System.out.println("\nPlease select an option");
        option = in.nextInt();
        return option;
    }

    private static int showPositionalMessagesOptions() {
        Scanner in = new Scanner(System.in);
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Search Menu: ");
        System.out.println("=============================");
        System.out.println("1.Search By Period");
        System.out.println("2.Search By Date");

        System.out.println("=============================");
        System.out.println("0.Exit\n\n");
        System.out.println("\nPlease select an option");
        option = in.nextInt();
        return option;
    }

    private static int showPathBtwTwoPointsOptions() {
        Scanner in = new Scanner(System.in);
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Search Menu: ");
        System.out.println("=============================");
        System.out.println("1.Land Path");
        System.out.println("2.Maritime Path");
        System.out.println("3.Path");

        System.out.println("=============================");
        System.out.println("0.Exit\n\n");
        System.out.println("\nPlease select an option");
        option = in.nextInt();
        return option;
    }
}
