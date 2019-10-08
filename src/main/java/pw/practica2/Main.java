package pw.practica2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pw.practica2.encapsulacion.Estudiante;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        //Recursos publicos
        staticFiles.location("/publico");

        get("/", (request, response) -> {
            Session sesion = request.session(true);
            Map<String, Object> values = new HashMap<>();
            ArrayList<Estudiante> estudiantes = sesion.attribute("estudiantes");
            if (estudiantes == null) {
                estudiantes = new ArrayList<>();

                //Aux Values
                Estudiante x = new Estudiante(20161229, "Osvaldo", "Fernandez", "809-570-2418");
                Estudiante y = new Estudiante(20161143, "Edgar", "Garcia", "809-570-2418");
                estudiantes.add(x);
                estudiantes.add(y);
            }
            sesion.attribute("estudiantes", estudiantes);
            values.put("estudiantes", estudiantes);
            return renderFreemarker(values, "/Estudiantes.ftl");
        });

        get("/formEst", (request, response) -> {
            return renderFreemarker(null, "/FormEst.ftl");
        });

        post("/agregarEst", (request, response) -> {
            Session sesion = request.session();
            String matricula = request.queryParams("matricula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            if (matricula != null && nombre != null && apellido != null) {
                Estudiante aux = new Estudiante(Integer.parseInt(matricula), nombre, apellido, telefono);
                ArrayList<Estudiante> estudiantes = sesion.attribute("estudiantes");
                if (buscarEstudiante(estudiantes, Integer.parseInt(matricula)) == null) {
                    estudiantes.add(aux);
                }
                sesion.attribute("estudiantes", estudiantes);
                response.redirect("/formEst");
            }
            return "";
        });

        get("/formEst/:matricula", (request, response) -> {
            Session session = request.session();
            Map<String, Object> values = new HashMap<>();
            Estudiante aux = buscarEstudiante(session.attribute("estudiantes"), Integer.parseInt(request.params("matricula")));
            values.put("estudiante", aux);
            return renderFreemarker(values, "/FormEst.ftl");
        });

        get("/showEstudiante/:matricula", (request, response) -> {
            Session session = request.session();
            Map<String, Object> values = new HashMap<>();
            Estudiante aux = buscarEstudiante(session.attribute("estudiantes"), Integer.parseInt(request.params("matricula")));
            values.put("estudiante", aux);
            return renderFreemarker(values, "/VerEstudiante.ftl");
        });

        post("/editarEst/:matricula", (request, response) -> {
            Session sesion = request.session();
            String id = request.params("matricula");
            String matricula = request.queryParams("matricula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            if (matricula != null && nombre != null && apellido != null) {
                ArrayList<Estudiante> estudiantes = sesion.attribute("estudiantes");
                Estudiante old = buscarEstudiante(estudiantes, Integer.parseInt(id));
                if (old != null) {
                    old.setMatricula(Integer.parseInt(matricula));
                    old.setNombre(nombre);
                    old.setApellido(apellido);
                    old.setTelefono(telefono);
                }
                sesion.attribute("estudiantes", estudiantes);
                response.redirect("/");
            }
            return "";
        });

        get("/eliminarEst/:matricula", (request, response) -> {
            Session sesion = request.session();
            String id = request.params("matricula");
            ArrayList<Estudiante> estudiantes = sesion.attribute("estudiantes");
            estudiantes.remove(buscarEstudiante(estudiantes, Integer.parseInt(id)));
            sesion.attribute("estudiantes", estudiantes);
            response.redirect("/");
            return "";
        });
    }

    public static String renderFreemarker(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

    public static Estudiante buscarEstudiante(ArrayList<Estudiante> estudiantes, Integer matricula){
        Estudiante est = null;
        for (Estudiante aux : estudiantes) {
            if (aux.getMatricula() == matricula){
                est = aux;
            }
        }
        return est;
    }
}
