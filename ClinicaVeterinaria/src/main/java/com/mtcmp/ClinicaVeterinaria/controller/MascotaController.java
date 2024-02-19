package com.mtcmp.ClinicaVeterinaria.controller;

import com.mtcmp.ClinicaVeterinaria.dto.DueñoMascotaDTO;
import com.mtcmp.ClinicaVeterinaria.model.Mascota;
import com.mtcmp.ClinicaVeterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    IMascotaService masServ;


    @GetMapping("/mascota/traer")
    public List<Mascota> getMascotas(){return masServ.getMascotas();}

    @GetMapping("/mascota/traer/{id}")
    public Mascota getMascota(@RequestParam long id){return masServ.findMascota(id);}

    @GetMapping("/mascota/{especie}")
    public List<Mascota> getEspecie(@RequestParam String especie){
        return masServ.findEspecie(especie);
    }

    @GetMapping("/mascota/{raza}")
    public List<Mascota> getRaza(@RequestParam String raza){
        return masServ.findRaza(raza);
    }

    @GetMapping("/mascota/caniche")
    public List<Mascota> getCaniche(){
        return masServ.findCaniche();
    }

    @GetMapping("/mascota/dueño")
    public List<DueñoMascotaDTO> getDueñoMascota(){
        return masServ.getDatosMascDue();
    }


    @PostMapping("/mascota/crear")
    public String saveMascota(@RequestBody Mascota mascota){
        masServ.saveMascota(mascota);
        return "Mascota guardada";
    }


    @PutMapping("/mascota/edit")
    public String editMascota(@RequestParam Mascota mascota){
        masServ.editMascota(mascota);
        return "Mascota editada con exito!";
    }


    @DeleteMapping("/mascota/eliminar")
    public String deleteMascota(@RequestBody Long id){
        masServ.deleteMascota(id);
        return "La mascota con id: " + id + " fue eliminada";
    }





}
