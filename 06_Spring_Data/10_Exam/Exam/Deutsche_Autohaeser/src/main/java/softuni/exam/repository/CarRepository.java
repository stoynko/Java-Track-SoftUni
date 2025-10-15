package softuni.exam.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import softuni.exam.models.entity.*;
import softuni.exam.models.entity.enums.*;

import java.util.*;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("""
            SELECT c FROM Car AS c 
            WHERE c.carType = :carType AND c.mileage < :mileageExcluding
            ORDER BY c.mileage DESC
            """)
    List<Car> getCarByType(CarType carType, Integer mileageExcluding);
}
