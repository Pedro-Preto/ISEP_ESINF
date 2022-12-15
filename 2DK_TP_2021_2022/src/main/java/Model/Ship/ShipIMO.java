package Model.Ship;

import java.util.List;

public class ShipIMO extends Ship implements Comparable<ShipIMO> {

    private List<ShipIMO> mapList;

    public ShipIMO(String imo) {
        super();
        super.setiMO(imo);
    }

    public ShipIMO(Ship ship) {
        super(ship);
    }

    public ShipIMO(String imo, List<ShipIMO> mapList) {
        super();
        super.setiMO(imo);
        this.mapList = mapList;
    }

    public List<ShipIMO> getMapList() {
        return mapList;
    }

    @Override
    public int compareTo(ShipIMO o) {
        return this.getiMO().compareTo(o.getiMO());
    }

    @Override
    public String toString() {
        return String.format("IMO: %s", mapList.get(0).getiMO());
    }

    public String toSuperString() {
        return super.toString();
    }
}
