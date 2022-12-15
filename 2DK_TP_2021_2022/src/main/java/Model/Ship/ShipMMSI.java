package Model.Ship;

import java.util.List;

public class ShipMMSI extends Ship implements Comparable<ShipMMSI> {
    private List<ShipMMSI> mapList;
    private double travelDistance;

    public ShipMMSI(int mMSI) {
        super();
        super.setmMSI(mMSI);
    }

    public ShipMMSI(Ship ship) {
        super(ship);
    }

    public ShipMMSI(int mmsi, List<ShipMMSI> mapList) {
        super();
        super.setmMSI(mmsi);
        super.setVesselType(mapList.get(0).getVesselType());
        this.mapList = mapList;
    }

    public ShipMMSI(Ship ship, double travelDistance) {
        super(ship);
        this.travelDistance = travelDistance;
    }

    public List<ShipMMSI> getMapList() {
        return mapList;
    }

    @Override
    public String toString() {
        return String.format("MMSI: %d", mapList.get(0).getmMSI());
    }

    public String toSuperString() {
        return super.toString();
    }

    public double getTravelDistance() {
        return travelDistance;
    }


    @Override
    public int compareTo(ShipMMSI o) {
        return this.getmMSI() - o.getmMSI();
    }

}
