package adam.reservation.repositories;

import adam.reservation.models.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {

    boolean existsByDateEquals(LocalDate date);

    List<ReservationModel> findByDateBetween(LocalDate date1, LocalDate date2);

    List<ReservationModel> findByLastnameIgnoreCase(String lastname);

    ReservationModel deleteById(int id);

    ReservationModel findById(int id);

}
