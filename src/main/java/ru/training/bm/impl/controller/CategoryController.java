package ru.training.bm.impl.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.json.View;
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

    @JsonView(View.UI.class)
    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET)
    public Category get(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @JsonView(View.UI.class)
    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE_SELECTED)
    public void delete(@RequestBody IdWrapper wrapper) {

    }

    @JsonView(View.UI.class)
    @Override
    @PostMapping(ControllerUrls.CATEGORY_CREATE)
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @JsonView(View.UI.class)
    @Override
    @PutMapping(ControllerUrls.CATEGORY_UPDATE)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @JsonView(View.UI.class)
    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET_ALL)
    public Page<Category> get(@PathVariable Integer page, @PathVariable Integer size) {
        return categoryService.get(page, size);
    }

}
