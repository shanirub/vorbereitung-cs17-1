public class Launcher {

    public static void main (String args[]) {
        Model model = new Model();
        model.initialise(0.0, "m");
        View view = new View();
        Controller controller = new Controller(model, view);
        view.initialise(model, controller);

    }
}
