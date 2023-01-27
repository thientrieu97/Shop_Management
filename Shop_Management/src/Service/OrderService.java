package Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Entity.Order;
import Entity.Product;
import Interface.IOrder;
import main.App;

public class OrderService implements IOrder {
    public static List<Order> listOrders = new ArrayList<>();

    public Order createOrder() {
        Order order = new Order();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        order.setCustomerId("C" + Integer.toString(ProductService.randomProductId(100,999)));
        order.setOrderId("O" + Integer.toString(ProductService.randomProductId(100,999)));
        order.setDateCreate(dtf.format(now));
        System.out.println("Enter customerId: " + order.getCustomerId());
        order.setCustomerName(App.scanner.nextLine());
        System.out.print("Enter Address: ");
        order.setCustomerAddress(App.scanner.nextLine());
        System.out.print("Enter productId: ");
        order.setProductId(App.scanner.nextInt());
        System.out.print("Enter quantity: ");
        order.setQuantity(App.scanner.nextInt());
        return order;
    }

    @Override
    public void createListOrder() {
        listOrders.add(createOrder());
    }

    public void showAll() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "Order ID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Price");
        HashMap<Integer, Product> mapProduct = new HashMap<>();
        for (int i = 0; i < ProductService.listProducts.size(); i++) {
            mapProduct.put(ProductService.listProducts.get(i).getId(),ProductService.listProducts.get(i) );
        }
        listOrders.forEach(order -> {
            Product product = mapProduct.get(order.getProductId());
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15.2f\n",order.getCustomerId(),order.getOrderId(), order.getCustomerName(), order.getProductId(), product.getName(),order.getDateCreate(),order.getCustomerAddress(),order.getQuantity(), product.getPrice());

        });
    }

    @Override
    public void inforOrderByOrderId() {
        showAll();
        System.out.println("Enter orderid");
        String orderId = App.scanner.nextLine();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "Order ID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Price");
        HashMap<Integer, Product> mapProduct = new HashMap<>();
        for (int i = 0; i < ProductService.listProducts.size(); i++) {
            mapProduct.put(ProductService.listProducts.get(i).getId(),ProductService.listProducts.get(i) );
        }
        listOrders.forEach(order -> {
            if(order.getOrderId() == orderId) {
                Product product = mapProduct.get(order.getProductId());
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15.2f\n",order.getCustomerId(),order.getOrderId(), order.getCustomerName(), order.getProductId(), product.getName(),order.getDateCreate(),order.getCustomerAddress(),order.getQuantity(), product.getPrice());
            }
            
        });
        
    }

    @Override
    public void showAllOrderByCustomerId() {
        showAll();
        System.out.println("Enter customerId");
        String customerId = App.scanner.nextLine();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "Order ID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Price");
        HashMap<Integer, Product> mapProduct = new HashMap<>();
        for (int i = 0; i < ProductService.listProducts.size(); i++) {
            mapProduct.put(ProductService.listProducts.get(i).getId(),ProductService.listProducts.get(i) );
        }
        listOrders.forEach(order -> {
            if(order.getCustomerId() == customerId) {
                Product product = mapProduct.get(order.getProductId());
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15.2f\n",order.getCustomerId(),order.getOrderId(), order.getCustomerName(), order.getProductId(), product.getName(),order.getDateCreate(),order.getCustomerAddress(),order.getQuantity(), product.getPrice());
            }
            
        } );
        
    }
    
}
