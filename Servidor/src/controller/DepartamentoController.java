package controller;

import model.DepartamentoModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DepartamentoController extends UnicastRemoteObject implements DepartamentoInterface {
    public DepartamentoController() throws RemoteException {}

    @Override
    public boolean inserir(DepartamentoModel departamento) throws RemoteException {
        return false;
    }

    @Override
    public boolean editar(DepartamentoModel departamento) throws RemoteException {
        return false;
    }

    @Override
    public boolean excluir(DepartamentoModel departamento) throws RemoteException {
        return false;
    }

    @Override
    public DepartamentoModel pesquisar(DepartamentoModel departamento) throws RemoteException {
        return null;
    }
}
