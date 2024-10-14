module es.ieslosmontecillos.pathtransition {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.pathtransition to javafx.fxml;
    exports es.ieslosmontecillos.pathtransition;
}