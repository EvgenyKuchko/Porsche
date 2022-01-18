package com.project.porsche.transformers;

import com.project.porsche.dto.RoleDto;
import com.project.porsche.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleTransformer implements Transformer<Role, RoleDto>{
    @Override
    public RoleDto transform(Role role) {
        return RoleDto.builder()
                .name(role.getName())
                .build();
    }

    @Override
    public Role transform(RoleDto roleDto) {
        return Role.builder()
                .name(roleDto.getName())
                .build();
    }
}