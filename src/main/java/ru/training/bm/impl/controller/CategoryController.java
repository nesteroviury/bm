package ru.training.bm.impl.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @JsonView(View.UI.class)
    @Override
    @GetMapping(ControllerUrls.CATEGORY_GET)
    public Category get(@PathVariable Long id) {
        Logger logger = LogManager.getLogger("JDBC_Logger");
        logger.error("error");
        logger.info("info");
        logger.debug("debug");
        logger.trace("debug");
        logger.warn("warn");
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
        if(wrapper.getTruncate()){
            bookmarkService.truncate();
            categoryService.truncate();
        }else{
            categoryService.delete(wrapper.getIds());
        }
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

    //todo:delete after test
    @GetMapping("/logs")
    public ResponseEntity<List<LogDetails>> getlogDetails() {
        return new ResponseEntity<>(logRepository.findAll(), HttpStatus.OK);
    }

}
