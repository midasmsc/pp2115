package jm.task.core.jdbc;

import java.util.logging.Logger;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl usimpl = new UserServiceImpl();

        usimpl.createUsersTable();
        usimpl.saveUser("Максим", "Суханов", (byte) 33);
        usimpl.saveUser("Егор", "Пирожков", (byte) 28);
        usimpl.saveUser("Герман", "Катов", (byte) 30);
        usimpl.saveUser("Морти", "Риков", (byte) 52);

        usimpl.removeUserById(1);
        usimpl.getAllUsers();
        usimpl.cleanUsersTable();
        usimpl.dropUsersTable();

        Logger logger = Logger.getLogger("MainLogger");

        Connection connection = Util.getConnection();

        try {
            Util.getConnection().close();
            logger.info("Соединение с БД закрыто");
        } catch (
                SQLException e) {
            logger.warning("Ошибка закрытия соединения с БД");
            throw new RuntimeException(e);
        }
    }
}
