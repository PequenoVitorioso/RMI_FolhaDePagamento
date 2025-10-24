package model;

public class CargoModel {
    private int id_cargo;
    private String nome;
    private String nivel;
    private float salario;

    public CargoModel(int idCargo, String nomeCargo, String nivel, float salarioBase) {
        this.id_cargo = idCargo;
        this.nome = nomeCargo;
        this.nivel = nivel;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
