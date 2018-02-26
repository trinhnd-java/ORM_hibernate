package main.java.vn.omi;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.entity.Items;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InsertData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		Cart cart = new Cart();
		cart.setName("Trinhnd");
		cart.setTotal(1001);
		session.save(cart);

		Items items = new Items();
		items.setItem_total(111111);
		items.setItem_id(12);
		items.setQuantity(222222);
		items.setCart(cart);
		session.save(items);

		tr.commit();
		System.out.println("Successfully OK");
		sessFact.close();
	}

}