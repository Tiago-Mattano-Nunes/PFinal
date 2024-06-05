/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Base64;

public class Carrinho {

    private int idCarrinho;
    private int quantidadeCarrinho;
    private int idProdutos;
    private int idUsuario;

    public Carrinho() {
    }

    public Carrinho(int idCarrinho, int quantidadeCarrinho, int idProdutos, int idUsuario) {
        this.idCarrinho = idCarrinho;
        this.quantidadeCarrinho = quantidadeCarrinho;
        this.idProdutos = idProdutos;
        this.idUsuario = idUsuario;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getQuantidadeCarrinho() {
        return quantidadeCarrinho;
    }

    public void setQuantidadeCarrinho(int quantidadeCarrinho) {
        this.quantidadeCarrinho = quantidadeCarrinho;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    
}
