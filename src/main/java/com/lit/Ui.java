package com.lit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Ui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane flowPane = new FlowPane();
        TextField textField = new TextField(Key.getKey());
        textField.setLayoutY(10d);
        textField.setLayoutY(10d);
        //构建控件
        Button l1=new Button("写入关键字");
        l1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Key.setKey(textField.getText());
            }
        });
        Button l2=new Button("清除关键字");
        l2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Key.setKey("");
            }
        });
        // 注册键盘监听
        KeyboardListenerUtil.initKeyboardListener();
        flowPane.getChildren().add(l1);
        flowPane.getChildren().add(l2);
        flowPane.getChildren().add(textField);
        Scene scene = new Scene(flowPane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("自动改造");
        stage.show();
    }
}
