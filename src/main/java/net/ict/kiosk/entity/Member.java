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
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;

    @Column(nullable = false)
    private LocalDateTime lastDate; // 마지막 방문일

    @Column(nullable = false)
    private String phoneNum;
}
