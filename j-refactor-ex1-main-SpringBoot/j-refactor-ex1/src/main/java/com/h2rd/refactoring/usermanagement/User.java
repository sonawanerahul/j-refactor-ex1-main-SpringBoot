package com.h2rd.refactoring.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {

	@JsonProperty("name")
    private String name;
	@JsonProperty("email")
    private String email;
	@JsonProperty("roles")
    private List<String> roles;

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
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
