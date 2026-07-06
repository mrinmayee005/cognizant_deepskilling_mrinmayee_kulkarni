public class TestCommand {
    public static void main(String[] args) {

        Light lights = new Light();

        Command lightOn = new LightOnCommand(lights);
        Command lightOff = new LightOffCommand(lights);

        RemoteControl remote = new RemoteControl();

        // Turn ON light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn OFF light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}