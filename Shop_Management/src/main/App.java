package main;

import java.util.Scanner;

import Service.OrderService;
import Service.ProductService;


public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1. Add a new product to the Store.");
            System.out.println("2. Update price for a particular product");
            System.out.println("3. A list of all available products in the Store");
            System.out.println("4. Create a new Order");
            System.out.println("5. Printf information of an Order by OrderID");
            System.out.println("6. Sort all products by product price as ascending");
            System.out.println("7. Print information of all Orders by a specific customer ID");
            System.out.println("8. Print information of all Orders");
            System.out.println("9. Exit");
            System.out.print("Seclect your choice: ");
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 1:
                    productService.createListProduct();
                    break;
                case 2:
                    productService.updatePriceProduct();
                    break;
                case 3:
                    productService.listAllProduct();
                    break;
                case 4:
                   
                    orderService.createListOrder();
                    break;
                case 5:
                    
                    orderService.inforOrderByOrderId();
                    break;
                case 6:
                    productService.sortPriceProductAsc();
                    break;
                case 7:
                  
                    orderService.showAllOrderByCustomerId();
                    break;
                case 8:
                   
                    orderService.showAll();
                    break;
                case 9:
                    return;
            }
        } while (true);
    }
}

