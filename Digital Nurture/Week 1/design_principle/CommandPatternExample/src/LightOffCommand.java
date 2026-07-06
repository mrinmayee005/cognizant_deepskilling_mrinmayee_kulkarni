public class LightOffCommand implements Command {

    private Light lights;

    public LightOffCommand(Light lights) {
        this.lights = lights;
    }

    public void execute() {
        lights.turnOff();
    }
}