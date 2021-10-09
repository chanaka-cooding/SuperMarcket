/*
 *
 *  *
 *  *  * --------------------------------------------------------------------------------------------------------------
 *  *  *  *  Copyright (c) Lahiru Chanaka. All rights reserved.
 *  *  *  *  Licensed under the SriLankan Information License. See License.txt in the project root for license information.
 *  *  *  *------------------------------------------------------------------------------------------------------------
 *  *
 *
 */

package controller;

/**
 * @author Lahiru Chanaka <chankalahiru69@gmail.com>
 * @since 10/9/2021
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.CustomerTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public JFXTextField txtSearch;
    public JFXButton btnSave;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOperate;

    public void initialize() throws SQLException, ClassNotFoundException {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllCustomers();


        // Bot
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            /*System.out.println(newValue);
            System.out.println(oldValue);*/

            txtId.setText(newValue.getId());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtSalary.setText(newValue.getSalary()+"");

        });


    }

    private void loadAllCustomers() throws SQLException, ClassNotFoundException {
        ResultSet resultSet =
                DBConnection.getInstance().getConnection().
                        prepareStatement(
                                "SELECT * FROM Customer")
                        .executeQuery();
        List<CustomerDTO> customerDTOS= new ArrayList<>();
        while (resultSet.next()){
            customerDTOS.add(
                    new CustomerDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4)
                            )
            );
        }

        ObservableList<CustomerTM> tmObservableList=
                FXCollections.observableArrayList();

        for (CustomerDTO dto : customerDTOS) {

            Button btn= new Button("Delete");

            tmObservableList.add(
                    new CustomerTM(
                          dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary(),btn
                    )
            );

            btn.setOnAction((e)->{
                try {
                    boolean isDelete=DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM Customer WHERE id='"+dto.getId()+"'").executeUpdate()>0;
                    if (isDelete){
                        new Alert(Alert.AlertType.CONFIRMATION,
                                "Deleted", ButtonType.OK).show();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            });

            tblCustomer.setItems(tmObservableList);
        }

    }

    public void newCustomerOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        if (btnSave.getText().equalsIgnoreCase("Save")){

            CustomerDTO dto= new CustomerDTO(
                    txtId.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText())
            );

            PreparedStatement stm = DBConnection.getInstance().
                    getConnection().prepareStatement(
                            "INSERT INTO Customer VALUES(?,?,?,?)");
            stm.setString(1,dto.getId());
            stm.setString(2,dto.getName());
            stm.setString(3,dto.getAddress());
            stm.setObject(4,dto.getSalary());

            if(stm.executeUpdate()>0){
                new Alert(Alert.AlertType.CONFIRMATION,
                        "Saved!", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,
                        "Try Again!", ButtonType.OK).show();
            }

        }else{
            //update
        }


    }
}
