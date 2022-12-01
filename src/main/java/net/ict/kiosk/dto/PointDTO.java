package net.ict.kiosk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointDTO {

    private Long pointNum;

    @NotEmpty
    private Long memberNum;

    @NotEmpty
    private Boolean history; //내역(적립/사용)

    @NotEmpty
    private LocalDateTime date;

    @NotEmpty
    private String phoneNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
