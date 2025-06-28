package com.appointment.doctor_appointment.admin;

import com.appointment.doctor_appointment.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/user")
    public ResponseEntity<Set<Menu>> getAllMenus(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(menuService.getMenuForUser(username));

    }

}
