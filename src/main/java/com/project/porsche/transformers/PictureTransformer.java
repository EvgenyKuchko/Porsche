package com.project.porsche.transformers;

import com.project.porsche.dto.PictureDto;
import com.project.porsche.entity.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureTransformer implements TransformerDto<Picture, PictureDto> {
    @Override
    public PictureDto transform(Picture picture) {
        return PictureDto.builder()
                .filePath(picture.getFilePath())
                .build();
    }
}