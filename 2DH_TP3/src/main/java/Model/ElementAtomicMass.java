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
public class ElementAtomicMass extends Element implements Comparable<ElementAtomicMass> {

    public ElementAtomicMass(double atomicMass){
        super();
        super.setAtomic_mass(atomicMass);
    }
    
    public ElementAtomicMass(Element e) {
        super(e);
    }

    @Override
    public int compareTo(ElementAtomicMass o) {
        return this.getAtomic_mass().compareTo(o.getAtomic_mass());
    }

    @Override
    public String toString() {
        return super.getAtomic_mass().toString();
    }

}
