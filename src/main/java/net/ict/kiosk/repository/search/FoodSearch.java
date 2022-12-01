package net.ict.kiosk.repository.search;

import net.ict.kiosk.dto.FoodListAllDTO;
import net.ict.kiosk.entity.Food;

import java.util.List;

public interface FoodSearch {

    List<Food> searchL();

    List<Food> search(String[] types, String keyword);

    List<FoodListAllDTO> searchWithAll(String[] types,
                                       String keyword);


}
