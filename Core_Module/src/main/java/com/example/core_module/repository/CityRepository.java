package com.example.core_module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
@Query(value="select * from City c where c.country_id=?1",nativeQuery = true)
List<City> findBycountry_id(Long country_id);
}
