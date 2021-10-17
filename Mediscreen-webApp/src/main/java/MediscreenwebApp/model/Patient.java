package MediscreenwebApp.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data

public class Patient {

    private Integer id;
    @NotBlank(message = "please enter your family")
    private String firstName;
    @NotBlank(message = "please enter your given")
    private String lastName;
    private LocalDate birthday;
    @NotBlank(message = "please enter your gender")
    private String gender;
    @NotBlank(message = "please enter your address")
    private String address;
    @NotBlank(message = "please enter your given")
    private String phone;


    public Patient() {

    }

    public Patient(Integer id, String firstName, String lastName, LocalDate birthday, String gender, String address, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}