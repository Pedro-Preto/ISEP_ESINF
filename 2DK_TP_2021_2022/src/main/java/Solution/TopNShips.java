package Solution;

import AlgorithmsPL.tree.BST;
import Model.Ship.ShipDto;
import Model.Ship.ShipMMSI;

import java.util.*;
import java.util.stream.Collectors;

public class TopNShips {
    ShipResume shipResume;

    public void topNShips(int shipNumber, Date start, Date end, BST<ShipMMSI> tree) {
        shipResume = new ShipResume();
        List<ShipDto> shipDtos = new LinkedList<>();

        for (ShipMMSI s : tree.inOrder()) {
            shipDtos.add(new ShipDto(s.getmMSI(), shipResume.getTravelDistance(movementsInACertainPeriod(start, end, s.getMapList())), shipResume.getMeanSOG(movementsInACertainPeriod(start, end, s.getMapList())), s.getVesselType()));
        }
        shipDtos.sort(Comparator.comparing(ShipDto::getTraveledDistance, Collections.reverseOrder()));

        while (shipDtos.size() > shipNumber) shipDtos.remove(shipDtos.size() - 1);

        Map<Integer, List<ShipDto>> shipDtoMapGrouped = shipDtos.stream().collect(Collectors.groupingBy(ShipDto::getVesselType));

        for (Map.Entry<Integer, List<ShipDto>> entry : shipDtoMapGrouped.entrySet()) System.out.println(entry);
    }

    private List<ShipMMSI> movementsInACertainPeriod(Date start, Date end, List<ShipMMSI> movements) {
        List<ShipMMSI> filteredMovements = new LinkedList<>();

        for (ShipMMSI s : movements) {
            if (s.getBaseDateTime().after(start) && s.getBaseDateTime().before(end)) {
                filteredMovements.add(s);
            }
        }
        return filteredMovements;
    }

}

