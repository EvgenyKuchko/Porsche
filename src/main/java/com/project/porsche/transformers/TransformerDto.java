package com.project.porsche.transformers;

import com.project.porsche.dto.Dto;
import com.project.porsche.entity.EntityObj;

public interface TransformerDto<E extends EntityObj, D extends Dto> {
    D transform(E e);
}