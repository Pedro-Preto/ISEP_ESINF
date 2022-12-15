package Model.Ship;

import java.util.Objects;

public class ShipDto {

    private int mmsi;
    private int nMovements;
    private double traveledDistance;
    private double deltaDistance;
    private double meanSOG;
    private int vesselType;

    private int mmsiShip1;
    private int mmsiShip2;
    private double traveledDistanceShip1;
    private double traveledDistanceShip2;
    private int nMovimentosShips1;
    private int nMovimentosShips2;
    private double traveledDistanceDiference;

    public ShipDto(int mmsi, int nMovements, double traveledDistance, double deltaDistance) {
        this.mmsi = mmsi;
        this.nMovements = nMovements;
        this.traveledDistance = traveledDistance;
        this.deltaDistance = deltaDistance;
    }

    public ShipDto(int mmsi, double traveledDistance, double meanSOG, int vesselType) {
        this.mmsi = mmsi;
        this.traveledDistance = traveledDistance;
        this.meanSOG = meanSOG;
        this.vesselType = vesselType;
    }

    public ShipDto(int mmsiShip1, int mmsiShip2, double traveledDistanceShip1, double traveledDistanceShip2, int nMovimentosShips1, int nMovimentosShips2, double traveledDistanceDiference) {
        this.mmsiShip1 = mmsiShip1;
        this.mmsiShip2 = mmsiShip2;
        this.traveledDistanceShip1 = traveledDistanceShip1;
        this.traveledDistanceShip2 = traveledDistanceShip2;
        this.nMovimentosShips1 = nMovimentosShips1;
        this.nMovimentosShips2 = nMovimentosShips2;
        this.traveledDistanceDiference = traveledDistanceDiference;
    }

    public int getMmsiShip1() {
        return mmsiShip1;
    }

    public void setMmsiShip1(int mmsiShip1) {
        this.mmsiShip1 = mmsiShip1;
    }

    public int getMmsiShip2() {
        return mmsiShip2;
    }

    public void setMmsiShip2(int mmsiShip2) {
        this.mmsiShip2 = mmsiShip2;
    }

    public double getTraveledDistanceShip1() {
        return traveledDistanceShip1;
    }

    public void setTraveledDistanceShip1(double traveledDistanceShip1) {
        this.traveledDistanceShip1 = traveledDistanceShip1;
    }

    public double getTraveledDistanceDiference() {
        return traveledDistanceDiference;
    }

    public void setTraveledDistanceDiference(double traveledDistanceDiference) {
        this.traveledDistanceDiference = traveledDistanceDiference;
    }

    public double getTraveledDistanceShip2() {
        return traveledDistanceShip2;
    }

    public void setTraveledDistanceShip2(double traveledDistanceShip2) {
        this.traveledDistanceShip2 = traveledDistanceShip2;
    }

    public int getnMovimentosShips1() {
        return nMovimentosShips1;
    }

    public void setnMovimentosShips1(int nMovimentosShips1) {
        this.nMovimentosShips1 = nMovimentosShips1;
    }

    public int getnMovimentosShips2() {
        return nMovimentosShips2;
    }

    public void setnMovimentosShips2(int nMovimentosShips2) {
        this.nMovimentosShips2 = nMovimentosShips2;
    }

    public int getVesselType() {
        return vesselType;
    }

    public void setVesselType(int vesselType) {
        this.vesselType = vesselType;
    }

    public double getMeanSOG() {
        return meanSOG;
    }

    public void setMeanSOG(double meanSOG) {
        this.meanSOG = meanSOG;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public int getnMovements() {
        return nMovements;
    }

    public void setnMovements(int nMovements) {
        this.nMovements = nMovements;
    }

    public double getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(double traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public double getDeltaDistance() {
        return deltaDistance;
    }

    public void setDeltaDistance(double deltaDistance) {
        this.deltaDistance = deltaDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipDto)) return false;
        ShipDto shipDto = (ShipDto) o;
        return mmsi == shipDto.mmsi && nMovements == shipDto.nMovements && Double.compare(shipDto.traveledDistance, traveledDistance) == 0 && Double.compare(shipDto.deltaDistance, deltaDistance) == 0 && Double.compare(shipDto.meanSOG, meanSOG) == 0 && Double.compare(shipDto.vesselType, vesselType) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mmsi, nMovements, traveledDistance, deltaDistance, meanSOG, vesselType);
    }

    @Override
    public String toString() {
        return String.format("MMSI:%s ,Traveled Distance:%s ,MeanSog:%s ,Vessel Type:%s", mmsi, traveledDistance, meanSOG, vesselType);
    }

    public String toString2() {
        return String.format("MMSI:%s ,NºMovements:%s ,Traveled Distance:%s ,Delta Distance:%s", mmsi, nMovements, traveledDistance, deltaDistance);
    }
}