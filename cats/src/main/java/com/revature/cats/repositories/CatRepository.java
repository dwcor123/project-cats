package com.revature.cats.repositories;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.cats.models.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer>{
  
  Cat findByName(String name);
  
  @Query("select c from Cat c order by c.catId")
  List<Cat> findAllSorted();
  
  @Query("select c from Cat c where c.name in :catNames")
  List<Cat> findCatsWithNamesInSet(Set<String> catNames);
}
