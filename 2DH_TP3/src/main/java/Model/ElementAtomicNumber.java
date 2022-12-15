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
public class ElementAtomicNumber extends Element implements Comparable<ElementAtomicNumber> {

    public ElementAtomicNumber(Integer atomic_number) {
        super();
        super.setAtomic_number(atomic_number);
    }
    
    public ElementAtomicNumber(Element e) {
        super(e);
    }

    @Override
    public int compareTo(ElementAtomicNumber o) {
        return this.getAtomic_number().compareTo(o.getAtomic_number());
    }

    @Override
    public String toString() {
        return super.getAtomic_number().toString();
    }
}
