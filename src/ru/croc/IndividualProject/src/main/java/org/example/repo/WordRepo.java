package org.example.repo;

import org.example.domain.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordRepo extends CrudRepository<Word,Long> {
    List<Word> findByText(String text);
}
