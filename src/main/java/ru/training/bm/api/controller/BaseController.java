package ru.training.bm.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.training.bm.dto.IdWrapper;

public interface BaseController<T> {

    T get(@PathVariable Long id);

    void delete(@RequestBody T entity);

    void delete(@PathVariable Long categoryId);

    void delete(@RequestBody IdWrapper wrapper);

    T create(@RequestBody T entity);

    T update(@PathVariable("id") T entity);

    Page<T> get(@PathVariable Integer page, @PathVariable Integer size);

}
