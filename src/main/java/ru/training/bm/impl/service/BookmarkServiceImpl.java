package ru.training.bm.impl.service;

import ru.training.bm.api.service.BookmarkService;
import ru.training.bm.domain.Bookmark;
import ru.training.bm.exception.ServiceException;

import java.util.List;

public class BookmarkServiceImpl implements BookmarkService {

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
        return null;
    }

    @Override
    public void deleteAll(Long categoryId) throws ServiceException {

    }

}
