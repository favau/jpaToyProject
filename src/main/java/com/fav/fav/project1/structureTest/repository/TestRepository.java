package com.fav.fav.project1.structureTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fav.fav.project1.structureTest.data.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

    // JpaRepository가 기본적으로 제공하는 CRUD 메서드를 사용

    // 엔티티 저장 (create)
    // save() 메서드 사용

    // 엔티티 조회 (read)
    // findById() 메서드 사용

    // 엔티티 수정 (update)
    // save() 메서드 사용

    // 엔티티 삭제
    // delete() 또는 deleteById() 메서드를 사용

    // @Query를 사용하여 JPQL 쿼리 작성
    @Query("SELECT t FROM TestEntity t WHERE t.name = ?1")
    List<TestEntity> findByName(String name);

    // SQL 쿼리 사용도 가능
    @Query(value = "SELECT * FROM test_entity WHERE name = ?1", nativeQuery = true)
    List<TestEntity> findByNameNative(String name);
}
