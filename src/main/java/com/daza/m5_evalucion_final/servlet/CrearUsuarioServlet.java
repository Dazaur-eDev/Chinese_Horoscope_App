package com.daza.m5_evalucion_final.servlet;

import com.daza.m5_evalucion_final.dto.HoroscopoDTO;
import com.daza.m5_evalucion_final.dto.UsuarioCreateDTO;
import com.daza.m5_evalucion_final.dto.UsuarioDTO;
import com.daza.m5_evalucion_final.service.HoroscopoService;
import com.daza.m5_evalucion_final.service.HoroscopoServiceImpl;
import com.daza.m5_evalucion_final.service.UsuarioService;
import com.daza.m5_evalucion_final.service.UsuarioServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "CrearUsuarioServlet", value = "/CrearUsuarioServlet")
public class CrearUsuarioServlet extends HttpServlet {

    UsuarioService usuarioService;
    HoroscopoService horoscopoService;

    @Override
    public void init() {
        usuarioService = new UsuarioServiceImpl();
        horoscopoService = new HoroscopoServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombre = request.getParameter("nombre").trim();
        String usuario = request.getParameter("usuario").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoDate;
        try {
            fechaNacimientoDate = formater.parse(fechaNacimiento);
        } catch (ParseException e) {
            throw new RuntimeException("Error al convertir al fecha a formato año-mes-dia", e);
        }
        Optional<UsuarioDTO> usuarioEmailEncontrado = usuarioService.listarUsuarios().stream()
                .filter(usuarioEmail -> usuarioEmail.getEmail() != null && usuarioEmail.getEmail().equals(email))
                .findFirst();
        if (usuarioEmailEncontrado.isPresent()) {
            if (usuarioEmailEncontrado.get().getEmail().equals(email)) {
                session.setAttribute("usuarioExistente", true);
            }
        } else {
            if (!usuarioService.buscarUsuario(usuario).isPresent()) {
                if (nombre == null || nombre.trim().isEmpty() ||
                        usuario == null || usuario.trim().isEmpty() ||
                        email == null || email.trim().isEmpty() ||
                        password == null || password.trim().isEmpty() ||
                        fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
                    session.setAttribute("usuarioNoCreado", true);
                } else {
                    UsuarioCreateDTO usuarioParaAgregar = new UsuarioCreateDTO();
                    List<HoroscopoDTO> listahoroscopos = horoscopoService.listarHoroscopos();
                    String horoscopoAnimal = null;
                    for (HoroscopoDTO h : listahoroscopos) {
                        if (fechaNacimientoDate.after(h.getFechaInicio()) && fechaNacimientoDate.before(h.getFechaFin())) {
                            horoscopoAnimal = h.getAnimal();
                        } else if (fechaNacimientoDate.equals(h.getFechaInicio()) || fechaNacimientoDate.equals(h.getFechaFin())) {
                            horoscopoAnimal = h.getAnimal();
                        }
                    }
                    usuarioParaAgregar.setNombre(nombre);
                    usuarioParaAgregar.setUsername(usuario);
                    usuarioParaAgregar.setEmail(email);
                    usuarioParaAgregar.setFechaNacimiento(fechaNacimientoDate);
                    usuarioParaAgregar.setPassword(password);
                    usuarioParaAgregar.setHoroscopoAnimal(horoscopoAnimal);
                    usuarioService.crearUsuario(usuarioParaAgregar);
                    session.setAttribute("usuarioCreado", true);
                }
            } else {
                session.setAttribute("usuarioExistente", true);
            }
        }
        request.getRequestDispatcher("./index.jsp").forward(request, response);
    }
}
