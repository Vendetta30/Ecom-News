package ecom.news

import com.Role
import com.User
import com.UserRole

import java.util.concurrent.ThreadLocalRandom

class CreateRecordService {

    static transactional = false
    def sessionFactory

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz";

    def createUser() {
        Role role = Role.findByAuthority("ROLE_USER")
        List batch = new ArrayList()
        for (int i = 0; i < 1000; i++) {
            char[] first = generateRandomString().toCharArray()
            char[] last = generateRandomString().toCharArray()
            char[] firstName = []
            char[] lastName = []

            if (String.valueOf(first).matches("([a-zA-Z]{3,30}\\s*)+")) {
                firstName = first
            } else {
                firstName = String.valueOf(first).substring(1, 5).toCharArray()
            }

            if (String.valueOf(last).matches("[a-zA-Z]{3,30}")) {
                lastName = last
            } else {
                lastName = String.valueOf(last).substring(1, 5).toCharArray()
            }

            User person = new User(username: "${String.valueOf(firstName)}@${String.valueOf(lastName)}.com",
                    firstName: String.valueOf(firstName), lastName: String.valueOf(lastName), password: "123456")

            batch.add(person)

        }
        if (batch.size() > 500) {
            User.withTransaction {
                for (User user : batch) {
                    user.save()
                    UserRole.create(user, role, false)
                }
                batch.clear()
            }
            sessionFactory.getCurrentSession().clear();
        }
        for (User user : batch) {
            user.save()
            UserRole.create(user, role, false)
        }
    }

    public String generateRandomString() {
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(3, 7); i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    String generateComments(String comments) {
        NonsenseGenerator generator = NonsenseGenerator.instance
        comments = generator.makeSentence(true) + ". "
        String withoutSpace = comments
        while (comments.length() < 300) {
            println("comments ${comments}")
            comments += generator.makeSentence(false) + ". "
        }
        comments
    }
}
