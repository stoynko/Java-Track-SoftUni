package Volcano.repository;

import Volcano.models.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface VolcanologistRepository extends JpaRepository<Volcanologist, Long> {


}
