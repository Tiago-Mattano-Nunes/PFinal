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
import model.Dao.EnderecosDAO;
import model.Dao.ProdutosDAO;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Enderecos;
import model.bean.Produtos;


@WebServlet(urlPatterns = "/calcular")
@MultipartConfig
public class CarrinhoController extends HttpServlet {

    Enderecos objProduto = new Enderecos();
    EnderecosDAO objProdutoDao = new EnderecosDAO();

 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CarrinhoDAO produto = new CarrinhoDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        List<Carrinho> carrinhos = produto.ler2(id);
        request.setAttribute("carrinhos", carrinhos);
        Cadastro cadastro = new Cadastro();
        CadastroDAO cadastrodao = new CadastroDAO();

        ProdutosDAO produto2 = new ProdutosDAO();
        List<Produtos> produtos = produto2.ler();
        request.setAttribute("produtos", produtos);

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                cadastro = cadastrodao.pegarPorId(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", cadastro);
            }
        }
        String url = "/WEB-INF/jsp/carrinho.jsp";
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
        if (action.equals("/calcular")) {
            user(request, response);
        } else {
            processRequest(request, response);
        }

    }

    protected void user(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter sout = response.getWriter();
        objProduto.setRua(request.getParameter("rua"));
        objProduto.setNumero(request.getParameter("numero"));
        objProduto.setCidade(request.getParameter("cidade"));
        objProduto.setCep(request.getParameter("cep"));
        objProduto.setEstado(request.getParameter("estado"));
        objProduto.setComplemento(request.getParameter("complemento"));
        objProduto.setIdUsuario(Integer.parseInt(request.getParameter("id")));

        objProdutoDao.create(objProduto);
        response.sendRedirect("./Carrinho?id=" + Integer.parseInt(request.getParameter("id")));

    }



    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
