package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment = new Date();
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem oderItem){
		items.add(oderItem);
	}
	
	public void removeItem(OrderItem oderItem){
		items.remove(oderItem);
	}
	
	public double total(){
		double sum = 0.0;
		for(OrderItem item: items){
			sum += item.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Oder moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: ");
		for(OrderItem item : items ){
			sb.append(item + "\n");
		}
		sb.append("Total price: US$");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
	
}
