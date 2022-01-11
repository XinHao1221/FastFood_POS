

import java.io.Serializable;

public class Order implements Serializable{
	
	private static int orderNumber = 1000;
	int orderNo;
    private Payment payment;
    private OrderList[] orderlist;

	public Order(OrderList[] orderlist, Payment payment){
		this.orderlist = orderlist;
		this.payment = payment;
		this.orderNo = orderNumber;
		orderNumber ++;
	}
	
	public Payment getPayment(){
		return this.payment;
	}
	
	public static int getOrderNumber(){
		return orderNumber;
	}
	
	public static void setOrderNumber(int orderNumber){
		Order.orderNumber = orderNumber;
	}
	
	public String toString(){
		String o = "Order No. : " + orderNo + "\n";
		for(int i = 0; i < orderlist.length; i++){
			if(orderlist[i]!=null)
				o = o +  orderlist[i].toString() + "\n";
		}
		o = o + payment.toString();
		return o;
	}
}
