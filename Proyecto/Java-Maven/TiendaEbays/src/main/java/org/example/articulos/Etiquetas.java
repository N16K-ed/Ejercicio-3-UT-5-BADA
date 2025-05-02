package org.example.articulos;

public enum Etiquetas {


    ELECTRONICA("Electrónica"),
    JARDIN("Jardín"),
    MODA("Moda"),
    MOTOR("Motor"),
    DEPORTES("Deportes"),
    JUGUETESYOCIO("Juguetes y ocio"),
    EQUIPAMIENTOINDUSTRIAL("Equipamiento industrial"),
    OFERTAS("Ofertas"),
    ;

    private String nombre;

    Etiquetas(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Object getNombreEtiqueta(){
        return nombre;
    }

    public static Etiquetas desdeNombre(String nombreEtiqueta) {
        for (Etiquetas e : Etiquetas.values()) {
            if (e.getNombre().equalsIgnoreCase(nombreEtiqueta)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Etiqueta no reconocida: " + nombreEtiqueta);
    }

}