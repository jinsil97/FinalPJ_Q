package net.ict.kiosk.service;

import net.ict.kiosk.dto.FoodDTO;
import net.ict.kiosk.dto.RequestDTO;
import net.ict.kiosk.dto.ResponseDTO;

import java.util.List;

public interface FoodService {

    String register(FoodDTO foodDTO);

    FoodDTO readOne(String foodName);

    FoodDTO read();

    void modify(FoodDTO foodDTO);

    void remove(String foodName);

    ResponseDTO<FoodDTO> list(RequestDTO requestDTO);

    List<FoodDTO> listL();

}
