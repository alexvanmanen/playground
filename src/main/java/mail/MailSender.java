package mail;

public class MailSender {

    public final void send(String text, String email) {
        openConnection();
        authenticate();
        //send mail
        closeConnection();

    }

    private void openConnection(){
        //open connection
    }

    private void authenticate() {
        //authenticate
    }

    private void closeConnection() {
        //close connection
    }


}
