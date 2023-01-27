package Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import Entity.Product;
import Interface.IProduct;
import main.App;

public class ProductService implements IProduct {

    public static List<Product> listProducts = new ArrayList<>();

    public static int randomProductId(int min, int max) {
        Random random = new Random();
        int randomId = random.nextInt(max - min + 1) + min;
        return randomId;
    }

    public Product createProduct() {
        Product product = new Product();
        product.setId(randomProductId(100, 999));
        System.out.println("Product id : " + product.getId());
        System.out.print("Enter name: ");
        String name = App.scanner.next();
        product.setName(name);
        System.out.print("Enter price: ");
        product.setPrice(App.scanner.nextDouble());
        return product;
    }

    @Override
    public void createListProduct() {
        listProducts.add(createProduct());
    }

    @Override
    public void updatePriceProduct() {
        listAllProduct();
        System.out.println("Enter product Id");
        int productId = App.scanner.nextInt();
        listProducts.forEach(product -> {
            if (product.getId() == productId) {
                System.out.println("Enter price:");
                product.setPrice(App.scanner.nextDouble());
            }
        });

    }

    @Override
    public void listAllProduct() {
        listProducts.forEach(product -> {
            System.out.println(product.toString());
        });
        
        

    }

    @Override
    public void sortPriceProductAsc() {
        List<Product> listSortProduct = listProducts.stream().sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        listSortProduct.forEach(product -> {
            System.out.println(product.toString());
        });

    }

}
