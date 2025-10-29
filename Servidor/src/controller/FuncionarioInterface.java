package controller;

import model.FuncionarioModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FuncionarioInterface extends Remote {
    public boolean inserir(FuncionarioModel f) throws RemoteException;
    public boolean editar(FuncionarioModel f) throws RemoteException;
    public boolean excluir(FuncionarioModel f) throws RemoteException;
    public FuncionarioModel pesquisar(FuncionarioModel f) throws RemoteException;
    public ArrayList<FuncionarioModel> listar() throws RemoteException;
}
