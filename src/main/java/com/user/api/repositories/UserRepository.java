package com.user.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.api.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
