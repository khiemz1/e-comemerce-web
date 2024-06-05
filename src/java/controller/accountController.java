/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.DonHangDao;
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
import model.ChiTietDonHang;
import model.DetailDH;
import model.DonHang;
import model.KhachHang;
import model.SanPham;
import model.account;

/**
 *
 * @author ASUS ROG
 */
@WebServlet(name = "accountController", urlPatterns = {"/account"})
public class accountController extends HttpServlet {

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
            DonHangDao dao = new DonHangDao();
            SanPhamDAO dao1 = new SanPhamDAO();
            KhachHangDAO dao2 = new KhachHangDAO();
            String tentk = (String) session.getAttribute("tentk");
            String sdt = (String) session.getAttribute("sdt");
            String mk = (String) session.getAttribute("mk");
            String confirm = request.getParameter("confirm");
            String maDonHang = request.getParameter("maDH");
            KhachHang kh = dao2.getKHbyTentk(tentk);
            List<DonHang> listDH = dao.getDonHangbyTentk(tentk);
            List<ChiTietDonHang> listDetail = dao.getChiTietDonHangbyId(tentk);
            List<DetailDH> listSP = new ArrayList<>();
            for (ChiTietDonHang c : listDetail) {
                SanPham c1 = dao1.getSanPhambyId(c.getMaSP());
                DetailDH sp = new DetailDH(c.getMaDH(),
                        tentk, c.getMaSP(), c1.getTenSP(),
                        c1.getAnhSP(), c.getSizeSP(), c1.getGiaSP(),
                        c.getSoLuongDH(), c.getTongTien());
                listSP.add(sp);
            }
            String thongBao = request.getParameter("thongBao");
            if (thongBao != null) {
                request.setAttribute("thongBao", thongBao);
            }
            request.setAttribute("tentk", tentk);
            request.setAttribute("sdt", sdt);
            request.setAttribute("mk", mk);
            request.setAttribute("KH", kh);
            request.setAttribute("listDH", listDH);
            request.setAttribute("listSP", listSP);
            if (confirm != null && maDonHang != null) {
                dao.updateDH(tentk, maDonHang, confirm);
                response.sendRedirect("account");
            } else {
                request.getRequestDispatcher("account.jsp").forward(request, response);
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
