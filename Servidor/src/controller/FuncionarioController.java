package controller;

import model.FuncionarioModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FuncionarioController extends UnicastRemoteObject implements FuncionarioInterface {
    @Override
    public boolean inserir(FuncionarioModel f) throws RemoteException {

        return false;
    }

    @Override
    public boolean editar(FuncionarioModel f) throws RemoteException {
        return false;
    }

    @Override
    public boolean excluir(FuncionarioModel f) throws RemoteException {
        return false;
    }

    @Override
    public FuncionarioModel pesquisar(FuncionarioModel f) throws RemoteException {
        return null;
    }
}
