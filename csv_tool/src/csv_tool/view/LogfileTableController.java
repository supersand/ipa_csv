package csv_tool.view;

import csv_tool.model.Logfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LogfileTableController
{
    @FXML
    private TableView<Logfile> logfileTable;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<Logfile, Integer> idColumn;
    @FXML
    private TableColumn<Logfile, String> var1Column;
    @FXML
    private TableColumn<Logfile, String> timeStringColumn;
    @FXML
    private TableColumn<Logfile, String> textMsgColumn;
    @FXML
    private TableColumn<Logfile, String> plcColumn;

    @FXML
    private ObservableList<Logfile> logData = FXCollections.observableArrayList();

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LogfileTableController()
    {
    	logData.add(new Logfile(1, "HMI", "a", "b", "c"));
    	logData.add(new Logfile(2, "test", "test", "test", "test"));
    	logData.add(new Logfile(3, "test", "test", "test", "test"));
    	logData.add(new Logfile(4, "test", "test", "test", "test"));
    	logData.add(new Logfile(5, "test", "test", "test", "test"));
    	logData.add(new Logfile(6, "test", "test", "test", "test"));
    	logData.add(new Logfile(7, "test", "test", "test", "test"));
    	logData.add(new Logfile(8, "test", "test", "test", "test"));
    	logData.add(new Logfile(9, "test", "test", "test", "test"));
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize()
    {
        // Initialize the Logfile table with the five columns.
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        var1Column.setCellValueFactory(cellData -> cellData.getValue().var1Property());
        timeStringColumn.setCellValueFactory(cellData -> cellData.getValue().timeStringProperty());
        textMsgColumn.setCellValueFactory(cellData -> cellData.getValue().textMsgProperty());
        plcColumn.setCellValueFactory(cellData -> cellData.getValue().plcProperty());

        FilteredList<Logfile> filteredData = new FilteredList<>(logData, p -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) ->
        {
			filteredData.setPredicate(logfile ->
			{
				// If filter text is empty, display all logfiles.
				if (newValue == null || newValue.isEmpty())
				{
					return true;
				}

				// Compare text columns with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (logfile.getVar1().toLowerCase().indexOf(lowerCaseFilter) != -1)
				{
					return true; // Filter matches
				}
					else if (logfile.getTimeString().toLowerCase().indexOf(lowerCaseFilter) != -1)
					{
						return true; // Filter matches
					}

						else if (logfile.getTextMsg().toLowerCase().indexOf(lowerCaseFilter) != -1)
						{
							return true; // Filter matches
						}

							else if (logfile.getPLC().toLowerCase().indexOf(lowerCaseFilter) != -1)
							{
								return true; // Filter matches
							}


					return false; // Does not match

			});
		});


        SortedList<Logfile> sortedData = new SortedList<>(filteredData);


        sortedData.comparatorProperty().bind(logfileTable.comparatorProperty());


        logfileTable.setItems(sortedData);

    }

}
