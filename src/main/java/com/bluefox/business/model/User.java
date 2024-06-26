package com.bluefox.business.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String password;
    private String role;
    private String status;

    // Default constructor required for JPA
    public User() {}

    // Constructor with all fields
    public User(String name, String email, String cpf, String rg, String password, String role, String status) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.password = password;
        this.role = role;
        this.status = status;
    }


    // Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    // Override hashCode, equals and toString

    /**
     * Used to identify a user
     * @return Returns the user's hashcode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Used to compare users
     * @return Returns true if it is equal and false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /**
     * Used to show a user's data
     * @return Returns a String with user's data
     */
    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", email: " + email + ", cpf: " + cpf + ", rg: " + rg + ", password: "
                + password + ", role: " + role + ", status: " + status;
    }
}