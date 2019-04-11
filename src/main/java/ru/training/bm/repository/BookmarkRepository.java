package ru.training.bm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.training.bm.domain.Bookmark;
import ru.training.bm.domain.Category;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    void deleteAllByCategory(Category category);
    void deleteAllByIdIn(List<Long> bookmarkIdList);

}
