enum UserStatus
{
    PENDING("P"), ACTIVE("A"), INACTIVE("I"), DELETED("D");

    private String statusCode;

    private UserStatus(String s) {
        statusCode = s;
    }

    public String getStatusCode() {
        return statusCode;
    }

}
public class TestConstructor {

    public static void main(String[] args) {

        System.out.println(UserStatus.ACTIVE.getStatusCode());

    }
}
