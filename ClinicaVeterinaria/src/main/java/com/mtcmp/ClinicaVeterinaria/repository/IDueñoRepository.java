package com.mtcmp.ClinicaVeterinaria.repository;

import com.mtcmp.ClinicaVeterinaria.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDueñoRepository extends JpaRepository<Dueño,Long> {
}
