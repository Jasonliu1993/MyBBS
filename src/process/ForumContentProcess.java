package process;

import db.DBConnections;
import javabean.ForumContent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Jason on 3/1/17.
 */
public class ForumContentProcess {
    public static void setForumContent (HashMap<String, ForumContent> forumContent) {
        Connection cn = DBConnections.getConnection();
        Statement stm = DBConnections.getStatment(cn);
        for (String key : forumContent.keySet()) {
            String SQL = null;
            if ("I".equals(key)) {
                SQL = "INSERT INTO FORUMCONTENT VALUES('"
                        + forumContent.get(key).getID() + "', '"
                        + (Integer.parseInt(forumContent.get(key).getOrderID()) + 1) + "', '"
                        + forumContent.get(key).getForumContent() + "','"
                        + forumContent.get(key).getCreateDateTime() + "','"
                        + forumContent.get(key).getForumThemeID() + "','"
                        + forumContent.get(key).getCreateUser() + "')";
                System.out.println(SQL);
                if (DBConnections.excute(stm,SQL)) {
                    System.out.println("保存成功");
                }
            } else {
                SQL = "UPDATE FORUMCONTENT SET ORDERID = '"
                        + forumContent.get(key).getOrderID() + "', FORUMCONTENT = '"
                        + forumContent.get(key).getForumContent() + "', CREATEDATETIME = '"
                        + forumContent.get(key).getCreateDateTime() + "', FORUMTHEMEID = '"
                        + forumContent.get(key).getForumThemeID() + "', CREATEUSER = '"
                        + forumContent.get(key).getCreateUser() + "' WHERE ID = '"
                        + forumContent.get(key).getID() + "'";
                System.out.println(SQL);
                if (DBConnections.excute(stm,SQL)) {
                    System.out.println("保存成功");
                }
            }
        }
        try {
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static LinkedList<ForumContent> getForumContent (String forumThemeID, int curentPage, int pageLong) {
        LinkedList<ForumContent> forumContents = new LinkedList<ForumContent>();
        ForumContent forumContent = null;
        Connection cn = DBConnections.getConnection();
        Statement stm = DBConnections.getStatment(cn);
        String SQL = "SELECT * FROM FORUMCONTENT WHERE FORUMTHEMEID = '" + forumThemeID + "' ORDER BY ORDERID LIMIT " + curentPage + ", " + pageLong + "";
        System.out.println(SQL);
        ResultSet rs = DBConnections.excuteQuery(stm,SQL);
        try {
            while (rs.next()) {
                forumContent = new ForumContent();
                forumContent.setID(rs.getString("ID"));
                forumContent.setOrderID(rs.getString("ORDERID"));
                forumContent.setForumContent(rs.getString("FORUMCONTENT"));
                forumContent.setCreateDateTime(rs.getString("CREATEDATETIME"));
                forumContent.setForumThemeID(rs.getString("FORUMTHEMEID"));
                forumContent.setCreateUser(rs.getString("CREATEUSER"));
                forumContents.add(forumContent);
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
        return forumContents;
    }
}
