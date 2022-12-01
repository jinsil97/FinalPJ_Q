package net.ict.kiosk.repository;

import lombok.extern.log4j.Log4j2;
import net.ict.kiosk.dto.FoodListAllDTO;
import net.ict.kiosk.entity.Food;
import net.ict.kiosk.entity.FoodImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class FoodRepositoryTests {
    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Food food = Food.builder()
                    .foodName("foodName..."+i)
                    .category("cate"+i)
                    .price(i*1000)
                    .description("description..."+i)
                    .build();
            Food result = foodRepository.save(food);

        });
    }

    @Test
    public void testInsertOne(){
        Food food = Food.builder()
                 .foodName("creampasta2")
                 .category("main")
                .price(26000)
                .description("nyan good")
                        .build();
        Food result = foodRepository.save(food);
    }

    @Test
    public void testSelect(){
        String foodName = "creampasta1";
        Optional<Food> result = foodRepository.findById(foodName);
        Food food =  result.orElseThrow();
        log.info(food);
    }

    @Test
    public void testSelectAll(){
        List<Food> result = foodRepository.findAll();
        result.forEach(i -> log.info(i));
    }

    @Test
    public void testUpdate(){
        String foodName = "creampasta1";
        Optional<Food> result = foodRepository.findById(foodName);
        Food food = result.orElseThrow();
        food.change( "qwe","update... nyam good",33333);
        foodRepository.save(food);
    }

    @Test
    public void testDelete(){
        String foodName = "creampasta1";
        foodRepository.deleteById(foodName);
    }

    @Test
    public void testInsertWithImages() {

        Food food = Food.builder()
                .foodName("Image Test")
                .description("첨부파일 테스트")
                .category("Image Test")
                .price(123456789)
                .build();

        for (int i = 0; i < 3; i++) {

            food.addImage(UUID.randomUUID().toString(), "file"+i+".jpg");

        }//end for

        foodRepository.save(food);
    }

    @Test
    public void testReadWithImages(){

        Optional<Food> result = foodRepository.findByIdWithImages("Image Test");
        Food food = result.orElseThrow();

        log.info(food);
        for(FoodImage foodImage : food.getImageSet()){
            log.info(foodImage);
        }
    }

    @Transactional
    @Commit
    @Test
    public void testModifyImages() {

        Optional<Food> result = foodRepository.findByIdWithImages("Image Test");
        Food food = result.orElseThrow();

        //기존의 첨부파일들은 삭제
        food.clearImages();

        //새로운 첨부파일들
        for (int i = 0; i < 2; i++) {
            food.addImage(UUID.randomUUID().toString(), "updatefile" + i + ".jpg");
        }
        foodRepository.save(food);
    }

    @Test
    @Transactional
    @Commit
    public void testRemoveAll(){

        String foodName = "Image Test";

        foodRepository.deleteById(foodName);
    }

    @Test
    @Transactional
    public void testSearchImage(){

        List<FoodListAllDTO> result = foodRepository.searchWithAll(null,null);

        log.info("==================");
        log.info(result);

        result.forEach(foodListAllDTO -> log.info(foodListAllDTO));
    }




}
