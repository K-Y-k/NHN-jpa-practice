package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @NotNull
    private String name;

    @Setter
    private long price;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    public Item(String name, long price) {
        this.name = name;
        this.price = price;
    }
}
