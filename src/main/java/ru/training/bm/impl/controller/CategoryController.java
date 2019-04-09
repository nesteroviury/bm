package ru.training.bm.impl.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.domain.Category;

@RestController
@RequestMapping(ControllerUrls.CATEGORIES_ROOT)
public class CategoryController implements BaseController<Category> {

    @Override
    @GetMapping(ControllerUrls.RETRIEVE)
    public Category retrieve(Long id) {
        return null;
    }

    @Override
    @DeleteMapping(ControllerUrls.DELETE)
    public void delete(Long id) {

    }

    @Override
    @DeleteMapping(ControllerUrls.DELETE_ALL)
    public void deleteAll() {

    }

    @Override
    @PostMapping(ControllerUrls.CREATE)
    public Category create(Category val) {
        return null;
    }

    @Override
    @PutMapping(ControllerUrls.UPDATE)
    public Category update(Category val) {
        return null;
    }

    @Override
    public Page<Category> retrieveAll(Integer page, Integer size) {
        return null;
    }

}
