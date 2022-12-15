/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author andre
 */
public class ElementBySymbol extends Element implements Comparable<ElementBySymbol> {

    public ElementBySymbol(String symbol) {
        super();
        super.setSymbol(symbol);
    }

    public ElementBySymbol(Element e) {
        super(e);
    }

    @Override
    public int compareTo(ElementBySymbol o) {
        return this.getSymbol().compareTo(o.getSymbol());
    }
}
