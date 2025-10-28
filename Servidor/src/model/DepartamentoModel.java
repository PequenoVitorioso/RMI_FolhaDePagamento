package model;

public class DepartamentoModel {
    private int id_departamento;
    private String nome;
    private String localizacao;

    public DepartamentoModel(int id_departamento, String nome, String localizacao) {
        this.id_departamento = id_departamento;
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public DepartamentoModel() {}

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
