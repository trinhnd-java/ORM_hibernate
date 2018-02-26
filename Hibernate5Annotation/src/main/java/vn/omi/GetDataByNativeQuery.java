package main.java.vn.omi;


import java.util.List;

import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.query.Query;

public class GetDataByNativeQuery {
    public static void main(String[] args) throws Exception {

        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CT.cart_id , CT.name , CT.total , IT.item_id , IT.item_total , IT.quantity");
        sql.append(" FROM Cart as CT ");
        sql.append(" Join Items as IT where CT.cart_id = IT.cart_id ");
        Query query = session.createNativeQuery(String.valueOf(sql));
        List<Object[]> it = query.getResultList();
        for (Object[] items : it) {
            System.out.print(String.format("ID:%s", items[0]));
            System.out.print(String.format("\tName:%s", items[1]));
            System.out.print(String.format("\tTotal:%s", items[2]));
            System.out.print(String.format("\tItem_id:%s", items[3]));
            System.out.print(String.format("\tItem_total:%s", items[4]));
            System.out.print(String.format("\tQuantity:%s", items[5]));
            System.out.println(" x x x");
        }


        tr.commit();
        System.out.println("Data printed : DONE");
        sessFact.close();
    }
}