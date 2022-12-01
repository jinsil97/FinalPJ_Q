package net.ict.kiosk.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ResponseDTO<E> {

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public ResponseDTO( List<E> dtoList){

        this.dtoList = dtoList;

    }
}
