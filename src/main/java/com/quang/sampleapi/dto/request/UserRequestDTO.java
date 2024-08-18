package com.quang.sampleapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quang.sampleapi.utils.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.quang.sampleapi.utils.Gender.FEMALE;
import static com.quang.sampleapi.utils.Gender.OTHER;

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

    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus status;

    @GenderSubset(anyOf = {Gender.MALE, FEMALE, OTHER})
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @NotEmpty
    private List<String> permissions;

    private @NotEmpty List<String> getPermissions() {
        return permissions;
    }

    private void setPermissions(@NotEmpty List<String> permissions) {
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
