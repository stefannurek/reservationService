package adam.reservation.controllers;

import adam.reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value = "/rest/reservation", method = RequestMethod.GET,
    produces = "application/json")
    public ResponseEntity reservation(){
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/reservation/{lastname}", method = RequestMethod.GET,
    produces = "application/json")
    public ResponseEntity reservation(@PathVariable("lastname") String lastname){
        return new ResponseEntity(reservationRepository.findByLastname(lastname), HttpStatus.OK);
    }

}
