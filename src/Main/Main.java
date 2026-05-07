package Main;

import ClassGym.GymClass;
import Payment.Pay;
import Payment.PaymentMethod;
import Reports.MensualReport;
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
        ArrayList<Pay> pagos = new ArrayList<>();

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

        Pay pago1 = new Pay(
                pablo,
                15000,
                PaymentMethod.TARJETA
        );

        usuarios.add(pablo);
        clases.add(yoga);
        reservas.add(reserva1);
        pagos.add(pago1);

        System.out.println("Usuario: " + pablo.getName());
        System.out.println("Clase: " + yoga.getName());
        System.out.println("Cupos disponibles: "
                + yoga.getCuposDisponibles());


        MensualReport reporte =
                new MensualReport(
                        usuarios,
                        reservas,
                        pagos
                );

        reporte.mostrarReporte();
    }

}