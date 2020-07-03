import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View extends JFrame {
    JPanel textInputPanel, buttonInputPanel, calculatedResultPanel, confirmButtonPanel;
    JComboBox<String> unitsChanger;
    JTextField textInput, meter, inch, foot, yard;
    Model model;

    private void addButoon(JPanel panel, String string, Controller c) {
        Controller controller = c;
        JButton button = new JButton(string);
        button.addActionListener(controller);
        panel.add(button);
    }

    public void reset() {
        inch.setText("");
        meter.setText("");
        foot.setText("");
        yard.setText("");
    }

    private JTextField addField(JPanel panel, String string) {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        jPanel.add(textField);

        JLabel label = new JLabel(string);
        jPanel.add(label);

        panel.add(jPanel);

        return textField;
    }

    public void initialise(Model m, Controller c) {
        Controller controller = c;
        model = m;
        textInputPanel = new JPanel();
        buttonInputPanel = new JPanel();
        calculatedResultPanel = new JPanel();
        confirmButtonPanel = new JPanel();

        String[] units = {"m", "inch", "foot", "yard"};
        unitsChanger = new JComboBox<>(units);
        unitsChanger.addActionListener(controller);

        textInput = new JTextField(20);
        textInput.setSize(100, 20);
        textInput.setHorizontalAlignment(JTextField.RIGHT);
        textInput.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textInput.setVisible(true);

        unitsChanger.setActionCommand("choose");

        textInputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 10));

        textInputPanel.add(textInput);
        textInputPanel.add(unitsChanger);
        textInputPanel.setVisible(true);

        buttonInputPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        buttonInputPanel.setLayout(new GridLayout(4, 3, 5, 5));

        calculatedResultPanel.setLayout(new GridLayout(4, 2, 10, 5));

        this.setLayout(new BorderLayout(10, 10));
        add(textInputPanel, BorderLayout.NORTH);
        add(confirmButtonPanel, BorderLayout.SOUTH);
        add(calculatedResultPanel, BorderLayout.EAST);
        add(buttonInputPanel, BorderLayout.WEST);

        addButoon(buttonInputPanel, "7", controller);
        addButoon(buttonInputPanel, "8", controller);
        addButoon(buttonInputPanel, "9", controller);
        addButoon(buttonInputPanel, "4", controller);
        addButoon(buttonInputPanel, "5", controller);
        addButoon(buttonInputPanel, "6", controller);
        addButoon(buttonInputPanel, "1", controller);
        addButoon(buttonInputPanel, "2", controller);
        addButoon(buttonInputPanel, "3", controller);
        addButoon(buttonInputPanel, "0", controller);
        addButoon(buttonInputPanel, ".", controller);
        addButoon(buttonInputPanel, "C", controller);

        inch = this.addField(calculatedResultPanel, "inch");
        meter = this.addField(calculatedResultPanel, "meter");
        foot = this.addField(calculatedResultPanel, "foot");
        yard = this.addField(calculatedResultPanel, "yard");

        addButoon(confirmButtonPanel, "Calculate", controller);

        buttonInputPanel.setVisible(true);;
        textInputPanel.setVisible(true);
        calculatedResultPanel.setVisible(true);
        confirmButtonPanel.setVisible(true);

        setTitle("Unit Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        inch.setText(model.format(model.inch));
        foot.setText(model.format(model.foot));
        meter.setText(model.format(model.meter));
        yard.setText(model.format(model.yard));
    }


}
