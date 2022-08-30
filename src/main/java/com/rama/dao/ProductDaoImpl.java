package com.rama.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.rama.entity.Product;
import com.rama.entity.ProductCompositePK;


public class ProductDaoImpl implements ProductDao {

	static SessionFactory sessionFactory;
	
	static{
		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata=new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		sessionFactory = metadata.buildSessionFactory();	
		}
	
	public boolean saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		try {
			session.save(product);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
			return false;	
		}
		finally{
			session.close();
		}
	}
   
	public Product fetchProduct(ProductCompositePK pkId) {
		Session session = sessionFactory.openSession();    
		Product product = session.get(Product.class, pkId);
		session.close();
		return product;
	}

	@SuppressWarnings("deprecation")
	public List<Product> ProductList() {
		Session session=sessionFactory.openSession();
	Criteria cri =session.createCriteria(Product.class);
		List<Product> products = cri.list();
	
		return products;
	}

}
