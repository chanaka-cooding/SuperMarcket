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


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardFormController {

    public AnchorPane context;

    public void initialize() throws IOException {
        loadDefault();//Alt + Enter
    }

    private void loadDefault() throws IOException {
        setUi("DefaultForm");
    }

    public void loadCustomer(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm");
    }

    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.
                load(this.getClass().
                        getResource("/view/" + location + ".fxml")));
    }
}
