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
public class MemberDTO {

    private Long memberNum;

    @NotEmpty
    private LocalDateTime lastDate; // 마지막 방문일

    @NotEmpty
    private String phoneNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
