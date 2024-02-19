package com.mtcmp.ClinicaVeterinaria.service;

import com.mtcmp.ClinicaVeterinaria.dto.DueñoMascotaDTO;
import com.mtcmp.ClinicaVeterinaria.model.Mascota;
import com.mtcmp.ClinicaVeterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    IMascotaRepository mascRep;


    @Override
    public List<Mascota> getMascotas() {
        return mascRep.findAll();
    }


    @Override
    public Mascota findMascota(Long id) {
        return mascRep.findById(id).orElse(null);
    }


    @Override
    public void deleteMascota(Long id) {
        mascRep.deleteById(id);
    }


    @Override
    public void saveMascota(Mascota mas) {
        mascRep.save(mas);
    }


    @Override
    public void editMascota(Mascota mas) {
        this.saveMascota(mas);
    }


    @Override
    public List<Mascota> findCaniche() {
         List<Mascota> listaMascotas = this.getMascotas();
         List<Mascota> listaCaniches = new ArrayList<Mascota>();

        for(Mascota mas : listaMascotas){

            if(mas.getEspecie().equalsIgnoreCase("perro")
                    && mas.getRaza().equalsIgnoreCase("caniche"))
            {
                listaCaniches.add(mas);
            }
        }
        return listaCaniches;
    }


    @Override
    public List<Mascota> findEspecie(String especie) {
        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaMascotaEspecie = new ArrayList<Mascota>();

        for(Mascota m : listaMascotas){
            if(m.getEspecie().equalsIgnoreCase(especie)){
                listaMascotaEspecie.add(m);
            }
        }
        return listaMascotaEspecie;
    }


    @Override
    public List<Mascota> findRaza(String raza) {
        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaMascotaRaza = new ArrayList<Mascota>();

        for(Mascota m : listaMascotas){
            if(m.getEspecie().equalsIgnoreCase(raza)){
                listaMascotaRaza.add(m);
            }
        }
        return listaMascotaRaza;
    }


    @Override
    public List<DueñoMascotaDTO> getDatosMascDue() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<DueñoMascotaDTO> listaDueñoMascota = new ArrayList<DueñoMascotaDTO>();
        DueñoMascotaDTO dueñoMascota = new DueñoMascotaDTO();

        for(Mascota m : listaMascotas){
            dueñoMascota.setApellido_dueño(m.getDueño().getApellido());
            dueñoMascota.setNombre_dueño(m.getDueño().getNombre());
            dueñoMascota.setNombre_mascota(m.getNombre());
            dueñoMascota.setRaza(m.getRaza());
            dueñoMascota.setEspecie(m.getEspecie());

            listaDueñoMascota.add(dueñoMascota);
            dueñoMascota = new DueñoMascotaDTO();
        }
        return listaDueñoMascota;
    }
}
