package org.shoppingdemon.dao;

import org.shoppingdemon.entity.Product;
import org.shoppingdemon.model.PaginationResult;
import org.shoppingdemon.model.ProductInfo;

public interface ProductDAO {
 
    public Product findProduct(String code);
    
    public ProductInfo findProductInfo(String code) ;
  
    
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);
 
    public void save(ProductInfo productInfo);
    
}