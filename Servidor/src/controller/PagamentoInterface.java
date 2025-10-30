package controller;

import model.PagamentoModel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PagamentoInterface extends Remote {
    public boolean registrarPagamento(PagamentoModel p) throws RemoteException;
    public boolean excluirPagamento(PagamentoModel p) throws RemoteException;
    public PagamentoModel consultaPagamento(PagamentoModel p) throws RemoteException;
    public ArrayList<PagamentoModel> listarPagamentosFuncionario(int funcionario) throws RemoteException;

}