package com.appointment.doctor_appointment.service;

import com.appointment.doctor_appointment.admin.Menu;

import java.util.List;
import java.util.Set;

public interface MenuService {
    Set<Menu> getMenuForUser(String username);
    List<Menu> getAllMenusWithSubmenus();
    List<Menu> getMEnuFindByParentId(Long parentId);

}
