package sharing;

public class ShareByPhone implements Shareable {
    @Override
    public void share() {
        System.out.println("Sharing ticket by phone...");
    }
}
