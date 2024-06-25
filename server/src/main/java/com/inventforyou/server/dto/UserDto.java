package com.inventforyou.server.dto;

public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address; // Vous pourriez vouloir séparer en address, city, country si nécessaire
    private String password;

    // Getters et setters pour firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getters et setters pour lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getters et setters pour email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters et setters pour phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getters et setters pour address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getters et setters pour password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Vous pouvez ajouter des méthodes de validation ou de logique métier supplémentaires ici si nécessaire
}
