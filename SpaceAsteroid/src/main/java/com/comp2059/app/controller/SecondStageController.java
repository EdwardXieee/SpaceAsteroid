package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.model.GameStageModel;
import com.comp2059.app.utils.SoundEffect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * This controller is to control second stage.
 * When user click the buttons, display the sound and do the corresponding actions.
 * When user's mouse enters the buttons, the button's opacity will be smaller.
 * When user's mouse exits the buttons, the button's opacity will be restored.
 * @author Yuening Xie
 * @version 3.0
 * @since 10 November 2022
 */
public class SecondStageController implements Initializable {
    @FXML
    public TextField textName;
    @FXML
    public ImageView dice;
    @FXML
    public Button btnPlay;
    @FXML
    public Button btnBack;
    private static int nameNumber = 0;
    private static final HashMap<Integer, String> NAME_MAP = new HashMap<>();

    /**
     * Initialize the second stage to read the randomName.txt to save the names in map so that user can get a random name.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String filePath = Objects.requireNonNull(getClass().getResource("/com/comp2059/app/txt/randomName.txt")).getPath();
        try(Scanner sr = new Scanner(new FileReader(filePath))) {
                String strTmp;
                while (sr.hasNextLine()) {
                    strTmp = sr.nextLine();
                    NAME_MAP.put(nameNumber, strTmp);
                    nameNumber++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * When user click "Start", judge whether the name is valid, if not, pop an error window to remind user.
     */
    @FXML
    void clickPlay() {
        if (textName.getText().isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Entry Error");
            error.setContentText("Name is a required field.");
            error.show();
            return;
        }
        for (int i = 0; i < textName.getText().length(); i++) {
            if (Character.isDigit(textName.getText().charAt(i))) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Entry Error");
                error.setContentText("Name must not contain a digit");
                error.show();
                return;
            }
        }

        SoundEffect.playButton();
        GameStageModel.setName(textName.getText());
        Director.getDirector().startGame();
    }

    /**
     * Click dice image to get a random name.
     */
    @FXML
    public void clickDice() {
        Random random = new Random();
        int key = random.nextInt(nameNumber);
        textName.setText(NAME_MAP.get(key));
    }

    @FXML
    void clickBack() {
        SoundEffect.playButton();
        Director.getDirector().toPrimaryStage();
    }

    @FXML
    public void enterPlay() {
        btnPlay.setOpacity(0.8);
    }

    @FXML
    public void existPlay() {
        btnPlay.setOpacity(1);
    }

    @FXML
    public void enterBack() {
        btnBack.setOpacity(0.8);
    }

    @FXML
    public void existBack() {
        btnBack.setOpacity(1);
    }

    @FXML
    public void enterDice() {
        dice.setOpacity(0.8);
    }

    @FXML
    public void exitDice() {
        dice.setOpacity(1);
    }

}

