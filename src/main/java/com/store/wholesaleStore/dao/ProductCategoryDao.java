package com.store.wholesaleStore.dao;

import com.store.wholesaleStore.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

}
