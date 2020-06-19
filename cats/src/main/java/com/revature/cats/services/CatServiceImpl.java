package com.revature.cats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.revature.cats.exceptions.CatNotFoundException;
import com.revature.cats.models.Cat;
import com.revature.cats.repositories.CatRepository;


@Service
@Primary
public class CatServiceImpl implements CatService {

  @Autowired
  CatRepository catRepository;

  @Override
  public List<Cat> getAll() {
    // TODO Auto-generated method stub
    return catRepository.findAll();
  }

  @Override
  public Cat getById(Integer id) {
    Optional<Cat> cat = catRepository.findById(id);
    if (cat.isPresent()) {
      return cat.get();
    } else {
      throw new CatNotFoundException();
    }
  }

  @Override
  public Cat create(Cat cat) {
    cat.setCatId(0);
    return catRepository.save(cat);
  }

  @Override
  public Cat update(Cat cat) {
    Optional<Cat> existingCat = catRepository.findById(cat.getCatId());
    if (existingCat.isPresent()) {
      return catRepository.save(cat);
    } else {
      throw new CatNotFoundException();
    }
  }

  @Override
  public Cat createOrUpdate(Cat cat) {
    return catRepository.save(cat);
  }

  @Override
  public void delete(Integer id) {
    catRepository.deleteById(id);

  }

}
