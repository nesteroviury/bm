package ru.training.bm.impl.controller;

import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.domain.Bookmark;

import java.util.List;

@RestController
@RequestMapping(ControllerUrls.BOOKMARKS_ROOT)
public class BookmarkController implements BaseController<Bookmark> {

    @Override
    @GetMapping(ControllerUrls.RETRIEVE)
    public Bookmark retrieve(@PathVariable Long id) {
        return null;
    }

    @Override
    @GetMapping(ControllerUrls.RETRIEVE_ALL)
    public List<Bookmark> retrieveAll() {
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
    public Bookmark create(Bookmark val) {
        return null;
    }

    @Override
    @PutMapping(ControllerUrls.UPDATE)
    public Bookmark update(Bookmark val) {
        return null;
    }

}