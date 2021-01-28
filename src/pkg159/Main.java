/*
 * Project: Java 2 Programming exercise 15.9
 * Name: Lauren Smith
 * Date: 1/11/2021 
 * Description: Can draw lines on a pane with the arrow keys for directions 
 */
package pkg159;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {
    //global x and y var to track where the line is, set to middle of the pane
    //for starting point
    double x=150; 
    double y=125; 
    @Override
    public void start(Stage primaryStage) {
       //makes a pane
        Pane pane=new Pane(); 
        //makes first line starting at starting point on the pane
        Line l=new Line(150,125,150,125); 
        //adds to pane
        pane.getChildren().add(l); 
        //lamda for setting the line when arrow keys are pressed 
        l.setOnKeyPressed(e->{           
            //switch statement to find which key has been pressed
            switch(e.getCode()) 
           { 
               //each key set to use corresponding named method below
                case UP: 
               { 
                 up(pane); 
               }
               break; 
               case DOWN: 
               {
                   down(pane); 
               }
               break; 
               case LEFT: 
               {
                   left(pane); 
               }
               break; 
               case RIGHT: 
               {
                   right(pane); 
               }
               break; 
           }
            
        }); 
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Draw");
        primaryStage.setScene(scene);
        primaryStage.show();
        //request focus for the line so it knows to look for keyboard input for the line
        l.requestFocus(); 
    }  
    
    //methods below take the pane as a parameter, make a new line start it at the 
    //current line x and y values, changing x to go left or right by 1 or y for
    //up and down. Adds line to the pane and updates x or y value dependent on direction
    public void up(Pane p) 
    {
        Line a=new Line(x,y,x,y-1); 
        p.getChildren().add(a); 
        y=a.getEndY(); 
    }
    
    public void down(Pane p) 
    {
        Line a=new Line(x,y,x,y+1); 
        p.getChildren().add(a); 
        y=a.getEndY(); 
    } 
    
    public void right(Pane p) 
    {
        Line a=new Line(x,y,x+1,y); 
        p.getChildren().add(a); 
        x=a.getEndX(); 
    }
    
    public void left (Pane p) 
    {
        Line a=new Line(x,y,x-1,y); 
        p.getChildren().add(a); 
        x=a.getEndX(); 
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
