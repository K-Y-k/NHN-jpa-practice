package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.nhnacademy.springbootjpa.entity.QItem.item;
import static com.nhnacademy.springbootjpa.entity.QOrder.order;
import static com.nhnacademy.springbootjpa.entity.QOrderItem.orderItem;

@Transactional(readOnly = true)
class ItemQuerydslRepositoryImpl extends QuerydslRepositorySupport implements ItemQuerydslRepository {

    public ItemQuerydslRepositoryImpl() {
        super(Item.class);
    }

    // TODO #1: Querydsl에서 fetch join을 사용하여 Item과 관련된 OrderItem과 Order를 함께 조회하는 메소드 구현
    @Override
    public List<Item> findAllBy() {
        return from(item)
                .leftJoin(item.orderItems, orderItem).fetchJoin()
                .innerJoin(orderItem.order, order).fetchJoin()
                .select(item)
                .fetch();
    }

}
