package Main;

import ClassGym.GymClass;
import Reserve.Reserva;
import User.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<GymClass> clases = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();

        GymClass yoga = new GymClass(
                "Yoga",
                "Ana",
                LocalTime.of(18, 0),
                20,
                20
        );

        Usuario pablo = new Usuario(
                "Pablo",
                "pablo@gmail.com",
                "Password1!"
        );

        Reserva reserva1 = new Reserva(
                pablo,
                yoga,
                LocalDate.now()
        );

        usuarios.add(pablo);
        clases.add(yoga);
        reservas.add(reserva1);

        System.out.println("Usuario: " + pablo.getName());
        System.out.println("Clase: " + yoga.getName());
        System.out.println("Cupos disponibles: "
                + yoga.getCuposDisponibles());


    }
}