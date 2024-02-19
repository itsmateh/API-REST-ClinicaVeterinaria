package com.mtcmp.ClinicaVeterinaria.service;


import com.mtcmp.ClinicaVeterinaria.model.Dueño;

import java.util.List;

public interface IDueñoService {

    public List<Dueño> getDueño();

    public Dueño findDueño(Long id);

    public void saveDueño(Dueño due);

    public void deletDueño(Long id);

    public void editDueño(Dueño due);



}
