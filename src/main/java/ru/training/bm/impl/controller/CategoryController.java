package ru.training.bm.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.service.CategoryService;
import ru.training.bm.domain.Category;
import ru.training.bm.dto.IdWrapper;

@RestController
@RequestMapping(ControllerUrls.ROOT)
public class CategoryController implements BaseController<Category> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET)
    public Category get(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE)
    public void delete(@RequestBody Category entity) {

    }

    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE_FAKE)
    public void delete(@PathVariable Long id) {

    }

    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE_SELECTED)
    public void delete(@RequestBody IdWrapper wrapper) {

    }

    @Override
    @PostMapping(ControllerUrls.CATEGORY_CREATE)
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @Override
    @PutMapping(ControllerUrls.CATEGORY_UPDATE)
    public Category update(@RequestBody Category category, @PathVariable Long id) {
        return null;
    }

    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET_ALL)
    public Page<Category> get(@PathVariable Integer page, @PathVariable Integer size) {
        return categoryService.get(page, size);
    }

}
