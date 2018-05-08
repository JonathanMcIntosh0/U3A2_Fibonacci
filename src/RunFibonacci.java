import javafx.application.Application;
import javafx.stage.Stage;

public class RunFibonacci extends Application {

    private static FibView fibView;

    public static void main(String[] args) {
        fibView = new FibView();
        FibModel fibModel = new FibModel();

        FibPresenter fibPresenter = new FibPresenter(fibModel, fibView);
        fibPresenter.run();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nombres Fibonacci");
        primaryStage.setScene(fibView.getScene());
        primaryStage.show();
    }
}
