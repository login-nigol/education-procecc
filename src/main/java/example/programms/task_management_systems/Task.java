package example.programms.task_management_systems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task { // Класс Task: Содержит поля для названия, описания, даты и времени создания, дедлайна
    // и временной зоны задачи. Конструктор и методы доступа (геттеры и сеттеры) позволяют управлять этими данными.
    private int id;
    private String title;
    private String description;
    private ZonedDateTime creationDateTime;
    private ZonedDateTime deadline;
    private String timeZone;

    public Task(String title, String description, ZonedDateTime deadline, String timeZone) {
        this.title = title;
        this.description = description;
        this.creationDateTime = ZonedDateTime.now();
        this.deadline = deadline;
        this.timeZone = timeZone;
    }
}
