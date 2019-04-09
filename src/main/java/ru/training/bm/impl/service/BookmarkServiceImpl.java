package ru.training.bm.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.training.bm.api.service.BookmarkService;
import ru.training.bm.domain.Bookmark;
import ru.training.bm.exception.ServiceException;
import ru.training.bm.repository.BookmarkRepository;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public void add(Bookmark bookmark) throws ServiceException {

    }

    @Override
    public void update(Bookmark bookmark) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public List<Bookmark> list() throws ServiceException {
        return null;
    }

    @Override
    public Bookmark findById(Long id) throws ServiceException {
        return bookmarkRepository
                .findById(id)
                .orElseThrow(() -> new ServiceException("Bookmark with id=" + id + " not found"));
    }

    @Override
    public Page<Bookmark> findAll(Integer page, Integer size) throws ServiceException {
        Sort sort = Sort.by("name");
        Pageable pageable = PageRequest.of(page, size, sort);

        return bookmarkRepository.findAll(pageable);
    }

    @Override
    public void deleteAll(Long categoryId) throws ServiceException {

    }

}
