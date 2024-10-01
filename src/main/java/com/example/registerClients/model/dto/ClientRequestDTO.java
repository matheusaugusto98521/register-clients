package com.example.registerClients.model.dto;

public record ClientRequestDTO(String name, String document, String occupation
                                , String email, String phone, String birthDate) {
}
