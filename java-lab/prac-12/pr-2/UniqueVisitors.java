
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = Arrays.asList(
                "shivam", "jeel", "rahul", "shivam",
                "priya", "jeel", "amit"
        );

        HashSet<String> uniqueUsers = new HashSet<>(logins);

        LinkedHashSet<String> orderedUsers =
                new LinkedHashSet<>(logins);

        System.out.println("Unique visitor count: " + uniqueUsers.size());

        System.out.println("First three distinct names:");

        int count = 0;

        for (String user : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(user);
            count++;
        }
    }
}
