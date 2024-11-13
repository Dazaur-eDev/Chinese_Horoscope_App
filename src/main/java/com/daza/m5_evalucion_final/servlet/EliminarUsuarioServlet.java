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

@WebServlet(name = "EliminarUsuarioServlet", value = "/EliminarUsuarioServlet")
public class EliminarUsuarioServlet extends HttpServlet {
    UsuarioService usuarioService;

    @Override
    public void init() {
        usuarioService = new UsuarioServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UsuarioDTO usuarioEncontrado = (UsuarioDTO) session.getAttribute("usuarioEncontrado");
        int id = usuarioEncontrado.getId();
        if (usuarioService.buscarUsuarioId(id).isPresent()) {
            usuarioService.eliminarUsuario(id);
            response.sendRedirect("./index.jsp?mensaje=El usuario ha sido eliminado satisfactoriamente");
        } else {
            response.sendRedirect("./landing.jsp?mensaje=Ha ocurrido un problema para eliminar tu cuenta");
        }
    }
}
