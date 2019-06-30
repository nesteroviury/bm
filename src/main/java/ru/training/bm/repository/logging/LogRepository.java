package ru.training.bm.repository.logging;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.training.bm.domain.LogDetails;

public interface LogRepository extends JpaRepository<LogDetails, Long> {
}
