import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    List<Product> products = new ArrayList<>();

    public void addNewProduct(Product product){
        products.add(product);
    }
    public void deleteProductByCode(String codeProduct){
        Product productDelete = findProductByCode(codeProduct);
        if (productDelete != null){
            products.remove(productDelete);
        } else {
            System.out.println(codeProduct + "not found");
        }

    }
    private Product findProductByCode(String product){
        for (Product product1: products){
            if (product1.getCodeProduct().equals(product)){
                return product1;
            }
        }
        return null;
    }

    public List<Product> getProducts(){
        return products;
    }

}
