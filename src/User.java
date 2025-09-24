public class User {
    private boolean isPremium;
    private String userName;

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
