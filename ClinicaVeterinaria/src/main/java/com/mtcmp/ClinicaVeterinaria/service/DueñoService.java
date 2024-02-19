package com.mtcmp.ClinicaVeterinaria.service;


import com.mtcmp.ClinicaVeterinaria.model.Dueño;
import com.mtcmp.ClinicaVeterinaria.repository.IDueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DueñoService implements IDueñoService{

    @Autowired
    IDueñoRepository dueRep;

    @Override
    public List<Dueño> getDueño() {
        return dueRep.findAll();
    }

    @Override
    public Dueño findDueño(Long id) {
        return dueRep.findById(id).orElse(null);
    }

    @Override
    public void saveDueño(Dueño due) {
        dueRep.save(due);
    }

    @Override
    public void deletDueño(Long id) {
        dueRep.deleteById(id);
    }

    @Override
    public void editDueño(Dueño due) {
            this.saveDueño(due);
    }
}
