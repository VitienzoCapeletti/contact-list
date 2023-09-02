package com.contactlist.service;

import com.contactlist.dto.UserDTO;
import com.contactlist.dto.UserRequestDTO;
import com.contactlist.entity.User;
import com.contactlist.mapper.UserMapper;
import com.contactlist.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.mapper = Mappers.getMapper(UserMapper.class);
    }

    public UserDTO create(UserRequestDTO requestDTO) {

        if (!repository.findAllByCpf(requestDTO.getCpf()).isEmpty()) {
            throw new ResponseStatusException(BAD_REQUEST, "Error: CPF already used");
        }

        final var user = mapper.buildUserEntity(requestDTO);
        return saveUser(user);
    }

    public UserDTO update(UserDTO userDTO) {
        findEntityById(userDTO.getId());
        final var user = mapper.buildUserEntity(userDTO);
        return saveUser(user);
    }

    public UserDTO findById(final Long userId) {
        return repository.findById(userId)
                .map(mapper::buildUserDTO)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User not found"));
    }

    public List<UserDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::buildUserDTO)
                .collect(Collectors.toList());
    }

    private UserDTO saveUser(User user) {
        final var savedUser = repository.save(user);
        return mapper.buildUserDTO(savedUser);
    }

    private User findEntityById(final Long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User not found"));
    }
}
