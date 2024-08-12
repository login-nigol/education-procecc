package example.programms.crud_contact_management_system;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Слой доступа к данным (Data Access Layer), для взаимодействия с базой данных.
public class ContactDAO {
    private final String url = "jdbc:mysql://localhost:3306/contacts_db";
    private final String user = "root";
    private final String password = "123456789Vadim";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addContact(Contact contact) throws SQLException {
        // Создается строка query с SQL-запросом для вставки данных.
        String query = "INSERT INTO contacts (name, phone_number, email) VALUES (?, ?, ?)";
        // В блоке try-with-resources открывается соединение conn и создается подготовленный запрос stmt.
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhoneNumber());
            stmt.setString(3, contact.getEmail());
            // Выполняется обновление базы данных с помощью stmt.executeUpdate().
            stmt.executeUpdate();
        }
    }

    public void updateContact(Contact contact) throws SQLException {
        // Создается строка query с SQL-запросом для обновления данных.
        String query = "UPDATE contacts SET name = ?, phone_number = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhoneNumber());
            stmt.setString(3, contact.getEmail());
            stmt.setInt(4, contact.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteContact(int id) throws SQLException {
        String query = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            // Устанавливается идентификатор контакта в запрос.
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Contact getContact(int id) throws SQLException {
        // Создается строка query с SQL-запросом для получения данных.
        String query = "SELECT * FROM contacts WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            // Устанавливается идентификатор контакта в запрос.
            stmt.setInt(1, id);
            // Выполняется запрос stmt.executeQuery() и результат сохраняется в ResultSet rs.
            ResultSet rs = stmt.executeQuery();
            // Если запись найдена, создается и возвращается объект Contact с данными из результата запроса.
            if (rs.next()) {
                return new Contact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                );
            }
            return null;
        }
    }

    public List<Contact> getAllContacts() throws SQLException {
        // Создается пустой список contacts для хранения объектов Contact.
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM contacts";
        // В блоке try-with-resources открывается соединение conn, создается объект Statement stmt и выполняется запрос stmt.executeQuery(query),
        // результат которого сохраняется в ResultSet rs.
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            // Пока есть записи в ResultSet, создаются объекты Contact с данными из результата запроса и добавляются в список contacts.
            while (rs.next()) {
                contacts.add(new Contact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                ));
            }
        }
        return contacts;
    }
}
