package com.EstructurasDatos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Import del tema de AtlantaFX
import atlantafx.base.theme.PrimerLight;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Aplicar el tema de AtlantaFX
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());  // :contentReference[oaicite:2]{index=2}

        stage.setTitle("Demo JavaFX + AtlantaFX");

        // Label con estilo de borde rojo
        Label label = new Label("Label con borde rojo");
        label.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-padding: 10px; -fx-font-size: 14px;");

        // Botón estilizado
        Button button = new Button("Haz clic aquí");
        button.setStyle("-fx-font-size: 16px; -fx-padding: 8px 16px;");

        // Acción del botón
        button.setOnAction(e -> {
            label.setText("¡Botón pulsado!");
        });

        // Layout
        VBox root = new VBox(20, label, button);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}