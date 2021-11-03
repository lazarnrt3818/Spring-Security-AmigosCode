package com.example.springsecurity.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ApplicationUserDao  {

public Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
