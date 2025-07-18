import javax.swing.*;
import java.awt.*;
import java.util.*;

public class OutputForm extends JFrame {
    public OutputForm(boolean correct, Map<Integer, String> map, int num) {
        setTitle("Result");
        setLayout(new BorderLayout(5,5));
        String msg = correct ? "Correct!" : "Wrong. Try again.";
        add(new JLabel(msg, SwingConstants.CENTER), BorderLayout.NORTH);
        if (correct)
            add(new JLabel(new ImageIcon("check.png")), BorderLayout.CENTER);
        JPanel p = new JPanel();
        JButton retry = new JButton(correct ? "Next" : "Retry");
        retry.setBackground(Color.BLUE);
        retry.addActionListener(event -> {
            dispose();
            new InputForm(map);
        });
        JButton quit = new JButton("Quit");
        quit.setBackground(Color.RED);
        quit.addActionListener(event -> System.exit(0));
        p.add(retry);
        p.add(quit);
        add(p, BorderLayout.SOUTH);
        setSize(300, correct ? 300 : 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
