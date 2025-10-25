package controller;

import model.FuncionarioModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FuncionarioInterface extends Remote {
    public boolean inserir(FuncionarioModel f) throws RemoteException;
    public boolean editar(FuncionarioModel f) throws RemoteException;
    public boolean excluir(FuncionarioModel f) throws RemoteException;
    public FuncionarioModel pesquisar(FuncionarioModel f) throws RemoteException;
}
