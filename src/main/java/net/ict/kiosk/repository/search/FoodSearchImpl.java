package net.ict.kiosk.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import net.ict.kiosk.dto.FoodImageDTO;
import net.ict.kiosk.dto.FoodListAllDTO;
import net.ict.kiosk.entity.Food;
import net.ict.kiosk.entity.QFood;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

public class FoodSearchImpl extends QuerydslRepositorySupport implements FoodSearch {

    public FoodSearchImpl() {
        super(Food.class);
    }

    @Override
    public List<Food> searchL(){

        QFood food = QFood.food;
        JPQLQuery<Food> query = from(food);

        List<Food> list = query.fetch();

        return list;

    }


    @Override
    public List<Food> search(String[] types, String keyword) {

        QFood food = QFood.food;
        JPQLQuery<Food> query = from(food);

        if ((types != null && types.length > 0) && keyword != null) {

            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for (String type : types) {

                switch (type) {
                    case "n":
                        booleanBuilder.or(food.foodName.contains(keyword));
                        break;
                    case "d":
                        booleanBuilder.or(food.description.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }

        List<Food> list = query.fetch();

        return list;
    }

      @Override
    public List<FoodListAllDTO> searchWithAll(String[] types, String keyword) {

        QFood qFood = QFood.food;

        JPQLQuery<Food> foodJPQLQuery = from(qFood);

        if ((types != null && types.length > 0) && keyword != null) {

            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for (String type : types) {

                switch (type) {
                    case "n":
                        booleanBuilder.or(qFood.foodName.contains(keyword));
                        break;
                    case "d":
                        booleanBuilder.or(qFood.description.contains(keyword));
                        break;
                }
            }//end for
            foodJPQLQuery.where(booleanBuilder);
        }

        foodJPQLQuery.groupBy(qFood);

        List<Food> foodList = foodJPQLQuery.fetch();

        List<FoodListAllDTO> dtoList = foodList.stream().map(food -> {


            FoodListAllDTO dto = FoodListAllDTO.builder()
                    .foodName(food.getFoodName())
                    .category(food.getCategory())
                    .description(food.getDescription())
                    .price(food.getPrice())
                    .build();

            List<FoodImageDTO> imageDTOS = food.getImageSet().stream().sorted()
                    .map(foodImage -> FoodImageDTO.builder()
                            .uuid(foodImage.getUuid())
                            .fileName(foodImage.getFileName())
                            .build()
                    ).collect(Collectors.toList());

            dto.setFoodImages(imageDTOS);

            return dto;

        }).collect(Collectors.toList());

        return dtoList;
    }
}






