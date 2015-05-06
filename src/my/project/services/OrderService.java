package my.project.services;

import java.util.List;

import my.project.business_classes.Order;
import my.project.business_classes.OrderItem;
import my.project.dao.OrderDao;
import my.project.exceptions.DaoException;

public class OrderService {
	
private OrderDao orderDao;
	
	public OrderService(OrderDao orderDao){
		this.orderDao = orderDao;
	}
	
	public OrderService(){
		this.orderDao = new OrderDao();
	}
	
	// CUSTOMER ORDER GETTING INFO FOR ORDERR TABLE.........CUSTOMERID.................................
	
	public Order order(int id){
			
			Order o = null;
			
			try{ 
				//OrderDao dao = new OrderDao();
				o = orderDao.CreateOrder(id);
			}
			catch (DaoException e) {
				e.printStackTrace();
			}
			
			return o;
		}
	
	// CUSTOMER ORDER GETTING INFO FOR THE ORDERITEM TABLE...............ORDERID & PRODUCTID.........................

		public OrderItem order1(int id2, int id1){
			
			OrderItem oi = null;
			
			try{ 
				//OrderDao dao = new OrderDao();
				oi = orderDao.CreateOrderItem(id1, id2);
			}
			catch (DaoException e) {
				e.printStackTrace();
			}
			
			return oi;
		}
		
		// FOR ADMIN USER TO SEE WHAT CUSTOMER ORDERED WHAT, ADVANCED SQKL USED..........CUSTID......................
		
		public List<Order> getAllCustomerOrders(int id){
			
				List<Order> o = null;
				
					try{ 
						//OrderDao dao = new OrderDao();
						o = orderDao.getOrder(id);
					}
					catch (DaoException e) {
						e.printStackTrace();
					}
				
				return o;
		}
		
		
		// FOR ADMIN USER HERE TO DELETE THE ORDER AFTER BEING REVIEWED............PRODID & ORDERID..............................
		
			public int deleteOrder(int pid, int oid){
						
						int o = 0;
						
						try{ 
							//OrderDao dao = new OrderDao();
							o = orderDao.DeleteOrder(pid, oid);
						}
						catch (DaoException e) {
							e.printStackTrace();
						}
						
						return o;
					}

}

