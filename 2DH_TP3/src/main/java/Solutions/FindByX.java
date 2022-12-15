package Solutions;

import Model.ElementAtomicMass;
import Model.ElementAtomicNumber;
import Model.ElementByName;
import Model.ElementBySymbol;
import tree.*;

public class FindByX {

    public ElementAtomicNumber findByAtomicNumber(BST<ElementAtomicNumber> tree , Integer atomicNumber) {
        if (atomicNumber != null && tree != null) {
            ElementAtomicNumber elementAtomicNumber = tree.find(new ElementAtomicNumber(atomicNumber));
            if (elementAtomicNumber == null) {
                System.out.println("Not able to found that Element");

            } else {
                System.out.println(elementAtomicNumber.getElement());
                return elementAtomicNumber;
            }
        } else
            System.out.println("Not able to found that Element");
        return null;
    }

    public ElementByName findByName(BST<ElementByName> tree, String name) {
        if (name != null && tree != null) {
            ElementByName element = tree.find(new ElementByName(name));
            if (element == null) {
                System.out.println("Not able to found that Element");

            } else {
                System.out.println(element.getElement());
                return element;
            }
        } else
            System.out.println("Not able to found that Element");
        return null;

    }

    public ElementBySymbol findBySymbol( BST<ElementBySymbol> tree, String symbol) {
        if (symbol != null && tree != null) {
            ElementBySymbol elementBySymbol = tree.find(new ElementBySymbol(symbol));
            if (elementBySymbol == null) {
                System.out.println("Not able to found that Element");

            } else {
                System.out.println(elementBySymbol.getElement());
                return elementBySymbol;
            }
        } else
            System.out.println("Not able to found that Element");
        return null;


    }

    public ElementAtomicMass findByAtomicMass(BST<ElementAtomicMass> tree, Double mass) {
        if (mass != null && tree != null) {
            ElementAtomicMass elementAtomicMass = tree.find(new ElementAtomicMass(mass));
            if (elementAtomicMass == null) {
                System.out.println("Not able to found that Element");

            } else {
                System.out.println(elementAtomicMass.getElement());
                return elementAtomicMass;
            }
        } else
            System.out.println("Not able to found that Element");
        return null;


    }

}
