/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author DEI-ISEP
 */
public class Invoice implements Comparable<Invoice> {
    private String reference;
    private LocalDate date;

    public Invoice(String reference, String date) {
        this.reference = reference;
        if (date != null) {
            String s[] = date.split("/");
            this.date = LocalDate.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
    }

    public Invoice(String reference) {
        this(reference, "1900/01/01");
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(reference, invoice.reference) ;
    }

    @Override
    public int hashCode() {
        return reference.hashCode();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "reference='" + reference + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Invoice o) {
        return reference.compareTo(o.reference);
    }

}