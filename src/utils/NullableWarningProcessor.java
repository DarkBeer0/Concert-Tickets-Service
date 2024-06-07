package utils;

import annotations.NullableWarning;

import java.lang.reflect.Field;

public class NullableWarningProcessor {
    public static void checkForNulls(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(NullableWarning.class))
                continue;

            field.setAccessible(true);
            try {
                if (field.get(obj) != null)
                    continue;
                System.out.println("Variable [" + field.getName() + "] is null in [" + obj.getClass().getSimpleName() + "]!");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
