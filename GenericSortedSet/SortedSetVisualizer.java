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
public class SortedSetVisualizer<E> extends Application
{
    private SortedSet<String> mySet;

    private Label[] labelsArray;
    private Label titleLabel;

    private TextField input;

    private GridPane pane;

    private Button addButton;
    private Button removeButton;

    /**
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        mySet = new SortedSet<String>();

        labelsArray = new Label[20];

        for (int i = 0; i < labelsArray.length; i++) {
            labelsArray[i] = new Label("");
            labelsArray[i].setFont(new Font("Arial", 24));
            labelsArray[i].setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        }

        titleLabel = new Label("Sorted Set:");

        // Create a TextField
        input = new TextField();

        // Create a Button or any control item
        addButton = new Button("add");
        removeButton = new Button("remove");

        // Create a new grid pane
        pane = new GridPane();
        pane.setPadding(new Insets(400, 10, 10, 200));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        addButton.setOnAction(this::addButtonClick);
        removeButton.setOnAction(this::removeButtonClick);

        // Add the button and label into the pane

        titleLabel.setFont(new Font("Arial", 36));

        for (int i = 0; i < labelsArray.length; i++) {
            pane.add(labelsArray[i], 4 + i, 2);
        }

        pane.add(titleLabel, 0, 0);

        pane.add(input, 0, 4);

        pane.add(addButton, 1, 4);
        pane.add(removeButton, 2, 4);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setTitle("Sorted Set Visualizer");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * 
     */
    private void addButtonClick(ActionEvent event)
    {
        if (input.getText() != "") 
        {
            if (mySet.getSize() == 0) 
            {
                mySet.add(input.getText());
            }
            else 
            {
                boolean found = false;
                SortedSetNode<String> currentNode = mySet.getSmallestNode();
                
                while (currentNode != null)
                {
                    if (currentNode.getElement().equals(input.getText())) 
                    {
                        currentNode = null;
                        found = true;
                    }
                    else 
                    {
                        currentNode = currentNode.getGreaterThanNode();
                    }
                }
    
                if (!found) 
                {
                    mySet.add(input.getText());
                }
            }
        

            SortedSetNode<String> currentNode = mySet.getSmallestNode();
            int appIndex = 4;
            int labelsIndex = 0;
    
            while (currentNode != null)
            {
                labelsArray[labelsIndex].setText(currentNode.getElement());
    
                appIndex++;
                labelsIndex++;
                currentNode = currentNode.getGreaterThanNode();
            }
            
            input.setText("");
        }
    }
    /**
     * 
     * 
     * 
     */
    private void removeButtonClick(ActionEvent event)
    {
        SortedSetNode<String> currentNode = mySet.getSmallestNode();
        
        boolean removed = false;
        
        while (currentNode != null)
        {
            if (currentNode.getElement().equals(input.getText())) 
            {
                mySet.remove(currentNode.getElement());
                currentNode = null;
                removed = true;
            }
            else 
            {
                currentNode = currentNode.getGreaterThanNode();
            }
        }

        if (removed) 
        {
            currentNode = mySet.getSmallestNode();
            int appIndex = 4;
            int labelsIndex = 0;
        
            while (currentNode != null) 
            {
                labelsArray[labelsIndex].setText("" + currentNode.getElement());
    
                appIndex++;
                labelsIndex++;
                currentNode = currentNode.getGreaterThanNode();
            }
    
            labelsArray[labelsIndex].setText("");
        }
        
        input.setText("");
    }
}