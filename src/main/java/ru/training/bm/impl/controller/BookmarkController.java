package ru.training.bm.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.service.BookmarkService;
import ru.training.bm.domain.Bookmark;
import ru.training.bm.dto.IdWrapper;

@RestController
@RequestMapping(ControllerUrls.ROOT)
public class BookmarkController implements BaseController<Bookmark> {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @Override
    @GetMapping(ControllerUrls.BOOKMARK_GET)
    public Bookmark get(@PathVariable Long id) {
        return bookmarkService.get(id);
    }

    @Override
    @GetMapping(ControllerUrls.BOOKMARK_GET_ALL)
    public Page<Bookmark> get(Integer page, Integer size) {
        return bookmarkService.get(page, size);
    }

    @Override
    @DeleteMapping(ControllerUrls.BOOKMARK_DELETE_ALL)
    public void delete(Long categoryId) {
        bookmarkService.delete(categoryId);
    }

    @Override
    @DeleteMapping(ControllerUrls.BOOKMARK_DELETE_SELECTED)
    public void delete(IdWrapper wrapper) {
        if(wrapper.getTruncate()){
            bookmarkService.truncate();
        }else{
            bookmarkService.delete(wrapper.getIds());
        }
    }

    @Override
    @PostMapping(ControllerUrls.BOOKMARK_CREATE)
    public Bookmark create(Bookmark bookmark) {
        return bookmarkService.create(bookmark);
    }

    @Override
    @PutMapping(ControllerUrls.BOOKMARK_UPDATE)
    public Bookmark update(Bookmark bookmark) {
        return bookmarkService.update(bookmark);
    }

}