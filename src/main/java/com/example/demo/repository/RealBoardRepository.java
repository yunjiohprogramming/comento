package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RealBoard;


@Repository
public interface RealBoardRepository extends JpaRepository<RealBoard, Long> {
}


/*
 * 이 인터페이스는 CRUD 기능을 자동으로 생성
 * 직접 SQL을 작성하지 않아도 됨
 */