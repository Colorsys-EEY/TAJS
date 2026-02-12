import javax.swing.*;

public class SettingsWindow extends JFrame {
    public JSlider slider;
    public static int Slide=2;
    public SettingsWindow(){
        slider = new JSlider(1,4,Game.RS);
        JPanel panel = new JPanel();
        panel.add(slider);
        panel.setVisible(true);
        add(panel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            Slide = slider.getValue();
    }
    public void tick(){
        Slide =slider.getValue();
    }
}
