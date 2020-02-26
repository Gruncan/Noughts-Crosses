package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    private static Scene sceneTitle;
    private static Scene sceneMain1;
    private static Scene sceneMain2;
    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        stage.setTitle("Tic Tac Toe");
        stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Tic_tac_toe.svg/2000px-Tic_tac_toe.svg.png"));
        stage.setResizable(false);

        Parent rootTitle = FXMLLoader.load(getClass().getResource("fxml/title.fxml"));
        sceneTitle = new Scene(rootTitle, 500, 500);
        sceneTitle.getStylesheets().add(Main.class.getResource("css/titleStyle.css").toExternalForm());


        Parent rootMain1 = FXMLLoader.load(getClass().getResource("fxml/main2.fxml"));
        sceneMain2 = new Scene(rootMain1, 500, 500);
        sceneMain2.getStylesheets().add(Main.class.getResource("css/mainStyle.css").toExternalForm());

        Parent rootMain2 = FXMLLoader.load(getClass().getResource("fxml/main2.fxml"));
        sceneMain2 = new Scene(rootMain2, 500, 500);
        sceneMain2.getStylesheets().add(Main.class.getResource("css/mainStyle.css").toExternalForm());

        DiscordRP.init();
        DiscordRP.title();
        stage.setScene(sceneTitle);
        stage.show();

    }

    public static void setSceneMain2(){
        DiscordRP.twoPlayer();
        stage.setScene(sceneMain2);
        stage.show();
    }

    public static void setSceneTitle(){
        DiscordRP.title();
        stage.setScene(sceneTitle);
        stage.show();
    }
    @Override
    public void stop() throws Exception{
        DiscordRP.close();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}