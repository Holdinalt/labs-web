package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class HitDao {

    public HitStorageBD findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(HitStorageBD.class, id);
    }

    public void save(HitStorageBD user) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
        }catch (Exception e){
            System.out.println("problems with save");
        }
    }

    public void update(HitStorageBD user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(HitStorageBD user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }


    public List<HitStorageBD> findAll() throws Exception {
        List<HitStorageBD> Hits = null;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Hits = (List<HitStorageBD>)  session.createQuery("From HitStorageBD").list();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
            //throw new Exception("Something wrong with FIND ALL" );
        }
        return Hits;
    }

    public void deleteAll() throws Exception {
        List<HitStorageBD> Hits = findAll();
        for (HitStorageBD hitResult : Hits) {
            delete(hitResult);
        }
    }
}
