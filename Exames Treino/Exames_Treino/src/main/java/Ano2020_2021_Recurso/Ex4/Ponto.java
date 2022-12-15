package Ano2020_2021_Recurso.Ex4;

public class Ponto {

    private String name;
    private boolean isFarmacia;

    public Ponto(String name, boolean isFarmacia) {
        this.name = name;
        this.isFarmacia = isFarmacia;
    }

    public boolean isFarmacia(){
        return isFarmacia;
    }

    @Override
    public String toString() {
        return name;
    }
}
