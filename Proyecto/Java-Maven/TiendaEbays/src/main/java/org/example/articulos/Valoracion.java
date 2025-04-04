package org.example.articulos;

public class Valoracion {
    private int puntuacion;
    private String comentario;

    public Valoracion(int puntuacion, String comentario) {
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
