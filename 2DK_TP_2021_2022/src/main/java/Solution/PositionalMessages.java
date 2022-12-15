package Solution;

import AlgorithmsPL.tree.BST;
import Model.Ship.ShipMMSI;

import java.util.Date;

public class PositionalMessages {

    public void getPositionalMessagesByPeriod(Date start, Date end, int mmsi, BST<ShipMMSI> tree) {
        for (ShipMMSI s : tree.find(new ShipMMSI(mmsi)).getMapList()) {
            if (s.getBaseDateTime().after(start) && s.getBaseDateTime().before(end)) {
                System.out.println(s.toSuperString());
            }
        }
    }


    public void getPositionalMessagesByDate(Date date, int mmsi, BST<ShipMMSI> tree) {
        for (ShipMMSI s : tree.find(new ShipMMSI(mmsi)).getMapList()) {
            if (s.getBaseDateTime().equals(date)) {
                System.out.println(s.toSuperString());
            }
        }
    }
}
