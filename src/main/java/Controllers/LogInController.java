package Controllers;

import Modules.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static Controllers.DatabaseManager.*;

public class LogInController extends DatabaseManager{
    private final String loginSQL = "SELECT * \n" +
            "FROM account\n" +
            "WHERE user_name=? AND password=?;";

    public Account login(String user_name, String password){
        try{
            Connection connection = getConnection();
            PreparedStatement ppsm = connection.prepareStatement(loginSQL);
            ppsm.setString(1, user_name);
            ppsm.setString(2, Account.hashPassword(password));
            ResultSet set = ppsm.executeQuery();
            set.next();

            System.out.println("Login succeeded");
            return new Account(set.getString(1), Account.AccountType.valueOf(set.getString(2).toUpperCase()), set.getString(3), set.getString(4),  set.getString(5) , Account.Race.valueOf(set.getString(6).toUpperCase()));
        }catch (SQLException e){
            System.out.println("Login failed" + e.toString());
        }
        return null;
    }

    @Override
    public TableState getAll() {
        return null;
    }
}
