package view;

import model.CargoModel;
import model.DepartamentoModel;
import model.FuncionarioModel;
import model.PagamentoModel;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try{
            Registry conexao = LocateRegistry.createRegistry(2000);
            System.out.println("Servidor Iniciado!");
            FuncionarioModel f = new FuncionarioModel();
            CargoModel c = new CargoModel();
            DepartamentoModel d = new DepartamentoModel();
            PagamentoModel p = new PagamentoModel();
            System.out.println("Servidor pronto!");

            conexao.bind("funcionario",f);
            conexao.bind("cargo", c);
            conexao.bind("departamento", d);
            conexao.bind("pagamento", p);


        }catch(AlreadyBoundException e){
            System.out.println("Erro na conexão: "+ e.getMessage());
        }catch(RemoteException e){
            System.out.println("Erro na chamada do serviço: "+ e.getMessage());
        }
    }
}
