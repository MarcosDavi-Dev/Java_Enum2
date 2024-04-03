package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.HashMap;
import java.util.Locale;
//import java.util.Map;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Map<Integer, OrderStatus> oderStatus = new HashMap<>();
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date: (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Choose the status: 0-Pending payment | 1-Processing | 2-Shipped | 3-Delivered: ");
		int statusNumber = sc.nextInt();
		
		//OrderStatus status = OrderStatusConverter.convertIntToOrderStatus(statusNumber);
		OrderStatus status = OrderStatus.valueOf(statusNumber);
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++){
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("Order summary: ");
		System.out.println(order);
		
		sc.close();
	}
	
	/*public static class OrderStatusConverter {
	    public static OrderStatus convertIntToOrderStatus(int number) {
	        switch (number) {
	            case 0:
	                return OrderStatus.PENDING_PAYMENT;
	            case 1:
	                return OrderStatus.PROCESSING;
	            case 2:
	                return OrderStatus.SHIPPED;
	            case 3:
	                return OrderStatus.DELIVERED;
	            default:
	                throw new IllegalArgumentException("Número de status de pedido inválido: " + number);
	        }
	    }
}*/
}
