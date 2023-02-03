package com.example.snakenladder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Random;

public class PlayAreaController
{
    int turn=1;
    HashMap<Pair<Double,Double>,Pair<Double,Double>>snakeLadderCordinateChange;
    @FXML
    Text ChangeTurn;
    @FXML
    Text number;
    @FXML
    ImageView player1,player2;
    @FXML
    public void roll(MouseEvent event)
    {
        getSnakeLadderCoordinates();
        System.out.println("Dice is rolled");
        Random random=new Random();
        int rolling= random.nextInt(6)+1;
     // rolling=1;
        number.setText(""+rolling);
        if(turn==1)
        {
         Pair<Double,Double>moveCoordinates=movement(player1.getTranslateX(), player1.getTranslateY(), rolling);
         player1.setTranslateX(moveCoordinates.getKey());
            player1.setTranslateY(moveCoordinates.getValue());
           if(snakeLadderCordinateChange.containsKey(new Pair<>(moveCoordinates.getKey(),moveCoordinates.getValue())))
          {
                player1.setTranslateX(snakeLadderCordinateChange.get
                (new Pair<>(moveCoordinates.getKey(),moveCoordinates.getValue())).getKey());
                player1.setTranslateY(snakeLadderCordinateChange.get
                (new Pair<>(moveCoordinates.getKey(),moveCoordinates.getValue())).getValue());
                }

            checkWin(player1.getTranslateX(),player1.getTranslateY());
        }
        else
        {
            Pair<Double,Double>moveCoordinates=movement(player2.getTranslateX(), player2.getTranslateY(), rolling);
            player2.setTranslateX(moveCoordinates.getKey());
            player2.setTranslateY(moveCoordinates.getValue());
            if(snakeLadderCordinateChange.containsKey(new Pair<>(moveCoordinates.getKey(),moveCoordinates.getValue()))) {
                player2.setTranslateX(snakeLadderCordinateChange.get(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())).getKey());
                player2.setTranslateY(snakeLadderCordinateChange.get(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())).getValue());
            }
            checkWin(player2.getTranslateX(),player2.getTranslateY());
        }
    if(rolling!=6) {
         if (turn == 1) {
             turn = 2;
             ChangeTurn.setText("Player2's Turn");
         } else {
             turn = 1;
             ChangeTurn.setText("Player1's Turn");
         }
     }
    }
    Pair<Double,Double> movement(double X,double Y,int rolling)
    {
      //  Double X=player2.getTranslateY();
      //  Double Y=player2.getTranslateY();
        double moveX=X,moveY=Y;

        if(moveY%100==0) {
            moveX+=rolling*50;
            if (moveX > 500) {
                moveX = (500 * 2 )- moveX + 50;
                moveY -= 50;
                //System.out.println(moveY);
            }
        }
        else
        {
          moveX-=rolling*50;
          if(moveX<50)
          {
              if(moveY==-450)
              {
                  return new Pair<>(X,Y);
              }
              moveX=-1*(moveX-50);
              moveY-=50;
          }
        }
      return new Pair<>(moveX,moveY);

    }
    void checkWin(Double X,Double Y) {
        if (X == 50 && Y == -450) {
            Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
            winAlert.setHeaderText("Result");
            if (turn == 1) {
                //System.out.println("Player 1 has won");
                winAlert.setContentText("Player 1 has won the game");
            } else {
                // System.out.println("Player 2 has won");
                winAlert.setContentText("Player 2 has won the game");
            }
            winAlert.showAndWait();

        }
    }
    void getSnakeLadderCoordinates()
    {
        snakeLadderCordinateChange=new HashMap<>();
        snakeLadderCordinateChange.put(new Pair<>(50.0,0.0),new Pair<>(150.0,-150.0));
        snakeLadderCordinateChange.put(new Pair<>(200.0,0.0),new Pair<>(350.0,-50.0));
        snakeLadderCordinateChange.put(new Pair<>(200.0,-50.0),new Pair<>(350.0,0.0));
        snakeLadderCordinateChange.put(new Pair<>(450.0,0.0),new Pair<>(500.0,-150.0));
        snakeLadderCordinateChange.put(new Pair<>(50.0,-100.0),new Pair<>(100.0,-200.0));
        snakeLadderCordinateChange.put(new Pair<>(400.0,-100.0),new Pair<>(200.0,-400.0));
        snakeLadderCordinateChange.put(new Pair<>(100.0,-300.0),new Pair<>(100.0,-50.0));
        snakeLadderCordinateChange.put(new Pair<>(500.0,-250.0),new Pair<>(350.0,-300.0));
        snakeLadderCordinateChange.put(new Pair<>(500.0,-350.0),new Pair<>(500.0,-450.0));
        snakeLadderCordinateChange.put(new Pair<>(50.0,-350.0),new Pair<>(50.0,-450.0));
        snakeLadderCordinateChange.put(new Pair<>(200.0,-300.0),new Pair<>(50.0,-250.0));
        snakeLadderCordinateChange.put(new Pair<>(350.0,-250.0),new Pair<>(350.0,-150.0));
        snakeLadderCordinateChange.put(new Pair<>(150.0,-450.0),new Pair<>(100.0,-350.0));
        snakeLadderCordinateChange.put(new Pair<>(300.0,-450.0),new Pair<>(300.0,-350.0));
        snakeLadderCordinateChange.put(new Pair<>(400.0,-450.0),new Pair<>(400.0,-350.0));
        snakeLadderCordinateChange.put(new Pair<>(350.0,-400.0),new Pair<>(200.0,-100.0));
    }

}
