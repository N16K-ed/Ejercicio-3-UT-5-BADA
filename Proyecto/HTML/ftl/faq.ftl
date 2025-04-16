<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link rel="stylesheet" href="carrito.css"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>

        html, body {
            margin: 0px;
            height: 100%;
        }

        .wrapper {
            padding: 20px;
        }

        @import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

        * {
            font-family: "Open Sans", sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #414141;
            border-radius: 20px;
        }

        .topnav a{
            display: inline-block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover:not(:first-child) {
            background-color: #717171;
            text-decoration: underline;
        }

        .topnav form {
            display: inline-block;
            padding: 14px 16px;
            margin-left: 25%;
        }

        .topnav input {
            width: 30vw;
            border-radius: 5px;
            height: 4vh;
        }

        .topnav button {
            margin-left: 10px;
            height: 5.5vh;
            width: 3vw;
            border-radius: 5px;
            background-color: transparent;
            outline: 1px solid white;
            border: none;
        }

        .faq {
            flex: 1;
            padding: 40px;
            padding-top: 50px;
            padding-bottom: 50px;
            width: 80%;
            margin: auto;
            margin-top: 15vh;
            margin-bottom: 25vh;
            outline: 1px solid rgb(154, 154, 154);
            border-radius: 10px;
            background-color: rgba(221, 221, 221, 0.5);
            box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
        }

        .faq img {
            width: 100px;
            margin-right: 20px;
            border-radius: 10px;
        }

        .faq h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .faq-item {
            margin-bottom: 15px;
        }

        .faq-boton {
            width: 100%;
            padding: 10px;
            text-align: left;
            background-color: #5e5e5e;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .faq-boton:hover {
            background-color: #303030;
        }

        .faq-respuesta {
            display: none;
            padding: 10px;
            background-color: #d6d6d6;
            border-radius: 5px;
            margin-top: 10px;
            font-size: 14px;
        }

        .faq-respuesta p {
            margin: 0;
        }

        footer {
            margin-top: 8vh;
            background-color: #4d4d4d;
            padding-top: 3px;
            margin-top: auto;
        }

        footer li {
            list-style-type: none;
        }

        .footerGrid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            grid-template-rows: 1fr;
            grid-column-gap: 0px;
            grid-row-gap: 0px;
            background-color: #414141;
            padding-top: 20px;
        }

        .footerGrid > * {
            padding: 0;
            margin: 0;
        }

        .footerGrid form {
            text-align: center;
            padding: 20px;
        }

        .footerGrid input {
            margin: 10px;
            height: 4vh;
            width: 18vw;
            border-radius: 5px;
        }

        .footerGrid ul {
            margin-left: 60px;
        }

        .footerGrid a {
            text-decoration: none;
            color: white;
        }

    </style>
</head>
<body>
    <div class="wrapper">
        <div class="topnav">
            <a class="active" href="home.html">Evai</a>
            <form action="">
                <input type="text" placeholder="Buscar..." name="" id="">
                <button><i class="fa fa-search" style="color: white;"></i></button>
            </form>
            <a href="login.html">Login</a>
            <a href="registrarse.html">Registrarse</a>
        </div>
    </div>
    <div class="faq">
        <h2>Preguntas Frecuentes</h2>
    
        <div class="faq-item">
            <button class="faq-boton">¿Cómo realizo una compra?</button>
            <div class="faq-respuesta">
                <p>Para realizar una compra, solo debes seleccionar el producto que te interesa, agregarlo al carrito y proceder al pago con los métodos disponibles.</p>
            </div>
        </div>
    
        <div class="faq-item">
            <button class="faq-boton">¿Cuáles son los métodos de pago?</button>
            <div class="faq-respuesta">
                <p>Aceptamos tarjetas de crédito, débito, PayPal y transferencias bancarias.</p>
            </div>
        </div>
    
        <div class="faq-item">
            <button class="faq-boton">¿Puedo cambiar mi pedido después de realizarlo?</button>
            <div class="faq-respuesta">
                <p>Si deseas cambiar tu pedido, contáctanos dentro de las 24 horas después de realizar la compra.</p>
            </div>
        </div>
    </div>
    
    <footer>
        <div class="footerGrid">
            <div>
                <ul>
                    <li><a href="aboutus.html">Sobre nosotros</a></li>
                    <li><a href="registrarse.html">Registrarse</a></li>
                    <li><a href="login.html">Iniciar sesion</a></li>
                </ul>
            </div>
            <div>
                <form action="">
                    <label for="" style="color: white;">Suscribete a nuestro newsletter</label>
                    <br>
                    <input type="text" name="" id="">
                </form>
            </div>
        </div>
    </footer>
    <script>
        const faqButtons = document.querySelectorAll('.faq-boton');

        // Agregamos el evento de clic a cada botón
        faqButtons.forEach(button => {
            button.addEventListener('click', () => {
                const answer = button.nextElementSibling;

                if (answer.style.display === "block") {
                    answer.style.display = "none";
                } else {
                    answer.style.display = "block";
                }
            });
        });

    </script>
</body>
</html>
