package Services;

import AlgorithmsPL.graph.matrix.MatrixGraph;
import AlgorithmsPL.tree2D.KdTree;
import AlgorithmsPL.tree2D.Node;
import Model.Country.Border;
import Model.Country.Country;
import Model.Country.SeaDists;
import Model.Point.Point;
import Model.Port.Port;

import java.util.List;

public class NetWorkData {
    private static NetWorkData instance = null;
    NetWorkGenerator netWorkGenerator;

    private NetWorkData() {
        netWorkGenerator = new NetWorkGenerator();
    }

    public void insertVertexes(Point point) {
        netWorkGenerator.insertVertexes(point);
    }

    public void addCapitalBorders(List<Border> borders) {
        netWorkGenerator.addCapitalBorders(borders);
    }

    public void addPortsSameCountryBorders(List<SeaDists> seaDists) {
        netWorkGenerator.addPortsSameCountryBorders(seaDists);
    }

    public void addCapitalPortBorder() {
        netWorkGenerator.addCapitalPortBorder();
    }

    public void addPortsNBorders(int n) {
        netWorkGenerator.addPortsNBorders(n);
    }

    public Point getPointByCountryName(String country) {
        return netWorkGenerator.getPointByCountryName(country);
    }

    public MatrixGraph<Point, Border> getNetWork() {
        return this.netWorkGenerator.getNetWork();
    }

    public Port getPortByCityName(String city) {
        return netWorkGenerator.getPortByCityName(city).getPort();
    }

    public Point getPointByPortCityName(String city) {
        return netWorkGenerator.getPortByCityName(city);
    }

    public void resetMap() {
        netWorkGenerator.resetMap();
    }

    public static NetWorkData getInstance() {
        if (instance == null) {
            instance = new NetWorkData();
        }
        return instance;
    }
}
