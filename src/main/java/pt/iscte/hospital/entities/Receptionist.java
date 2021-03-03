package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "receptionist_id")
public class Receptionist extends Employee {
    // Attributes
    @OneToMany(mappedBy="receptionist")
    private Set<Invoice> invoices;

    // Constructors
    public Receptionist() {
        super.setAccount("Recepcionista");
    }

    public Receptionist(Long userId,
                   String name, String username,
                   String sex, Date birthday,
                   String address, String postCode,
                   String city,
                   String nationality, String documentType,
                   Long documentNumber, Long nif,
                   Long patientNumber, Long phone,
                   String email, String password, String photoURL) {
        super(userId, name, username, sex, birthday, address, postCode, city, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
        super.setAccount("Recepcionista");
    }

    // Methods
    public Set<Invoice> getInvoices() {
        return invoices;
    }
}
