package controller;

import model.PagamentoModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PagamentoInterface extends Remote {
    public PagamentoModel consultaPagamento(int id) throws RemoteException;
    public PagamentoModel listarPagamentosFuncionario(int id) throws RemoteException;
    public boolean registrarPagamento(PagamentoModel p) throws RemoteException;
    
}
