package com.github.fadeciness.lesson9.homework.processor;

import com.github.fadeciness.lesson9.homework.annotation.Column;
import com.github.fadeciness.lesson9.homework.annotation.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public class DbSchemaCreationAnnotationProcessor {

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS %s (%s);";

    private static final Map<String, String> types = Map.ofEntries(
            Map.entry("String", "TEXT"),
            Map.entry("Integer", "INTEGER"),
            Map.entry("int", "INTEGER"),
            Map.entry("Long", "INTEGER"),
            Map.entry("long", "INTEGER"),
            Map.entry("Double", "REAL"),
            Map.entry("double", "REAL"),
            Map.entry("Float", "REAL"),
            Map.entry("float", "REAL")
    );

    public static String createTableQuery(Class<?> clazz) {
        if (clazz == null) {
            throw new RuntimeException("Not specified class for processing");
        }
        String tableName;
        Table tableAnno = clazz.getAnnotation(Table.class);
        if (tableAnno != null && tableAnno.title() != null && !tableAnno.title().isBlank()) {
            tableName = tableAnno.title();
        } else {
            throw new RuntimeException("Class must contains 'Table' annotation and not blank table title");
        }

        ArrayList<String> columns = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Column columnAnno = field.getAnnotation(Column.class);
            String columnName;
            String columnType = types.get(field.getType().getSimpleName());
            if (columnType == null) {
                throw new RuntimeException("Unsupported field type: " + field.getType().getSimpleName());
            }

            if (columnAnno == null) {
                continue;
            } else if (columnAnno.name() != null && !columnAnno.name().isBlank()) {
                columnName = columnAnno.name();
            } else {
                columnName = field.getName();
            }
            columns.add(columnName + " " + columnType);
        }
        if (columns.isEmpty()) {
            throw new RuntimeException("At least one column required in class: " + clazz.getName());
        }

        return String.format(
                CREATE_TABLE_QUERY,
                tableName,
                String.join(", ", columns));
    }

}
