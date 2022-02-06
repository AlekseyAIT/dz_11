package com.hillel.dz_11;

public record UserDTO(String name, String surname, Integer age) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String surname() {
        return surname;
    }

    @Override
    public Integer age() {
        return age;
    }
}
