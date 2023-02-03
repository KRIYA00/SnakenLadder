package com.example.snakenladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class GamePage
{
    public AnchorPane root;
    GamePage() throws IOException
    {
     root=FXMLLoader.load(getClass().getResource("GamePage.fxml"));
    }
}
