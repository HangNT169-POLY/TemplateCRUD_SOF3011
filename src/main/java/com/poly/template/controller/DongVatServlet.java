package com.poly.template.controller;

import com.poly.template.entity.DongVat;
import com.poly.template.repository.DongVatRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author hangnt169
 */
@WebServlet(name = "DongVatController", value = {
        "/dong-vat/hien-thi",  // GET
        "/dong-vat/add",      // POST
        "/dong-vat/update",      // POST
        "/dong-vat/delete",    // GET
        "/dong-vat/view-update",// GET
        "/dong-vat/view-add", // GET
        "/dong-vat/detail"    // GET
})
public class DongVatServlet extends HttpServlet {

    private DongVatRepository dongVatRepository = new DongVatRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<DongVat> dongvats = dongVatRepository.getAll();
        request.setAttribute("dongvats", dongvats);
        request.getRequestDispatcher("/view/dong-vat.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/add-dong-vat.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        DongVat dongvat = dongVatRepository.getOne(Long.valueOf(id));
        request.setAttribute("dongVat", dongvat);
        request.getRequestDispatcher("/view/update-dong-vat.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongVat dongvat = dongVatRepository.getOne(Long.valueOf(id));
        request.setAttribute("dongVat", dongvat);
        request.getRequestDispatcher("/view/detail-dong-vat.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        DongVat dongvat = dongVatRepository.getOne(Long.valueOf(id));
        dongVatRepository.delete(dongvat);
        response.sendRedirect("/dong-vat/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ten = request.getParameter("ten");
        String canNang = request.getParameter("canNang");
        String gioiTinh = request.getParameter("gioiTinh");
        String namSinh = request.getParameter("namSinh");

        DongVat dongVat = new DongVat(ten, Float.valueOf(canNang), Boolean.valueOf(gioiTinh), Integer.valueOf(namSinh));
        dongVatRepository.add(dongVat);
        response.sendRedirect("/dong-vat/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String canNang = request.getParameter("canNang");
        String gioiTinh = request.getParameter("gioiTinh");
        String namSinh = request.getParameter("namSinh");
        DongVat dongVat = new DongVat(Long.valueOf(id), ten, Float.valueOf(canNang), Boolean.valueOf(gioiTinh), Integer.valueOf(namSinh));
        dongVatRepository.update(dongVat);
        response.sendRedirect("/dong-vat/hien-thi");
    }
}
