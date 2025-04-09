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

        // Ruta principal (Página de inicio)
        app.get("/", ctx -> {
            // Datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();
            model.put("message", "¡Bienvenido a Tienda Ebays!");

            // Renderizar la plantilla 'index.ftl'
            ctx.render("index.ftl", model);
        });

        // Ruta 'Sobre nosotros'
        app.get("/about", ctx -> {
            // Datos a pasar a la plantilla
            Map<String, Object> model = new HashMap<>();
            model.put("about", "Tienda Ebays es una tienda de ejemplo para demostración.");

            // Renderizar la plantilla 'about.ftl'
            ctx.render("about.ftl", model);
        });
    }
}
