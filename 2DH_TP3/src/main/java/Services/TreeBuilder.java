package Services;

import Model.*;
import tree.*;


public class TreeBuilder {


    public BST<ElementAtomicNumber> treeAtomicNumber;

    /**
     * Variable representative of the BST for Atomic Mass
     */
    public BST<ElementAtomicMass> treeAtomicMass;

    /**
     * Variable representative of the BST for Element Name
     */
    public BST<ElementByName> treeByName;

    /**
     * Variable representative of the BST for Element Symbol
     */
    public BST<ElementBySymbol> treeBySymbol;

    /**
     * Variable representative of the BST for Element by Discovered and year of
     * discovered
     */

    public TreeBuilder() {
        this.treeAtomicNumber = new AVL<>();
        this.treeAtomicMass = new AVL<>();
        this.treeByName = new AVL<>();
        this.treeBySymbol = new AVL<>();
    }

    public void createTrees(Element e) {
        treeAtomicNumber.insert(new ElementAtomicNumber(e));
        treeAtomicMass.insert(new ElementAtomicMass(e));
        treeByName.insert(new ElementByName(e));
        treeBySymbol.insert(new ElementBySymbol(e));
    }

    public BST<ElementAtomicNumber> getTreeAtomicNumber() {
        return treeAtomicNumber;
    }

    public BST<ElementAtomicMass> getTreeAtomicMass() {
        return treeAtomicMass;
    }

    public BST<ElementByName> getTreeByName() {
        return treeByName;
    }

    public BST<ElementBySymbol> getTreeBySymbol() {
        return treeBySymbol;
    }


}
