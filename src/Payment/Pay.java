package Payment;

import User.Usuario;

import java.time.LocalDate;

public class Pay {

    private final int id;

    private Usuario usuario;
    private double amount;
    private LocalDate date;

    private boolean estado;

    private PaymentMethod method;
    private PaymentStatus status;

    private static int lastID = 0;


    // Constructor
    public Pay(
            Usuario usuario,
            double amount,
            PaymentMethod method
    ) {

        this.id = ++lastID;

        setUsuario(usuario);
        setAmount(amount);

        this.method = method;

        this.date = LocalDate.now();

        this.status = PaymentStatus.PAGADO;

        this.estado = true;
    }


    // GETTERS
    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public boolean isEstado() {
        return estado;
    }


    // SETTERS
    public void setUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException("Usuario inválido");
        }

        this.usuario = usuario;
    }

    public void setAmount(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Monto inválido");
        }

        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", amount=" + amount +
                ", date=" + date +
                ", estado=" + estado +
                ", method=" + method +
                ", status=" + status +
                '}';
    }
}