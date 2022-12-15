package Solution;

import AlgorithmsPL.tree.BST;
import Model.Ship.ShipDto;
import Model.Ship.ShipMMSI;

import java.util.LinkedList;
import java.util.List;

public class ShipListDetails {
    ShipResume shipResume;

    public void shipDetails(BST<ShipMMSI> tree) {
        List<ShipDto> list = new LinkedList<>();
        shipResume = new ShipResume();

        for (ShipMMSI s : tree.inOrder()) {
            list.add(new ShipDto(s.getmMSI(), s.getMapList().size(), shipResume.getTravelDistance(s.getMapList()), shipResume.getDeltaDistance(s.getMapList())));
        }

        list.stream().map(ShipDto::toString2).forEach(System.out::println);
    }

}
