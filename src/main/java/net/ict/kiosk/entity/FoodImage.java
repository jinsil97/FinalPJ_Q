package net.ict.kiosk.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "food")
public class FoodImage {

    @Id
    private String uuid;

    private  String fileName;

    @ManyToOne
    private Food food;

    public void changeFood(Food food) {
        this.food = food;
    }
}
