package adam.reservation.models.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class ReservationForm {


    @Getter
    @Setter
    @Size(min = 3, max = 20, message = "{Size.ReservationForm.name}")
    @NotNull
    private String name;
    @Getter
    @Setter
    @Size(min = 3, max = 20, message = "{Size.ReservationForm.lastname}")
    @NotNull
    private String lastname;
    @Getter
    @Setter
    @NotNull
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "{Pattern.ReservationForm.date}")
    private String date;
    @Getter
    @Setter
    @Size(min = 5, max = 50, message = "{Size.ReservationForm.adres}")
    @NotNull
    private String adres;

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getFormatedDate() {
        return LocalDate.parse(date, format);
    }
}
