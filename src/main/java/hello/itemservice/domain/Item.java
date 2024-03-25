package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    // JPA 는 public, protected 기본 생성자를 필수로 넣어주어야 한다.
    public Item() {}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
