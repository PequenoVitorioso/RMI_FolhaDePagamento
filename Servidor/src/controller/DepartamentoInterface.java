package controller;

import model.DepartamentoModel;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DepartamentoInterface extends Remote {
    public boolean inserir(DepartamentoModel departamento) throws RemoteException;
    public boolean editar(DepartamentoModel departamento) throws RemoteException;
    public boolean excluir(DepartamentoModel departamento) throws RemoteException;
    public DepartamentoModel pesquisar(DepartamentoModel departamento) throws RemoteException;
}
