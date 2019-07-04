package ru.training.bm.impl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.training.bm.api.config.logging.aop.Loggable;
import ru.training.bm.api.service.CategoryService;
import ru.training.bm.domain.Category;
import ru.training.bm.exception.ServiceException;
import ru.training.bm.repository.data.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Loggable
    @Override
    @Transactional
    public Category create(Category category) throws ServiceException {
        Optional<Long> parentIdOptional = Optional.ofNullable(category.getParentId());

        parentIdOptional.ifPresent(id -> {
            Category parent = this.get(id);
            category.setParent(parent);
            category.setTop(parent.getTop());
        });

        return categoryRepository.saveAndFlush(category);
    }

    @Loggable
    @Override
    @Transactional
    public Category update(Category category) throws ServiceException {
        return categoryRepository
                .findById(category.getId())
                .map(persistentCategory -> {
                    Category parent = this.get(category.getParentId());

                    persistentCategory.setParent(parent);
                    persistentCategory.setName(category.getName());
                    persistentCategory.setDescription(category.getDescription());
                    persistentCategory.setTop(parent.getTop());
                    persistentCategory.setParentId(category.getParentId());

                    return categoryRepository.saveAndFlush(persistentCategory);
                })
                .get();
    }

    @Loggable
    @Override
    @Transactional
    public void delete(Category entity) throws ServiceException {

    }

    @Loggable
    @Override
    @Transactional
    public void delete(List<Long> entityIdList) throws ServiceException {
        categoryRepository.deleteAllByIdIn(entityIdList);
    }

    @Loggable
    @Override
    public void truncate() throws ServiceException {
        categoryRepository.deleteAllInBatch();
    }

    @Loggable
    @Override
    @Transactional
    public Category get(Long id) throws ServiceException {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ServiceException("Category with id=" + id + " not found"));

        Optional<Category> parent = Optional.ofNullable(category.getParent());
        Optional<Category> top = Optional.ofNullable(category.getTop());
        List<Long> subCategoryIds = category.getSubCategories()
                .stream()
                .map(subCategory -> subCategory.getId())
                .collect(Collectors.toList());

        category.setParentId(parent.isPresent() ? parent.get().getId() : null);
        category.setTopId(top.isPresent() ? top.get().getId() : null);
        category.setSubCategoryIds(subCategoryIds);

        return category;
    }

    @Loggable
    @Override
    @Transactional
    public Page<Category> get(Integer page, Integer size) throws ServiceException {
        Sort sort = Sort.by("name");
        Pageable pageable = PageRequest.of(page, size, sort);

        return categoryRepository.findAll(pageable);
    }

    @Loggable
    @Override
    @Transactional
    public void delete(Long categoryId) throws ServiceException {
        categoryRepository.deleteById(categoryId);
    }

}
