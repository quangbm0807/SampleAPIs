package com.quang.sampleapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quang.sampleapi.utils.PhoneNumber;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserRequestDTO implements Serializable {
    @NotBlank(message = "First Name khong duoc blank")
    private String firstName;
    @NotNull(message = "Last name must not be null")
    private String lastName;
    //    @Pattern(regexp = )
    @PhoneNumber
    private String phone;
    @Email(message = "Khong dung dinh dang")
    private String email;


    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthDate;

    @NotEmpty
    private List<String> permissions;

    public @NotEmpty List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(@NotEmpty List<String> permissions) {
        this.permissions = permissions;
    }

    public UserRequestDTO(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public @NotNull LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
