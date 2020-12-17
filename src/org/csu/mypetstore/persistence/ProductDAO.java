package org.csu.mypetstore.persistence;

import java.util.List;
import org.csu.mypetstore.domain.Product;

public interface ProductDAO {
    List<Product>getProductListByCategory(String categoryId);
    Product getProduct(String productId);
    List<Product>searchProductList(String keywords);
}
