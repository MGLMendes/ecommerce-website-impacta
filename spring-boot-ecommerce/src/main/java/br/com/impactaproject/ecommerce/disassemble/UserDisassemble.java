package br.com.impactaproject.ecommerce.disassemble;

import br.com.impactaproject.ecommerce.dto.input.UserInputDTO;
import br.com.impactaproject.ecommerce.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDisassemble {

    private final ModelMapper modelMapper;

    public User toEntity(UserInputDTO userInput) {
        return modelMapper.map(userInput, User.class);
    }
}
