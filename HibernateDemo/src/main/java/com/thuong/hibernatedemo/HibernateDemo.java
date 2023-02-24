/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.thuong.hibernatedemo;

import com.thuong.pojo.Category;
import com.thuong.pojo.Product;
import com.thuong.repository.ProductRepository;
import com.thuong.repository.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author thuon
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        try ( // Mở
//            Session s = HibernateUtils.getFactory().openSession()) {
//            Query q = s.createQuery("From Category");
//            List<Category> cates = q.getResultList();
//            cates.forEach(c -> System.out.println(c.getName()));
//        } 

        ProductRepository p = new ProductRepositoryImpl();
        Map<String,String> params = new HashMap<>();
        params.put("kw","ipad");
        List<Product> products = p.getProducts(params);
        products.forEach(x-> System.out.printf("%d - %s - %.1f\n"
                ,x.getId(),x.getName(),x.getPrice()));
        
    }
}
