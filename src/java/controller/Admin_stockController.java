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
@WebServlet(name = "Admin_stockController", urlPatterns = {"/admin_stock"})
public class Admin_stockController extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        SanPhamDAO dao = new SanPhamDAO();
        String job = request.getParameter("job");
        String maSP = request.getParameter("maSP");
        String size = request.getParameter("size");
        String quantity = request.getParameter("quantity");
        if (job != null && job.equals("addSize")) {
            int sl = Integer.parseInt(quantity);
            if (dao.checkSize(maSP, size) == 1) {
                dao.updateSoLuongSize(maSP, size, sl);
            } else {
                dao.themSizeSP(maSP, size, sl);
            }
            SanPham sp = dao.getSanPhambyId(maSP);
            List<SizeSP> ListSize = dao.getSizebyId(maSP);
            if (sp != null && size != null) {
                String htmlOutput = "<td>" + sp.getTenSP() + "</td>"
                        + "<td>" + sp.getMaSP() + "</td>"
                        + "<td>" + sp.getBrandSP() + "</td>"
                        + "<td>" + sp.getGiaSP() + " Vnđ</td>"
                        + "<td>";

                for (SizeSP s : ListSize) {
                    if (s.getMaSP().equals(maSP)) {
                        htmlOutput += "<p> Size: " + s.getSize() + " (Còn lại: " + s.getSoLuongSize() + ")</p>";

                    }
                }
                htmlOutput += "</td>"
                        + "<td>" + sp.getSoluongDaBan() + "</td>"
                        + "<td><a class=\"btn\" id=\"btn-edit\" onclick=\"edit_Form('" + sp.getTenSP() + "', '" + sp.getMaSP() + "', '" + sp.getBrandSP() + "', '" + sp.getGiaSP() + "', '" + sp.getMoTaSP() + "', '" + sp.getAnhSP() + "')\">Sửa</a></td>"
                        + "<td><a href=\"admin_stock?job=delete&maSP=" + sp.getMaSP() + "\" class=\"btn\">Xóa</a></td>";

// In đoạn HTML ra PrintWriter
                out.print(htmlOutput);
            }
        } else if (job != null && job.equals("delete")) {
            dao.deleteSP(maSP);
            response.sendRedirect("admin_stock");
        } 
        else {
            List<SanPham> listSP = dao.getAll();
            List<SizeSP> listSize = dao.getAllSize();
            request.setAttribute("listSP", listSP);
            request.setAttribute("listSize", listSize);
            request.getRequestDispatcher("admin-stock.jsp").forward(request, response);
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
