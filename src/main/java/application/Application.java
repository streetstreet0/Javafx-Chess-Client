package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.Node;

import java.awt.GraphicsEnvironment;
import java.awt.DisplayMode;
import java.io.IOException;

public class Application extends javafx.application.Application {
    private int screenWidth;
    private int screenHeight;
    private Stage primaryStage;
    private Board chessBoard;
    private static final double buttonHeight = 30;
    private static final double buttonWidth = 180;
    private static final double buttonSpacing = 15;
    private static final Font buttonFont = new Font(14);


    @Override
    public void start(Stage primaryStage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        this.primaryStage = primaryStage;
        DisplayMode graphicsDeviceMode = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
        screenWidth = graphicsDeviceMode.getWidth();
        screenHeight = graphicsDeviceMode.getHeight() - 50;

        setMainScreen(primaryStage);
        primaryStage.setTitle("Chess");
//        primaryStage.setWidth(screenWidth);
//        primaryStage.setHeight(screenHeight);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    public void setMainScreen(Stage stage) {
        Scene scene = generateMainScene();
        stage.setScene(scene);
    }

    public void setChessScreen(Stage stage) {
        Scene scene = generateChessScreen();
        stage.setScene(scene);
    }

    public Scene generateMainScene() {
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setMaxHeight(Double.MAX_VALUE);
        mainBox.setMaxHeight(Double.MAX_VALUE);
        mainBox.setBackground(Background.fill(Color.BLACK));

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setSpacing(buttonSpacing);
        buttonBox.setMaxWidth(buttonWidth);
        buttonBox.setMaxHeight(Double.MAX_VALUE);

        Button testGameButton = new Button("Test Moving Pieces");
        testGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setChessScreen(primaryStage);
            }
        });

        Button testServerButton = new Button("Test Server Connection");
        testServerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("other");
            }
        });

        buttonBox.getChildren().addAll(testGameButton, testServerButton);


        for (Node child : buttonBox.getChildren()) {
            if (child instanceof Button button) {
                button.setAlignment(Pos.CENTER);
                button.setMaxWidth(Double.MAX_VALUE);
                button.setPrefHeight(buttonHeight);
                button.setFont(buttonFont);
            }
        }

        mainBox.getChildren().add(buttonBox);
        return new Scene(mainBox);
    }

    public Scene generateChessScreen() {
        BorderPane mainBox = new BorderPane();
        mainBox.setMaxHeight(Double.MAX_VALUE);
        mainBox.setMaxHeight(Double.MAX_VALUE);
        mainBox.setBackground(Background.fill(Color.CHOCOLATE.darker().darker().desaturate()));

        VBox boardBox = new VBox();
        boardBox.setAlignment(Pos.CENTER);
        chessBoard = new Board();
        boardBox.getChildren().add(chessBoard);

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setSpacing(buttonSpacing);
        buttonBox.setPrefWidth(buttonWidth);
        buttonBox.setMinWidth(buttonWidth);
        buttonBox.setMaxHeight(Double.MAX_VALUE);
        buttonBox.setPadding(new Insets(40, 0, 0, 0));

        Button returnButton = new Button("Back");
        returnButton.setPrefWidth(buttonWidth / 2);
        returnButton.setMaxWidth(buttonWidth / 2);
        returnButton.setPrefHeight(buttonHeight);
        returnButton.setFont(buttonFont);
        returnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setMainScreen(primaryStage);
            }
        });
        buttonBox.getChildren().add(returnButton);

        mainBox.setLeft(buttonBox);
        mainBox.setCenter(boardBox);

        return new Scene(mainBox);
    }

    public static void main(String[] args) {
        launch();
    }
}