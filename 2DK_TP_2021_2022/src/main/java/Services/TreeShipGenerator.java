package Services;

import AlgorithmsPL.tree.AVL;
import AlgorithmsPL.tree.BST;
import Model.Ship.Ship;
import Model.Ship.ShipCallSign;
import Model.Ship.ShipIMO;
import Model.Ship.ShipMMSI;

import java.util.*;

public class TreeShipGenerator {


    /**
     * Variable representative of the BST for MMSI
     */
    public BST<ShipMMSI> treeMMSI;

    /**
     * Variable representative of the BST for IMO
     */
    public BST<ShipIMO> treeIMO;

    /**
     * Variable representative of the BST for Call Sign
     */
    public BST<ShipCallSign> treeCallSign;

    /**
     * Variable representative of List of Maps for ShipMMSI
     */
    public Map<Integer, List<ShipMMSI>> mapShipMMSI;
    /**
     * Variable representative of List of Maps for ShipIMO
     */
    public Map<String, List<ShipIMO>> mapShipIMO;
    /**
     * Variable representative of List of Maps for ShipCallSign
     */
    public Map<String, List<ShipCallSign>> mapShipCallSign;

    public TreeShipGenerator() {
        this.mapShipCallSign = new HashMap<>();
        this.mapShipIMO = new HashMap<>();
        this.mapShipMMSI = new HashMap<>();
        this.treeMMSI = new AVL<>();
        this.treeIMO = new AVL<>();
        this.treeCallSign = new AVL<>();
    }

    public void resetTress() {
        this.treeMMSI = new AVL<>();
        this.treeIMO = new AVL<>();
        this.treeCallSign = new AVL<>();
        this.mapShipMMSI = new HashMap<>();
        this.mapShipIMO = new HashMap<>();
        this.mapShipCallSign = new HashMap<>();
    }

    public BST<ShipMMSI> getTreeMMSI() {
        return treeMMSI;
    }

    public BST<ShipIMO> getTreeIMO() {
        return treeIMO;
    }

    public BST<ShipCallSign> getTreeCallSign() {
        return treeCallSign;
    }

    public void createTrees() {
        createMMSITree();
        createImoTree();
        createCallSignTree();
    }

    private void createMMSITree() {
        for (Map.Entry<Integer, List<ShipMMSI>> m : mapShipMMSI.entrySet()) {
            m.getValue().sort(Comparator.comparing(Ship::getBaseDateTime));
        }
        for (Map.Entry<Integer, List<ShipMMSI>> m : mapShipMMSI.entrySet()) {
            treeMMSI.insert(new ShipMMSI(m.getKey(), m.getValue()));
        }
    }

    private void createImoTree() {
        for (Map.Entry<String, List<ShipIMO>> m : mapShipIMO.entrySet()) {
            m.getValue().sort(Comparator.comparing(Ship::getBaseDateTime));
        }
        for (Map.Entry<String, List<ShipIMO>> m : mapShipIMO.entrySet()) {
            treeIMO.insert(new ShipIMO(m.getKey(), m.getValue()));
        }
    }

    private void createCallSignTree() {
        for (Map.Entry<String, List<ShipCallSign>> m : mapShipCallSign.entrySet()) {
            m.getValue().sort(Comparator.comparing(Ship::getBaseDateTime));
        }
        for (Map.Entry<String, List<ShipCallSign>> m : mapShipCallSign.entrySet()) {
            treeCallSign.insert(new ShipCallSign(m.getKey(), m.getValue()));
        }
    }

    public void fillMaps(Ship e) {
        fillMMSImap(e);
        fillIMOmap(e);
        fillCallSignMap(e);
    }

    private void fillMMSImap(Ship e) {
        if (containByMMSI(e.getmMSI(), mapShipMMSI)) {
            mapShipMMSI.get(e.getmMSI()).add(new ShipMMSI(e));
        } else {
            List<ShipMMSI> l = new LinkedList<>();
            l.add(new ShipMMSI(e));
            mapShipMMSI.put(e.getmMSI(), l);
        }

    }

    private void fillIMOmap(Ship e) {
        if (containByIMO(e.getiMO(), mapShipIMO)) {
            mapShipIMO.get(e.getiMO()).add(new ShipIMO(e));
        } else {
            List<ShipIMO> l = new LinkedList<>();
            l.add(new ShipIMO(e));
            mapShipIMO.put(e.getiMO(), l);
        }

    }

    private void fillCallSignMap(Ship e) {
        if (containByCallSign(e.getCallSign(), mapShipCallSign)) {
            mapShipCallSign.get(e.getCallSign()).add(new ShipCallSign(e));
        } else {
            List<ShipCallSign> l = new LinkedList<>();
            l.add(new ShipCallSign(e));
            mapShipCallSign.put(e.getCallSign(), l);
        }

    }

    private boolean containByMMSI(int mmsi, Map<Integer, List<ShipMMSI>> map) {
        for (Map.Entry<Integer, List<ShipMMSI>> entry : map.entrySet()) {
            if (entry.getKey() == mmsi) {
                return true;
            }
        }
        return false;
    }

    private boolean containByIMO(String imo, Map<String, List<ShipIMO>> map) {
        for (Map.Entry<String, List<ShipIMO>> entry : map.entrySet()) {
            if (entry.getKey().equals(imo)) {
                return true;
            }
        }
        return false;
    }

    private boolean containByCallSign(String callSign, Map<String, List<ShipCallSign>> map) {
        for (Map.Entry<String, List<ShipCallSign>> entry : map.entrySet()) {
            if (entry.getKey().equals(callSign)) {
                return true;
            }
        }
        return false;
    }
}
