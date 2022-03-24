package com.project.porsche.transformers;

import com.project.porsche.dto.PictureDto;
import com.project.porsche.entity.Picture;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PictureTransformerTest {

    private static final PictureTransformer pictureTransformer = new PictureTransformer();

    @Test
    public void shouldTransformPictureToPictureDto(){
        Picture picture = new Picture();
        picture.setFilePath("img/p1.jpeg");

        PictureDto pictureDto = pictureTransformer.transform(picture);

        assertThat(picture.getFilePath())
                .isEqualTo(pictureDto.getFilePath());
    }
}