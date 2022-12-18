package org.example.repo;

import org.example.domain.User;
import org.example.domain.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String name);
}
