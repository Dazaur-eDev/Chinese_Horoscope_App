package com.daza.m5_evalucion_final.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CerrarUsuarioServlet", value = "/CerrarUsuarioServlet")
public class CerrarUsuarioServlet extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession session = request.getSession(false);
        if (session != null) {
        session.invalidate();
    }
        response.sendRedirect("index.jsp");
    }
}
