package br.com.st.service;

import br.com.st.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User save(User u);
}
