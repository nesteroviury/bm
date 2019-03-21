package ru.training.bm.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface BaseController<T> {

    T retrieve(@PathVariable Long id);

    List<T> retrieveAll();

    void delete(@PathVariable Long id);

    void deleteAll();

    T create(@RequestBody T val);

    T update(@RequestBody T val);

}
