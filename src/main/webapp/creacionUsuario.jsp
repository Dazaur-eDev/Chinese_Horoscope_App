<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
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
            <a class="navbar-brand" href="#">M5-EvaluationFinal - Horoscopo - Crear Nuevo Usuario</a>
        </div>
    </nav>
</header>
<div class="container-fluid flex-grow-1 d-flex justify-content-start align-items-start">
    <div class="ms-5">
        <h2 class="mb-4 mt-5">INSERTAR NUEVO USUARIO</h2>
        <p>Ingrese la información requerida para registrar el nuevo usuario: </p>
        <form action="./CrearUsuarioServlet" method="post">
            <div class="mb-3 col-md-12">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control bg-dark text-white" id="nombre" name="nombre"
                       placeholder="Indique nombre." required>
            </div>
            <div class="mb-3 col-md-12">
                <label for="usuario" class="form-label">Usuario</label>
                <input type="text" class="form-control bg-dark text-white" id="usuario" name="usuario"
                       placeholder="Indique nombre de usuario." required>
            </div>
            <div class="mb-3 col-md-12">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control bg-dark text-white" id="email" name="email"
                       placeholder="Indique correo." required>
            </div>
            <div class="mb-3 col-md-6">
                <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
                <input type="date" class="form-control bg-dark text-white" id="fechaNacimiento" name="fechaNacimiento"
                       value=<%= LocalDate.now()%> required>
            </div>
            <div class="mb-3 col-md-8">
                <label for="password" class="form-label">Contraseña</label>
                <input type="password" class="form-control bg-dark text-white" id="password" name="password"
                       placeholder="Indique su contraseña." required>
            </div>
            <div>
                <button type="submit" class="btn btn-dark mt-2">Guardar</button>
                <a href="./index.jsp" class="btn btn-darkLog mt-2">Cancelar</a>
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