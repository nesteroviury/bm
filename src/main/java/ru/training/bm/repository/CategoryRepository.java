package ru.training.bm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.training.bm.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
