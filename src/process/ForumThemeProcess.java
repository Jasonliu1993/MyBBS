package process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;

import db.DBConnections;
import javabean.ForumTheme;
import utility.KeyValue;

/**
 * Created by Jason on 2/28/17.
 */
public class ForumThemeProcess {
    public static void setForumThmee (HashMap<String,ForumTheme> forumThemeHashMap) {

        Connection cn = DBConnections.getConnection();
        Statement stm = DBConnections.getStatment(cn);
        for (String key : forumThemeHashMap.keySet()) {
            String SQL = null;
            if ("I".equals(key)) {
                SQL = "INSERT INTO FORUMTHEME VALUES('"
                        + forumThemeHashMap.get(key).getID() + "','"
                        + forumThemeHashMap.get(key).getForumTheme() + "','"
                        + forumThemeHashMap.get(key).getPostDatetime() + "','"
                        + forumThemeHashMap.get(key).getForumCreater() + "','"
                        + forumThemeHashMap.get(key).getForumContentID() + "')";
                if (DBConnections.excute(stm,SQL)) {
                    System.out.println("保存成功");
                }
            } else {
                SQL = "UPDATE FORUMTHEME SET FORUMTHEME = '"
                        + forumThemeHashMap.get(key).getForumTheme() + "', POSTDATETIME = '"
                        + forumThemeHashMap.get(key).getPostDatetime() + "', FORUMCREATER = '"
                        + forumThemeHashMap.get(key).getForumCreater() + "', FORUMCONTENTID = '"
                        + forumThemeHashMap.get(key).getForumContentID() + "' WHERE ID = '"
                        + forumThemeHashMap.get(key).getID() + "'";
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
    public static ForumTheme getForumTheme (String keyID) {
        ForumTheme forumTheme = new ForumTheme();
        String SQL = "SELECT * FROM FORUMTHEME WHERE ID = '" + keyID + "'";
        Connection cn = DBConnections.getConnection();
        Statement stm = DBConnections.getStatment(cn);
        ResultSet rs = DBConnections.excuteQuery(stm,SQL);
        try {
            while (rs.next()) {
                forumTheme.setID(rs.getString("ID"));
                forumTheme.setForumTheme(rs.getString("FORUMTHEME"));
                forumTheme.setPostDatetime(rs.getString("POSTDATETIME"));
                forumTheme.setForumCreater(rs.getString("FORUMCREATER"));
                forumTheme.setForumContentID(rs.getString("FORUMCONTENTID"));
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
        return forumTheme;
    }
    public static LinkedList<ForumTheme> getForumTheme (int curentPage,int pageLong) {
        LinkedList<ForumTheme> forumThemes = new LinkedList<ForumTheme>();
        ForumTheme forumTheme = null;
        String SQL = "SELECT * FROM FORUMTHEME ORDER BY POSTDATETIME DESC LIMIT " + curentPage + ", " + pageLong + "";
        Connection cn = DBConnections.getConnection();
        Statement stm = DBConnections.getStatment(cn);
        ResultSet rs = DBConnections.excuteQuery(stm,SQL);
        try {
            while (rs.next()) {
                forumTheme = new ForumTheme();
                forumTheme.setID(rs.getString("ID"));
                forumTheme.setForumTheme(rs.getString("FORUMTHEME"));
                forumTheme.setPostDatetime(rs.getString("POSTDATETIME"));
                forumTheme.setForumCreater(rs.getString("FORUMCREATER"));
                forumTheme.setForumContentID(rs.getString("FORUMCONTENTID"));
                forumThemes.add(forumTheme);
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
        return forumThemes;
    }
}
