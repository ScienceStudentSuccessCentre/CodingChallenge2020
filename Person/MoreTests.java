import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
     * Below is a class Person. Each Person has an ID as well as zero or one friend. 
     * 
     * Friendship is one-way, so if Janet is assigned to be Sarah’s friend, Janet must be 
     * friendly to Sarah, but Sarah is not required to reciprocate.
     * 
     * Sometimes, a ‘circle of friends’ occurs. For example, if Marc is assigned Fred,
     * Fred is assigned Lori, Lori is assigned Jean, and Jean assigned Marc, we have a circle of 4 friends
     * containing Marc, Fred, Lori, and Jean. In the circle, we can say that Marc has a separation of 1
     * from Fred, of 2 from Lori, of 3 from Jean, and of 4 from Marc (Like on LinkedIn).
     * 
     * Part 1:
     * Complete the isInFriendCircleWith(Person) method. 
     * 
     * Part 2:
     * Complete the separationFrom(Person) method. 
     */

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        System.out.println("All test cases passed!");
    }

    public static void testCase1() {
        // Here is a simple test case
        Person marc = new Person(1);
        Person fred = new Person(2);
        Person lori = new Person(3);
        Person jean = new Person(4);

        marc.friend = fred;
        fred.friend = lori;
        lori.friend = jean;
        jean.friend = marc;

        if (!marc.isInFriendCircleWith(fred) || 
            !marc.isInFriendCircleWith(jean) || 
            !jean.isInFriendCircleWith(fred))
                throw new IllegalStateException("Didn't pass test case 1!");

        if (marc.separationFrom(fred) != 1 ||
            marc.separationFrom(jean) != 3 ||
            jean.separationFrom(fred) != 2)
                throw new IllegalStateException("Didn't pass test case 2!");
    }

    public static void testCase2() {
        // Setup
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            people.add(new Person(i));
        }
        for (int i = 0; i < 999; i++) {
            people.get(i).friend = people.get(i+1);
        }
        people.get(999).friend = people.get(0);

        // Test
        for (int i = 0; i < 1000; i++) {
            if (!people.get(123).isInFriendCircleWith(people.get(i))) {
                throw new IllegalStateException("Didn't pass test case 2.1!");
            }
            if (people.get(777).separationFrom(people.get(i)) != (i-777 + 1000) % 1000)
                throw new IllegalStateException("Didn't pass test case 2.2!");
        }
        if (people.get(321).isInFriendCircleWith(new Person()))
            throw new IllegalStateException("Didn't pass test case 2.3!");
        if (people.get(654).separationFrom(new Person() != -1))
            throw new IllegalStateException("Didn't pass test case 2.4!");
    }

    public static void testCase3() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            people.add(new Person(i));
        }

        people.get(0).friend = people.get(0);
        if (!people.get(0).isInFriendCircleWith(people.get(0)))
            throw new IllegalStateException("Didn't pass test case 3.1!");

        if (people.get(1).separationFrom(people.get(10)) != -1)
            throw new IllegalStateException("Didn't pass test case 3.2!");

        // No time to write more cases rip
    }

}

class Person {
    int id;
    Person friend;

    public Person(int id) {
        this.id = id;
        this.friend = null;
    }
    public Person(int id, Person friend) {
        this.id = id;
        this.friend = friend;
    }

    /**
     * Returns true if this Person is in a friend circle with Person other, or false otherwise.
     */
    public boolean isInFriendCircleWith(Person other) {
        if (this == other) return true;

        // TODO Step 1: implement this
        return true;
    }

    /**
     * Returns the separation of this Person from Person other. 
     * 0 means this == other, 1 means this Person's friend == other, 
     * 2 means other is a friend of this Person's friend.
     */
    public int separationFrom(Person other) {
        if (!isInFriendCircleWith(other)) return -1;

        // TODO Step 2: implement this
        return 12345;
    }
}
