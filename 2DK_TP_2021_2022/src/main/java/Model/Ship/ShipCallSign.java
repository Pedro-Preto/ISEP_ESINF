package Model.Ship;

import java.util.List;

public class ShipCallSign extends Ship implements Comparable<ShipCallSign> {
    private List<ShipCallSign> mapList;


    public ShipCallSign(String callSign) {
        super();
        super.setCallSign(callSign);
    }

    public ShipCallSign(Ship ship) {
        super(ship);
    }

    public ShipCallSign(String callSign, List<ShipCallSign> mapList) {
        super();
        super.setCallSign(callSign);
        this.mapList = mapList;
    }

    public List<ShipCallSign> getMapList() {
        return mapList;
    }

    @Override
    public int compareTo(ShipCallSign o) {
        return this.getCallSign().compareTo(o.getCallSign());
    }

    @Override
    public String toString() {
        return String.format("Call Sign: %s", mapList.get(0).getCallSign());
    }

    public String toSuperString() {
        return super.toString();
    }
}
