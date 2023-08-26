package com.contactlist.dto;

import com.contactlist.entity.ContactList;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    @NotNull
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String cpf;
    @NotNull
    private ContactList contactList;

}
