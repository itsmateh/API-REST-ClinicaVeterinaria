package com.mtcmp.ClinicaVeterinaria.controller;

import com.mtcmp.ClinicaVeterinaria.model.Dueño;
import com.mtcmp.ClinicaVeterinaria.service.IDueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DueñoController {

    @Autowired
    IDueñoService dueServ;

    @GetMapping("/dueño/traer")
    public List<Dueño> getDueños(){
        return dueServ.getDueño();
    }

    @PostMapping("/dueño/crear")
    public String saveDueño(@RequestBody Dueño dueño){
        dueServ.saveDueño(dueño);
        String datos = "Nombre: " + dueño.getNombre() +
                        "Apellido: " + dueño.getApellido();
        return "Dueño creado" + "\n" + datos;

    }

    @PutMapping("/dueño/editar")
    public String editDueño(@RequestBody Dueño dueño){
            dueServ.editDueño(dueño);
            dueServ.findDueño(dueño.getId());
            return "Dueño editado: " + dueño.getNombre() + " " + dueño.getApellido();
    }

   @DeleteMapping("/dueño/eliminar")
    public String deleteDueño(@RequestBody Long id){
        dueServ.deletDueño(id);
        return "Dueño eliminado";
   }
}
