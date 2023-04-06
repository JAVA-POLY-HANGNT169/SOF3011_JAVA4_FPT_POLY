package com.poly.hangnt169.controller;

import com.poly.hangnt169.entity.MayTinh;
import com.poly.hangnt169.repository.MayTinhRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MayTinhServlet", value = {
        "/may-tinh/hien-thi",
        "/may-tinh/detail",
        "/may-tinh/view-update",
        "/may-tinh/add",
        "/may-tinh/update",
        "/may-tinh/remove",
})
public class MayTinhServlet extends HttpServlet {

    private MayTinhRepository mayTinhRepository = new MayTinhRepository();
    private List<MayTinh> lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID ma = UUID.fromString(request.getParameter("ma"));
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String boNho = request.getParameter("boNho");
        String mauSac = request.getParameter("mauSac");
        String hang = request.getParameter("hang");
        String mieuTa = request.getParameter("moTa");
        MayTinh mayTinh = MayTinh.builder()
                .ma(ma)
                .ten(ten)
                .gia(Double.parseDouble(gia))
                .boNho(boNho)
                .mauSac(mauSac)
                .hang(hang)
                .mieuTa(mieuTa)
                .build();
        mayTinhRepository.update(mayTinh);
        response.sendRedirect("/may-tinh/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String boNho = request.getParameter("boNho");
        String mauSac = request.getParameter("mauSac");
        String hang = request.getParameter("hang");
        String mieuTa = request.getParameter("moTa");
        MayTinh mayTinh = MayTinh.builder()
                .ten(ten)
                .gia(Double.parseDouble(gia))
                .boNho(boNho)
                .mauSac(mauSac)
                .hang(hang)
                .mieuTa(mieuTa)
                .build();
        mayTinhRepository.add(mayTinh);
        response.sendRedirect("/may-tinh/hien-thi");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID ma = UUID.fromString(request.getParameter("ma"));
        MayTinh mayTinh = mayTinhRepository.getOne(ma);
        request.setAttribute("mayTinh", mayTinh);
        request.getRequestDispatcher("/view-update.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID ma = UUID.fromString(request.getParameter("ma"));
        MayTinh mayTinh = mayTinhRepository.getOne(ma);
        mayTinhRepository.remove(mayTinh);
        response.sendRedirect("/may-tinh/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID ma = UUID.fromString(request.getParameter("ma"));
        MayTinh mayTinh = mayTinhRepository.getOne(ma);
        request.setAttribute("mayTinh", mayTinh);
        lists = mayTinhRepository.getALl();
        request.setAttribute("list", lists);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = mayTinhRepository.getALl();
        request.setAttribute("list", lists);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

}
