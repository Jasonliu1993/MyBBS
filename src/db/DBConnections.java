package db;
import java.sql.*;


/**
 * Created by Jason on 2/19/17.
 */
public class DBConnections {


    public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";

        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://localhost:3306/MyBBS_DB?characterEncoding=utf8";

        // MySQL配置时的用户名
        String user = "SYSADM";

        // MySQL配置时的密码
        String password = "SYSADM";
        Connection cn = null;

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return cn;
    }

    public static Statement getStatment(Connection cn) {
        Statement stm = null;
        if (cn != null) {
            try {
                stm = cn.createStatement();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return stm;
    }

    /***
     * 执行select操作
     * @param stm
     * @param sql
     * @return
     */
    public static ResultSet excuteQuery(Statement stm, String sql) {
        ResultSet rs = null;
        if (stm != null) {
            try {
                rs = stm.executeQuery(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    /**
     * 执行insert,update,delete操作
     * @param stm
     * @param sql
     * @return
     */
    public static boolean excute(Statement stm, String sql) {
        boolean bl = false;
        try {
            bl = stm.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bl;
    }

    /*public static void close(Connection cn, Statement st, ResultSet rs) {
        try {
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/
}
