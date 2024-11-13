package com.daza.m5_evalucion_final.servlet;

import com.daza.m5_evalucion_final.dto.HoroscopoDTO;
import com.daza.m5_evalucion_final.dto.UsuarioDTO;
import com.daza.m5_evalucion_final.dto.UsuarioUpdateDTO;
import com.daza.m5_evalucion_final.service.HoroscopoService;
import com.daza.m5_evalucion_final.service.HoroscopoServiceImpl;
import com.daza.m5_evalucion_final.service.UsuarioService;
import com.daza.m5_evalucion_final.service.UsuarioServiceImpl;

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

@WebServlet(name = "ModificarUsuarioServlet", value = "/ModificarUsuarioServlet")
public class ModificarUsuarioServlet extends HttpServlet {

    UsuarioService usuarioService;
    HoroscopoService horoscopoService;

    @Override
    public void init() {
        usuarioService = new UsuarioServiceImpl();
        horoscopoService = new HoroscopoServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UsuarioDTO usuarioEncontrado = (UsuarioDTO) session.getAttribute("usuarioEncontrado");
        int id = usuarioEncontrado.getId();
        String nombre = request.getParameter("nombre").trim();
        String password = request.getParameter("password").trim();
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoDate;
        try {
            fechaNacimientoDate = formater.parse(fechaNacimiento);
        } catch (ParseException e) {
            throw new RuntimeException("Error al convertir al fecha a formato año-mes-dia", e);
        }
        if (nombre == null || nombre.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
            session.setAttribute("usuarioNoModificadoAlert", true);
        } else {
            UsuarioUpdateDTO usuarioParaModificar = new UsuarioUpdateDTO();

            List<HoroscopoDTO> listahoroscopos = horoscopoService.listarHoroscopos();
            String horoscopoAnimal = null;

            for (HoroscopoDTO h : listahoroscopos) {
                if (fechaNacimientoDate.after(h.getFechaInicio()) && fechaNacimientoDate.before(h.getFechaFin())) {
                    horoscopoAnimal = h.getAnimal();
                } else if (fechaNacimientoDate.equals(h.getFechaInicio()) || fechaNacimientoDate.equals(h.getFechaFin())) {
                    horoscopoAnimal = h.getAnimal();
                }
            }
            usuarioParaModificar.setId(id);
            usuarioParaModificar.setNombre(nombre);
            usuarioParaModificar.setUsername(usuarioEncontrado.getUsername());
            usuarioParaModificar.setEmail(usuarioEncontrado.getEmail());
            usuarioParaModificar.setFechaNacimiento(fechaNacimientoDate);
            usuarioParaModificar.setPassword(password);
            usuarioParaModificar.setHoroscopoAnimal(horoscopoAnimal);

            usuarioService.actualizarUsuarioId(usuarioParaModificar);
            session.setAttribute("usuarioModificado", usuarioParaModificar);
            session.setAttribute("usuarioModificadoAlert", true);
        }
        response.sendRedirect("./landing.jsp");
    }
}
