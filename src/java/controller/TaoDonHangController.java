/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.DonHangDao;
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

/**
 *
 * @author ASUS ROG
 */
@WebServlet(name="TaoDonHangController", urlPatterns={"/taoDH","/taoDonHang"})
public class TaoDonHangController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tentk = (String) session.getAttribute("tentk");
        SanPham sp = (SanPham) session.getAttribute("SP");
        DonHangDao dao = new DonHangDao();
        SanPhamDAO dao1 = new SanPhamDAO();
        GioHangDao dao2 = new GioHangDao();
        String diaChi = request.getParameter("diaChi");
        String nganHang = request.getParameter("nganHang");
        String stk = request.getParameter("stk");
        Integer tong = (Integer) session.getAttribute("tong");
        String maDH = (String) session.getAttribute("maDH");
        List<GioHang> listSP = (List<GioHang>) session.getAttribute("listCart");
        if (tentk == null) {
            response.sendRedirect("login");
            session.invalidate();
        }
        else if (sp != null){    
            String size = (String) session.getAttribute("size");
            int quantity =  (Integer) session.getAttribute("quantity");
            String hinhThucThanhToan;
            if (nganHang =="" && stk=="") {
                hinhThucThanhToan = "Trả tiền khi nhận hàng";
            } else {
                hinhThucThanhToan = "Chuyển khoản";
            }
            dao.taoDH(maDH, tentk, tong, hinhThucThanhToan, diaChi, nganHang, stk);
            dao.taoChiTietDH(maDH, tentk, sp.getMaSP(),size, quantity, tong);
            dao1.updateSizeSP(sp.getMaSP(), size, quantity);
            dao1.updateSoLuongDaBan(maDH, quantity);
            response.sendRedirect("order_success.jsp");
        }
        else if (listSP != null) {
            String hinhThucThanhToan;
            if (nganHang =="" && stk=="") {
                hinhThucThanhToan = "Trả tiền khi nhận hàng";
            } else {
                hinhThucThanhToan = "Chuyển khoản";
            }
            for (GioHang c: listSP) {
                dao.taoDH(maDH, tentk, tong, hinhThucThanhToan, diaChi, nganHang, stk);
                dao.taoChiTietDH(maDH, tentk, c.getMaSP(),c.getSizeSP(), c.getSoLuongGH(), tong);
                dao1.updateSizeSP(c.getMaSP(), c.getSizeSP(), c.getSoLuongGH());
                dao1.updateSoLuongDaBan(maDH, c.getSoLuongGH());
                dao2.deleteGioHangbyId(tentk, c.getMaSP(), c.getSizeSP());
            }            
            session.setAttribute("tentk", tentk);
            response.sendRedirect("order_success.jsp");
        }
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
