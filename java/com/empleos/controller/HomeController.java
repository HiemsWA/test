package com.empleos.controller;

import com.empleos.model.Vacante;
import com.empleos.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IVacanteService vacanteService;

    @GetMapping("/")
    public String mostrarHome(Model model) {
//        model.addAttribute("mensaje", "Binvenidos a Empleos");
//        model.addAttribute("fecha", new Date());
//        String nombre = "Auxiliar de Contabilidad";
//        Date fechaPub = new Date();
//        double salario = 9000.0;
//        boolean vigente = true;
//        model.addAttribute("nombre", nombre);
//        model.addAttribute("fechaPub", fechaPub);
//        model.addAttribute("salario", salario);
//        model.addAttribute("vigente", vigente);
        List<Vacante> lista = vacanteService.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "home";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");
        model.addAttribute("empleos", lista);
        return "listado";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de Comunicaciones");
        vacante.setDescripcion("Se solicita Ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = vacanteService.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

//    /**
//     * M??todo que regresa una lista de objetos de tipo Vacante
//     *
//     * @return
//     */
//    private List<Vacante> getVacantes() {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        List<Vacante> lista = new LinkedList<Vacante>();
//        try {
//            // Creamos la oferta de Trabajo 1.
//            Vacante vacante1 = new Vacante();
//            vacante1.setId(1);
//            vacante1.setNombre("Ingeniero Civil"); // Titulo de la vacante
//            vacante1.setDescripcion("Solicitamos Ing. Civil para dise??ar puente peatonal.");
//            vacante1.setFecha(sdf.parse("08-02-2019"));
//            vacante1.setSalario(8500.0);
//            vacante1.setDestacado(1);
//            vacante1.setImagen("empresa1.png");
//
//            // Creamos la oferta de Trabajo 2.
//            Vacante vacante2 = new Vacante();
//            vacante2.setId(2);
//            vacante2.setNombre("Contador Publico");
//            vacante2.setDescripcion("Empresa importante solicita contador con 5 a??os de experiencia titulado.");
//            vacante2.setFecha(sdf.parse("09-02-2019"));
//            vacante2.setSalario(12000.0);
//            vacante2.setDestacado(0);
//            vacante2.setImagen("empresa2.png");
//
//            // Creamos la oferta de Trabajo 3.
//            Vacante vacante3 = new Vacante();
//            vacante3.setId(3);
//            vacante3.setNombre("Ingeniero El??ctrico");
//            vacante3.setDescripcion("Empresa internacional solicita Ingeniero mec??nico para mantenimiento de la instalaci??n el??ctrica.");
//            vacante3.setFecha(sdf.parse("10-02-2019"));
//            vacante3.setSalario(10500.0);
//            vacante3.setDestacado(0);
//            vacante3.setImagen("no-image.png");
//
//            // Creamos la oferta de Trabajo 4.
//            Vacante vacante4 = new Vacante();
//            vacante4.setId(4);
//            vacante4.setNombre("Dise??ador Gr??fico");
//            vacante4.setDescripcion("Solicitamos Dise??ador Gr??fico titulado para dise??ar publicidad de la empresa.");
//            vacante4.setFecha(sdf.parse("11-02-2019"));
//            vacante4.setSalario(7500.0);
//            vacante4.setDestacado(1);
//            vacante4.setImagen("empresa3.png");
//
//            /**
//             * Agregamos los 4 objetos de tipo Vacante a la lista ...
//             */
//            lista.add(vacante1);
//            lista.add(vacante2);
//            lista.add(vacante3);
//            lista.add(vacante4);
//
//        } catch (ParseException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        return lista;
//
//    }
}
