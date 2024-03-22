package br.com.impactaproject.ecommerce.service.impl;

import br.com.impactaproject.ecommerce.entities.User;
import br.com.impactaproject.ecommerce.entities.enums.Profile;
import br.com.impactaproject.ecommerce.repositories.UserRepository;
import br.com.impactaproject.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerUser(User user) {
        // Adicionando Profile REGULAR padrão
        user.getProfile().add(Profile.REGULAR);

        // Encriptando a senha
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
