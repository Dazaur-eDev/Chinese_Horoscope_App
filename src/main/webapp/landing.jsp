<%@ page import="com.daza.m5_evalucion_final.dto.UsuarioDTO" %>
<%@ page import="com.daza.m5_evalucion_final.dto.UsuarioUpdateDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido</title>
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
            <a class="navbar-brand" href="#">M5-EvaluationFinal - Horoscopo - Página principal de Usuario</a>
        </div>
    </nav>
</header>

<div class="container-fluid flex-grow-1 d-flex justify-content-center align-items-center">
    <!-- Card para desplegar info del usuario-->
    <div class="col-12 col-sm-8 col-md-6 col-lg-4">
        <div class="card shadow rounded-4">
            <div class="card-body card-glow rounded-4">
                <%
                    String mensaje = request.getParameter("mensaje");
                    if (mensaje != null) {
                %>
                <div class="alert alert-warning text-center" role="alert">
                    <%=mensaje%>
                </div>
                <%
                    }
                    request.removeAttribute("mensaje");
                %>
                <h2 class="card-title text-center mb-4 mt-5">BIENVENIDO</h2>
                <%
                    Boolean usuarioModificadoAlert = (Boolean) session.getAttribute("usuarioModificadoAlert");
                    Boolean usuarioNoModificadoAlert = (Boolean) session.getAttribute("usuarioNoModificadoAlert");
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
                    if (usuarioModificadoAlert != null && usuarioModificadoAlert) {
                %>
                <div class="alert alert-success text-center mt-2" id="mensajeCrud" role="alert">
                    Tus datos han sido actualizados.
                </div>
                <%
                } else if (usuarioNoModificadoAlert != null && usuarioNoModificadoAlert) {
                %>
                <div class="alert alert-warning text-center mt-2" id="mensajeCrud" role="alert">
                    Tus datos no han sido actualizados. Verifica que no sean vacíos.
                </div>
                <%
                    }
                    session.removeAttribute("usuarioModificadoAlert");
                    session.removeAttribute("usuarioNoModificadoAlert");
                %>
                <div class="mb-2 text-center mx-auto d-block">
                    <img class="align-items-center" src="./assets/img/FotoPerfil.png" alt="Foto_Perfil" width="250"
                         height="250">
                </div>
                <div class="text-center">
                    <label id="usuario" class="form-label">Usuario: <strong><%= usuarioEncontrado.getUsername()%>
                    </strong><br> Nombre: <strong><%= usuarioEncontrado.getNombre()%>
                    </strong>
                        <br> <strong><%= fechaNacimientoFormateada%>
                        </strong>
                    </label>
                </div>
                <div class="d-grid m-2">
                    <a href="./verHoroscopo.jsp" class="btn btn-darkLog mt-2">Averigua tu animal de Horoscopo Chino</a>
                </div>
                <div class="d-grid m-2">
                    <a href="./modificarUsuario.jsp" class="btn btn-darkLog mt-2">Modificar tus datos</a>
                </div>
                <div class="d-grid m-2">
                    <a href="./EliminarUsuarioServlet" class="btn btn-darkLog mt-2" onclick="return confirmarSalir();">Eliminar tu cuenta</a>
                </div>
                <div class="d-grid m-2">
                    <a href="./CerrarUsuarioServlet" class="btn btn-dark mt-2">Salir</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    function confirmarSalir() {
        return confirm("¿Estás seguro de que deseas eliminar la cuenta?");
    }
</script>
<!-- Footer -->
<footer class="bg-dark text-white text-center card-glow mt-auto">
    <div class="container-fluid">
        <p class="small m-1"> © 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>

</body>
</html>
