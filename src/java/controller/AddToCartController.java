/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.GioHangDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ASUS ROG
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/addToCart"})
public class AddToCartController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        GioHangDao dao1 = new GioHangDao();
        HttpSession session = request.getSession();
        if (session.getAttribute("tentk") == null) {
            response.sendRedirect("login");
        } else {
            String maSP = request.getParameter("maSP");
            String link = request.getParameter("link");
            String tentk = (String) session.getAttribute("tentk");
            String soLuong = request.getParameter("quantity");
            int soLuongMoi = Integer.parseInt(soLuong);
            String size = request.getParameter("size");
            if (dao1.checkGioHang(maSP, size, tentk)) {
                dao1.updateGioHang(tentk, maSP, soLuongMoi, size);
            } else if (!dao1.checkGioHang(maSP, size, tentk)) {
                dao1.themVaoGioHang(tentk, maSP, soLuongMoi, size);
            }
            if (link.equals("index") || link.equals("DsSanPham")) {
                request.setAttribute("thongBao", "Thêm vào giỏ hàng thành công!");
                request.getRequestDispatcher(link).forward(request, response);
            } else {
                response.sendRedirect(link);
            }

        }
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
        processRequest(request, response);
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
