package com.edutech.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.users.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
