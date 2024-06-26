/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Base64;

/**
 *
 * @author Senai
 */
public class Produtos {
    private int idProdutos;
    private int idCategoria;
    private String nome;
    private int categoria;
    private String descricao;
    private float preco;
    private int quantidade;
    private byte[] imagens;

    public Produtos() {
    }

    public String getImagemBase64() {
        if (imagens != null) {
            return Base64.getEncoder().encodeToString(imagens);
        } else {
            return "";
        }
    }

    public Produtos(int idProdutos, int idCategoria, String nome, int categoria, String descricao, float preco, int quantidade, byte[] imagens) {
        this.idProdutos = idProdutos;
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagens = imagens;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public byte[] getImagens() {
        return imagens;
    }

    public void setImagens(byte[] imagens) {
        this.imagens = imagens;
    }

   

}
