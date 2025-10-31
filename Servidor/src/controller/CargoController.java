package controller;

import model.CargoModel;
import util.Conexao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CargoController extends UnicastRemoteObject implements CargoInterface {
    public CargoController()throws RemoteException{}

    @Override
    public boolean inserir(CargoModel cargo) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT
        String sql = "insert into cargo (nome_cargo, descricao, salario_base) values (?,?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setString(1, cargo.getNome());
            sentenca.setString(2, cargo.getDescricao());
            sentenca.setFloat(3, cargo.getSalario());
            //EXECUTAR SENTENCA
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }

    @Override
    public boolean editar(CargoModel cargo) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL UPDATE
        String sql = "update cargo set nome_cargo = ?, descricao = ?, salario_base = ? where id_cargo = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setString(1, cargo.getNome());
            sentenca.setString(2, cargo.getDescricao());
            sentenca.setFloat(3, cargo.getSalario());
            sentenca.setInt(4, cargo.getId_cargo());
            //EXECUTAR SENTENCA
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }

    @Override
    public boolean excluir(CargoModel cargo) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL DELETE
        String sql = "delete from cargo where id_cargo = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1, cargo.getId_cargo());
            //EXECUTAR SENTENCA
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }

    @Override
    public CargoModel pesquisar(CargoModel cargo) throws RemoteException {
        CargoModel retorno = null;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from cargo where id_cargo = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1,cargo.getId_cargo());
            //EXECUTAR SENTENCA
            ResultSet rs = sentenca.executeQuery();
            if(rs.next()){
                retorno = new CargoModel();
                retorno.setId_cargo(rs.getInt(1));
                retorno.setNome(rs.getString(2));
                retorno.setDescricao(rs.getString(3));
                retorno.setSalario(rs.getFloat(4));
            }
        }catch(SQLException e){
            System.out.println("Erro ao excluir: "+ e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<CargoModel> listar() throws RemoteException {
        ArrayList<CargoModel> retorno = new ArrayList<>();
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        System.out.println("DEBUG: Conexão = " + c.conector);
        //CRIAR SQL SELECT
        String sql = "select * from cargo";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //EXECUTAR SENTENCA
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                CargoModel cargo = new CargoModel();
                cargo.setId_cargo(result.getInt(1));
                cargo.setNome(result.getString(2));
                cargo.setDescricao(result.getString(3));
                cargo.setSalario(result.getFloat(4));
                retorno.add(cargo);
            }
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }
    
    @Override
    public CargoModel selecionar(CargoModel cargo) throws RemoteException {
        CargoModel retorno = null;

        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from cargo where id_cargo = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, cargo.getId_cargo());
            //EXECUTAR SENTENCA
            ResultSet rs = sentenca.executeQuery();

            if (rs.next()) {
                retorno = new CargoModel();
                retorno.setId_cargo(rs.getInt("id_cargo"));
                retorno.setNome(rs.getString("nome_cargo"));
                retorno.setDescricao(rs.getString("descricao"));
                retorno.setSalario(rs.getFloat("salario_base"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao selecionar cargo: " + e.getMessage());
        }

        //DESCONECTAR
        c.desconectar();
        return retorno;
    }
}
