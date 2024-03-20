package br.com.impactaproject.ecommerce.service.impl;

import br.com.impactaproject.ecommerce.entities.User;
import br.com.impactaproject.ecommerce.repositories.UserRepository;
import br.com.impactaproject.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
