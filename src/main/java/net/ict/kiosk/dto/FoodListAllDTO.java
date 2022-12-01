package net.ict.kiosk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodListAllDTO {

    private String foodName;
    private String category;
    private int price;
    private String description;

    private List<FoodImageDTO> foodImages;

}
