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
import model.Dao.CarrinhoDAO;
import model.Dao.EnderecosDAO;
import model.bean.Carrinho;
import model.bean.Enderecos;

@WebServlet(urlPatterns = "/calcular")
@MultipartConfig
public class FinalCompraController extends HttpServlet {

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
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {
                
                request.setAttribute("teste", cookie.getValue());
                System.out.println( cookie.getValue());
            }
        }
        request.setAttribute("carrinhos", carrinhos);
        String url = "/WEB-INF/jsp/finalCompra.jsp";
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
        
        if (objProduto.getRua().trim().equals("") 
                || objProduto.getCidade().trim().equals("")                 
                || objProduto.getNumero().trim().equals("")) {
            sout.println("<script type=\"text/javascript\">");
            sout.println("alert('Por favor, preencha todos os campos.');");
            sout.println("window.location.href = './FinalCompra';");
            sout.println("</script>");
        } else {
         
            objProdutoDao.create(objProduto);
            response.sendRedirect("./FinalCompra");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
