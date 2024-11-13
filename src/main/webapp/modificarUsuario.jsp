<%@ page import="com.daza.m5_evalucion_final.dto.UsuarioDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.daza.m5_evalucion_final.dto.UsuarioUpdateDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Usuario</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>

<body class="d-flex flex-column min-vh-100">

<header>
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark card-glow">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">M5-EvaluationFinal - Horoscopo - Modificar Usuario</a>
        </div>
    </nav>
</header>
<div class="container-fluid flex-grow-1 d-flex justify-content-start align-items-start">
    <%
        UsuarioDTO usuarioEncontrado;
        UsuarioUpdateDTO usuarioModificado;
        usuarioEncontrado = (UsuarioDTO) session.getAttribute("usuarioEncontrado");
        usuarioModificado = (UsuarioUpdateDTO) session.getAttribute("usuarioModificado");
        String fechaNacimientoFormateada;
        if (usuarioModificado != null) {
            usuarioEncontrado.setNombre(usuarioModificado.getNombre());
            usuarioEncontrado.setUsername(usuarioModificado.getUsername());
            usuarioEncontrado.setEmail(usuarioModificado.getEmail());
            usuarioEncontrado.setFechaNacimiento(usuarioModificado.getFechaNacimiento());
            usuarioEncontrado.setPassword(usuarioModificado.getPassword());
            usuarioEncontrado.setHoroscopoAnimal(usuarioModificado.getHoroscopoAnimal());
        }
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        fechaNacimientoFormateada = formater.format(usuarioEncontrado.getFechaNacimiento());
    %>
    <div class="ms-5">
        <h2 class="mb-4 mt-5">MODIFICAR NUEVO USUARIO</h2>
        <p>Ingrese la información que desea actualizar: </p>
        <form action="./ModificarUsuarioServlet" method="post">
            <div class="mb-3 col-md-12">
                <label for="nombre" class="form-label">Nombre actual:</label>
                <input type="text" class="form-control bg-dark text-white" id="nombre" name="nombre"
                       value="<%=usuarioEncontrado.getNombre()%>" required>
            </div>
            <div class="mb-3 col-md-12">
                <label for="usuario" class="form-label">Nombre de Usuario actual:</label>
                <input type="text" class="form-control bg-dark text-white" id="usuario" name="usuario"
                       placeholder=" <%=usuarioEncontrado.getUsername()%>" disabled>
            </div>
            <div class="mb-3 col-md-12">
                <label for="email" class="form-label">Email actual:</label>
                <input type="email" class="form-control bg-dark text-white" id="email" name="email"
                       placeholder="<%=usuarioEncontrado.getEmail()%>" disabled>
            </div>
            <div class="mb-3 col-md-7">
                <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento registrada:</label>
                <input type="date" class="form-control bg-dark text-white" id="fechaNacimiento" name="fechaNacimiento"
                       value=<%=fechaNacimientoFormateada%> required>
            </div>
            <div class="mb-3 col-md-8">
                <label for="password" class="form-label">Tu Contraseña actual:</label>
                <input type="password" class="form-control bg-dark text-white" id="password" name="password"
                       value="<%=usuarioEncontrado.getPassword()%>" required>
            </div>
            <div>
                <button type="submit" class="btn btn-dark mt-2">Guardar</button>
                <a href="./landing.jsp" class="btn btn-darkLog mt-2">Cancelar</a>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<!-- Footer -->
<footer class="bg-dark text-white text-center card-glow mt-auto">
    <div class="container-fluid">
        <p class="small m-1"> © 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>

</body>
</html>
