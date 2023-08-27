package com.contactlist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@With
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate birthday;
    @CPF
    @Column(nullable = false)
    private String cpf;
    @OneToMany
    @Column(nullable = false)
    private ContactList contactList;

}
