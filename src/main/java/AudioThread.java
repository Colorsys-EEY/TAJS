public class AudioThread implements Runnable{
    public static int sound=0;
    AAudioPlayer audi = new AAudioPlayer();
    @Override
    public void run() {
        System.out.println("Audio init");
        do {
            audi.Pluyy = true;
            if (sound == 0) {
                audi.play(CharMenu.Theme0 + "/MainTheme.wav");
            } else if (sound == 1) {
                audi.play(CharMenu.Theme0 + "/Scientist.wav");
            } else if (sound == 2) {
                audi.play(CharMenu.Theme0 + "/Adventure.wav");
            } else if (sound == 3) {
                audi.play(CharMenu.Theme0 + "/Creator.wav");
            } else if (sound == 4) {
                audi.play(CharMenu.Theme0 + "/Destroyer.wav");
            } else if (sound == 5) {
                audi.play(CharMenu.Theme0 + "/Doctor.wav");
            } else if (sound == 6) {
                audi.play(CharMenu.Theme0 + "/Ghost.wav");
            } else if (sound == 7) {
                audi.play(CharMenu.Theme0 + "/Soldier.wav");
            } else if (sound == 8) {
                audi.play(CharMenu.Theme0 + "/Watcher.wav");
            } else if (sound == 9) {
                audi.play(CharMenu.Theme0 + "/Chemist.wav");
            } else if (sound == 10) {
                audi.play(CharMenu.Theme0 + "/Split.wav");
            } else if (sound == 11) {
                audi.play(CharMenu.Theme0 + "/RainyDay.wav");
            }
        } while (true);
    }
}
