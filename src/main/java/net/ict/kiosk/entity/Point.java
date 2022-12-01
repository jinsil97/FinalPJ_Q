package net.ict.kiosk.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Point extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointNum;

    @Column(nullable = false)
    private Long memberNum;

    @Column(nullable = false)
    private Boolean history; //내역(적립/사용)
    
    @Column(nullable = false)
    private LocalDateTime date;
    
    @Column(nullable = false)
    private String phoneNum;

}
