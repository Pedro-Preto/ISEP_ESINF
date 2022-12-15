package Services;

import Model.*;
import Solutions.*;
import tree.BST;

public class Data {

    private static Data instance = null;
    private final TreeBuilder treeBuilder;
    private final FindByX findByX;
    private final AtomicMassLimit atomicMassLimit;
    private final MostDistanteEletronicConfig mostDistanteEletronicConfig;
    private final DecrescenteElectronicConfig decrescenteElectronicConfig;
    private final BSTDecrescente bstDecrescente;

    private Data() {
        this.treeBuilder = new TreeBuilder();
        this.findByX = new FindByX();
        this.atomicMassLimit = new AtomicMassLimit();
        this.mostDistanteEletronicConfig = new MostDistanteEletronicConfig();
        this.decrescenteElectronicConfig = new DecrescenteElectronicConfig();
        this.bstDecrescente = new BSTDecrescente();
    }

    public void createTrees(int atomicNumber, String element, String symbol, Double atomicWeight, Double atomicMass, int period,
                            int group, String phase, String mostStableCrystal, String type, Double ionicRadius, Double atomicRadius, Double electronegativity,
                            Double firstIonizationPotential, Double density, Double meltingPoint, Double boilingPoint, int isotopes, String discoverer, int yearOfDiscovery,
                            Double specificHeatCapacity, String electronConfiguration, int displayRow, int displayColumn) {
        Element el = new Element(atomicNumber, element, symbol, atomicWeight, atomicMass, period, group, phase, mostStableCrystal, type, ionicRadius, atomicRadius, electronegativity, firstIonizationPotential, density, meltingPoint, boilingPoint, isotopes, discoverer, yearOfDiscovery, specificHeatCapacity, electronConfiguration, displayRow, displayColumn);
        treeBuilder.createTrees(el);

    }

    public TreeBuilder treeBuilder() {
        return treeBuilder;
    }

    public void getElementAtomicNumber(BST<ElementAtomicNumber> tree, Integer number) {
        findByX.findByAtomicNumber(tree, number);
    }

    public void getElementByName(BST<ElementByName> tree, String name) {
        findByX.findByName(tree, name);
    }

    public void getElementBySymbol(BST<ElementBySymbol> tree, String symbol) {
        findByX.findBySymbol(tree, symbol);
    }

    public void getElementAtomicMass(BST<ElementAtomicMass> tree, double mass) {
        findByX.findByAtomicMass(tree, mass);

    }

    public void getElementByAtomicMassInCertainLimit(BST<ElementAtomicMass> tree, int limit1, int limit2) {
        atomicMassLimit.getElementByAtomicMassInCertainLimit(tree, limit1, limit2);
    }

    public void newBST(BST<ElementAtomicNumber> tree) {
        bstDecrescente.newBST(tree);
    }

    public void getMostDistanceNodes(BST<ElementAtomicNumber> tree) {
        mostDistanteEletronicConfig.getMostDistanceNodes(tree);
    }

    public void getDecrescenteElectronicConfig(BST<ElementAtomicNumber> tree) {
        decrescenteElectronicConfig.occurrencesByElectronConf(tree);
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }

        return instance;
    }

}
