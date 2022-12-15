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
public class ElementByName extends Element implements Comparable<ElementByName>{
    
    public ElementByName(String name) {
        super();
        super.setElement(name);
    }
    
    public ElementByName(Element e) {
        super(e);
    }

    @Override
    public int compareTo(ElementByName o) {
        return this.getElement().compareTo(o.getElement());
    }

}
