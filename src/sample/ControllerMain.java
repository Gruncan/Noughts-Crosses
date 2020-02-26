package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ControllerMain {

    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;

    @FXML
    private Label turn;

    @FXML
    private Label winner;


    private ArrayList<Button> buttons = new ArrayList<>();

    public static boolean computer = false;

    private boolean[] clicked = {true, true, true, true, true, true, true, true, true};
    private boolean isP1 = true;

    private boolean finished = false;

    public void initialize(){
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);
    }

    private int[] checkWon() {
        String line = " ";
        int[] iList = null;
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    line = (buttons.get(0).getText() + buttons.get(1).getText() + buttons.get(2).getText());
                    iList = new int[]{0, 1, 2};
                    break;
                case 1:
                    line = (buttons.get(3).getText() + buttons.get(4).getText() + buttons.get(5).getText());
                    iList = new int[]{3, 4, 5};
                    break;
                case 2:
                    line = (buttons.get(6).getText() + buttons.get(7).getText() + buttons.get(8).getText());
                    iList = new int[]{6, 7, 8};
                    break;
                case 3:
                    line = (buttons.get(0).getText() + buttons.get(3).getText() + buttons.get(6).getText());
                    iList = new int[]{0, 3, 6};
                    break;
                case 4:
                    line = (buttons.get(1).getText() + buttons.get(4).getText() + buttons.get(7).getText());
                    iList = new int[]{1, 4, 7};
                    break;
                case 5:
                    line = (buttons.get(2).getText() + buttons.get(5).getText() + buttons.get(8).getText());
                    iList = new int[]{2, 5, 8};
                    break;
                case 6:
                    line = (buttons.get(0).getText() + buttons.get(4).getText() + buttons.get(8).getText());
                    iList = new int[]{0, 4, 8};
                    break;
                case 7:
                    line = (buttons.get(2).getText() + buttons.get(4).getText() + buttons.get(6).getText());
                    iList = new int[]{2, 4, 6};
                    break;

            }
            if (line.equals("⭕⭕⭕")) {
                winner.setText("Player 1 (⭕) has won");
                return iList;
            } else if (line.equals("❌❌❌")) {
                winner.setText("Player 2 has won");
                return iList;
            }
        }
        return null;
    }

    private void reset(){

        turn.setText("Turn : Player 1 (⭕)");

        clicked = new boolean[] {true, true, true, true, true, true, true, true, true};
        for(int i=0; i<buttons.size(); i++){
            buttons.get(i).setText(" ");
            buttons.get(i).setTextFill(Color.BLACK);
        }

        winner.setText(" ");
        finished = false;



    }


    private void twoPlayer(ActionEvent e){


        if(e.getSource() == b1 && clicked[0]){
            b1.setText((isP1) ? "⭕" : "❌");
            clicked[0] = false;


        }else if(e.getSource() == b2 && clicked[1]){
            b2.setText((isP1) ? "⭕" : "❌");
            clicked[1] = false;



        }else if(e.getSource() == b3 && clicked[2]){
            b3.setText((isP1) ? "⭕" : "❌");
            clicked[2] = false;



        }else if(e.getSource() == b4 && clicked[3]){
            b4.setText((isP1) ? "⭕" : "❌");
            clicked[3] = false;



        }else if(e.getSource() == b5 && clicked[4]){
            b5.setText((isP1) ? "⭕" : "❌");
            clicked[4] = false;



        }else if(e.getSource() == b6 && clicked[5]){
            b6.setText((isP1) ? "⭕" : "❌");
            clicked[5] = false;


        }else if(e.getSource() == b7 && clicked[6] ){
            b7.setText((isP1) ? "⭕" : "❌");
            clicked[6] = false;


        }else if(e.getSource() == b8 && clicked[7]){
            b8.setText((isP1) ? "⭕" : "❌");
            clicked[7] = false;



        }else if(e.getSource() == b9 && clicked[8]){
            b9.setText((isP1) ? "⭕" : "❌");
            clicked[8] = false;


        }else{
            return;
        }

        isP1 = !isP1;
        turn.setText((isP1) ? "Turn : Player 1 (⭕)" : "Turn : Player 2 (❌)");



        int[] iList = checkWon();
        if(iList != null) {
            for(int i=0; i<buttons.size();i++){
                for(int a: iList){
                    if(a == i){
                        buttons.get(i).setTextFill(Color.RED);
                    }
                }
            }


            finished = true;
            turn.setText("Turn : Player 1 (⭕)");
            isP1 = true;
        }else if(allFalse(clicked)){
            winner.setText("Draw");
            finished = true;
            return;
        }
    }

    private boolean allFalse(boolean[] a){
        for(boolean b : a) if(b) return false;
        return true;
    }

    private void onePlayer(ActionEvent e){

    }

    @FXML
    public void buttonClicked(ActionEvent e){
        if(finished){
            reset();
            return;
        }

        if(computer){
            onePlayer(e);
        }else{
            twoPlayer(e);
        }

    }


    @FXML
    public void sceneTitle(){
        reset();
        Main.setSceneTitle();
    }
}
