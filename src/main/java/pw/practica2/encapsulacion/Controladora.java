package pw.practica2.encapsulacion;

import java.util.ArrayList;

public class Controladora {
    private static Controladora controladora = null;
    private ArrayList<Estudiante> estudiantes;

    private Controladora(){
        estudiantes = new ArrayList<>();
    }

    public static Controladora getInstance() {
        if (controladora == null) {
            controladora = new Controladora();
        }
        return controladora;
    }

    public void addEstudiante(Estudiante est){
        estudiantes.add(est);
    }

    public boolean editEstudiante(int id, int matricula, String nombre, String apellido, String telefono){
        boolean edited = false;
        Estudiante old = buscarEstudiante(id);
        if (old != null) {
            if (id != matricula) {
                if (buscarEstudiante(matricula) == null) {
                    old.setMatricula(matricula);
                    old.setNombre(nombre);
                    old.setApellido(apellido);
                    old.setTelefono(telefono);
                    edited = true;
                }
            } else {
                old.setNombre(nombre);
                old.setApellido(apellido);
                old.setTelefono(telefono);
                edited = true;
            }
        }
        return edited;
    }

    public void delEstudiante(int matricula){
        Estudiante aux = buscarEstudiante(matricula);
        if (aux != null) {
            estudiantes.remove(aux);
        }
    }

    public ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }

    public Estudiante buscarEstudiante(int matricula){
        Estudiante est = null;
        for (Estudiante aux : estudiantes) {
            if (aux.getMatricula() == matricula){
                est = aux;
            }
        }
        return est;
    }

}
