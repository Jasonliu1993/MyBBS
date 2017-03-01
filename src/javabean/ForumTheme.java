package javabean;

/**
 * Created by Jason on 2/28/17.
 */
public class ForumTheme {
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getForumTheme() {
        return ForumTheme;
    }

    public void setForumTheme(String forumTheme) {
        ForumTheme = forumTheme;
    }

    public String getPostDatetime() {
        return PostDatetime;
    }

    public void setPostDatetime(String postDatetime) {
        PostDatetime = postDatetime;
    }

    public String getForumCreater() {
        return ForumCreater;
    }

    public void setForumCreater(String forumCreater) {
        ForumCreater = forumCreater;
    }

    public String getForumContentID() {
        return ForumContentID;
    }

    public void setForumContentID(String forumContentID) {
        ForumContentID = forumContentID;
    }
    private String ID;
    private String ForumTheme;
    private String PostDatetime;
    private String ForumCreater;
    private String ForumContentID;
}
