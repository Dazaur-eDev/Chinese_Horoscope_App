<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
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
            <a class="navbar-brand" href="#">M5-EvaluationFinal - Horoscopo - Inicio Sesión</a>
        </div>
    </nav>
</header>

<div class="container-fluid flex-grow-1 d-flex justify-content-center align-items-center">
    <!-- Card para iniciar Sesión-->
    <div class="col-12 col-sm-8 col-md-6 col-lg-4">
        <div class="card shadow rounded-4">
            <div class="card-body card-glow rounded-4">
                <h2 class="card-title text-center mb-4">Iniciar Sesión</h2>
                <%
                    String mensaje = request.getParameter("mensaje");
                    if (mensaje != null) {
                %>
                <div class="alert alert-success text-center" role="alert">
                    <%=mensaje%>
                </div>
                <%
                    }
                    request.removeAttribute("mensaje");
                    Boolean usuarioInvalido = (Boolean) session.getAttribute("usuarioInvalido");
                    Boolean passwordInvalida = (Boolean) session.getAttribute("passwordInvalida");
                    Boolean usuarioCreado = (Boolean) session.getAttribute("usuarioCreado");
                    Boolean usuarioNoCreado = (Boolean) session.getAttribute("usuarioNoCreado");
                    Boolean usuarioExistente = (Boolean) session.getAttribute("usuarioExistente");
                    if (usuarioInvalido != null && usuarioInvalido) {
                %>
                <div class="alert alert-danger text-center mt-2" id="mensajeCrud" role="alert">
                    Usuario no existente. Crea uno nuevo para ingresar.
                </div>
                <%
                } else if (passwordInvalida != null && passwordInvalida) {
                %>
                <div class="alert alert-warning text-center mt-2" id="mensajeCrud" role="alert">
                    Contraseña incorrecta. Por favor vuelve a intentarlo.
                </div>
                <%
                } else if (usuarioCreado != null && usuarioCreado) {
                %>
                <div class="alert alert-success text-center mt-2" id="mensajeCrud" role="alert">
                    Usuario creado con éxito.
                </div>
                <%
                } else if (usuarioNoCreado != null && usuarioNoCreado) {
                %>
                <div class="alert alert-danger text-center mt-2" id="mensajeCrud" role="alert">
                    Usuario no ha sido creado, por favor intente nuevamente.
                </div>
                <%
                } else if (usuarioExistente != null && usuarioExistente) {
                %>
                <div class="alert alert-warning text-center mt-2" id="mensajeCrud" role="alert">
                    Usuario y/o Email ya existen, por favor intente nuevamente.
                </div>
                <%
                }
                    session.removeAttribute("usuarioInvalido");
                    session.removeAttribute("passwordInvalida");
                    session.removeAttribute("usuarioCreado");
                    session.removeAttribute("usuarioNoCreado");
                    session.removeAttribute("usuarioExistente");
                %>
                <form action="./IniciarSesionServlet" method="post">
                    <div class="mb-3">
                        <label for="usuario" class="form-label">Usuario</label>
                        <input type="text" class="form-control" id="usuario" name="usuario" required>
                    </div>
                    <div class="mb-3">
                        <label for="contrasena" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="contrasena" name="contrasena" required>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-darkLog mb-1">Ingresar</button>
                    </div>
                    <div class="d-grid">
                        <a href="/creacionUsuario.jsp" class="btn btn-darkLog mt-2">Crear nuevo Usuario</a>
                    </div>
                </form>
            </div>
        </div>
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
