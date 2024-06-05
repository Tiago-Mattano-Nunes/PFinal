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
import model.bean.Enderecos;

public class EnderecosDAO {

   public void create(Enderecos endereco) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;

        // Inserindo os dados na tabela "Enderecos" junto com o idUsuario
        stmt = conexao.prepareStatement("INSERT INTO Enderecos(idUsuario, Cep, Estado, Cidade, Complemento, Numero, Rua) VALUES (?,?,?,?,?,?,?)");
        stmt.setInt(1, endereco.getIdUsuario()); // Fornecendo o idUsuario
        stmt.setString(2, endereco.getCep());
        stmt.setString(3, endereco.getEstado());
        stmt.setString(4, endereco.getCidade());
        stmt.setString(5, endereco.getComplemento());
        stmt.setString(6, endereco.getNumero());
        stmt.setString(7, endereco.getRua());

        stmt.executeUpdate();
        stmt.close();
        conexao.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
