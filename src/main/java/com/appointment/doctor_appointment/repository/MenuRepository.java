package com.appointment.doctor_appointment.repository;

import com.appointment.doctor_appointment.admin.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    // Fetch all top-level menus (no parent)
    List<Menu> findByParentIsNull();

    // Fetch all submenus of a specific parent
    List<Menu> findByParentId(Long parentId);
}
