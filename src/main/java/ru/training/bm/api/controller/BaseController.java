package ru.training.bm.api.controller;

import org.springframework.data.domain.Page;
import ru.training.bm.dto.IdWrapper;

public interface BaseController<T> {

    T get(Long id);

    void delete(Long id);

    void delete(IdWrapper wrapper);

    T create(T entity);

    T update(T entity);

    Page<T> get(Integer page, Integer size);

}
