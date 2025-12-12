package com.demo.SpringbootMVCProductCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.SpringbootMVCProductCrud.beans.Product;


@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

}
