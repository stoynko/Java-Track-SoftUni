package E01_Products_Shop.repositories;

import E01_Products_Shop.data.*;
import E01_Products_Shop.repositories.projections.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /* SELECT c.name AS category_name,
       COUNT(c.name) AS products_in_category,
       AVG(p.price) AS average_price,
       SUM(p.price) AS total_revenue
       FROM categories AS c
       JOIN categories_products AS cp ON cp.category_id = c.id
       JOIN products AS p ON cp.product_id = p.id
       GROUP BY c.id
       ORDER BY products_in_category DESC; */

    @Query("""
            SELECT new E01_Products_Shop.repositories.projections.CategoryInfoProjection(
                c.name,
                COUNT(p),
                AVG(p.price),
                SUM(p.price))
            FROM Category AS c
            JOIN c.products AS p
            GROUP BY c.name
            ORDER BY COUNT(p) DESC""")
    List<CategoryInfoProjection> getCategoriesInfo();


}
