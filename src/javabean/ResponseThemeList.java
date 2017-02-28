package javabean;

/**
 * Created by Jason on 2/26/17.
 */
public class ResponseThemeList {
    public String getThemeID() {
        return themeID;
    }

    public void setThemeID(String themeID) {
        this.themeID = themeID;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    private String themeID;
    private String theme;
    private String currentPage;
    private String totalPage;

    @Override
    public String toString() {
        return "ResponseThemeList [themeID=" + themeID + ", theme=" + theme + ", currentPage="
                + currentPage + "]";
    }
}
