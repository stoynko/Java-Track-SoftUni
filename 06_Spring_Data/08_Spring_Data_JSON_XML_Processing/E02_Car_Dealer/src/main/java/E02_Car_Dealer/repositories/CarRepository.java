package E02_Car_Dealer.repositories;

import E02_Car_Dealer.data.dtos.car.export.*;
import E02_Car_Dealer.data.entities.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM cars c LEFT JOIN FETCH c.partsList")
    List<Car> findAllCarsWithParts();
}
