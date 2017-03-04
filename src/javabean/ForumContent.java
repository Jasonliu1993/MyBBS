package javabean;

/**
 * Created by Jason on 3/1/17.
 */
public class ForumContent {
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getForumThemeID() {
        return forumThemeID;
    }

    public void setForumThemeID(String forumThemeID) {
        this.forumThemeID = forumThemeID;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    private String ID;
    private String orderID;
    private String forumContent;
    private String createDateTime;
    private String forumThemeID;
    private String createUser;
}
