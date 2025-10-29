/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

/**
 *
 * @author Yasmim Mendes
 
*/


import controller.CargoController;
import model.CargoModel;
import java.util.ArrayList;

public class TesteServidor {
    public static void main(String[] args) {
        try {
            CargoController c = new CargoController();
            ArrayList<CargoModel> lista = c.listar();
            System.out.println("Quantidade de cargos: " + lista.size());
            
            for (CargoModel cargo : lista) {
                System.out.println(
                    cargo.getId_cargo() + " - " +
                    cargo.getNome() + " - " +
                    cargo.getDescricao() + " - " +
                    cargo.getSalario()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
