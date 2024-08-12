package example.programms.task_management_systems;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() { // Класс TaskManager: Содержит методы для добавления, редактирования,
        // удаления и получения списка задач. Все задачи хранятся в списке tasks.
        this.tasks = new ArrayList<>();
    }

    public void addTask(String title, String description, ZonedDateTime deadline, String timeZone) {
        Task task = new Task(title, description, deadline, timeZone);
        tasks.add(task);
    }

    public void editTask(int index, String title, String description, ZonedDateTime deadline, String timeZone) {
        Task task = tasks.get(index);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setTimeZone(timeZone);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
