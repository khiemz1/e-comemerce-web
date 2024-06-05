/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.DonHangDao;
import dao.GioHangDao;
import dao.KhachHangDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.GioHang;
import model.KhachHang;
import model.SanPham;

/**
 *
 * @author ASUS ROG
 */
@WebServlet(name = "thanhtoan", urlPatterns = {"/thanhtoan"})
public class ThanhtoanController extends HttpServlet {

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
        GioHangDao dao = new GioHangDao();
        SanPhamDAO dao1 = new SanPhamDAO();
        KhachHangDAO dao2 = new KhachHangDAO();
        DonHangDao dao3 = new DonHangDao();
        String listCart = request.getParameter("StringMaSP");
        String listSizeSP = request.getParameter("StringSizeSP");
        String maSP = request.getParameter("maSP");
        String quantity = request.getParameter("quantity");
        String size = request.getParameter("size");
        HttpSession session = request.getSession();
        String tentk = (String) session.getAttribute("tentk");
        if (tentk == null) {
            response.sendRedirect("login");
        } else if (listCart != null && tentk != null && listSizeSP != null) {
            String[] listMaSP = listCart.split(",");
            String[] listSize = listSizeSP.split(",");
            List<GioHang> a = new ArrayList<>();
            int tong = 0;
            for (int i = 0; i < listMaSP.length; i++) {
                GioHang c = dao.getGioHangforCheckOut(tentk, listMaSP[i], listSize[i]);
                a.add(c);
                int tmp = c.getTongTien();
                tong = tmp + tong;
            }
            List<SanPham> b = dao1.getAllbyID(a);
            KhachHang kh = dao2.getKHbyTentk(tentk);
            String maDH = dao3.taoMaDH(tentk);
            request.setAttribute("listCart", a);
            session.setAttribute("listCart", a);
            request.setAttribute("tong", tong);
            session.setAttribute("tong", tong);
            request.setAttribute("listSP", b);
            request.setAttribute("KH", kh);
            request.setAttribute("maDH", maDH);
            session.setAttribute("maDH", maDH);
            request.getRequestDispatcher("thanhtoan_fromCart.jsp").forward(request, response);
        } else if (maSP != null && tentk != null && quantity != null && size != null) {
            KhachHang kh = dao2.getKHbyTentk(tentk);
            String maDH = dao3.taoMaDH(tentk);
            SanPham a = dao1.getSanPhambyId(maSP);
            int sl = Integer.parseInt(quantity);
            int tong = a.getGiaSP()*sl; 
            request.setAttribute("quantity", sl);
            request.setAttribute("size", size);
            request.setAttribute("SP", a);
            request.setAttribute("KH", kh);
            request.setAttribute("maDH", maDH);
            request.setAttribute("tong", tong);
            session.setAttribute("tong", tong);
            session.setAttribute("maDH", maDH);
            session.setAttribute("SP", a);
            session.setAttribute("size", size);
            session.setAttribute("quantity", sl);
            request.getRequestDispatcher("thanhtoan_buynow.jsp").forward(request, response);
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
