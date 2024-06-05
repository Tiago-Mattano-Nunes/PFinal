/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Dao.CadastroDAO;
import model.Dao.CarrinhoDAO;
import model.Dao.ProdutosDAO;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Produtos;

@WebServlet(urlPatterns = "/enviarc")
@MultipartConfig
public class PUnicoController extends HttpServlet {

    Carrinho produto = new Carrinho();
    CarrinhoDAO produtoDao = new CarrinhoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdutosDAO produto = new ProdutosDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        List<Produtos> produtos = produto.ler2(id);
        request.setAttribute("produtos", produtos);
        Cadastro cadastro = new Cadastro();
        CadastroDAO cadastrodao = new CadastroDAO();

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                cadastro = cadastrodao.pegarPorId(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", cadastro);
            }
        }
        String url = "/WEB-INF/jsp/pUnico.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/enviarc")) {
            produto(request, response);
        } else {
            processRequest(request, response);
        }

    }

    protected void produto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Carrinho produto = new Carrinho();
        CarrinhoDAO produtoDao = new CarrinhoDAO();
        produto.setIdProdutos(Integer.parseInt(request.getParameter("idproduto")));
        produto.setIdUsuario(Integer.parseInt(request.getParameter("idusuario")));
        produto.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade")));
        
        produtoDao.criar(produto);
        response.sendRedirect("./Carrinho?id="+Integer.parseInt(request.getParameter("idusuario")));
/**    */
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
