package ru.training.bm.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.training.bm.domain.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    void deleteAllByIdIn(List<Long> ids);

}
