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

public class PasswordDTO {

    private Long password;

    @NotEmpty
    private Long pwdNum; //카운터, 테이블 번호

    private LocalDateTime regDate;
    private LocalDateTime modeDate;
}
