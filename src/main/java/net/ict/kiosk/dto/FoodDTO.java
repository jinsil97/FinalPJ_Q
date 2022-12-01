package net.ict.kiosk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

    private String foodName;

    @NotEmpty
    private String category;

    @NotNull
    private int price;

    @NotEmpty
    private String description;

    private String oFile;

    private String sFile;

    private Boolean best;

    private Boolean New;

    private Boolean signature;

    private Boolean soldOut;

    private Boolean hide;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private List<String> fileNames;

}
