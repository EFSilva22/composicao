package AppAvaInter2;

public class Remedio {

    private String nome;
    private String laboratorio;
    private String unidade;

    public Remedio(String nome, String laboratorio, String unidade) {
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
}
