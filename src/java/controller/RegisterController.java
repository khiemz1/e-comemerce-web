/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.KhachHangDAO;
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
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

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
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        if (action.equals("dangky")) {
            AccountDAO dao = new AccountDAO();
            String tentk = request.getParameter("tentk");
            String mk = request.getParameter("mk");
            String sdt = request.getParameter("sdt");
            String mk_confirm = request.getParameter("mk_confirm");
            if (!mk.equals(mk_confirm)) {
                request.setAttribute("thongBao", "Vui lòng xác nhận lại mật khẩu");
                processRequest(request, response);
            } else if (dao.checkTentk(tentk) == 1) {
                request.setAttribute("thongBao", "Tên tài khoản đã tồn tại");
                processRequest(request, response);
            } else if (dao.checkTentk(tentk) == 0) {
                if (dao.checkSdt(sdt) == 1) {
                    request.setAttribute("thongBao", "Số điện thoại đã được đăng ký!");
                    processRequest(request, response);
                }
                else {
                    dao.taoTaiKhoanKhachHang(tentk, mk, sdt);
                    KhachHangDAO dao1 = new KhachHangDAO();
                    dao1.themKhachHang(tentk);
                    response.sendRedirect("login");
                }
            }
        }
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
