package com.project.porsche.transformers;

import com.project.porsche.dto.Dto;
import com.project.porsche.entity.EntityObj;

public interface Transformer<E extends EntityObj, D extends Dto> {
    D transform(E e);

    E transform(D d);
}