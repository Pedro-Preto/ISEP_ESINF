/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author andre
 */
public class Element {

    private Integer atomic_number;

    private String element;

    private String symbol;

    private Double atomic_weight;

    private Double atomic_mass;

    private Integer period;

    private Integer group;

    private String phase;

    private String most_stable_crystal;

    private String type;

    private Double ionic_radius;

    private Double atomic_radius;

    private Double electronegativity;

    private Double first_ionization_potential;

    private Double density;

    private Double melting_point;

    private Double boiling_point;

    private Integer isotepes;

    private String discoverer;

    private Integer year_of_discovery;

    private Double specific_heat_capacity;

    private String electron_configuration;

    private Integer display_row;

    private Integer display_column;

    public Element(Element e) {
        this.atomic_number = e.getAtomic_number();
        this.element = e.getElement();
        this.symbol = e.getSymbol();
        this.atomic_weight = e.getAtomic_weight();
        this.atomic_mass = e.getAtomic_mass();
        this.period = e.getPeriod();
        this.group = e.getGroup();
        this.phase = e.getPhase();
        this.most_stable_crystal = e.getMost_stable_crystal();
        this.type = e.getType();
        this.ionic_radius = e.getIonic_radius();
        this.atomic_radius = e.getAtomic_radius();
        this.electronegativity = e.getElectronegativity();
        this.first_ionization_potential = e.getFirst_ionization_potential();
        this.density = e.getDensity();
        this.melting_point = e.getMelting_point();
        this.boiling_point = e.getBoiling_point();
        this.isotepes = e.getIsotepes();
        this.discoverer = e.getDiscoverer();
        this.year_of_discovery = e.getYear_of_discovery();
        this.specific_heat_capacity = e.getSpecific_heat_capacity();
        this.electron_configuration = e.getElectron_configuration();
        this.display_row = e.getDisplay_row();
        this.display_column = e.getDisplay_column();
    }

    public Element(Integer atomic_number, String element, String symbol, Double atomic_weight, Double atomic_mass, Integer period, Integer group, String phase, String most_stable_crystal, String type, Double ionic_radius, Double atomic_radius, Double electronegativity, Double first_ionization_potential, Double density, Double melting_point, Double boiling_point, Integer isotepes, String discoverer, Integer year_of_discovery, Double specific_heat_capacity, String electron_configuration, Integer display_row, Integer display_column) {
        this.atomic_number = atomic_number;
        this.element = element;
        this.symbol = symbol;
        this.atomic_weight = atomic_weight;
        this.atomic_mass = atomic_mass;
        this.period = period;
        this.group = group;
        this.phase = phase;
        this.most_stable_crystal = most_stable_crystal;
        this.type = type;
        this.ionic_radius = ionic_radius;
        this.atomic_radius = atomic_radius;
        this.electronegativity = electronegativity;
        this.first_ionization_potential = first_ionization_potential;
        this.density = density;
        this.melting_point = melting_point;
        this.boiling_point = boiling_point;
        this.isotepes = isotepes;
        this.discoverer = discoverer;
        this.year_of_discovery = year_of_discovery;
        this.specific_heat_capacity = specific_heat_capacity;
        this.electron_configuration = electron_configuration;
        this.display_row = display_row;
        this.display_column = display_column;
    }
    
    public Element (){
        
    }
    
    public Integer getAtomic_number() {
        return atomic_number;
    }

