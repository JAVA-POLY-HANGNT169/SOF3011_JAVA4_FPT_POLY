package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.service.SinhVienService;
import com.fpt.poly.lab.service.impl.SinhVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/search",
        "/sinh-vien/remove",
        "/sinh-vien/detail",
        "/sinh-vien/view-update",
        "/sinh-vien/view-add",
        "/sinh-vien/update",
        "/sinh-vien/add",
})
public class SinhVienServlet extends HttpServlet {
    private SinhVienService service = new SinhVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
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


    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSV", service.getAll());
        request.getRequestDispatcher("/view/trang-chu.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String code = request.getParameter("id");
        service.delete(service.getOne(UUID.fromString(code)));
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sten");
        request.setAttribute("listSV", service.search(sname));
        request.getRequestDispatcher("/view/trang-chu.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("id");
        request.setAttribute("sv", service.getOne(UUID.fromString(code)));
        request.getRequestDispatcher("/view/detail.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add.jsp").forward(request, response);
    }

    private UUID codeUpdate = null;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("id");
        request.setAttribute("sv", service.getOne(UUID.fromString(code)));
        request.getRequestDispatcher("/view/update.jsp").forward(request, response);
        codeUpdate = UUID.fromString(code);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ten = request.getParameter("name");
        String tuoi = request.getParameter("age");
        String diaChi = request.getParameter("address");
        String gioiTinh = request.getParameter("gender");
        service.update(new SinhVien(codeUpdate, ten, Long.valueOf(tuoi), diaChi, Boolean.valueOf(gioiTinh)));
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ten = request.getParameter("name");
        String tuoi = request.getParameter("age");
        String diaChi = request.getParameter("address");
        String gioiTinh = request.getParameter("gender");
        SinhVien sv = new SinhVien();
        sv.setAge(Long.valueOf(tuoi));
        sv.setName(ten);
        sv.setAddress(diaChi);
        sv.setGender(Boolean.valueOf(gioiTinh));
        service.save(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

}
