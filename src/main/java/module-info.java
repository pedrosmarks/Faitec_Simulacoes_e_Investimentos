module br.com.faitec.sistemadeinvestimentos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;


    exports br.com.faitec.sistemadeinvestimentos.main;
    opens br.com.faitec.sistemadeinvestimentos.main to javafx.fxml;

    exports br.com.faitec.sistemadeinvestimentos.viewscontroller;
    opens br.com.faitec.sistemadeinvestimentos.viewscontroller to javafx.fxml;

}