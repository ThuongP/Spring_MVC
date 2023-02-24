/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thuong.repository.impl;

import com.thuong.hibernatedemo.HibernateUtils;
import com.thuong.pojo.Product;
import com.thuong.repository.ProductRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author thuon
 */
public class ProductRepositoryImpl implements ProductRepository{

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernateUtils.getFactory().openSession()){ 
           // Truy vấn dữ liệu _ chứa biểu thức truy vấn
            CriteriaBuilder b = s.getCriteriaBuilder();
            // Tạo đối tượng truy vấn
            CriteriaQuery <Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            String kw = params.get("kw");
            if(kw != null && ! kw.isEmpty()){
                Predicate p1 = b.like(root.get("name")
                        .as(String.class),String.format("%%%s%%",kw));
                q.where(p1);
            }
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
    
}
