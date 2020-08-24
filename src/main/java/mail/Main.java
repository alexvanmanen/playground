package mail;

public class Main {

    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        mailSender.send("hallo", "alex@vanmanenit.nl");

        MailSenderPlus mailSenderPlus = new MailSenderPlus();
        mailSenderPlus.sendExtra("hallo", "alex@vanmanenit.nl");

    }
}
