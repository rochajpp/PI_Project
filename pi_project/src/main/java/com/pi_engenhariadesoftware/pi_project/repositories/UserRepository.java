package com.pi_engenhariadesoftware.pi_project.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pi_engenhariadesoftware.pi_project.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query(value="SELECT * FROM user WHERE login = :login AND password = :password", nativeQuery = true)
    public User login(String login, String password);

    @Query(value="SELECT * FROM user WHERE login = :login AND birthdate = :birthdate", nativeQuery = true)
    public User reset(String login, LocalDate birthdate);

    @Query(value="SELECT * FROM user WHERE id = :idUser", nativeQuery = true)
    public User getUser(int idUser);

    @Query(value="SELECT * FROM user WHERE login = :login", nativeQuery = true)
    public User checkLogin(String login);
}
