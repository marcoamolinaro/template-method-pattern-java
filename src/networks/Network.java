/**
 * Base class of social network.
 */
public abstract class Network {
    String userName;
    String password;

    Network() {}

    Network(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Publish the data to whatever network.
     */
    public boolean post(String message) {
        if (logIn(this.userName, this.password)) {
            System.out.println("Message: '" + message + "' was posted on " + getClass().getSimpleName());
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract void logOut();

    abstract boolean sendData(byte[] bytes);

    abstract boolean logIn(String userName, String password);
}
