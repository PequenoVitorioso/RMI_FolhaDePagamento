package controller;

import model.FuncionarioModel;
import util.Conexao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CargoModel;

public class FuncionarioController extends UnicastRemoteObject implements FuncionarioInterface {
    public FuncionarioController()throws RemoteException{}

    @Override
    public boolean inserir(FuncionarioModel f) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT
        String sql = "insert into funcionario (nome, id_departamento, id_cargo) values (?,?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setString(1, f.getNome());
            sentenca.setInt(2, f.getId_departamento());
            sentenca.setInt(3, f.getId_cargo());
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
    public boolean editar(FuncionarioModel f) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL UPDATE
        String sql = "update funcionario set nome = ?, id_departamento = ?, id_cargo = ? where id_funcionario = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setString(1, f.getNome());
            sentenca.setInt(2, f.getId_departamento());
            sentenca.setInt(3, f.getId_cargo());
            sentenca.setInt(4, f.getId_funcionario());
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
    public boolean excluir(FuncionarioModel f) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL DELETE
        String sql = "delete from funcionario where id_funcionario = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1, f.getId_funcionario());
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
    public FuncionarioModel pesquisar(FuncionarioModel f) throws RemoteException {
        FuncionarioModel retorno = null;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from funcionario where id_funcionario = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1,f.getId_funcionario());
            //EXECUTAR SENTENCA
            ResultSet rs = sentenca.executeQuery();
            if(rs.next()){
                retorno = new FuncionarioModel();
                retorno.setId_funcionario(rs.getInt(1));
                retorno.setNome(rs.getString(2));
                retorno.setId_cargo(rs.getInt(3));
                retorno.setId_departamento(rs.getInt(4));
            }
        }catch(SQLException e){
            System.out.println("Erro ao excluir: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<FuncionarioModel> listar() throws RemoteException {
        ArrayList<FuncionarioModel> retorno = new ArrayList<>();
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from funcionario";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //EXECUTAR SENTENCA
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setId_funcionario(result.getInt(1));
                funcionario.setNome(result.getString(2));
                funcionario.setId_departamento(result.getInt(3));
                funcionario.setId_cargo(result.getInt(4));
                retorno.add(funcionario);
            }
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }
    
    @Override
    public FuncionarioModel selecionar(FuncionarioModel funcionario) throws RemoteException {
        FuncionarioModel retorno = null;

        // CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, funcionario.getId_funcionario());

            ResultSet rs = sentenca.executeQuery();

            if (rs.next()) {
                retorno = new FuncionarioModel();
                retorno.setId_funcionario(rs.getInt("id_funcionario"));
                retorno.setNome(rs.getString("nome"));
                retorno.setId_departamento(rs.getInt("id_departamento")); // chave estrangeira
                retorno.setId_cargo(rs.getInt("id_cargo"));               // chave estrangeira
            }

        } catch (SQLException e) {
            System.out.println("Erro ao selecionar funcionário: " + e.getMessage());
        }

        // DESCONECTAR
        c.desconectar();

        return retorno;
    }
}
