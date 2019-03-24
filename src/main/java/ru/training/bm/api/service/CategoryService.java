package ru.training.bm.api.service;

import ru.training.bm.domain.Category;
import ru.training.bm.exception.ServiceException;

import java.util.List;

public class CategoryService implements BaseService<Category> {

    @Override
    public void add(Category category) throws ServiceException {

    }

    @Override
    public void update(Category category) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public List<Category> list() throws ServiceException {
        return null;
    }

    @Override
    public Category findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public void deleteAll(Long categoryId) throws ServiceException {

    }

}
