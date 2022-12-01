package net.ict.kiosk.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "imageSet")
public class Food extends BaseEntity{
    @Id
    private String foodName;

    @Column(length = 50, nullable = false)
    private String category;

    @Column(nullable = false)
    private int price;

    @Column(length = 2000, nullable = false)
    private String description;

    @Column(length = 50)
    private String oFile;

    @Column(length = 50)
    private String sFile;

    @Column
    private Boolean best;

    @Column
    private Boolean New;

    @Column
    private Boolean signature;

    @Column
    private Boolean soldOut;

    @Column
    private Boolean hide;

//    public void change(String foodName, String description) {
//        this.foodName = foodName;
//        this.description = description;
//    }
  public void change(String category,String description, int price) {
    this.category = category;
    this.description = description;
    this.price = price;
}

    @OneToMany(mappedBy = "food",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @Builder.Default
    @BatchSize(size = 20)
    private Set<FoodImage> imageSet = new HashSet<>();

    public void addImage(String uuid, String fileName){

        FoodImage foodImage = FoodImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .food(this)

                .build();
        imageSet.add(foodImage);
    }

    public void clearImages() {

        imageSet.forEach(foodImage -> foodImage.changeFood(null));

        this.imageSet.clear();
    }


}
