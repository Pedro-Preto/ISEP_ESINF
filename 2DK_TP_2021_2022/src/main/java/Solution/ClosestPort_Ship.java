package Solution;

import AlgorithmsPL.tree.BST;
import AlgorithmsPL.tree2D.KdTree;
import Model.Port.Port;
import Model.Ship.ShipCallSign;

import java.util.Date;
import java.util.List;

public class ClosestPort_Ship {

    public void getNearestPort(KdTree<Port> ports, String shipCallSign, BST<ShipCallSign> treeCallSign, Date baseDateTime) {
        ShipCallSign ship = getNearestDate(treeCallSign.find(new ShipCallSign(shipCallSign)).getMapList(), baseDateTime);
        System.out.println(ports.findNearestNeighbour(ship.getlAT(), ship.getlON()));
    }

    public static ShipCallSign getNearestDate(List<ShipCallSign> dates, Date currentDate) {
        long minDiff = -1, currentTime = currentDate.getTime();
        ShipCallSign minDate = null;
        for (ShipCallSign date : dates) {
            long diff = Math.abs(currentTime - date.getBaseDateTime().getTime());
            if ((minDiff == -1) || (diff < minDiff)) {
                minDiff = diff;
                minDate = date;
            }
        }
        return minDate;
    }
}



