package Model;

import java.util.Date;

public class Covid_Info {
    private Location location;
    private Date date;
    private String total_casos;
    private String novos_casos;
    private String total_mortes;
    private String novas_mortes;
    private String total_testes;
    private String novos_testes;

    public Covid_Info(Location location, Date date, String total_casos, String novos_casos, String total_mortes, String novas_mortes, String total_testes, String novos_testes) {
        this.location = location;
        this.date = date;
        this.total_casos = total_casos;
        this.novos_casos = novos_casos;
        this.total_mortes = total_mortes;
        this.novas_mortes = novas_mortes;
        this.total_testes = total_testes;
        this.novos_testes = novos_testes;
    }

    public Location getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getTotal_casos() {
        return total_casos;
    }

    public String getNovos_casos() {
        return novos_casos;
    }

    public String getTotal_mortes() {
        return total_mortes;
    }

    public String getNovas_mortes() {
        return novas_mortes;
    }

    public String getTotal_testes() {
        return total_testes;
    }

    public String getNovos_testes() {
        return novos_testes;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotal_casos(String total_casos) {
        this.total_casos = total_casos;
    }

    public void setNovos_casos(String novos_casos) {
        this.novos_casos = novos_casos;
    }

    public void setTotal_mortes(String total_mortes) {
        this.total_mortes = total_mortes;
    }

    public void setNovas_mortes(String novas_mortes) {
        this.novas_mortes = novas_mortes;
    }

    public void setTotal_testes(String total_testes) {
        this.total_testes = total_testes;
    }

    public void setNovos_testes(String novos_testes) {
        this.novos_testes = novos_testes;
    }

    @Override
    public String toString() {
        return "Covid_Info{" +
                "location=" + location +
                ", date=" + date +
                ", total_casos='" + total_casos + '\'' +
                ", novos_casos='" + novos_casos + '\'' +
                ", total_mortes='" + total_mortes + '\'' +
                ", novas_mortes='" + novas_mortes + '\'' +
                ", total_testes='" + total_testes + '\'' +
                ", novos_testes='" + novos_testes + '\'' +
                '}';
    }
}

