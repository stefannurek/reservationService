package adam.reservation.models;

import adam.reservation.models.form.ReservationForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastname;
    private LocalDate date;
    private String adres;

    public ReservationModel(ReservationForm form) {
        name = form.getName();
        lastname = form.getLastname();
        date = form.getFormatedDate();
        adres = form.getAdres();
    }
}
