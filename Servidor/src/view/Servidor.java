package view;

import java.rmi.registry.*;
import controller.*;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class Servidor {
    public static void main(String[] args){
        try{
            Registry conexao = LocateRegistry.createRegistry(1100);
            System.out.println("Servidor Iniciado! ");
            
            //INSTANCIA DOS OBJETOS REMOTOS
            
            // (CARGO CONTROLLER)
            CargoController cargoService = new CargoController();
            // (FUNCIONARIO CONTROLLER) 
            FuncionarioController funcionarioService = new FuncionarioController();
            // (DEPARTAMENTO CONTROLLER)
            DepartamentoController departamentoService = new DepartamentoController();
            // (PAGAMENTO CONTROLLER) = AINDA A REALIZAR//
            PagamentoController pagamentoService = new PagamentoController();
            
    
            ////////////////Ainda falta a implementação das funções da Interface////////////////
           
            // REGISTRA OS OBJETOS REMOTOS NO REGISTRY 
            conexao.bind("CargoService", cargoService);
            
            
            conexao.bind("FuncionarioService", funcionarioService);
            
            
            conexao.bind("DepartamentoService", departamentoService);
            
            
            conexao.bind("PagamentoService", pagamentoService);
            


        }catch(AlreadyBoundException e){
            System.out.println("Erro na conexão:  "+e.getMessage());
        }catch(RemoteException e ){
            System.out.println("Erro na chamada so seviço:  "+e.getMessage());
        }
    }
}
