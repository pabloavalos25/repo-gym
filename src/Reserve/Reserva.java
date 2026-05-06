package Reserve;

import User.Usuario;

import java.time.LocalDate;

public class Reserva {
    private final int id;
    private Usuario usuario;
    private String clase; // por ejemplo "Yoga", "Pilates"
    private LocalDate fecha;
    private State estado;
    private static int lastID = 0;

    public Reserva(Usuario usuario, String clase, LocalDate fecha) {
        this.id = ++lastID;
        setUsuario(usuario);
        setClase(clase);
        setFecha(fecha);
        this.estado = State.RESERVADA; // estado inicial
    }

    // Getters
    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public String getClase() { return clase; }
    public LocalDate getFecha() { return fecha; }
    public State getEstado() { return estado; }

    // Setters
    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Debe asociar un usuario válido");
        }
        this.usuario = usuario;
    }

    public void setClase(String clase) {
        if (clase != null && !clase.trim().isEmpty()) {
            this.clase = clase;
        } else {
            throw new IllegalArgumentException("Clase inválida");
        }
    }

    public void setFecha(LocalDate fecha) {
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser anterior a hoy");
        }
        this.fecha = fecha;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }
}
