import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    Model model;
    View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        model.builder.setLength(0);
        model.builder.append(view.textInput.getText());

        if ("0123456789".contains(command)) {
            model.builder.append(command);
            view.textInput.setText(model.builder.toString());
        } else if (command.equals(".") && !(model.builder.toString().contains("."))) {
            model.builder.append(command);
            view.textInput.setText(model.builder.toString());
        } else if (command.equals("C")) {
            model.builder.setLength(0);
            view.textInput.setText("");
        } else if (command.equals("Calculate")) {
            view.reset();
            try {
                double value = Double.parseDouble(model.builder.toString().replace(',', '.'));
                model.calculate(value, model.unit);
                view.repaint();
            } catch (NumberFormatException e) {
                model.builder.setLength(0);
                view.textInput.setText("");
            }
        } else if (command.equals("choose")) {
            model.unit = view.unitsChanger.getSelectedItem().toString();
            view.reset();
        }


    }
}
