public class TestDecorator {
    public static void main(String[] args) {

        // Only Email
        Notifier notifier1 = new EmailNotifier();
        notifier1.send("Hello Mrinmayee!");

        System.out.println("-----------");

        // Email + SMS
        Notifier notifier2 = new SMSNotifierDecorator(new EmailNotifier());
        notifier2.send("Hello mrinmayee!");

        System.out.println("-----------");

        // Email + SMS + Slack
        Notifier notifier3 =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()
                        )
                );

        notifier3.send("Hello mrinmayee!");
    }
}