package net.ict.kiosk.service;

import lombok.extern.log4j.Log4j2;
import net.ict.kiosk.dto.FoodDTO;
import net.ict.kiosk.dto.RequestDTO;
import net.ict.kiosk.dto.ResponseDTO;
import net.ict.kiosk.entity.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
@SuppressWarnings("unchecked")
public class FoodServiceTests {

    @Autowired
    private  FoodService foodService;

    @Test
    public void testRegister(){

        FoodDTO foodDTO = FoodDTO.builder()
                .foodName("sample pasta.......")
                .category("sample main........")
                .description("sample good......")
                .price(100000000)
                .build();

        String foodName = foodService.register(foodDTO);

        log.info("////////////////////////////////");
        log.info("foodName : " + foodName);
    }

    @Test
    public void testReadOne(){

        String foodName = "sample pasta.......";
        Optional<FoodDTO> result = Optional.ofNullable(foodService.readOne(foodName));
        log.info(result);
    }

    @Test
    public void testRead(){
        List<FoodDTO> result = (List<FoodDTO>) foodService.read();
        result.forEach(i -> log.info(i));
    }

    @Test
    public void testModify(){

        FoodDTO foodDTO = FoodDTO.builder()
                .foodName("sample pasta.......")
                .description("modify.................")
                .price(32123)
                .category("qwe")
                .build();
        foodService.modify(foodDTO);
    }

    @Test
    public void testRemove(){

        String foodName = "sample pasta.......";
        foodService.remove(foodName);
    }

    @Test
    public void testList(){

        RequestDTO requestDTO = RequestDTO.builder()
                .type("n")
                .keyword("food")
                .build();

    ResponseDTO<FoodDTO> responseDTO = foodService.list(requestDTO);

    log.info(responseDTO);
  }

  @Test
    public void testListL(){
        List<FoodDTO> list = foodService.listL();
        list.forEach(i -> log.info(i));
  }

}
