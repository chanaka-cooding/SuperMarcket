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


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField pwd;
    public AnchorPane root;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        String userName=txtUserName.getText().trim();
        String password=pwd.getText().trim();

        if (userName.length()>0 && password.length()>0){
            if (userName.equalsIgnoreCase("Lahiru")
                    && password.equals("1234")){
                /*start Login */

                Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(this.getClass()
                        .getResource("/view/DashBoardForm.fxml"))));
                window.centerOnScreen();

                /*End Login */
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!",
                        ButtonType.OK).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING, "User Name Or Password Empty!",
                    ButtonType.OK).show();
        }


    }
}
