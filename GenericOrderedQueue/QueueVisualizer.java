import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class is an application to visualize the queue data structure.
 *
 * @author Ryan Lawton
 */
public class QueueVisualizer<E> extends Application
{
    private OrderedQueue myQueue;
    
    private Label[] labelsArray;
    private Label frontLabel;
    private Label titleLabel;

    private TextField input;

    private GridPane pane;

    private Button offerButton;
    private Button pollButton;

    /**
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        myQueue = new OrderedQueue();

        labelsArray = new Label[20];
        
        for (int i = 0; i < labelsArray.length; i++) {
            labelsArray[i] = new Label("");
            labelsArray[i].setFont(new Font("Arial", 24));
            labelsArray[i].setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        
        frontLabel = new Label("Front");
        titleLabel = new Label("Queue:");

        // Create a TextField
        input = new TextField();

        // Create a Button or any control item
        offerButton = new Button("offer");
        pollButton = new Button("poll");

        // Create a new grid pane
        pane = new GridPane();
        pane.setPadding(new Insets(400, 10, 10, 200));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        offerButton.setOnAction(this::offerButtonClick);
        pollButton.setOnAction(this::pollButtonClick);

        // Add the button and label into the pane

        titleLabel.setFont(new Font("Arial", 36));
        
        for (int i = 0; i < labelsArray.length; i++) {
            pane.add(labelsArray[i], 4 + i, 2);
        }

        
        pane.add(frontLabel, 4, 1);
        pane.add(titleLabel, 0, 0);

        pane.add(input, 0, 4);

        pane.add(offerButton, 1, 4);
        pane.add(pollButton, 2, 4);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setTitle("Queue Visualizer");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * 
     */
    private void offerButtonClick(ActionEvent event)
    {
        // Add the element to queue.
        if (input.getText() != "") 
        {
            myQueue.add(input.getText());
            
            // Set label text.
            labelsArray[myQueue.getSize() - 1].setText(input.getText());
    
            input.setText("");
        }
    }
    /**
     * 
     * 
     * 
     */
    private void pollButtonClick(ActionEvent event)
    {
        myQueue.removeOldestValue();
        // Copy queue to display.
        OrderedQueueNode<E> currentNode = myQueue.getOldestNode();
        int appIndex = 4;
        int labelsIndex = 0;

        while (currentNode != null)
        {
            // currentNode.getElement()
            labelsArray[labelsIndex].setText("" + currentNode.getElement());

            appIndex++;
            labelsIndex++;
            currentNode = currentNode.getNewerNode();
        }
        
        labelsArray[labelsIndex].setText("");
        
    }
}
