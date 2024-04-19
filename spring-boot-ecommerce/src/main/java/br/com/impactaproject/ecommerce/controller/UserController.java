package br.com.impactaproject.ecommerce.controller;

import br.com.impactaproject.ecommerce.assemble.UserAssemble;
import br.com.impactaproject.ecommerce.disassemble.UserDisassemble;
import br.com.impactaproject.ecommerce.dto.UserDTO;
import br.com.impactaproject.ecommerce.dto.input.UserInputDTO;
import br.com.impactaproject.ecommerce.entities.User;
import br.com.impactaproject.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 20)
public class UserController {

    private final UserDisassemble userDisassemble;
    private final UserAssemble userAssemble;

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserInputDTO userInput) {
        User user = userService.registerUser(userDisassemble.toEntity(userInput));
        UserDTO userDTO = userAssemble.toModel(user);
        return ResponseEntity.status(201).body(userDTO);
    }
}
