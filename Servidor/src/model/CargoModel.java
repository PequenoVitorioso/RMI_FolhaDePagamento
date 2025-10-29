package model;

import java.io.Serializable;

public class CargoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id_cargo;
    private String nome;
    private String descricao;
    private float salario;

    public CargoModel(int idCargo, String nomeCargo, String descricao, float salarioBase) {
        this.id_cargo = idCargo;
        this.nome = nomeCargo;
        this.descricao = descricao;
        this.salario = salarioBase;
    }

    public CargoModel() {}

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
