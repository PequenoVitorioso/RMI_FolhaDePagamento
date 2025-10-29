package controller;

import model.CargoModel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CargoInterface extends Remote {
    public boolean inserir(CargoModel cargo) throws RemoteException;
    public boolean editar(CargoModel cargo) throws RemoteException;
    public boolean excluir(CargoModel cargo) throws RemoteException;
    public CargoModel pesquisar(CargoModel cargo) throws RemoteException;
    public ArrayList<CargoModel> listar() throws RemoteException;
}
