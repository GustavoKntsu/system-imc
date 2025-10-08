module org.systemimc {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.systemimc to javafx.fxml;
    exports org.systemimc;
    exports org.systemimc.Controller;
    opens org.systemimc.Controller to javafx.fxml;
}