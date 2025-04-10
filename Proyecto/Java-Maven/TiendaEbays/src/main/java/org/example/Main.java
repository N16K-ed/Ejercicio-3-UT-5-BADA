package org.example;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Configurar FreeMarker
        Configuration freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
        freemarkerConfig.setClassForTemplateLoading(Main.class, "/templates");

        // Inicializar Javalin con FreeMarker
        Javalin app = Javalin.create(config -> {
            // Configurar FreeMarker como motor de plantillas
            config.fileRenderer(new JavalinFreemarker(freemarkerConfig));

        }).start(7070);
        // Configurar las rutas

        // Ruta para renderizar una plantilla con datos
        app.get("/", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("index.ftl", model);
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
        app.post("/inisesion", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("inisesion.ftl", model);
        });
        app.get("/registrarse", ctx -> {
            // Crear un mapa de datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("registrarse.ftl", model);
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

            // Renderizar la plantilla index.ftl y pasar los datos del mapa
            ctx.render("conf_regis.ftl", model);
        });

    }
}
