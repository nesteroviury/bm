package ru.training.bm.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.service.BookmarkService;
import ru.training.bm.domain.Bookmark;

@RestController
@RequestMapping(ControllerUrls.BOOKMARKS_ROOT)
public class BookmarkController implements BaseController<Bookmark> {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @Override
    @GetMapping(ControllerUrls.RETRIEVE)
    public Bookmark retrieve(@PathVariable Long id) {
        return bookmarkService.findById(id);
    }

    @Override
    @GetMapping(ControllerUrls.RETRIEVE_ALL)
    public Page<Bookmark> retrieveAll(Integer page, Integer size) {
        return bookmarkService.findAll(page, size);
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
    public Bookmark create(Bookmark val) {
        return null;
    }

    @Override
    @PutMapping(ControllerUrls.UPDATE)
    public Bookmark update(Bookmark val) {
        return null;
    }

}