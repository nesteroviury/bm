package ru.training.bm.api.service;

import org.springframework.data.domain.Page;
import ru.training.bm.exception.ServiceException;

import java.util.List;

public interface BaseService<T> {

    T create(T entity) throws ServiceException;

    T update(T entity) throws ServiceException;

    void delete(T entity) throws ServiceException;

    T get(Long id) throws ServiceException;

    Page<T> get(Integer page, Integer size) throws ServiceException;

    void delete(Long categoryId) throws ServiceException;

    void delete(List<Long> entityIdList) throws ServiceException;

    void truncate() throws ServiceException;

}
