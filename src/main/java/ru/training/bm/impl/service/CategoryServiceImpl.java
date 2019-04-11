package ru.training.bm.impl.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.training.bm.api.service.CategoryService;
import ru.training.bm.domain.Category;
import ru.training.bm.exception.ServiceException;
import ru.training.bm.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) throws ServiceException {

        return null;
    }

    @Override
    public Category update(Category category) throws ServiceException {

        return null;
    }

    @Override
    public void delete(Category entity) throws ServiceException {

    }

    @Override
    public void delete(List<Long> entityIdList) throws ServiceException {

    }

    @Override
    @Transactional
    public Category get(Long id) throws ServiceException {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ServiceException("Category with id=" + id + " not found"));
    }

    @Override
    public Page<Category> get(Integer page, Integer size) throws ServiceException {
        return null;
    }

    @Override
    public void delete(Long categoryId) throws ServiceException {

    }

}
