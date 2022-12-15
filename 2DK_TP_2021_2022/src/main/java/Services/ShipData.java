package Services;

import AlgorithmsPL.tree.BST;
import Model.Ship.Ship;
import Model.Ship.ShipCallSign;
import Model.Ship.ShipIMO;
import Model.Ship.ShipMMSI;

import java.util.Date;

public class ShipData {
    private static ShipData instance = null;
    private static TreeShipGenerator treeShipGenerator;

    private ShipData() {
        treeShipGenerator = new TreeShipGenerator();
    }

    public void fillMaps(int mMSI, Date baseDateTime, double lAT, double lON, double sOG, double cOG, int heading, String vesselName, String iMO, String callSign, int vesselType, int length, int width, double draft, int cargo, String transcieverClass, String vehicleID) {
        Ship ship = new Ship(mMSI, baseDateTime, lAT, lON, sOG, cOG, heading, vesselName, iMO, callSign, vesselType, length, width, draft, cargo, transcieverClass, vehicleID);
        treeShipGenerator.fillMaps(ship);
    }

    public void generateTrees() {
        treeShipGenerator.createTrees();
    }

    public BST<ShipMMSI> getTreeShipMMSI() {
        return treeShipGenerator.getTreeMMSI();
    }

    public BST<ShipIMO> getTreeShipIMO() {
        return treeShipGenerator.getTreeIMO();
    }

    public BST<ShipCallSign> getTreeShipCallSign() {
        return treeShipGenerator.getTreeCallSign();
    }

    public static ShipData getInstance() {
        if (instance == null) {
            instance = new ShipData();
        }
        return instance;
    }

    public void resetShipTrees() {
        treeShipGenerator.resetTress();
    }
}
