// package com.fav.fav.project1.jpaExample.repository;

// import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

// import com.fav.fav.project1.jpaExample.data.JpaExampleEntity;

// @Repository
// public interface JpaExampleRepository extends JpaRepository<JpaExampleEntity, Long> {

//     // @Query를 사용하여 JPQL 쿼리 작성
//     // @Query("SELECT t FROM TestEntity t WHERE t.name = ?1")
//     // List<TestEntity> findByName(String name);

//     // SQL 쿼리 사용도 가능
//     // @Query(value = "SELECT * FROM test_entity WHERE name = ?1", nativeQuery = true)
//     // List<TestEntity> findByNameNative(String name);
// }
