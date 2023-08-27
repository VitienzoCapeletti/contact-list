package com.contactlist.repository;

import com.contactlist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByCpf(String cpf);
}
