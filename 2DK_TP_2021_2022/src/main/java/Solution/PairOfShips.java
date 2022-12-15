package Solution;

import AlgorithmsPL.tree.BST;
import Model.Ship.ShipDto;
import Model.Ship.ShipMMSI;

import java.util.*;

public class PairOfShips {

    public void getPairOfShips(BST<ShipMMSI> tree) {
        ShipResume shipResume = new ShipResume();
        List<ShipDto> pairOfShips = new LinkedList<>();
        for (ShipMMSI ship1 : tree.inOrder()) {
            double deltaDistance1 = shipResume.getDeltaDistance(ship1.getMapList());
            double travelDistance1 = shipResume.getTravelDistance(ship1.getMapList());
            if (deltaDistance1 <= 5 && travelDistance1 > 10) {
                for (ShipMMSI ship2 : tree.inOrder()) {
                    if (ship1.getmMSI() != ship2.getmMSI()) {
                        double deltaDistance2 = shipResume.getDeltaDistance(ship2.getMapList());
                        double travelDistance2 = shipResume.getTravelDistance(ship2.getMapList());
                        if (deltaDistance2 <= 5 && travelDistance2 > 10) {
                            {
                                pairOfShips.add(new ShipDto(ship1.getmMSI(), ship2.getmMSI(), shipResume.getTravelDistance(ship1.getMapList()), shipResume.getTravelDistance(ship2.getMapList()), shipResume.getTotalNumberOfMovements(ship1.getMapList()), shipResume.getTotalNumberOfMovements(ship2.getMapList()), shipResume.getTotalNumberOfMovements(ship1.getMapList()) - shipResume.getTotalNumberOfMovements(ship2.getMapList())));
                            }
                        }
                    }
                }
            }
        }
        pairOfShips.sort(Comparator.comparing(ShipDto::getMmsiShip1).reversed().thenComparingDouble(ShipDto::getTraveledDistanceDiference));
        System.out.printf("%-10s  %-10s  %-10s  %-10s  %-10s  %-10s\n","Ship1MMSI","Ship2MMSI","Ship1TravelDistance","Ship2TravelDistance","Ship1Movements","Ship2Movements");
        for (ShipDto dto:pairOfShips) {
            System.out.printf("%-10d  %-10d  %-19f  %-19f  %-14d  %-10d\n",dto.getMmsiShip1(),dto.getMmsiShip2(),dto.getTraveledDistanceShip1(),dto.getTraveledDistanceShip2(),dto.getnMovimentosShips1(),dto.getnMovimentosShips2());

        }
    }

}
