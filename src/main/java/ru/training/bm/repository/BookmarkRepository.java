package ru.training.bm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.training.bm.domain.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
