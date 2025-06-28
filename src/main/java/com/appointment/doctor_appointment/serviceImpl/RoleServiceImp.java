package com.appointment.doctor_appointment.serviceImpl;

import com.appointment.doctor_appointment.admin.Role;
import com.appointment.doctor_appointment.repository.RoleRepository;
import com.appointment.doctor_appointment.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with ID: " + id));
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role existing = getRoleById(id);
        existing.setRoleName(role.getRoleName());
        existing.setMenus(role.getMenus());
        return roleRepository.save(existing);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
