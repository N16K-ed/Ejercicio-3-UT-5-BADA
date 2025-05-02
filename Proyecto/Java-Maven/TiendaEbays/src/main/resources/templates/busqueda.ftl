<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

        * {
            font-family: "Open Sans", sans-serif;
        }

        html, body {
            margin: 0px;
        }

        .resultados {
            padding: 30px;
        }

        .resultadoGrid {
            margin-top: 40px;
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            grid-row-gap: 4vh;
        }

        .resultadoGrid  div {
            padding: 20px;
            padding-top: 30px;
            padding-bottom: 40px;
            text-align: center;
            outline: 1px solid rgb(154, 154, 154);
            border-radius: 10px;
            align-items: center;
            width: 60%;
            margin: auto;
            background-color: rgba(221, 221, 221, 0.5);
            box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
        }

        .resultadoGrid  div  img {
            border-radius: 10px;
        }

        .resultadoGrid  div  p{
            text-align: center;
            margin: auto;
        }

        .topnav {
            overflow: hidden;
            background-color: #414141;
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


    </style>
</head>
<body>
    <div class="topnav">
        <a class="active" href="/">Evai</a>
        <form action="">
            <input type="text" placeholder="Buscar..." name="" id="">
            <button><i class="fa fa-search" style="color: white;"></i></button>
        </form>
        <a href="/login">Login</a>
        <a href="/registrarse">Registrarse</a>
    </div>

    <div class="resultados">
        <h1>Resultados de tu busqueda</h1>
        <div class="resultadoGrid">
            <#list articulos as articulo>
                <#if articulo??>
                    <div>
                        <a href="/product?id=${articulo.idArticulo}">
                            <img src="../imajes/objetoimagen.png" height="150px" alt="">
                        </a>
                        <h3>${articulo.nombre}</h3>
                        <p>${articulo.descripcion}</p>
                    </div>
                <#else>
                        <p>No se encontró el artículo.</p>
                    </#if>
                </#list>
        </div>
    </div>

</body>
</html>
