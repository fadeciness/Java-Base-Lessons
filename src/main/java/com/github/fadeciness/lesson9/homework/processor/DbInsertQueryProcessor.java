package com.github.fadeciness.lesson9.homework.processor;

import com.github.fadeciness.lesson9.homework.annotation.Column;
import com.github.fadeciness.lesson9.homework.annotation.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DbInsertQueryProcessor {

    private static final String INSERT_QUERY = "INSERT INTO %s (%s) VALUES (%s)";

    public static String insertQuery(Object obj) throws IllegalAccessException {
        List<Field> annotatedFields = Stream.of(obj)
                .filter(Objects::nonNull)
                .map(Object::getClass)
                .filter(c -> c.isAnnotationPresent(Table.class))
                .flatMap(c -> Arrays.stream(c.getDeclaredFields()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
        if (annotatedFields.isEmpty()) {
            throw new RuntimeException("Class bad structure");
        }

        String tableName = obj.getClass().getAnnotation(Table.class).title();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        for (Field annotatedField : annotatedFields) {
            annotatedField.setAccessible(true);
            String annoColumnName = annotatedField.getAnnotation(Column.class).name();
            String columnName = annoColumnName.isBlank() ? annotatedField.getName() : annoColumnName;
            Object fieldValue = annotatedField.get(obj);
            String fV;
            if (fieldValue instanceof String) {
                fV = "'" + (String) fieldValue + "'";
            } else {
                fV = String.valueOf(fieldValue);
            }
            names.add(columnName);
            values.add(fV);
        }
        String joinedNames = String.join(", ", names);
        String joinedValues = String.join(", ", values);
        return String.format(INSERT_QUERY, tableName, joinedNames, joinedValues);
    }

}
