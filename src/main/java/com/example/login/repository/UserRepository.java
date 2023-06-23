package com.example.login.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.login.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByNameAndPassword(String name, String password);
    
    @Query(nativeQuery = true, value = "select * from UserEntity where date between :regStartDate and :regEndDate")
    List<UserEntity> dateRange(@Param("regStartDate") Optional<LocalDate> regStartDate, @Param("regEndDate") Optional<LocalDate> regEndDate);

    @Query(nativeQuery = true, value = "select * from UserEntity where date between :regStartDate and :regEndDate and picode = :pincode")
    List<UserEntity> dateRangeWithPincode(@Param("regStartDate") Optional<LocalDate> regStartDate, @Param("regEndDate") Optional<LocalDate> regEndDate, @Param("pincode") Optional<Integer> pincode);

    @Query(nativeQuery = true, value = "select * from UserEntity where date between :regStartDate and :regEndDate and name = :name")
    List<UserEntity> dateRangeWithName(@Param("regStartDate") Optional<LocalDate> regStartDate, @Param("regEndDate") Optional<LocalDate> regEndDate, @Param("name") Optional<String> name);

    @Query(nativeQuery = true, value = "select * from UserEntity where date between :regStartDate and :regEndDate and name = :name and pincode = :pincode")
    List<UserEntity> dateRangeWithNameAndPincode(@Param("regStartDate") Optional<LocalDate> regStartDate, @Param("regEndDate") Optional<LocalDate> regEndDate, 
    @Param("name") Optional<String> name,  @Param("pincode") Optional<Integer> pincode);

    List<UserEntity> findByPincode(Optional<Integer> pincode);

    List<UserEntity> findByName(Optional<String> name);

    List<UserEntity> findByNameAndPincode(Optional<String> name, Optional<Integer> pincode);

}
