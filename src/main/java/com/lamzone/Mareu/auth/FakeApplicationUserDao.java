package com.lamzone.Mareu.auth;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.lamzone.Mareu.security.ApplicationUserRole.ADMIN;
import static com.lamzone.Mareu.security.ApplicationUserRole.EMPLOYEE;

@AllArgsConstructor
@Repository
public class FakeApplicationUserDao implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        "papa",
                        passwordEncoder.encode("papa"),
                        EMPLOYEE.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "emma",
                        passwordEncoder.encode("passer"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
