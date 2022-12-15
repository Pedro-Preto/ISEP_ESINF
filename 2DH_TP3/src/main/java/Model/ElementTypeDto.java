package Model;

public class ElementTypeDto {

    private String type;

    private int artificial;

    private int gas;

    private int liq;

    private int solid;

    private int total;


    public ElementTypeDto(String type) {
        this.type = type;
        this.artificial = 0;
        this.gas = 0;
        this.liq = 0;
        this.solid = 0;
        this.total = 0;
    }

    public String getType() {
        return type;
    }

    public void occurrencyArtificial() {
        this.artificial++;
    }

    public void occurrencyGas() {
        this.gas++;
    }

    public void occurrencySolid() {
        this.solid++;
    }

    public void occurrencyLiqu() {
        this.liq++;
    }

    public int getTotal() {
        total = artificial + gas + liq + solid + total;
        return total;
    }

    public int getArtificial() {
        return artificial;
    }

    public int getGas() {
        return gas;
    }

    public int getLiq() {
        return liq;
    }

    public int getSolid() {
        return solid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setArtificial(int artificial) {
        this.artificial = artificial;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public void setLiq(int liq) {
        this.liq = liq;
    }

    public void setSolid(int solid) {
        this.solid = solid;
    }
}
