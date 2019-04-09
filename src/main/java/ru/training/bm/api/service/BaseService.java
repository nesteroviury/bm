package ru.training.bm.api.service;

import org.springframework.data.domain.Page;
import ru.training.bm.exception.ServiceException;

import java.util.List;

public interface BaseService<T> {

    void add(T t) throws ServiceException;

    void update(T t) throws ServiceException;

    void delete(Long id) throws ServiceException;

    List<T> list() throws ServiceException;

    T findById(Long id) throws ServiceException;

    Page<T> findAll(Integer page, Integer size) throws ServiceException;

    void deleteAll(Long categoryId) throws ServiceException;

}
