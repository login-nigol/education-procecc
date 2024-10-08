Создадим еще один проект. Рассмотрим планирование задач с помощью аннотаций.

Аннотация @EnableScheduling используется для включения планировщика для вашего приложения. 
Эту аннотацию следует добавить в основной файл класса приложения Spring Boot.

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
public static void main(String[] args) {
SpringApplication.run(DemoApplication.class, args);
}
}

Аннотация @Scheduled используется для запуска планировщика на определенный период времени.
Следующий код позволит выполнять задачу каждую минуту, начиная с 9:00 и заканчивая в 9:59 каждый день.

@Component
public class Scheduler {

@Scheduled(cron = "0 * 9 * * ?")
public void cronJobSch() {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
Date now = new Date();
String strDate = sdf.format(now);
System.out.println("Java cron job expression:: " + strDate);
}
}


Планировщик с фиксированной скоростью используется для выполнения задач в определенное время.
Он не ждет завершения предыдущего задания.
Значения должны быть в миллисекундах. Пример кода для выполнения задачи каждую секунду после запуска приложения:

@Component
public class Scheduler {

@Scheduled(fixedRate = 1000)
public void fixedRateSch() {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

      Date now = new Date();
      String strDate = sdf.format(now);
      System.out.println("Fixed Rate scheduler:: " + strDate);
}
}

Планировщик с фиксированной задержкой используется для выполнения задач в определенное время.
Следует дождаться завершения предыдущего задания. Значения должны быть в миллисекундах.

@Component
public class Scheduler {

@Scheduled(fixedDelay = 1000, initialDelay = 3000)
public void fixedDelaySch() {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
Date now = new Date();
String strDate = sdf.format(now);
System.out.println("Fixed Delay scheduler:: " + strDate);
}
}

Здесь initialDelay – это время, после которого задача будет выполнена в первый раз после начального значения задержки.

Через каждые 3 секунды задача планировщика с фиксированной задержкой выполняется каждую секунду.