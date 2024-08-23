package application;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class Board extends GridPane {
    private HashMap<int[], BoardPosition> boardPositions;

    public Board() {
        super();
        boardPositions = new HashMap<int[], BoardPosition>();
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                BoardPosition boardPosition = new BoardPosition(x, y);
                boardPositions.put(new int[] {x, y}, boardPosition);
                VBox boardPositionDisplaySquare = boardPosition.getDisplaySquare();
                getChildren().add(boardPositionDisplaySquare);

                GridPane.setRowIndex(boardPositionDisplaySquare, 8-x);
                GridPane.setColumnIndex(boardPositionDisplaySquare, 8-y);
            }
        }
    }
}
