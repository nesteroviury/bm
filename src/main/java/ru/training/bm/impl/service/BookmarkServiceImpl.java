package ru.training.bm.impl.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.training.bm.api.config.logging.aop.Loggable;
import ru.training.bm.api.service.BookmarkService;
import ru.training.bm.api.service.CategoryService;
import ru.training.bm.domain.Bookmark;
import ru.training.bm.domain.Category;
import ru.training.bm.exception.ServiceException;
import ru.training.bm.repository.data.BookmarkRepository;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final CategoryService categoryService;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository, CategoryService categoryService) {
        this.bookmarkRepository = bookmarkRepository;
        this.categoryService = categoryService;
    }

    @Loggable
    @Override
    @Transactional
    public Bookmark create(Bookmark bookmark) throws ServiceException {
        return bookmarkRepository.saveAndFlush(bookmark);
    }

    @Loggable
    @Override
    @Transactional
    public Bookmark update(Bookmark bookmark) throws ServiceException {
        return bookmarkRepository
                .findById(bookmark.getId())
                .map(persistentBookmark -> {
                    BeanUtils.copyProperties(bookmark, persistentBookmark);
                    return bookmarkRepository.saveAndFlush(persistentBookmark);
                })
                .get();
    }

    @Loggable
    @Override
    @Transactional
    public void delete(Bookmark bookmark) throws ServiceException {
        bookmarkRepository.delete(bookmark);
    }

    @Loggable
    @Override
    @Transactional
    public Bookmark get(Long id) throws ServiceException {
        return bookmarkRepository
                .findById(id)
                .orElseThrow(() -> new ServiceException("Bookmark with id=" + id + " not found"));
    }

    @Loggable
    @Override
    @Transactional
    public Page<Bookmark> get(Integer page, Integer size) throws ServiceException {
        Sort sort = Sort.by("name");
        Pageable pageable = PageRequest.of(page, size, sort);

        return bookmarkRepository.findAll(pageable);
    }

    @Loggable
    @Override
    @Transactional
    public void delete(Long categoryId) throws ServiceException {
        Category category = categoryService.get(categoryId);
        bookmarkRepository.deleteAllByCategory(category);
    }

    @Loggable
    @Override
    @Transactional
    public void delete(List<Long> bookmarkIdList) throws ServiceException {
        bookmarkRepository.deleteAllByIdIn(bookmarkIdList);
    }

    @Loggable
    @Override
    public void truncate() throws ServiceException {
        bookmarkRepository.deleteAllInBatch();
    }

}
