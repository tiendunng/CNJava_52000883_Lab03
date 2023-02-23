import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Create the student object.
        Users user = new Users();

        //Setting the object properties.
        user.setUserName("AAA");
        user.setPassword("AAA@123");
        user.setCreateDate(new Date());
        user.setCreateUser("TI");

        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            //Start hibernate session.


            System.out.println("Ads");
            tx = session.beginTransaction();

            //Insert a new student record in the database.
            session.save(user);

            //Commit hibernate transaction if no exception occurs.
            tx.commit();
            System.out.println("Saved Successfully.");
        } catch (HibernateException e) {
            if (tx != null) {
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //Close hibernate session.
            session.close();
        }
    }
}