/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.util.*;

/**
 * @author DEI-ISEP
 */
public class Supermarket implements Comparable<Supermarket> {
    Map<Invoice, Set<Product>> sup;

    Supermarket() {
        sup = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List<String> l) throws Exception {
        Set<Product> products ;
        String novaRef = "";
        for (String elemento : l) {
            String[] splitter = elemento.split(",");
            switch (splitter[0]) {
                case "I":
                    products=new HashSet<>();
                    sup.put(new Invoice(splitter[1],splitter[2]),products);
                    novaRef = splitter[1];
                    break;
                case "P":
                    sup.get(getInvoiceByReference(sup, novaRef)).add(new Product(splitter[1], Integer.parseInt(splitter[2]), Long.parseLong(splitter[3])));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: ");
            }
        }
    }


    public Invoice getInvoiceByReference(Map<Invoice, Set<Product>> map, String reference) {
        for (Map.Entry<Invoice, Set<Product>> m : map.entrySet()) {
            if (m.getKey().getReference().equals(reference)) {
                return m.getKey();
            }
        }
        return null;
    }

    // returns a set in which each number is the number of products in the r
    // invoice
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        Map<Invoice, Integer> numPro = new HashMap<>();
        for (Map.Entry<Invoice, Set<Product>> map : sup.entrySet()) {
            if (!numPro.containsKey(map.getKey())) {
                numPro.put(map.getKey(), map.getValue().size());
            }
        }
        return numPro;

    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> dates = new HashSet();
        for (Map.Entry<Invoice, Set<Product>> m : sup.entrySet()) {
            if (m.getKey().getDate().isAfter(d1) && m.getKey().getDate().isBefore(d2)) {
                dates.add(m.getKey());
            }

        }
        return dates;
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        long total = 0;
        for (Map.Entry<Invoice, Set<Product>> m : sup.entrySet()) {
            for (Product p : m.getValue()) {
                if (p.getIdentification().equals(productId)) {
                    total += p.getPrice() * p.getQuantity();
                }
            }
        }
        return total;
    }

    // converts a map of invoices and troducts to a map which key is a product
    // identification and the values are a set of the invoices in which it appears
    Map<String, Set<Invoice>> convertInvoices() {
        Map<String, Set<Invoice>> newMap = new HashMap<>();
        Set<Invoice> inv;
        for (Map.Entry<Invoice, Set<Product>> m : sup.entrySet()) {
            inv = new HashSet<>();
            for (Product p : m.getValue()) {
                if (newMap.containsKey(p.getIdentification())) {
                    newMap.get(p.getIdentification()).add(m.getKey());
                } else {
                    inv.add(m.getKey());
                    newMap.put(p.getIdentification(), inv);
                }
            }
        }
        return newMap;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supermarket)) return false;
        Supermarket that = (Supermarket) o;
        return Objects.equals(sup, that.sup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sup);
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "sup=" + sup +
                '}';
    }

    @Override
    public int compareTo(Supermarket supermarket) {
        return 0;
    }
}
