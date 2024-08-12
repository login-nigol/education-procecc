//package org.example.programms.annotationreader;
//
//import java.lang.annotation.*;
//import java.lang.reflect.Method;
//
//
//public class AnnotationReader {
//
//    public static void main(String[] args) {
//        // Получаем класс AnnotatedClass
//        Class<AnnotatedClass> obj = AnnotatedClass.class;
//
//        // Проверка наличия аннотации @Info на классе
//        if (obj.isAnnotationPresent((Class<? extends Annotation>) ProcessHandle.Info.class)) {
//            // Получение аннотации
//            Annotation annotation = obj.getAnnotation(Info.class);
//            ProcessHandle.Info info = (ProcessHandle.Info) annotation;
//
//            // Вывод данных аннотации
//            System.out.println("Class Annotation:");
//            System.out.println("Author: " + ((Info) info).author());
//            System.out.println("Date: " + ((Info) info).date());
//            System.out.println("Description: " + ((Info) info).description());
//            System.out.println();
//        }
//
//        // Проход по методам класса
//        for (Method method : obj.getDeclaredMethods()) {
//            // Проверка наличия аннотации @Info на методе
//            if (method.isAnnotationPresent(Info.class)) {
//                // Получение аннотации
//                Annotation annotation = method.getAnnotation(Info.class);
//                Info info = (Info) annotation;
//
//                // Вывод данных аннотации
//                System.out.println("Method Annotation:");
//                System.out.println("Method: " + method.getName());
//                System.out.println("Author: " + info.author());
//                System.out.println("Date: " + info.date());
//                System.out.println("Description: " + info.description());
//                System.out.println();
//            }
//        }
//    }
//}
