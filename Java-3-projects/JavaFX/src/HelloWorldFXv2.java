import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorldFXv2 extends Application{
    
    public void start(Stage mainStage){
        mainStage.setTitle("Hello World!");

        Button btn = new Button();
        btn.setText("Print Hello World!");

        btn.setOnAction(ActionEvent -> System.out.println("Hello World!")); //anonymous inner class using the lambda expression -> : defines the event handler interface method within the setOnAction event
        
        /*
         *anonymous inner class before lambda expression
         *EventHandler is an interface

        EventHandler<ActionEvent> handler = new EventHandler<>(){ 
            public void handle(ActionEvent event){
                System.out.println("Hello World!");
            }
        };       
         btn.setOnAction(handler);
         
        */

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 300);
        mainStage.setScene(scene);
        mainStage.show();

    }

    /*** less effecient way to call custom event handler that's only used once
     * 
    private class CustomEventHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            System.out.println("Hello World!");
        }
    }
    */
}
