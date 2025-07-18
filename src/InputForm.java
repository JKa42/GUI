import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.Color;

public class InputForm extends JFrame {
    private final Map<Integer, String> map;
    private final int number;
    private final JTextField field = new JTextField(10);

    public InputForm(Map<Integer, String> map) {
        this.map = map;
        List<Integer> keys = new ArrayList<>(map.keySet());
        number = keys.get(new Random().nextInt(keys.size()));

        setTitle("Guess Number");
        setLayout(new BorderLayout(5, 5));
        add(new JLabel("Number: " + number, SwingConstants.CENTER), BorderLayout.NORTH);
        add(field, BorderLayout.CENTER);
        setBackground(Color.BLACK);

        JButton btn = new JButton("Check");
        btn.addActionListener(event -> check());
        add(btn, BorderLayout.SOUTH);

        setSize(200, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void check() {
        String ans = field.getText().trim();
        boolean ok = ans.equalsIgnoreCase(map.get(number));
        dispose();
        new OutputForm(ok, map, number);
    }

    public static void main(String[] args) {
        Main.main(args);
    }
}
