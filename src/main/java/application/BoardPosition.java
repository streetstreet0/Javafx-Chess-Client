package application;

import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardPosition {
    private static double squareSize = 40;
    private int xPosition;
    private int yPosition;
    private Color background;
    private VBox displaySquare;
//    private Piece piece;

    public BoardPosition(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        if ((xPosition + yPosition) % 2 == 0) {
            background = Color.WHITE;
        }
        else {
            background = Color.BLACK;
        }
        displaySquare = new VBox();
        displaySquare.setPrefWidth(squareSize);
        displaySquare.setMinWidth(squareSize);
        displaySquare.setPrefHeight(squareSize);
        displaySquare.setMinHeight(squareSize);
        displaySquare.setBackground(Background.fill(background));
//        displaySquare.setX(xPosition * squareSize);
//        displaySquare.setY(yPosition * squareSize);
    }

    public VBox getDisplaySquare() {
        return displaySquare;
    }

    public String getBoardPositionString() {
        try {
            char depthLetter = depthLetter(yPosition);
            return "" + depthLetter + xPosition;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static char depthLetter(int letterNumber) throws Exception {
        if (letterNumber < 1 || letterNumber > 8) {
            throw new Exception("Board Depth out of bounds");
        }
        return (char) (letterNumber + 64);
    }
}
