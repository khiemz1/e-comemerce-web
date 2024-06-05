/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.SanPham;
import model.SizeSP;

/**
 *
 * @author ASUS ROG
 */
@WebServlet(name = "AddSanPhamController", urlPatterns = {"/addSP"})
public class AddSanPhamController extends HttpServlet {

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
        String maSP = request.getParameter("maSP");
        String tenSP = request.getParameter("tenSP");
        String anhSP = request.getParameter("anhSP");
        String anhSP1 = request.getParameter("anhSP1");
        String anhSP2 = request.getParameter("anhSP2");
        String anhSP3 = request.getParameter("anhSP3");
        String brandSP = request.getParameter("brand");
        String giaSP = request.getParameter("giaSP");
        String moTaSP = request.getParameter("moTaSP");

        SanPhamDAO dao = new SanPhamDAO();
        dao.addSanPham(maSP, tenSP, anhSP, brandSP, giaSP, moTaSP);
        dao.addAnhSanPham(maSP, anhSP1, anhSP2, anhSP3);
        SanPham sp = dao.getSanPhambyId(maSP);
        List<SizeSP> size = dao.getSizebyId(maSP);
        PrintWriter out = response.getWriter();
        if (sp != null && size != null) {
            String htmlOutput = "<tr id=\"" + maSP + "\">"
                    + "<td>" + sp.getTenSP() + "</td>"
                    + "<td>" + sp.getMaSP() + "</td>"
                    + "<td>" + sp.getBrandSP() + "</td>"
                    + "<td>" + sp.getGiaSP() + " Vnđ</td>"
                    + "<td>";

            for (SizeSP s : size) {
                if (s.getMaSP().equals(maSP)) {
                    htmlOutput += "<p> Size: " + s.getSize() + " (Còn lại: " + s.getSoLuongSize() + ")</p>";

                }
            }
            htmlOutput += "</td>"
                    + "<td>" + sp.getSoluongDaBan() + "</td>"
                    + "<td><a class=\"btn\" id=\"btn-edit\" onclick=\"edit_Form('" + sp.getTenSP() + "', '" + sp.getMaSP() + "', '" + sp.getBrandSP() + "', '" + sp.getGiaSP() + "', '" + sp.getMoTaSP() + "', '" + sp.getAnhSP() + "')\">Sửa</a></td>"
                    + "<td><a href=\"admin_stock?job=delete&maSP=" + sp.getMaSP() + "\" class=\"btn\">Xóa</a></td>"+
                    "</tr>";

// In đoạn HTML ra PrintWriter
            out.print(htmlOutput);
        } else {
            if (sp == null) {
                out.println("1");
            } else if (size == null) {
                out.print("2");
            } else if (sp == null && size == null) {
                out.print("3");
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
