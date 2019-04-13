package ru.training.bm.impl.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.domain.Category;
import ru.training.bm.dto.IdWrapper;

import java.util.List;

@RestController
@RequestMapping(ControllerUrls.ROOT)
public class CategoryController implements BaseController<Category> {

    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET)
    public Category get(Long id) {
        return null;
    }

    @Override
    public void delete(Category entity) {

    }

    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE)
    public void delete(Long id) {

    }

    @Override
    public void delete(IdWrapper wrapper) {

    }

    @Override
    @PostMapping(ControllerUrls.CATEGORY_CREATE)
    public Category create(Category val) {
        return null;
    }

    @Override
    @PutMapping(ControllerUrls.CATEGORY_UPDATE)
    public Category update(Category category, Long id) {
        return null;
    }

    @Override
    public Page<Category> get(Integer page, Integer size) {
        return null;
    }

}
