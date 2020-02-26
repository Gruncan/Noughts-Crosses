package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class ControllerTitle {

    @FXML
    private Button onePlayer;

    @FXML
    private Button twoPlayer;

    @FXML
    private Label notAvailable;

    @FXML
    public void buttonClick(ActionEvent event){
        if(event.getSource() == onePlayer){
            notAvailable.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(4000), notAvailable);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setAutoReverse(true);
            ft.play();

        }else if(event.getSource() == twoPlayer){
            Main.setSceneMain2();
        }

    }

}
