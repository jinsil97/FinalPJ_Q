package net.ict.kiosk.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Receipt extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNum;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long tableNum;

    @Column(length = 50, nullable = false)
    private String foodName;

    @Column
    private String phoneNum;

    @Column
    private Long point;

    @Column
    private Boolean status; // 상태(반려/완료) , 취소는 관리자 페이지에서

}
