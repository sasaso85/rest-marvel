package com.challenge.marvel.rest.respository;

import com.challenge.marvel.rest.model.RegisterLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterLogRepository extends JpaRepository<RegisterLog, Long> {
}
