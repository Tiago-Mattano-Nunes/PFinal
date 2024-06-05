/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {

    /**
     * public List<Carrinho> ler() { List<Carrinho> carrinho = new
     * ArrayList<>(); try { Connection conexao = Conexao.conectar();
     * PreparedStatement stmt = null; ResultSet rs = null;
     *
     * stmt = conexao.prepareCall("SELECT * FROM carrinho"); rs =
     * stmt.executeQuery(); while (rs.next()) { Carrinho cro = new Carrinho();
     * cro.setIdCarrinho(rs.getInt("idCarrinho"));
     *
     * cro.setQuantidadeCarrinho(rs.getInt("quantidade_carrinho"));
     * cro.setIdProdutos(rs.getInt("idProdutos"));
     * cro.setIdUsuario(rs.getInt("idUsuario")); carrinho.add(cro); }
     *
     * rs.close(); stmt.close(); conexao.close();
     *
     * } catch (SQLException e) { e.printStackTrace(); } return carrinho; }
     */

    public List<Carrinho> ler2(int id) {
        List<Carrinho> carrinho = new ArrayList<>();
        List<Cadastro> cadastro = new ArrayList<>();
        List<Produtos> produto = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT\n"
                    + "    c.idCarrinho,\n"
                    + "    u.nome AS nome_usuario,\n"
                    + "    p.nomeProdutos AS nome_produtos,\n"
                    + "    p.imagem,\n"
                    + "    c.quantidade_carrinho\n"
                    + "FROM\n"
                    + "    carrinho c\n"
                    + "    INNER JOIN usuario u ON c.idusuario = u.idusuario\n"
                    + "    INNER JOIN produtos p ON c.idProdutos = p.idprodutos where u.idusuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Carrinho cro = new Carrinho();
                Cadastro cro2 = new Cadastro();
                Produtos cro3 = new Produtos();

                cro.setIdCarrinho(rs.getInt("idCarrinho"));
                cro.setQuantidadeCarrinho(rs.getInt("quantidade_carrinho"));
                cro2.setNome(rs.getString("nome_usuario"));
                cro3.setNome(rs.getString("nome_produtos"));
                cro3.setImagens(rs.getBytes("imagem"));

                carrinho.add(cro);
                cadastro.add(cro2);
                produto.add(cro3);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinho;
    }

    public void criar(Carrinho carrinho) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO carrinho(quantidade_carrinho, idProdutos, idUsuario)VALUES(?,?,?)");

            stmt.setInt(1, carrinho.getQuantidadeCarrinho());
            stmt.setInt(2, carrinho.getIdProdutos());
            stmt.setInt(3, carrinho.getIdUsuario());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
