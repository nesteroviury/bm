package ru.training.bm.api.controller;

import org.springframework.data.domain.Page;
import ru.training.bm.dto.IdWrapper;

public interface BaseController<T> {

    T get(Long id);

    void delete(T entity);

    void delete(Long categoryId);

    void delete(IdWrapper wrapper);

    T create(T entity);

    T update(T entity, Long id);

    Page<T> get(Integer page, Integer size);

}
