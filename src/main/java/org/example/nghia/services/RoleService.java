package org.example.nghia.services;

import org.example.nghia.entities.Role;
import org.example.nghia.entities.User;
import org.example.nghia.repositories.RoleRepository;
import org.example.nghia.requesEntities.RequesUpdateUser;
import org.example.nghia.requesEntities.RequesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    public Role getRoleById(String id){
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role with id " + id + " not found")
        );
    }

    public Role createRole(Role role){
        try {
            Role newRole = new Role();
            newRole.setRollname(role.getRollname());
            roleRepository.save(newRole);
            return newRole;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void updateRole(Role role, String id){
        try {
            Role updateRole = getRoleById(id);
            updateRole.setRollname(role.getRollname());
            roleRepository.save(updateRole);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
