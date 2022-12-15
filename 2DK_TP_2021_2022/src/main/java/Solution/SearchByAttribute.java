package Solution;

import AlgorithmsPL.tree.BST;
import Model.Ship.ShipCallSign;
import Model.Ship.ShipIMO;
import Model.Ship.ShipMMSI;

public class SearchByAttribute {


    public void searchByMMSI(int mmsi, BST<ShipMMSI> tree) {
        for (ShipMMSI s : tree.find(new ShipMMSI(mmsi)).getMapList()) {
            System.out.println(s.toSuperString());
        }
    }

    public void searchByIMO(String imo, BST<ShipIMO> tree) {
        for (ShipIMO s : tree.find(new ShipIMO(imo)).getMapList()) {
            System.out.println(s.toSuperString());
        }
    }

    public void searchByCallSign(String callSign, BST<ShipCallSign> tree) {
        for (ShipCallSign s : tree.find(new ShipCallSign(callSign)).getMapList()) {
            System.out.println(s.toSuperString());
        }
    }

}
