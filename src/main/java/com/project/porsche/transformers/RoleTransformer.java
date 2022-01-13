package com.project.porsche.transformers;

import com.project.porsche.dto.RoleDto;
import com.project.porsche.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleTransformer implements Transformer<Role, RoleDto> {
    @Override
    public RoleDto transform(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        return roleDto;
    }

    @Override
    public Role transform(RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        return role;
    }
}