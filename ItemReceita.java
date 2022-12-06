package AppAvaInter2;

public class ItemReceita {

    private double dose;
    private int duracao;
    private Remedio remedio;

    public ItemReceita(double dose, int duracao) {
        this.dose = dose;
        this.duracao = duracao;
    }

    public ItemReceita(double dose, int duracao, Remedio remedio) {
        this.dose = dose;
        this.duracao = duracao;
        this.remedio = remedio;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }
}
