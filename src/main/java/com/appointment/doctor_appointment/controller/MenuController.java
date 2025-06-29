package com.appointment.doctor_appointment.controller;


import com.appointment.doctor_appointment.admin.Menu;
import com.appointment.doctor_appointment.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/menus")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {
    private MenuService menuService;
    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/user")
    public ResponseEntity<Set<Menu>> getAllMenus(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(menuService.getMenuForUser(username));

    }

    @GetMapping
    public List<Menu> getMenus() {

        return menuService.getAllMenusWithSubmenus();
    }

}
