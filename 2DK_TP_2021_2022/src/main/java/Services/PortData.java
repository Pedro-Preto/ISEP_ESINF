package Services;

import AlgorithmsPL.tree2D.KdTree;
import AlgorithmsPL.tree2D.Node;
import Model.Country.Country;
import Model.Port.Port;

import java.util.List;

public class PortData {
    private static PortData instance = null;
    Tree2DPortGenerator tree2DPortGenerator;

    private PortData() {
        tree2DPortGenerator = new Tree2DPortGenerator();
    }
    public void fillPortNodeList(String continent, Country country, int code, String portCity, double lat, double lon) {
        Port port = new Port(continent, country, code, portCity, lat, lon);
        tree2DPortGenerator.fillList(port);
    }

    public void build2DPortTree() {
        tree2DPortGenerator.build2DPortTree();
    }

    public List<Node<Port>> getPortNodeList() {
        return tree2DPortGenerator.getNodeList();
    }

    public KdTree<Port> getPort2dTree(){
        return tree2DPortGenerator.getPort2dTree();
    }

    public void reset2DPortTree() {
        tree2DPortGenerator.reset2DPortTree();
    }

    public static PortData getInstance() {
        if (instance == null) {
            instance = new PortData();
        }
        return instance;
    }


}
