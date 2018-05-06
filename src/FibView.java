import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
/**
 *Interface
 */
class FibView extends Application {

    private static final int SCENE_WIDTH = 350;
    private static final int SCENE_HEIGHT = 230;

    private Text txtMessage = new Text();

    private FibPresenter fibPresenter;

    FibView() {

    }

    //    CRÉATION DU GRAPHIQUE

    /**
     * Crée le graphique
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        super.init();

        primaryStage.setTitle("Nombres Fibonacci");
        VBox layout = createMainLayout();

        Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createMainLayout() {
        VBox mainLayout = new VBox(
                15,
                createMainTitle(),
                createSubText(),
                createInputLayout(),
                createButtonLayout(),
                createMsgLayout()
        );
        mainLayout.setPadding(new Insets(20));

        return mainLayout;
    }

    private Node createMainTitle() {
        Text mainTitle = new Text("Les nombres de Fibonacci");
        mainTitle.setFont(Font.font(null, FontWeight.BOLD, FontPosture.ITALIC, 15));

        StackPane mainTitleLayout = new StackPane(mainTitle);
        mainTitleLayout.setAlignment(Pos.CENTER);

        return mainTitleLayout;
    }

    private Node createSubText() {
        Text subText = new Text(
                "Les neuf premiers termes de la suite Fibonnacci sont\n" +
                        "les suivants : "
        );
        for (int i = 1; i < 10; i++) {
            String tempTxt;
            tempTxt = FibonacciGetter.getFibonacciNum(i) + ", ";
            if (i == 9) tempTxt += "...";
            subText.setText(subText.getText().concat(tempTxt));
        }
        subText.setTextAlignment(TextAlignment.CENTER);

        StackPane subTextLayout = new StackPane(subText);
        subTextLayout.setAlignment(Pos.CENTER);

        return subTextLayout;
    }

    private Node createInputLayout() {
        TextField tfIndex = new TextField();

        HBox inputLayout = new HBox(
                10,
                new Text("Inscrire le rang du nombre de Fibonacci voulu : "),
                tfIndex
        );
        inputLayout.setAlignment(Pos.CENTER);

        tfIndex.textProperty().addListener((observable, oldValue, newValue) -> {
            getPresenter().updateModelFromView(newValue);
        });

        return inputLayout;
    }

    private Node createButtonLayout() {
        Button btn = new Button();
        btn.setOnAction(event -> {
            getPresenter().updateMsgFromModel();
        });

        HBox btnLayout = new HBox(
                10,
                btn,
                new Text("Déterminer le nombre Fibbonacci")
        );
        btnLayout.setAlignment(Pos.CENTER);

        return btnLayout;
    }
    private Node createMsgLayout() {
        StackPane msgLayout = new StackPane(txtMessage);
        msgLayout.setAlignment(Pos.CENTER);

        return msgLayout;
    }

    //MÉTHODES

    void setMsg(String msg) {
        txtMessage.setText(msg);
    }

    //SETUP

    FibPresenter getPresenter() {
        return fibPresenter;
    }

    void setPresenter(FibPresenter fibPresenter) {
        this.fibPresenter = fibPresenter;
    }


}
