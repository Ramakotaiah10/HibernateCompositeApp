package com.rama.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.Embeddable;

import com.rama.dao.ProductDao;
import com.rama.dao.ProductDaoImpl;
import com.rama.entity.Product;
import com.rama.entity.ProductCompositePK;

public class Main {

	public static void main(String[] args) {
	
		ProductDao dao=new ProductDaoImpl();
		//1.create @Embeddable class for composite primary keys  
		//ProductCompositePK compositePk=new ProductCompositePK();
		//compositePk.setPdrouctId(3);
		//compositePk.setProcustCategory("Electonics");
	
		//2.create product class  
		//Product p=new Product();
		//p.setPkId(compositePk);
		//p.setProductName("Air Conditioner");
		//p.setProductPrice(45000.0);
			
		//3.save product in database table 
		//if(dao.saveProduct(p)){	
		//   System.out.println("New Product is Created");
		//}
		//else{
		//   System.out.println("Product Already Exist");
		//}
	    
		//4.set the values for id and category in productcompositepk
		//by using these we can we can fetch the product from database table. 
		ProductCompositePK getPk=new ProductCompositePK();
		getPk.setPdrouctId(1);
		getPk.setProcustCategory("Clothes");
		
		Product fetchProduct = dao.fetchProduct(getPk);
		System.out.println(fetchProduct);
		
		//5. get product list from the database table 
		//List<Product> productList = dao.ProductList();
		List<Product> productList = dao.ProductList();
		Iterator<Product> it = productList.iterator();

        while (it.hasNext()) {
            Product product = (Product) it.next();
            System.out.println(product.toString());

        }
        System.out.println("==============================================================================");
        System.out.println("Sort by Product Price");        
        productList.stream()
        .sorted(Comparator.comparing(Product::getProductPrice)).forEach(System.out::println);
        
        System.out.println("==============================================================================");
        System.out.println("Grouping Products By Category"); 
        Map<ProductCompositePK, List<Product>> groupingByCategory = productList.stream()
        .collect(Collectors.groupingBy(Product::getPkId));    
        System.out.println(groupingByCategory);
        
        groupingByCategory.forEach((primarykey, Productlst) ->{
        	
        	Productlst.forEach(System.out::println);
        	//System.out.println(primarykey.get);
        });
        
        
        
        //for (Product pro: productList){
		//System.out.println(pro.getPkId()+" || "+pro.getProductName()+" || "+pro.getProductPrice());		
		//}
		
		
	}

}
