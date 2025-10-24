package model;

public class DepartamentoModel {
    private int id_Departamento;
    private String nome;
    private String localizacao;

    public DepartamentoModel(int id_Departamento, String nome, String localizacao) {
        this.id_Departamento = id_Departamento;
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public DepartamentoModel() {}

    public int getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_Departamento = id_Departamento;
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
