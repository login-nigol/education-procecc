package example.programms.crud_contact_management_system;

import java.util.List;
import java.util.Scanner;

// Пользовательский интерфейс (CLI), для взаимодействия с пользователем.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactService contactService = new ContactService();

        while (true) {
            System.out.println("1. Добавить контакт");
            System.out.println("2. Обновить контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Посмотреть контакт");
            System.out.println("5. Посмотреть все контакты");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Введите адрес электронной почты: ");
                    String email = scanner.nextLine();
                    Contact newContact = new Contact(0, name, phoneNumber, email);
                    contactService.addContact(newContact);
                    System.out.println("Контакт успешно создан");
                    break;
                case 2:
                    System.out.print("Введите ID для обновления: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите новое имя: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новый номер телефона: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Введите новый адрес почты: ");
                    String newEmail = scanner.nextLine();
                    Contact updatedContact = new Contact(updateId, newName, newPhoneNumber, newEmail);
                    contactService.updateContact(updatedContact);
                    System.out.println("Контакт успешно обновлён");
                    break;
                case 3:
                    System.out.print("Введите ID для удаления: ");
                    int deleteId = scanner.nextInt();
                    contactService.deleteContact(deleteId);
                    System.out.println("Контакт успешно удалён");
                    break;
                case 4:
                    System.out.print("Введите ID для просмотра: ");
                    int viewId = scanner.nextInt();
                    Contact contact = contactService.getContact(viewId);
                    if (contact != null) {
                        System.out.println("ID: " + contact.getId());
                        System.out.println("Имя: " + contact.getName());
                        System.out.println("Номер телефона: " + contact.getPhoneNumber());
                        System.out.println("Адрес почты: " + contact.getEmail());
                    } else {
                        System.out.println("Контакт не найден.");
                    }
                    break;
                case 5:
                    List<Contact> contacts = contactService.getAllContacts();
                    for (Contact c : contacts) {
                        System.out.println("ID: " + c.getId() + ", Имя: " + c.getName() + ", Номер телефона: " + c.getPhoneNumber()
                                + ", Адрес почты: " + c.getEmail());
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
}
