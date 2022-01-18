package com.project.porsche.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoleDto implements Dto {
    private String name;
}