package com.appointment.doctor_appointment.serviceImpl;

import com.appointment.doctor_appointment.admin.Menu;
import com.appointment.doctor_appointment.repository.MenuRepository;
import com.appointment.doctor_appointment.repository.OurUserRepository;
import com.appointment.doctor_appointment.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImp implements MenuService {

    private final OurUserRepository ourUserRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImp(OurUserRepository ourUserRepository, MenuRepository menuRepository) {
        this.ourUserRepository = ourUserRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public Set<Menu> getMenuForUser(String username) {
        return ourUserRepository.findByEmail(username)
                .map(user -> user.getRole().getMenus())
                .orElse(Collections.emptySet());
    }

    @Override
    public List<Menu> getAllMenusWithSubmenus() {
        return menuRepository.findByParentIsNull();
    }

    @Override
    public List<Menu> getMEnuFindByParentId(Long parentId) {
        return menuRepository.findByParentId(parentId);
    }


}
