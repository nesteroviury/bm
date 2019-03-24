package ru.training.bm.api.service;

import ru.training.bm.exception.ServiceException;

import java.util.List;

public interface BaseService<T> {

    void add(T t) throws ServiceException;

    void update(T t) throws ServiceException;

    void delete(Long id) throws ServiceException;

    List<T> list() throws ServiceException;

    T findById(Long id) throws ServiceException;

    void deleteAll(Long categoryId) throws ServiceException;

}
