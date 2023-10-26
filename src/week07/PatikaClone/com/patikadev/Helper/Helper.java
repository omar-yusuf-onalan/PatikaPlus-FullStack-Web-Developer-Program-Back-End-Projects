package week07.PatikaClone.com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Helper {

    public static void setLayout(String layoutName) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (layoutName.equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                         InstantiationException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public static int getScreenCenter(String axis, Dimension size) {
        int point;

        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;

        }

        return point;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().isEmpty();
    }

    public static boolean isComboBoxEmpty(JComboBox cmb) {
        return cmb.getModel().getSelectedItem().equals("");
    }

    public static void showMessage(String messageType) {
        String message = "";
        String title = "";

        switch (messageType) {
            case "fill":
                message = "Please fill in all details";
                title = "Fill Error";
                break;
            case "success":
                message = "Operation successful";
                title = "Result";
                break;
            case "error":
                message = "An error has occurred";
                title = "Error";
            default:
                message = messageType;
        }

        JOptionPane.showMessageDialog(
                null, message,
                title, JOptionPane.INFORMATION_MESSAGE);

    }
}
