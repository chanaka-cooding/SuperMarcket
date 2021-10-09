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


import db.DBConnection;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultFormController {


    public Label txtCustomerCount;

    public void initialize() throws SQLException, ClassNotFoundException {
        initInfo(); // ALT + ENTER
    }

    private void initInfo() throws SQLException, ClassNotFoundException {
        // Start load Customer Count-----------------
        ResultSet set = DBConnection.getInstance().
                getConnection().
                prepareStatement
                        ("SELECT COUNT(id) FROM Customer")
                .executeQuery();
        if (set.next()) {
            int customerCount = set.getInt(1);
            txtCustomerCount.setText(String.valueOf(customerCount));
        }
        // End load Customer Count-----------------


    }
}
