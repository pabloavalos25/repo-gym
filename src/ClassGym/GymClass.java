package ClassGym;

import java.time.LocalTime;

public class GymClass {

    private static final LocalTime APERTURA = LocalTime.of(7,0);
    private static final LocalTime CIERRE = LocalTime.of(23,0);

    private Long id;
    private  String name;
    private  String profesor;
    private LocalTime horario;
    private int cupoMaximo;
    private int cuposDisponibles;


    //SETTER HORARIO

    public void setHorario(LocalTime horario) {
        if(horario == null){
            throw new IllegalArgumentException("Error, el horario no debe estar vacio.");
        }

        if (horario.isBefore(APERTURA) || horario.isAfter(CIERRE)) {
            throw new IllegalArgumentException("Gimnasio cerrado. Horario permitido: " + APERTURA + " a " + CIERRE);
        }
        this.horario = horario;
    }

    //Constructor

    public GymClass(String name, String profesor, LocalTime horario, int cupoMaximo,  int cuposDisponibles) {
        setName(name);
        setProfesor(profesor);
        setHorario(horario);
        setCupoMaximo(cupoMaximo);
        setCuposDisponibles(cuposDisponibles);
    }

    //Getters

    public String getName() { return name; }
    public String getProfesor() { return profesor; }
    public LocalTime getHorario() { return horario; }
    public int getCupoMaximo() { return cupoMaximo; }
    public int getCuposDisponibles() { return cuposDisponibles; }

    //Setters

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Error, debe colocar un nombre válido");
        }
    }

    public void setProfesor(String profesor) {
        if(profesor != null && !profesor.trim().isEmpty()){
            this.profesor = profesor;
        } else {
            throw new IllegalArgumentException("Error, debe seleccionar un profesor válido");
        }
    }

    public void setCupoMaximo(int cupoMaximo) {
        if (cupoMaximo <= 0 || cupoMaximo < cuposDisponibles)
            throw new IllegalArgumentException("Error, no hay cupos disponibles.");
        else {
            this.cupoMaximo = cupoMaximo;
        }

    }

    public void setCuposDisponibles(int cuposDisponibles) {
        if (this.cuposDisponibles < 0) {
            System.out.println("No hay cupos disponibles.");
            this.cuposDisponibles = 0;
        }else {
            this.cuposDisponibles = cuposDisponibles;
        }
    }

    //Metodos

    public void ocuparCupo() {
        if (cuposDisponibles <= 0) {
            throw new IllegalStateException("No hay cupos disponibles");
        }

        cuposDisponibles--;
    }

    public void liberarCupo() {
        if (cuposDisponibles < cupoMaximo) {
            cuposDisponibles++;
        }
    }

    @Override
    public String toString() {
        return "GymClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profesor='" + profesor + '\'' +
                ", horario=" + horario +
                ", cupoMaximo=" + cupoMaximo +
                ", cuposDisponibles=" + cuposDisponibles +
                '}';
    }
}
