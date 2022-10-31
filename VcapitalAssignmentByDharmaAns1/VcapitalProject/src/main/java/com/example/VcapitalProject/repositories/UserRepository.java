package com.example.VcapitalProject.repositories;

import com.example.VcapitalProject.domain.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {


}
