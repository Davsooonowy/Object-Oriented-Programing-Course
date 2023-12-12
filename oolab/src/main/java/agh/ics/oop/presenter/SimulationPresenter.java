package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @FXML
    private Label infoLabel;
    @FXML
    private TextField movesListTextField;
    @FXML
    private Label moveInfoLabel;
    @FXML
    private Button startButton;

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
    @FXML
public void drawMap() {
    clearGrid();
    Boundary boundary = worldMap.getCurrentBounds();
    for (int i = boundary.lowerLeft().getY(); i <= boundary.upperRight().getY(); i++) {
        for (int j = boundary.lowerLeft().getX(); j <= boundary.upperRight().getX(); j++) {
            Vector2d position = new Vector2d(j, i);
            WorldElement element = worldMap.objectAt(position);
            Label label;
            if (element != null) {
                label = new Label(element.toString());
            } else {
                label = new Label(" ");
            }
            label.setMinWidth(50);
            label.setMinHeight(50);
//            label.setTextAlignment(TextAlignment.CENTER);
            label.setAlignment(Pos.CENTER);

            mapGrid.add(label, j, boundary.upperRight().getY() - i);
//            GridPane.setHalignment(label, HPos.CENTER);
//            GridPane.setValignment(label, VPos.CENTER);
        }
    }
    infoLabel.setText("");
}


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            this.drawMap();
            moveInfoLabel.setText(message);
        });
    }
    @FXML
    public void onSimulationStartClicked() {
        String movesString = movesListTextField.getText();
    try {
        List<MoveDirection> movesList = OptionsParser.parse(movesString.split(" "));
        Simulation simulation = new Simulation(movesList, List.of(new Vector2d(2, 2) , new Vector2d(5,5)), worldMap);
        SimulationEngine simulationEngine = new SimulationEngine(new ArrayList<>(List.of(simulation)));
        simulationEngine.runAsync();
        Platform.runLater(() -> startButton.setDisable(true));
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    @FXML
    private GridPane mapGrid;
}