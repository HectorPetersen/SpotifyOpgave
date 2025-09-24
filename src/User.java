public class User {
    protected boolean isPremium;
    protected String userName;

    User(String userName, boolean isPremium){
        this.userName = userName;
        this.isPremium = isPremium;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isPremium() {
        return isPremium;
    }
}
