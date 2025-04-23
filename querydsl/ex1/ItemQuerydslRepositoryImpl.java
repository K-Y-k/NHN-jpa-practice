package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

import static com.nhnacademy.springbootjpa.entity.QItem.item;
import static com.nhnacademy.springbootjpa.entity.QOrder.order;
import static com.nhnacademy.springbootjpa.entity.QOrderItem.orderItem;

// TODO #2: Custom Repository 구현
// QuerydslRepositorySupport 방식
@Transactional(readOnly = true)
class ItemQuerydslRepositoryImpl extends QuerydslRepositorySupport implements ItemQuerydslRepository {

    public ItemQuerydslRepositoryImpl() {
        super(Item.class);
    }

    @Override
    public List<Item> findAllByOrderedAtAfter(ZonedDateTime orderedAt) {
//        return from(item)
//                .leftJoin(item.orderItems, orderItem)
//                .innerJoin(orderItem.order, order)
//                .where(order.orderedAt.after(orderedAt))
//                .select(item)
//                .fetch();
        
        /**
         * queryDsl의 장점
         * 1.컴파일 시점에서 에러를 찾아줘 타입 안정성
         * 2.동적으로 생성 가능
         */
         var dynamic = from(item)
                 .leftJoin(item.orderItems, orderItem)
                 .innerJoin(orderItem.order, order)
                 .where(order.orderedAt.after(orderedAt));
         
         dynamic.where(item.name.eq("some"));
         if (true) {
             dynamic.where(item.name.eq("thing"));
         } else {
             dynamic.where(item.name.eq("thing"));
         }
         
         return dynamic.select(item).fetch();
    }

}
