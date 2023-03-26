module com.vexed.vexed {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires javafx.swing;

    opens com.comp2059.app to javafx.fxml;
    exports com.comp2059.app;
    exports com.comp2059.app.controller;
    opens com.comp2059.app.controller to javafx.fxml;
    exports com.comp2059.app.utils;
    opens com.comp2059.app.utils to javafx.fxml;
    exports com.comp2059.app.view;
    opens com.comp2059.app.view to javafx.fxml;
    exports com.comp2059.app.model;
    opens com.comp2059.app.model to javafx.fxml;
    exports com.comp2059.app.model.bullet;
    opens com.comp2059.app.model.bullet to javafx.fxml;
    exports com.comp2059.app.model.shuttle;
    opens com.comp2059.app.model.shuttle to javafx.fxml;
    exports com.comp2059.app.model.fireStrategy;
    opens com.comp2059.app.model.fireStrategy to javafx.fxml;
}

