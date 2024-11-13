package com.daza.m5_evalucion_final.servlet;

import com.daza.m5_evalucion_final.dto.UsuarioDTO;
import com.daza.m5_evalucion_final.service.UsuarioService;
import com.daza.m5_evalucion_final.service.UsuarioServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "IniciarSesionServlet", value = "/IniciarSesionServlet")
public class IniciarSesionServlet extends HttpServlet {

    UsuarioService usuarioService;

    @Override
    public void init() {
        usuarioService = new UsuarioServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("contrasena");
        Optional<UsuarioDTO> usuarioOptional = usuarioService.buscarUsuario(usuario);
        if (usuarioOptional.isPresent()) {
            UsuarioDTO usuarioEncontrado = usuarioOptional.get();
            session.setAttribute("usuarioEncontrado", usuarioEncontrado);
            if (usuarioEncontrado.getPassword().equals(password) && usuarioEncontrado.getPassword() != null) {
                request.getRequestDispatcher("landing.jsp").forward(request, response);
            } else {
                session.setAttribute("passwordInvalida", true);
                response.sendRedirect("./index.jsp");
            }
        } else {
            session.setAttribute("usuarioInvalido", true);
            response.sendRedirect("./index.jsp");
        }
    }
}
