package example.programms.crud_contact_management_system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

// Модель данных (Model), для представления контактов.
public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
}
