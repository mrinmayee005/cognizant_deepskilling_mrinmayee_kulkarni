/**
 * Exercise 19: Interface Demo
 * Objective: Define a Playable interface and implement it in Guitar and Piano.
 * Compile: javac InterfaceDemo.java
 * Run: java InterfaceDemo
 */
interface Playable {
    void play();
    void stop();
    void adjustVolume(int level);

    default void displayStatus() {
        System.out.println("  Device is ready to play.");
    }
}

class Guitar implements Playable {
    private String brand;
    private int volume;
    private boolean isPlaying;

    public Guitar(String brand) {
        this.brand = brand;
        this.volume = 5;
        this.isPlaying = false;
    }

    @Override
    public void play() {
        isPlaying = true;
        System.out.println(brand + " guitar: Strumming strings...");
    }

    @Override
    public void stop() {
        isPlaying = false;
        System.out.println(brand + " guitar: Stopped playing.");
    }

    @Override
    public void adjustVolume(int level) {
        this.volume = level;
        System.out.println(brand + " guitar: Amplifier set to " + level);
    }
}

class Piano implements Playable {
    private String brand;
    private int volume;
    private boolean isPlaying;

    public Piano(String brand) {
        this.brand = brand;
        this.volume = 7;
        this.isPlaying = false;
    }

    @Override
    public void play() {
        isPlaying = true;
        System.out.println(brand + " piano: Playing melody...");
    }

    @Override
    public void stop() {
        isPlaying = false;
        System.out.println(brand + " piano: Stopped playing.");
    }

    @Override
    public void adjustVolume(int level) {
        this.volume = level;
        System.out.println(brand + " piano: Volume set to " + level);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Interface Demo ===\n");

        Guitar guitar = new Guitar("Fender");
        Piano piano = new Piano("Yamaha");

        System.out.println("--- Guitar ---");
        guitar.displayStatus();
        guitar.play();
        guitar.adjustVolume(8);
        guitar.stop();

        System.out.println("\n--- Piano ---");
        piano.displayStatus();
        piano.play();
        piano.adjustVolume(10);
        piano.stop();

        System.out.println("\n--- Using Interface Type ---");
        Playable instrument1 = guitar;
        Playable instrument2 = piano;

        instrument1.play();
        instrument2.play();
        instrument1.stop();
        instrument2.stop();
    }
}
