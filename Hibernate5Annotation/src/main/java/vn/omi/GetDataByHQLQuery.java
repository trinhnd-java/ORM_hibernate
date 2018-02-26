package main.java.vn.omi;

import java.util.List;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GetDataByHQLQuery {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
		Root<Cart> root = query.from(Cart.class);
		query.select(root);
		Query<Cart> q=session.createQuery(query);
		List<Cart> carts=q.getResultList();

		for (Cart cart : carts) {
			System.out.print(String.format("\tID:%s " , cart.getCart_id()));
			System.out.print(String.format("\tName:%s " ,cart.getName()));
			System.out.print(String.format("\tTotal:%s " , cart.getTotal()));
			System.out.println(" =_=_=");
		}  
		

		tr.commit();
		System.out.println("Data printed : OK");
		sessFact.close();
	}
}