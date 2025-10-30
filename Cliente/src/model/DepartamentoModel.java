package model;

import java.io.Serializable;

public class DepartamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id_departamento;
    private String nome;
    private String localizacao;

    public DepartamentoModel(int id_Departamento, String nome, String localizacao) {
        this.id_departamento = id_Departamento;
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public DepartamentoModel() {}

    public int getId_Departamento() {
        return id_departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_departamento = id_Departamento;
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
    
    @Override
    public String toString() {
        return nome;
    }
}
