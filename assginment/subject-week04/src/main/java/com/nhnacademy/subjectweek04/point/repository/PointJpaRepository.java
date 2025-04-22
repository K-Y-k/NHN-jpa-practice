package com.nhnacademy.subjectweek04.point.repository;

import com.nhnacademy.subjectweek04.point.entity.Point;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointJpaRepository extends JpaRepository<Point, Long> {
    // Point save(Point point);
    void deleteByPointId(long pointId);

    List<Point> findAllByUser_UserId(String userUserId);
}
