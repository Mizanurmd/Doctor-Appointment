package com.appointment.doctor_appointment.repository;

import com.appointment.doctor_appointment.admin.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
