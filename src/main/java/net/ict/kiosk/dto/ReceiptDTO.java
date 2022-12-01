package net.ict.kiosk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO {

    private Long orderNum;
    @NotEmpty
    private LocalDateTime date;

    @NotEmpty
    private Long quantity;

    @NotEmpty
    private Long tableNum;

    @NotEmpty
    private String foodName;

    private String phoneNum;

    private Long point;

    private Boolean status;
}
