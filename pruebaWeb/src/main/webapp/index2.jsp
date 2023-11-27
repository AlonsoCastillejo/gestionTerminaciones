<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Minsait - Web90x</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>Web90x</h1>
        <nav>
            <ul>
                <li><a href="info?action=logout">Inicio</a></li>
                <li><a href="#servicios">Servicios</a></li>
                <li><a href="#contacto">Contacto</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
        <section id="inicio">
            <h2>Bienvenido a Web90x</h2>
            <p>Ofrecemos la gestion a lo numeros 900</p>
            <a href="#contacto" class="btn">Contáctanos</a>
        </section>

        <section id="servicios">
            <h2>Nuestros Servicios</h2>
            <ul>
                <li>Migracion Encuestas</li>
                <li>Migracion Asociacion Encuestas</li>
            </ul>
        </section>

        <section id="contacto">
            <h2>Contacto</h2>
            <p>Para obtener más información sobre nuestros servicios, déjanos tus datos y nos pondremos en contacto contigo.</p>
            <form>
                <input type="text" placeholder="Nombre">
                <input type="email" placeholder="Correo electrónico">
                <textarea placeholder="Mensaje"></textarea>
                <button type="submit" class="btn">Enviar</button>
            </form>
        </section>
    </main>

    <footer>
        <p>2023 Indra - Todos los derechos reservados</p>
    </footer>
</body>
</html>
