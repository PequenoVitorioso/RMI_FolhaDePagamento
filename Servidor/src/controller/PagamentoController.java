package controller;

import model.CargoModel;
import model.PagamentoModel;
import util.Conexao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagamentoController extends UnicastRemoteObject implements PagamentoInterface {
    public PagamentoController() throws RemoteException {}

    @Override
    public boolean registrarPagamento(PagamentoModel p) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT
        String sql = "insert into pagamento (id_funcionario, valor_liquido) values (?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1, p.getId_cliente());
            sentenca.setFloat(2, p.getValor_liquido());
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
    public boolean excluirPagamento(PagamentoModel p) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL DELETE
        String sql = "delete from pagamento where id_pagamento = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1, p.getId_pagamento());
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
    public PagamentoModel consultaPagamento(PagamentoModel p) throws RemoteException {
        PagamentoModel retorno = null;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from pagamento where id_pagamento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS
            sentenca.setInt(1,p.getId_pagamento());
            //EXECUTAR SENTENCA
            ResultSet rs = sentenca.executeQuery();
            if(rs.next()){
                retorno = new PagamentoModel();
                retorno.setId_pagamento(rs.getInt(1));
                retorno.setId_cliente(rs.getInt(2));
                retorno.setValor_liquido(rs.getFloat(3));

            }
        }catch(SQLException e){
            System.out.println("Erro ao excluir: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<PagamentoModel> listarPagamentosFuncionario(int funcionario) throws RemoteException {
        ArrayList<PagamentoModel> retorno = new ArrayList<>();
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from pagamento where id_funcionario = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //EXECUTAR SENTENCA
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                PagamentoModel p = new PagamentoModel();
                p.setId_pagamento(result.getInt(1));
                p.setId_cliente(result.getInt(2));
                p.setValor_liquido(result.getFloat(3));
                retorno.add(p);
            }
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<PagamentoModel> listarTodosPagamentos() throws RemoteException {
        ArrayList<PagamentoModel> retorno = new ArrayList<>();
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL SELECT
        String sql = "select * from pagamento";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //EXECUTAR SENTENCA
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                PagamentoModel p = new PagamentoModel();
                p.setId_pagamento(result.getInt(1));
                p.setId_cliente(result.getInt(2));
                p.setValor_liquido(result.getFloat(3));
                retorno.add(p);
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    @Override
    public boolean editarPagamento(PagamentoModel p) throws RemoteException {
        boolean retorno = false;
        //CONECTAR COM O BANCO
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL UPDATE
        String sql = "update pagamento set id_funcionario = ?, valor_liquido = ? where id_pagamento = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, p.getId_cliente());       // ID do funcionário
            sentenca.setFloat(2, p.getValor_liquido());  // Valor atualizado
            sentenca.setInt(3, p.getId_pagamento());     // ID do pagamento
            //EXECUTAR SENTENCA
            int linhasAfetadas = sentenca.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
        }
        //DESCONECTAR
        c.desconectar();
        return retorno;
    }
}
