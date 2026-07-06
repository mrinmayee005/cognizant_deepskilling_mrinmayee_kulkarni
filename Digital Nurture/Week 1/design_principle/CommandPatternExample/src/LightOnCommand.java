public class LightOnCommand implements Command {

    private Light lights;

    public LightOnCommand(Light lights) {
        this.lights = lights;
    }

    public void execute() {
        lights.turnOn();
    }
}