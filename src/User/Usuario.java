package User;


import java.time.LocalDate;

public class Usuario {
    private final int id;
    private String name;
    private String email;
    private String password;
    private LocalDate date;
    private LocalDate dateOff;
    private Boolean estado;
    private Plan planActual;
    private static int lastID = 0;

    // Constructor principal
    public Usuario(String name, String email, String password, Plan planActual) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setPlanActual(planActual);
        this.id = ++lastID;
        this.date = LocalDate.now();
        calcularVencimiento();
    }

    // Constructor con plan básico por defecto
    public Usuario(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setPlanActual(Plan.BASIC);
        this.id = ++lastID;
        this.date = LocalDate.now();
        calcularVencimiento();
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Boolean getEstado() { return estado; }
    public LocalDate getDateOff() { return dateOff; }
    public Plan getPlanActual() { return planActual; }

    //Setters


    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
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

    public void setPlanActual(Plan planActual) {
        this.planActual = planActual;
        calcularVencimiento();
    }


    //Logica

    private void calcularVencimiento() {
        this.dateOff = LocalDate.now().plusDays(planActual.getDuracionDias());
    }
}
