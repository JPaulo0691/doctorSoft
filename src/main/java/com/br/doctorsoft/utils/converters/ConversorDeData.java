package com.br.doctorsoft.utils.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class ConversorDeData implements AttributeConverter<LocalDate, String> {

    private static  final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String convertToDatabaseColumn(LocalDate attribute) {
        return attribute != null ? attribute.format(FORMAT_DATE) : null;
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        return dbData != null ? LocalDate.parse(dbData, FORMAT_DATE) : null;
    }
}
