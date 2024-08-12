package example.programms.crud_contact_management_system;

import java.sql.SQLException;
import java.util.List;

// Слой сервиса (Service Layer), для управления логикой приложения.
public class ContactService {
    // Объявляется приватное поле contactDAO типа ContactDAO, которое будет использоваться для доступа
    // к методам взаимодействия с базой данных.
    private ContactDAO contactDAO;

    public ContactService() {
        // Инициализирует поле contactDAO новым объектом ContactDAO.
        this.contactDAO = new ContactDAO();
    }

    public void addContact(Contact contact) {
        try {
            // Вызывается метод addContact объекта contactDAO, который добавляет контакт в базу данных.
            contactDAO.addContact(contact);
        } catch (SQLException e) {
            // В случае исключения выводится стек вызовов ошибки.
            e.printStackTrace();
        }
    }

    public void updateContact(Contact contact) {
        try {
            // принимает объект типа Contact для обновления в базе данных.
            contactDAO.updateContact(contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(int id) {
        try {
            // принимает id контакта для удаления из базы данных.
            contactDAO.deleteContact(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact getContact(int id) {
        try {
            // принимает id контакта и возвращает объект Contact из базы данных.
            return contactDAO.getContact(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        try {
            // возвращает список всех контактов.
            return contactDAO.getAllContacts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
