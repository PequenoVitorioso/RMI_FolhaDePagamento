package view;

import java.rmi.registry.*;
import controller.*;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class Servidor {
    public static void main(String[] args){
        try{
            System.setProperty("java.rmi.server.hostname", " "); // ADICIONAR IP DA MAQUINA
            Registry conexao = LocateRegistry.createRegistry(1100);
            System.out.println("Servidor Iniciado! ");
            
            //INSTANCIA DOS OBJETOS REMOTOS
            
            // (CARGO CONTROLLER)
            CargoController c= new CargoController();
            // (FUNCIONARIO CONTROLLER) 
            FuncionarioController f= new FuncionarioController();
            // (DEPARTAMENTO CONTROLLER)
            DepartamentoController d = new DepartamentoController();
            // (PAGAMENTO CONTROLLER) 
            PagamentoController p = new PagamentoController();

            System.out.println("Servidor pronto!... ");
            // REGISTRA OS OBJETOS REMOTOS NO REGISTRY 
            conexao.bind("cargo", c);
            conexao.bind("funcionario", f);
            conexao.bind("departamento", d);
            conexao.bind("pagamento", p);
            
        }catch(AlreadyBoundException e){
            System.out.println("Erro na conexão:  "+e.getMessage());
        }catch(RemoteException e ){
            System.out.println("Erro na chamada so seviço:  "+e.getMessage());
        }
    }
}
