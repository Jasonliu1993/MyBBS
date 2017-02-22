package process;

import db.DBConnections;
import javabean.LoginData;
import java.util.HashMap;
import java.sql.*;

/**
 * Created by Jason on 2/19/17.
 */
public class LoginDataProcess {
    public static void setLoginData(HashMap<String,LoginData> loginDataHashMap) {
        Connection cn = DBConnections.getConnection();

        Statement stm = DBConnections.getStatment(cn);

        for (String key : loginDataHashMap.keySet()) {
            /***
             * 如果没有key值,则插入数据
             */
            if (key.equals("I")) {
                String SQL = "INSERT INTO LOGINDATA VALUES('" + loginDataHashMap.get("I").getName() + "','"
                            + loginDataHashMap.get("I").getPassword() +"',"+ loginDataHashMap.get("I").getVersion() + ",'"
                            + loginDataHashMap.get("I").getLastLoginDate() + "', '" + loginDataHashMap.get("I").getRegisterDate() + "', " +
                            "'" + loginDataHashMap.get("I").getLastModification() + "')";

                    System.out.println(SQL);

                    if (DBConnections.excute(stm, SQL)) {
                        System.out.println("保存成功!");
                    }

            } else {
                /***
                 *如果有key值则直接更新
                 */
                String SQL = "UPDATE LOGINDATA "
                            + "SET VERSION = " + (loginDataHashMap.get("key").getVersion() + 1 )
                            + ", PASSWORD = '" + loginDataHashMap.get("key").getPassword()
                            + "', LASTMODIFICATION = '" + loginDataHashMap.get("key").getLastModification()
                            + "' WHERE KEYID = '" + loginDataHashMap.get("key").getName() + "'";

                System.out.println(SQL);

                if (DBConnections.excute(stm, SQL)) {
                    System.out.println("保存成功!");
                }
            }
        }
        /***
         * 关闭连接
         */
        try {
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static LoginData getLoginDate(String userName) {
        LoginData loginData = new LoginData();
        Connection cn = DBConnections.getConnection();
        Statement stm = DBConnections.getStatment(cn);
        String SQL = "SELECT * FROM LOGINDATA WHERE NAME = '" + userName + "'";
        ResultSet rs = DBConnections.excuteQuery(stm,SQL);
        try {
            while(rs.next()) {
                loginData.setName(rs.getString("NAME"));
                loginData.setPassword(rs.getString("PASSWORD"));
                loginData.setVersion(rs.getInt("VERSION"));
                loginData.setRegisterDate("REGISTERDATE");
                loginData.setLastLoginDate("LASTLOGINDATE");
                loginData.setLastModification("LASTMODIFICATION");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stm.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return loginData;
    }
}
