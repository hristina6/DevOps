package com.example.wplabs2.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AuthorFullNameConverter implements AttributeConverter<AuthorFullName, String> {


    @Override
    public String convertToDatabaseColumn(AuthorFullName authorFullName) {
        return authorFullName.getName() + " " + authorFullName.getSurname();
    }

    // String (Mladen Jovanovski) -> AuthorFullName(Mladen, Jovanovski)
    @Override
    public AuthorFullName convertToEntityAttribute(String s) {
        String name = s.split("\\s+")[0];
        String surname = s.split("\\s+")[1];
        return new AuthorFullName(name, surname);
    }
}

