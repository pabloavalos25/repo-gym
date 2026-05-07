package User;


import java.time.LocalDate;
import Utils.PasswordUtil;

public class Usuario {
    private final int id;
    private String name;
    private String email;
    private String password;
    private LocalDate date;
    private LocalDate dateOff;
    private boolean estado;
    private Plan planActual;
    private static int lastID = 0;

    // Constructor principal
    public Usuario(String name, String email, String password, Plan planActual) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setPlanActual(planActual);

        this.estado = true;
        this.id = ++lastID;
        this.date = LocalDate.now();
    }

    // Constructor con plan básico por defecto
    public Usuario(String name, String email, String password) {
        this(name, email, password, Plan.BASIC);
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getId() { return id; }
    public boolean getEstado() { return estado; }
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
        }else {
            this.password = PasswordUtil.hashPassword(password);
        }
    }

    public void setPlanActual(Plan planActual) {
        if(planActual == null){
            throw new IllegalArgumentException("Plan inválido");
        }

        this.planActual = planActual;
        calcularVencimiento();
    }


    //Logica

    private void calcularVencimiento() {
        this.dateOff = LocalDate.now().plusDays(planActual.getDuracionDias());
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
