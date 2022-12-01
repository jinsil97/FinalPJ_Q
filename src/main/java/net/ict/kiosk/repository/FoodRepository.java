package net.ict.kiosk.repository;

import net.ict.kiosk.entity.Food;
import net.ict.kiosk.repository.search.FoodSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, String>, FoodSearch {

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select f from Food f where f.foodName =:foodName")
    Optional<Food> findByIdWithImages(String foodName);
}
