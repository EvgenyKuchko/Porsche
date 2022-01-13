package com.project.porsche.transformers;

import com.project.porsche.dto.PictureDto;
import com.project.porsche.entity.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureTransformer implements Transformer<Picture, PictureDto> {
    @Override
    public PictureDto transform(Picture picture) {
        PictureDto pictureDto = new PictureDto();
        pictureDto.setFilePath(picture.getFilePath());
        return pictureDto;
    }

    @Override
    public Picture transform(PictureDto pictureDto) {
        Picture picture = new Picture();
        picture.setFilePath(pictureDto.getFilePath());
        return picture;
    }
}