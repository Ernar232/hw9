
class TV {
    public void on() {
        System.out.println("Телевизор включен");
    }

    public void off() {
        System.out.println("Телевизор выключен");
    }

    public void setChannel(int channel) {
        System.out.println("Выбран канал: " + channel);
    }
}

class AudioSystem {
    private int volume = 10;

    public void on() {
        System.out.println("Аудиосистема включена");
    }

    public void off() {
        System.out.println("Аудиосистема выключена");
    }

    public void setVolume(int level) {
        volume = level;
        System.out.println("Громкость установлена на: " + volume);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD-проигрыватель включен");
    }

    public void play(String movie) {
        System.out.println("Воспроизведение фильма: " + movie);
    }

    public void pause() {
        System.out.println("Фильм на паузе");
    }

    public void stop() {
        System.out.println("Воспроизведение остановлено");
    }

    public void off() {
        System.out.println("DVD-проигрыватель выключен");
    }
}

class GameConsole {
    public void on() {
        System.out.println("Игровая консоль включена");
    }

    public void startGame(String game) {
        System.out.println("Запуск игры: " + game);
    }

    public void off() {
        System.out.println("Игровая консоль выключена");
    }
}

class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audio;
    private DVDPlayer dvd;
    private GameConsole console;

    public HomeTheaterFacade(TV tv, AudioSystem audio, DVDPlayer dvd, GameConsole console) {
        this.tv = tv;
        this.audio = audio;
        this.dvd = dvd;
        this.console = console;
    }

    public void watchMovie(String movie) {
        System.out.println("\n--- Подготовка к просмотру фильма ---");
        tv.on();
        audio.on();
        audio.setVolume(15);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\n--- Завершение просмотра ---");
        dvd.stop();
        dvd.off();
        audio.off();
        tv.off();
    }

    public void playGame(String game) {
        System.out.println("\n--- Подготовка к игре ---");
        tv.on();
        audio.on();
        audio.setVolume(20);
        console.on();
        console.startGame(game);
    }

    public void listenToMusic() {
        System.out.println("\n--- Включение системы для прослушивания музыки ---");
        tv.on();
        audio.on();
        audio.setVolume(12);
        System.out.println("Аудиовход TV установлен на AUX");
    }

    public void setVolume(int level) {
        audio.setVolume(level);
    }

    public void turnOffAll() {
        System.out.println("\n--- Выключение всей системы ---");
        dvd.off();
        console.off();
        audio.off();
        tv.off();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audio = new AudioSystem();
        DVDPlayer dvd = new DVDPlayer();
        GameConsole console = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audio, dvd, console);

        homeTheater.watchMovie("Inception");
        homeTheater.setVolume(18);
        homeTheater.endMovie();

        homeTheater.playGame("FIFA 25");
        homeTheater.turnOffAll();

        homeTheater.listenToMusic();
        homeTheater.turnOffAll();
    }
}
