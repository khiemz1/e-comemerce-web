/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.GioHangDao;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.GioHang;
import model.SanPham;
import model.SizeSP;

/**
 *
 * @author ASUS ROG
 */
@WebServlet(name = "cartController", urlPatterns = {"/cart"})
public class cartController extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (session.getAttribute("tentk") == null) {
            response.sendRedirect("login");
        } else {
            String soLuong = request.getParameter("soLuong");
            String maSP = request.getParameter("maSP");
            String tentk = (String) session.getAttribute("tentk");
            String deleteId = request.getParameter("delete");
            String size = request.getParameter("size");
            GioHangDao dao = new GioHangDao();
            List<GioHang> listGioHang = dao.getGioHangbyTentk(tentk);
            SanPhamDAO c = new SanPhamDAO();
            if (soLuong != null && maSP != null) {
                int soLuongMoi = Integer.parseInt(soLuong);
                dao.updateGioHangtrongCart(tentk, maSP, soLuongMoi,size );
                response.sendRedirect("cart");
            } else {
                if (deleteId != null) {
                    dao.deleteGioHangbyId(tentk, deleteId, size);
                    response.sendRedirect("cart");
                } else {
                    List<SanPham> listSP = c.getAllbyID(listGioHang);
                    request.setAttribute("listCart", listGioHang);
                    request.setAttribute("listSP", listSP);
                    List<SizeSP> listSize = c.getAllSize();
                    request.setAttribute("listSize", listSize);
                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                }
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
