package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;



public class Main {
    public static void main(String[] args) {
//        SessionFactory factory = new Configuration().buildSessionFactory();
//        Session session = factory.getCurrentSession();
//
//        User user = new User("Максим", "Суханов", (byte) 33);
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();



//        UserDaoHibernateImpl studentDao = new UserDaoHibernateImpl();
//
//        User user = new User("Max", "Sukhanov", (byte) 33);
//            UserDaoHibernateImpl.saveUser(user);
//
//        System.out.println(user.getId());








        // реализуйте алгоритм здесь
        Connection connection = Util.getConnection();


        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Максим", "Суханов", (byte) 33);
        userDao.saveUser("Егор", "Пирожков", (byte) 28);
        userDao.saveUser("Герман", "Катов", (byte) 30);
        userDao.saveUser("Морти", "Риков", (byte) 52);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();


        try {
            Util.getConnection().close();
            System.out.println("Соединение с БД закрыто");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
