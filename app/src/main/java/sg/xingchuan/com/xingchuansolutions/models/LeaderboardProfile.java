package sg.xingchuan.com.xingchuansolutions.models;

public class LeaderboardProfile {
    private String count, imagelink, sales, name;

    public LeaderboardProfile(String count, String imagelink, String sales, String name) {
        this.count = count;
        this.imagelink = imagelink;
        this.sales = sales;
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public String getImagelink() {
        return imagelink;
    }

    public String getSales() {
        return sales;
    }

    public String getName() {
        return name;
    }
}
