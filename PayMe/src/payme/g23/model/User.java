package payme.g23.model;


import lombok.*;
import payme.g23.model.role.Role;

import java.io.Serial;
import java.util.UUID;

import static payme.g23.model.role.Role.USER;



public class User {
    private String name ;
    private String phoneNumber ;
    private String password ;
    private String role = "USER" ;
    private Boolean isBlock = true ;
    private UUID userId = UUID.randomUUID();



    public User(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(String name, String phoneNumber, String password, String role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getBlock() {
        return isBlock;
    }

    public void setBlock(Boolean block) {
        isBlock = block;
    }

    public UUID getUserId() {
        return userId;
    }


}
