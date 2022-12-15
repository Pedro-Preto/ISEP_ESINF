package Ano2019_2020.Ex4;

import java.util.List;

public class NoPetri {
    private String name;
    private List<Integer> tokens;
    private boolean isTransicao;

    public NoPetri(String name, List<Integer> tokens) {
        this.name = name;
        this.tokens = tokens;
        this.isTransicao = false;
    }

    public boolean temToken() {
        return !tokens.isEmpty();
    }

    public void addToken() {
        tokens.add(1);
    }

    public void removeToken() {
        tokens.remove(1);
    }

    public boolean isTransicao() {
        return isTransicao;
    }

    public void setTransicao() {
        isTransicao = true;
    }

    @Override
    public String toString() {
        return name;
    }
}
