<%@ page import="com.daza.m5_evalucion_final.dto.UsuarioDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tu animal del Horóscopo</title>
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
            <a class="navbar-brand" href="#">M5-EvaluationFinal - Horoscopo - Encuentra tu Animal del Horóscopo
                Chino</a>
        </div>
    </nav>
</header>

<div class="container-fluid flex-grow-1 d-flex justify-content-center align-items-center">
    <!-- Card para desplegar animal del horóscopo-->
    <div class="col-12 col-sm-8 col-md-6 col-lg-4">
        <div class="card shadow rounded-4">
            <div class="card-body card-glow rounded-4">
                <%
                    UsuarioDTO usuarioEncontrado;
                    usuarioEncontrado = (UsuarioDTO) session.getAttribute("usuarioEncontrado");
                    String horoscopoAnimal = usuarioEncontrado.getHoroscopoAnimal();
                    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaNacimientoFormateada = formater.format(usuarioEncontrado.getFechaNacimiento());
                    String mensajePersonalizado;
                    switch (horoscopoAnimal) {
                        case "Rata":
                            mensajePersonalizado = "Astuta, adaptable y persuasiva. Se destaca por su ingenio, curiosidad y habilidades para resolver problemas.";
                            break;
                        case "Buey":
                            mensajePersonalizado = "Paciente, trabajador y confiable. Firme y determinado, tiene una gran ética de trabajo y un enfoque práctico.";
                            break;
                        case "Tigre":
                            mensajePersonalizado = "Valiente, apasionado y seguro de sí mismo. Le gusta la aventura y no teme tomar riesgos, pero puede ser impulsivo.";
                            break;
                        case "Conejo":
                            mensajePersonalizado = "Gracioso, tranquilo y bondadoso. Valora la paz y la estabilidad, y es muy querido por su amabilidad y sensibilidad.";
                            break;
                        case "Dragon":
                            mensajePersonalizado = "Energético, carismático y audaz. Es un líder natural, lleno de confianza, ambición y poder.";
                            break;
                        case "Serpiente":
                            mensajePersonalizado = "Sabia, intuitiva y enigmática. Prefiere la reflexión y la calma, pero puede ser muy perspicaz y astuta.";
                            break;
                        case "Caballo":
                            mensajePersonalizado = "Independiente, enérgico y amante de la libertad. Siempre en movimiento, disfruta de la aventura y es muy sociable.";
                            break;
                        case "Cabra":
                            mensajePersonalizado = "Creativa, artística y gentil. Prefiere un entorno pacífico, es muy considerada con los demás y busca la armonía.";
                            break;
                        case "Mono":
                            mensajePersonalizado = "Ingenioso, travieso y versátil. Es muy inteligente, curioso y lleno de energía, lo que lo hace muy adaptable.";
                            break;
                        case "Gallo":
                            mensajePersonalizado = "Valiente, preciso y trabajador. Es muy observador, le gusta destacar y es conocido por su fiabilidad.";
                            break;
                        case "Perro":
                            mensajePersonalizado = "Leal, honesto y protector. Siempre busca la justicia y es un amigo fiel, muy preocupado por el bienestar de los demás.";
                            break;
                        case "Cerdo":
                            mensajePersonalizado = "Sincero, generoso y amable. Es muy optimista y disfruta de la vida, pero también es muy trabajador cuando es necesario.";
                            break;
                        default:
                            mensajePersonalizado = "";
                            break;
                    }
                %>
                <h2 class="card-title text-center mb-4 mt-5"><%= horoscopoAnimal.toUpperCase()%></h2>
                <div class="mb-2 text-center mx-auto d-block">
                    <img class="align-items-center m-3" src="./assets/img/<%=horoscopoAnimal%>.png" alt="Animal Horóscopo" width="150"
                         height="150">
                </div>
                <div class="text-center">
                    <label id="usuario" class="form-label">
                        De acuerdo a tu fecha de nacimiento <br>
                        <strong><%=fechaNacimientoFormateada%>
                        </strong><br>
                        eres un/una <strong><%= horoscopoAnimal%></strong><br>
                        __________________________________________________
                    </label>
                </div>
                <div class="text-center m-3">
                    <label class="text-secondary text-center"><em><%= mensajePersonalizado %></em></label>
                </div>
                <div class="d-grid m-2">
                    <a href="./landing.jsp" class="btn btn-dark mt-2">Regresar</a>
                </div>
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