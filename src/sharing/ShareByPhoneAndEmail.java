package sharing;

public class ShareByPhoneAndEmail implements Shareable {
    @Override
    public void share() {
        System.out.println("Sharing ticket by phone and email...");
    }
}
