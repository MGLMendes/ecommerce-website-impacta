package br.com.impactaproject.ecommerce.assemble;

import br.com.impactaproject.ecommerce.dto.UserDTO;
import br.com.impactaproject.ecommerce.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAssemble {

    private final ModelMapper modelMapper;

    public UserDTO toModel(User user) {
        return modelMapper.map(user , UserDTO.class);
    }
}
