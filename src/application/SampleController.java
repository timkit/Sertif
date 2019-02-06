package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable {

	@FXML
	private TableView<Data> table;
	@FXML
	private TableColumn<Data, String> sert;
	@FXML
	private TableColumn<Data, String> mat;
	@FXML
	private TableColumn<Data, String> colSize;
	@FXML
	private TableColumn<Data, String> colSteel;

	ObservableList<Data> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try (Connection con = new DBConnector().getConn();) {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM sertif");
			while (rs.next()) {
				oblist.add(new Data(rs.getString("sert"), rs.getString("mat"), rs.getString("steel"),
						rs.getString("size")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, e);
		}

		sert.setCellValueFactory(new PropertyValueFactory<>("sert"));
		mat.setCellValueFactory(new PropertyValueFactory<>("mat"));
		colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
		colSteel.setCellValueFactory(new PropertyValueFactory<>("steel"));

		table.setItems(oblist);
	}
}
