package example.programms.annotationreader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определение аннотации
@Retention(RetentionPolicy.RUNTIME) // Аннотация будет доступна во время выполнения
@Target({ElementType.TYPE, ElementType.METHOD}) // Аннотация может применяться к классам и методам
public @interface Info {
    String author() default "Unknown";
    String date();
    String description();
}
