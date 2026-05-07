package Reports;

import Payment.Pay;
import Reserve.Reserva;
import User.Usuario;

import java.util.ArrayList;

public class MensualReport {

    private ArrayList <Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private ArrayList<Pay> pagos;

    public MensualReport(
            ArrayList<Usuario> usuarios,
            ArrayList<Reserva> reservas,
            ArrayList<Pay> pagos
    ) {

        this.usuarios = usuarios;
        this.reservas = reservas;
        this.pagos = pagos;
    }

    //TOTAL INGRESOS

    public double calcularIngresosTotales() {

        double total = 0;

        for (Pay p : pagos) {
            total += p.getAmount();
        }

        return total;
    }

    //CANTIDAD USUARIOS

    public int cantidadUsuarios() {
        return usuarios.size();
    }

    //CANTIDAD RESERVAS
    public int cantidadReservas() {
        return reservas.size();
    }
    public void mostrarReporte() {

        System.out.println("===== REPORTE MENSUAL =====");

        System.out.println(
                "Usuarios registrados: "
                        + cantidadUsuarios()
        );

        System.out.println(
                "Reservas realizadas: "
                        + cantidadReservas()
        );

        System.out.println(
                "Ingresos totales: $"
                        + calcularIngresosTotales()
        );
    }

}