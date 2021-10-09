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

package db;

/**
 * @author Lahiru Chanaka <chankalahiru69@gmail.com>
 * @since 10/9/2021
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection=null;
    private DBConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/Kade",
                        "root","1234");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
            return (null==dbConnection)?
                    (dbConnection= new DBConnection()):(dbConnection);
    }

    public Connection getConnection(){return connection;}
}

