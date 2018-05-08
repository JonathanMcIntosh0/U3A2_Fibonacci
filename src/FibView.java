import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
/**
 *Interface
 */
class FibView {

    private static final int SCENE_WIDTH = 350;
    private static final int SCENE_HEIGHT = 230;

    private final TextField tfIndex  = new TextField();
    private Text txtMessage;

    //    CRÉATION DU GRAPHIQUE

    /**
     * Crée le graphique
     */
    public Scene getScene() {
        VBox layout = createMainLayout();

        return new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
    }

    private VBox createMainLayout() {
        VBox mainLayout = new VBox(
                15,
                createMainTitle(),
                createSubText(),
                createInputLayout(),
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
                        "les suivants : 1, 1, 2, 3, 5, 8, 13, 21, 34..."
        );

        subText.setTextAlignment(TextAlignment.CENTER);

        StackPane subTextLayout = new StackPane(subText);
        subTextLayout.setAlignment(Pos.CENTER);

        return subTextLayout;
    }

    private Node createInputLayout() {
        HBox inputLayout = new HBox(
                10,
                new Text("Inscrire le rang du nombre de Fibonacci voulu : "),
                tfIndex
        );
        inputLayout.setAlignment(Pos.CENTER);

        return inputLayout;
    }

    private Node createMsgLayout() {
        txtMessage = new Text("SVP entrer une rangée.");
        StackPane msgLayout = new StackPane(txtMessage);
        msgLayout.setAlignment(Pos.CENTER);

        return msgLayout;
    }

    //Getters

    TextField getTextField() {
        return tfIndex;
    }

    Text getText() {
        return txtMessage;
    }

}