    public void setAtomic_number(Integer atomic_number) {
        this.atomic_number = atomic_number;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getAtomic_weight() {
        return atomic_weight;
    }

    public void setAtomic_weight(Double atomic_weight) {
        this.atomic_weight = atomic_weight;
    }

    public Double getAtomic_mass() {
        return atomic_mass;
    }

    public void setAtomic_mass(Double atomic_mass) {
        this.atomic_mass = atomic_mass;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getMost_stable_crystal() {
        return most_stable_crystal;
    }

    public void setMost_stable_crystal(String most_stable_crystal) {
        this.most_stable_crystal = most_stable_crystal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getIonic_radius() {
        return ionic_radius;
    }

    public void setIonic_radius(Double ionic_radius) {
        this.ionic_radius = ionic_radius;
    }

    public Double getAtomic_radius() {
        return atomic_radius;
    }

    public void setAtomic_radius(Double atomic_radius) {
        this.atomic_radius = atomic_radius;
    }

    public Double getElectronegativity() {
        return electronegativity;
    }

    public void setElectronegativity(Double electronegativity) {
        this.electronegativity = electronegativity;
    }

    public Double getFirst_ionization_potential() {
        return first_ionization_potential;
    }

    public void setFirst_ionization_potential(Double first_ionization_potential) {
        this.first_ionization_potential = first_ionization_potential;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getMelting_point() {
        return melting_point;
    }

    public void setMelting_point(Double melting_point) {
        this.melting_point = melting_point;
    }

    public Double getBoiling_point() {
        return boiling_point;
    }

    public void setBoiling_point(Double boiling_point) {
        this.boiling_point = boiling_point;
    }

    public Integer getIsotepes() {
        return isotepes;
    }

    public void setIsotepes(Integer isotepes) {
        this.isotepes = isotepes;
    }

    public String getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
    }

    public Integer getYear_of_discovery() {
        return year_of_discovery;
    }

    public void setYear_of_discovery(Integer year_of_discovery) {
        this.year_of_discovery = year_of_discovery;
    }

    public Double getSpecific_heat_capacity() {
        return specific_heat_capacity;
    }

    public void setSpecific_heat_capacity(Double specific_heat_capacity) {
        this.specific_heat_capacity = specific_heat_capacity;
    }

    public String getElectron_configuration() {
        return electron_configuration;
    }

    public void setElectron_configuration(String electron_configuration) {
        this.electron_configuration = electron_configuration;
    }

    public Integer getDisplay_row() {
        return display_row;
    }

    public void setDisplay_row(Integer display_row) {
        this.display_row = display_row;
    }

    public Integer getDisplay_column() {
        return display_column;
    }

    public void setDisplay_column(Integer display_column) {
        this.display_column = display_column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element1 = (Element) o;
        return Objects.equals(atomic_number, element1.atomic_number) && Objects.equals(element, element1.element) && Objects.equals(symbol, element1.symbol) && Objects.equals(atomic_weight, element1.atomic_weight) && Objects.equals(atomic_mass, element1.atomic_mass) && Objects.equals(period, element1.period) && Objects.equals(group, element1.group) && Objects.equals(phase, element1.phase) && Objects.equals(most_stable_crystal, element1.most_stable_crystal) && Objects.equals(type, element1.type) && Objects.equals(ionic_radius, element1.ionic_radius) && Objects.equals(atomic_radius, element1.atomic_radius) && Objects.equals(electronegativity, element1.electronegativity) && Objects.equals(first_ionization_potential, element1.first_ionization_potential) && Objects.equals(density, element1.density) && Objects.equals(melting_point, element1.melting_point) && Objects.equals(boiling_point, element1.boiling_point) && Objects.equals(isotepes, element1.isotepes) && Objects.equals(discoverer, element1.discoverer) && Objects.equals(year_of_discovery, element1.year_of_discovery) && Objects.equals(specific_heat_capacity, element1.specific_heat_capacity) && Objects.equals(electron_configuration, element1.electron_configuration) && Objects.equals(display_row, element1.display_row) && Objects.equals(display_column, element1.display_column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atomic_number, element, symbol, atomic_weight, atomic_mass, period, group, phase, most_stable_crystal, type, ionic_radius, atomic_radius, electronegativity, first_ionization_potential, density, melting_point, boiling_point, isotepes, discoverer, year_of_discovery, specific_heat_capacity, electron_configuration, display_row, display_column);
    }

    @Override
    public String toString() {
        return "Element->" +
                "atomic_number=" + atomic_number +
                ", element='" + element + '\'' +
                ", symbol='" + symbol + '\'' +
                ", atomic_weight=" + atomic_weight +
                ", atomic_mass=" + atomic_mass +
                ", period=" + period +
                ", group=" + group +
                ", phase='" + phase + '\'' +
                ", most_stable_crystal='" + most_stable_crystal + '\'' +
                ", type='" + type + '\'' +
                ", ionic_radius=" + ionic_radius +
                ", atomic_radius=" + atomic_radius +
                ", electronegativity=" + electronegativity +
                ", first_ionization_potential=" + first_ionization_potential +
                ", density=" + density +
                ", melting_point=" + melting_point +
                ", boiling_point=" + boiling_point +
                ", isotepes=" + isotepes +
                ", discoverer='" + discoverer + '\'' +
                ", year_of_discovery=" + year_of_discovery +
                ", specific_heat_capacity=" + specific_heat_capacity +
                ", electron_configuration='" + electron_configuration + '\'' +
                ", display_row=" + display_row +
                ", display_column=" + display_column ;
    }
}
