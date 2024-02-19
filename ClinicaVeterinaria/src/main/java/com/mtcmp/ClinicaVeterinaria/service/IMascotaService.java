package com.mtcmp.ClinicaVeterinaria.service;

import com.mtcmp.ClinicaVeterinaria.dto.DueñoMascotaDTO;
import com.mtcmp.ClinicaVeterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    public List<Mascota> getMascotas();

    public Mascota findMascota(Long id);

    public void deleteMascota(Long id);

    public void editMascota(Mascota mas);

    public void saveMascota(Mascota mas);



    public List<Mascota> findCaniche();

    public List<Mascota> findEspecie(String especie);

    public List<Mascota> findRaza(String raza);


    public List<DueñoMascotaDTO> getDatosMascDue();


}
