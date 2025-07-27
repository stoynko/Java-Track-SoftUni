package E02_Car_Dealer.repositories;

import E02_Car_Dealer.data.dtos.supplier.export.*;
import E02_Car_Dealer.data.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, Long> {

    @Query("""
      SELECT new E02_Car_Dealer.data.dtos.supplier.export.ExportSupplierProductsDTO(
          s.id,
          s.name,
          COUNT(p)
      )
      FROM suppliers s
      JOIN s.partsList p
      WHERE s.isImporter = :isImporter
      GROUP BY s.id, s.name
      """)
    List<ExportSupplierProductsDTO> exportSuppliers(@Param("isImporter") boolean isImporter);
}
