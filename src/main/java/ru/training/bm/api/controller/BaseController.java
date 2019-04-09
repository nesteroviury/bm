package ru.training.bm.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<T> {

    T retrieve(@PathVariable Long id);

    void delete(@PathVariable Long id);

    void deleteAll();

    T create(@RequestBody T val);

    T update(@RequestBody T val);

    Page<T> retrieveAll(@PathVariable Integer page, @PathVariable Integer size);

}
