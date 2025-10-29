/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import controller.*;

/**
 *
 * @author Yasmim Mendes
 */
public class ServidorView {
    public static void main(String[] args) {
        try{
             Registry registry;
            try {
                registry = LocateRegistry.getRegistry(1200);
                registry.list();
                System.out.println("Registry já está rodando.");
            } catch (RemoteException e) {
                registry = LocateRegistry.createRegistry(1200);
                System.out.println("Registry criado na porta 1200");
            }
            CargoController c = new CargoController();
            DepartamentoController d = new DepartamentoController();
            FuncionarioController f = new FuncionarioController();
            PagamentoController p = new PagamentoController();
            System.out.println("Servidor pronto!");
            registry.bind("cargo",c);
            registry.bind("departamento", d);
            registry.bind("funcionario", f);
            registry.bind("pagamento", p);
        }catch(AlreadyBoundException e){
            System.out.println("Erro na conexão: "+ e.getMessage());
        }catch(RemoteException e){
            System.out.println("Erro na chamada do serviço: "+ e.getMessage());
        }
    }
}
