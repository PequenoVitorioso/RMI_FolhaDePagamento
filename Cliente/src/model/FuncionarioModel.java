package model;

import java.io.Serializable;

public class FuncionarioModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id_funcionario;
    private String nome;
    private int id_departamento;
    private int id_cargo;

    public FuncionarioModel() {
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
}
