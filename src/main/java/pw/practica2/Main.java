package pw.practica2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pw.practica2.encapsulacion.Controladora;
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

        //Coleccion Estatica
        Controladora control = Controladora.getInstance();

        get("/", (request, response) -> {
            Map<String, Object> values = new HashMap<>();
            values.put("estudiantes", control.getEstudiantes());
            return renderFreemarker(values, "/Estudiantes.ftl");
        });

        get("/formEst", (request, response) -> {
            return renderFreemarker(null, "/FormEst.ftl");
        });

        post("/agregarEst", (request, response) -> {
            Map<String, Object> logs = new HashMap<>();
            String log = "";
            String matricula = request.queryParams("matricula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            if (matricula != null && isNumeric(matricula) && nombre != null && !nombre.equalsIgnoreCase("") && apellido != null && !apellido.equalsIgnoreCase("")) {
                Estudiante aux = new Estudiante(Integer.parseInt(matricula), nombre, apellido, telefono);
                if (control.buscarEstudiante(Integer.parseInt(matricula)) == null) {
                    control.addEstudiante(aux);
                    log = "Estudiante agregado con exito!";
                    logs.put("exito", log);
                } else {
                    log = "Este estudiante ya existe!";
                    logs.put("existe", log);
                }
            } else {
                log = "Revise los campos";
                logs.put("error", log);
            }
            return renderFreemarker(logs, "/FormEst.ftl");
        });

        get("/formEst/:matricula", (request, response) -> {
            Map<String, Object> values = new HashMap<>();
            Estudiante aux = control.buscarEstudiante(Integer.parseInt(request.params("matricula")));
            values.put("estudiante", aux);
            return renderFreemarker(values, "/FormEst.ftl");
        });

        get("/showEstudiante/:matricula", (request, response) -> {
            Map<String, Object> values = new HashMap<>();
            Estudiante aux = control.buscarEstudiante(Integer.parseInt(request.params("matricula")));
            values.put("estudiante", aux);
            return renderFreemarker(values, "/VerEstudiante.ftl");
        });

        post("/editarEst/:matricula", (request, response) -> {
            Map<String, Object> logs = new HashMap<>();
            String log = "";
            String id = request.params("matricula");
            String matricula = request.queryParams("matricula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            if (matricula != null && isNumeric(matricula) && nombre != null && !nombre.equalsIgnoreCase("") && apellido != null && !apellido.equalsIgnoreCase("")) {
                if(control.editEstudiante(Integer.parseInt(id), Integer.parseInt(matricula), nombre, apellido, telefono)) {
                    response.redirect("/");
                } else {
                    log = "Error: matricula del estudiante debe ser unica!";
                    logs.put("errorEdit", log);
                }
            } else {
                log = "Revise los campos";
                logs.put("error", log);
            }
            Estudiante aux = new Estudiante(Integer.parseInt(id), nombre, apellido, telefono);
            logs.put("estudiante", aux);
            return renderFreemarker(logs, "/FormEst.ftl");
        });

        get("/eliminarEst/:matricula", (request, response) -> {
            String id = request.params("matricula");
            control.delEstudiante(Integer.parseInt(id));
            response.redirect("/");
            return "";
        });
    }

    public static String renderFreemarker(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

    public static boolean isNumeric(String number){
        boolean result = false;
        try {
            Integer.parseInt(number);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }
}
