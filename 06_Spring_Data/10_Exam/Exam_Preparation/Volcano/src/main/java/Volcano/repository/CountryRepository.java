package Volcano.repository;

import Volcano.models.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
