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

/**
 * @author Lahiru Chanaka <chankalahiru69@gmail.com>
 * @since 10/9/2021
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass()
                .getResource("view/LoginForm.fxml"))));
        primaryStage.show();  //Ctrl + ALT+ L

    }
}
