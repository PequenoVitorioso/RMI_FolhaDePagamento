package controller;

import model.DepartamentoModel;
import util.Conexao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartamentoController extends UnicastRemoteObject implements DepartamentoInterface {
    public DepartamentoController() throws RemoteException {
    }

    @Override
    public boolean inserir(DepartamentoModel departamento) throws RemoteException {
        boolean retorno = false; 
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT
        String sql = "insert into departamento (nome_departamento, localizacao) values (?,?)";
        try {

        //CONECTAR AO BANCO//
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT//
        String sql = "insert into departamento (nome, localizacao) values (??)";
        try{

            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setString(1, departamento.getNome());
            sentenca.setString(2, departamento.getLocalizacao());
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
    public boolean editar(DepartamentoModel departamento) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL UPDATE
        String sql = "update departamento set nome_departamento = ?, localizacao = ? where id_departamento = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setString(1, departamento.getNome());
            sentenca.setString(2, departamento.getLocalizacao());
            sentenca.setInt(3, departamento.getId_departamento());
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
    public boolean excluir(DepartamentoModel departamento) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL DELETE
        String sql = "delete from departamento where id_departamneto = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1, departamento.getId_departamento());
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
    public DepartamentoModel pesquisar(DepartamentoModel departamento) throws RemoteException {
        DepartamentoModel retorno = null;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from departamento where id_departamento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1,departamento.getId_departamento());
            //EXECUTAR SENTENCA
            ResultSet rs = sentenca.executeQuery();
            if(rs.next()){
                retorno = new DepartamentoModel();
                retorno.setId_departamento(rs.getInt(1));
                retorno.setNome(rs.getString(2));
                retorno.setLocalizacao(rs.getString(3));
            }
        }catch(SQLException e){
            System.out.println("Erro ao excluir: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<DepartamentoModel> listar() throws RemoteException {
        ArrayList<DepartamentoModel> retorno = new ArrayList<>();
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from departamento";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //EXECUTAR SENTENCA
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                DepartamentoModel departamento = new DepartamentoModel();
                departamento.setId_departamento(result.getInt(1));
                departamento.setNome(result.getString(2));
                departamento.setLocalizacao(result.getString(3));
                retorno.add(departamento);
            }
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }

}
