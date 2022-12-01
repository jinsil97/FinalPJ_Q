package net.ict.kiosk.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Password extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long password;
    
    @Column (nullable = false)
    private Long pwdNum; //카운터, 테이블 번호
    
}
