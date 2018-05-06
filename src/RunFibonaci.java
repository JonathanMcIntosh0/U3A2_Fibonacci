import javafx.application.Application;

public class RunFibonaci {
    public static void main(String[] args) {

        FibPresenter fibPresenter = new FibPresenter();
        FibModel fibModel = new FibModel();
        FibView fibView = new FibView();

        fibPresenter.setModel(fibModel);
        fibPresenter.setView(fibView);

        fibPresenter.run(args);
    }
}
