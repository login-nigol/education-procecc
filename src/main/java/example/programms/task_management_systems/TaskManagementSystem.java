package example.programms.task_management_systems;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Scanner;

public class TaskManagementSystem { // Основной класс TaskManagementSystem: Обеспечивает взаимодействие с пользователем
    // через консоль. Позволяет пользователю выбирать действия, такие как создание, редактирование, удаление и просмотр задач.

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter deadline (yyyy-MM-ddTHH:mm:ssZ): ");
                    String deadlineStr = scanner.nextLine();
                    ZonedDateTime deadline = ZonedDateTime.parse(deadlineStr);
                    System.out.print("Enter time zone: ");
                    String timeZone = scanner.nextLine();
                    taskManager.addTask(title, description, deadline, timeZone);
                    break;
                case 2:
                    System.out.print("Enter task index: ");
                    int indexEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter new deadline (yyyy-MM-ddTHH:mm:ssZ): ");
                    String newDeadlineStr = scanner.nextLine();
                    ZonedDateTime newDeadline = ZonedDateTime.parse(newDeadlineStr);
                    System.out.print("Enter new time zone: ");
                    String newTimeZone = scanner.nextLine();
                    taskManager.editTask(indexEdit, newTitle, newDescription, newDeadline, newTimeZone);
                    break;
                case 3:
                    System.out.print("Введите интекс задания: ");
                    int indexDelete = scanner.nextInt();
                    taskManager.deleteTask(indexDelete);
                    break;
                case 4:
                    List<Task> tasks = taskManager.getTasks();
                    for (int i = 0; i < tasks.size(); i++) {
                        Task task = tasks.get(i);
                        System.out.println("Задание " + (i + 1) + ": " + task);
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
