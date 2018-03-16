package eshop.model;

/**
 * Class contains information about user.
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public class User {

    private String password;

    private String username;

    private String firstName;

    private String lastName;

    private int age;

    private String activity;

    /**
     * Instantiates a new User.
     * @param username user name
     * @param password password
     * @param firstName first name
     * @param lastName last name
     * @param age user  age
     * @param activity activity
     */
    public User(String username, String password, String firstName, String lastName, int age, String activity) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.activity = activity;
    }

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * gets password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * gets user name
     * @return user name
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets user name
     * @param username user name
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * gets first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets first name
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets last name
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets userage
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets user age
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * gets user activity
     * @return activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * sets user activity
     * @param activity activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

}
