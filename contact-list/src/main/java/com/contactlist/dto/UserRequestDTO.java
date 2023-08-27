package com.contactlist.dto;

import com.contactlist.entity.ContactList;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {

    @NotNull
    private String name;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    @NotNull
    private String cpf;
    @NotNull
    private ContactList contactList;

}