package User;


import java.time.LocalDate;

public class Usuario {
    private final int id;
    private String name;
    private String email;
    private String password;
    private LocalDate date;
    private LocalDate dateOff;
    private static Boolean estado;
    private Plan planActual;
    private static int lastID = 0;

    //Constructor

    public Usuario(String name, String email, String planActual, String date, String dateOff) {
        setName(name);
        setEmail(email);
        setPlanActual(planActual);
        this.id = ++lastID;
        setPassword(password);
        this.date = LocalDate.now();
        calcularVencimiento();
    }

    public Usuario(String name, String email, String date, String dateOff) {
        setName(name);
        setEmail(email);
        this.planActual = "Basic";
        setPassword(password);
    }

    //Getters


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static Boolean getEstado() {
        return estado;
    }

    public String getDateOff() {
        return dateOff;
    }

    //Setters


    public void setName(String name) {
        if(name != null && name.trim().isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Error, debe colocar un nombre válido");

        }
    }

    public void setEmail(String email) {
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setPassword(String password) {
        if (!password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$")) {
            throw new IllegalArgumentException("Contraseña inválida");
        }
        this.password = password;
    }

    public void setPlanActual(String planActual) {
        if ("Basic".equals(planActual) || "Premium".equals(planActual)) {
            this.planActual = planActual;
            calcularVencimiento();
        } else {
            throw new IllegalArgumentException("Error, seleccione el plan correcto.");
        }
    }

    //Logica

    private void calcularVencimiento() {
        this.dateOff = LocalDate.now().plusDays(planActual.getDuracionDias());
    }


}
