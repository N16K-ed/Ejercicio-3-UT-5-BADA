package org.example.controladores;

import freemarker.template.Configuration;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;
import org.example.Main;
import org.example.articulos.Articulo;
import org.example.articulos.ArticuloDAO;
import org.example.users.Usuario;
import org.example.users.UsuarioDAO;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistasControler {
    public static void initVistas(){
        Configuration freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
        freemarkerConfig.setClassForTemplateLoading(Main.class, "/templates");

        // Inicializar Javalin con FreeMarker
        Javalin app = Javalin.create(config -> {
            // Configurar FreeMarker como motor de plantillas
            config.fileRenderer(new JavalinFreemarker(freemarkerConfig));
        }).start(7070);
        // Ruta para renderizar una plantilla con datos
        app.get("/", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            List<Articulo> articulos = ArticuloDAO.obtenerTodosLosArticulos();


            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("home.ftl", model);
        });

        app.post("/", ctx -> {
            // Obtener los datos del formulario
            String nombre = ctx.formParam("nombre");
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");

            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();
            //model.put("nombre", nombre);
            //model.put("email", email);
            //model.put("password", password);

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("index.ftl", model);
        });
        app.get("/login", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("login.ftl", model);
        });
        app.get("/registrarse", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("registrarse.ftl", model);
        });/*
        app.get("/busqueda", ctx -> {
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("busqueda.ftl", model);
        });*/
        app.get("/aboutus", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("aboutus.ftl", model);
        });
        app.get("/product", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("product.ftl", model);
        });
        app.post("/regis" , ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", ctx.formParam("nombre"));
            model.put("apellido1", ctx.formParam("apellido1"));
            model.put("apellido2", ctx.formParam("apellido2"));
            model.put("usuario", ctx.formParam("nombre_usuario"));
            model.put("email", ctx.formParam("email"));
            model.put("contrasenya", ctx.formParam("contrasenya"));
            Usuario nuevoUser = new Usuario(model.get("nombre").toString(),
                    model.get("apellido1").toString(),
                    model.get("apellido2").toString(),
                    model.get("usuario").toString(),
                    model.get("email").toString(),
                    model.get("contrasenya").toString());
            //model.put("password", ctx.formParam("password"));
            //UsuarioDAO.comprobarInsertarUsuarios(nuevoUser);
            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("fin_reg.ftl", model);
        });
        app.post("/inisesion", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();
            model.put("usuario", ctx.formParam("usuario"));
            model.put("contrasenya", ctx.formParam("contrasenya"));
            if (UsuarioDAO.comprobarUsuarios(model.get("usuario").toString())){
                ctx.render("fin_login.ftl", model);
            }else{
                // Renderizar la plantilla index.ftl y pasar los datos del mapa
                ctx.render("error_credenciales.ftl", model);
            }

        });
        app.get("/perfil_usuario", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("perfil_usuario.ftl", model);
        });
        app.get("/busqueda", ctx -> {
            // Obtener el parámetro 'query' de la URL
            String query = ctx.queryParam("query");

            // Obtener los artículos según el parámetro 'query'
            List<Articulo> articulos;
            if (query == null || query.isEmpty()) {
                articulos = ArticuloDAO.obtenerTodosLosArticulos(); // Obtener todos los artículos
            } else {
                articulos = ArticuloDAO.obtenerArticuloPorNombre(query); // Buscar artículos por nombre
            }

            // Verificar si no hay artículos, para evitar pasar una lista vacía o nula
            if (articulos == null || articulos.isEmpty()) {
                ctx.render("no_resultados.ftl"); // Si no hay artículos, muestra una página de "no resultados"
            } else {
                ctx.render("busqueda.ftl", Map.of("articulos", articulos)); // Pasar los artículos a la plantilla
            }
        });
    }
}
