package ru.training.bm.impl.controller;

import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.dto.CategoryDTO;

import java.util.List;

@RestController
@RequestMapping(ControllerUrls.CATEGORIES_ROOT)
public class CategoryController implements BaseController<CategoryDTO> {

    @Override
    @GetMapping(ControllerUrls.RETRIEVE)
    public CategoryDTO retrieve(Long id) {
        return null;
    }

    @Override
    @GetMapping(ControllerUrls.RETRIEVE_ALL)
    public List<CategoryDTO> retrieveAll() {
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
    public CategoryDTO create(CategoryDTO val) {
        return null;
    }

    @Override
    @PutMapping(ControllerUrls.UPDATE)
    public CategoryDTO update(CategoryDTO val) {
        return null;
    }

}
