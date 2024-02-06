package com.javaapp.employeemanagementapp;

public record Department(int id, String name) {
    // Другие геттеры и сеттеры

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

