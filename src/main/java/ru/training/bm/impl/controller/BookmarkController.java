package ru.training.bm.impl.controller;

import org.springframework.web.bind.annotation.*;
import ru.training.bm.api.controller.BaseController;
import ru.training.bm.api.dto.BookmarkDTO;

import java.util.List;

@RestController
@RequestMapping(ControllerUrls.BOOKMARKS_ROOT)
public class BookmarkController implements BaseController<BookmarkDTO> {

    @Override
    @GetMapping(ControllerUrls.RETRIEVE)
    public BookmarkDTO retrieve(@PathVariable Long id) {
        return null;
    }

    @Override
    @GetMapping(ControllerUrls.RETRIEVE_ALL)
    public List<BookmarkDTO> retrieveAll() {
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
    public BookmarkDTO create(BookmarkDTO val) {
        return null;
    }

    @Override
    @PutMapping(ControllerUrls.UPDATE)
    public BookmarkDTO update(BookmarkDTO val) {
        return null;
    }

}