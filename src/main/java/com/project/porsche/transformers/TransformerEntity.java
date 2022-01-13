package com.project.porsche.transformers;

import com.project.porsche.dto.Dto;
import com.project.porsche.entity.EntityObj;

public interface TransformerEntity<E extends EntityObj, D extends Dto> {
    E transform(D d);
}