package ru.training.bm.impl.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.config.logging.aop.Loggable;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.json.View;
import ru.training.bm.api.service.BookmarkService;
import ru.training.bm.api.service.CategoryService;
import ru.training.bm.domain.Category;
import ru.training.bm.domain.LogDetails;
import ru.training.bm.dto.IdWrapper;
import ru.training.bm.repository.logging.LogRepository;

import java.util.List;

@RestController
@RequestMapping(ControllerUrls.ROOT)
public class CategoryController implements BaseController<Category> {

    private final CategoryService categoryService;
    private final BookmarkService bookmarkService;
    private final LogRepository logRepository;

    @Autowired
    public CategoryController(CategoryService categoryService, BookmarkService bookmarkService, LogRepository logRepository) {
        this.categoryService = categoryService;
        this.bookmarkService = bookmarkService;
        this.logRepository = logRepository;
    }

    @Loggable
    @JsonView(View.UI.class)
    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET)
    public Category get(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @Loggable
    @JsonView(View.UI.class)
    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @Loggable
    @Override
    @DeleteMapping(ControllerUrls.CATEGORY_DELETE_SELECTED)
    public void delete(@RequestBody IdWrapper wrapper) {
        if(wrapper.getTruncate()){
            bookmarkService.truncate();
            categoryService.truncate();
        }else{
            categoryService.delete(wrapper.getIds());
        }
    }

    @Loggable
    @JsonView(View.UI.class)
    @Override
    @PostMapping(ControllerUrls.CATEGORY_CREATE)
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @Loggable
    @JsonView(View.UI.class)
    @Override
    @PutMapping(ControllerUrls.CATEGORY_UPDATE)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @Loggable
    @JsonView(View.UI.class)
    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET_ALL)
    public Page<Category> get(@PathVariable Integer page, @PathVariable Integer size) {
        return categoryService.get(page, size);
    }

    //todo:delete after test
    @GetMapping("/logs")
    public ResponseEntity<List<LogDetails>> getlogDetails() {
        return new ResponseEntity<>(logRepository.findAll(), HttpStatus.OK);
    }

}
