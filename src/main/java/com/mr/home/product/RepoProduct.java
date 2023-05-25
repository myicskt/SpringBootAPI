package com.mr.home.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProduct extends JpaRepository<EntityProduct, Integer> {

}
