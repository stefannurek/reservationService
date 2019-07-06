package adam.reservation.repositories;

import adam.reservation.models.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository <ReservationModel, Integer> {
}
