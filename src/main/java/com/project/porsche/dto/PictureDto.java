package com.project.porsche.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PictureDto implements Dto {
    private String filePath;
}