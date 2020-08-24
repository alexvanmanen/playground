package mail;

public class MailSenderPlus extends MailSender {

    public void sendExtra(String text, String email) {
        //doe wat extra
        super.send(text, email);

    }

}
