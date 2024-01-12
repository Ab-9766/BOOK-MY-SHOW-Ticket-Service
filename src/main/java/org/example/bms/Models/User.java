package org.example.bms.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.bms.Models.Enums.Role;

import java.util.List;

@Getter
@Setter
@Entity

public class User extends BaseModel{
    private String name;
    private String username;
    private String pwd;
    private String phone_number;


    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Role> roles;

    @OneToMany(mappedBy = "bookedBy")
    private List<Ticket> tickets;

}
