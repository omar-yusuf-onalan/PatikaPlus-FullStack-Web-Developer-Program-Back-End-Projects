package week07.PatikaClone.com.patikadev.View;

import week07.PatikaClone.com.patikadev.Helper.Config;
import week07.PatikaClone.com.patikadev.Helper.Helper;
import week07.PatikaClone.com.patikadev.Model.Instructor;
import week07.PatikaClone.com.patikadev.Model.Operator;
import week07.PatikaClone.com.patikadev.Model.Student;
import week07.PatikaClone.com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_user_login;
    private JLabel lbl_user_login;
    private JLabel lbl_icon;
    private JTextField tf_user_login_username;
    private JTextField tf_user_login_password;
    private JLabel lbl_user_login_username;
    private JLabel lbl_user_login_password;
    private JButton btn_login_user;
    private JTabbedPane tab;
    private JLabel lbl_user_signup;
    private JButton btn_signup_user;
    private JTextField tf_user_signup_name;
    private JPasswordField tf_user_signup_password;
    private JLabel lbl_user_signup_name;
    private JLabel lbl_user_signup_username;
    private JTextField tf_user_signup_username;
    private JLabel lbl_user_signup_password;
    private JPanel pnl_user_signup;

    public LoginGUI() {
        add(wrapper);

        setSize(700, 600);

        int x = Helper.getScreenCenter("x", getSize());
        int y = Helper.getScreenCenter("y", getSize());

        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        initSignUpListeners();
        initLoginListeners();
    }

    private void initSignUpListeners() {
        btn_signup_user.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_user_signup_name) || Helper.isFieldEmpty(tf_user_signup_username) || Helper.isFieldEmpty(tf_user_signup_password)) {
                Helper.showMessage("fill");
                return;
            }

            String name = tf_user_signup_name.getText();
            String username = tf_user_signup_username.getText();
            String password = String.valueOf(tf_user_signup_password.getPassword());
            String type = "student"; // only a student can sign up

            if (User.add(name, username, password, type)) {
                login(User.fetch(username));
            }
        });
    }

    private void initLoginListeners() {
        btn_login_user.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_user_login_username) || Helper.isFieldEmpty(tf_user_login_password)) {
                Helper.showMessage("fill");
            } else {
                User user = User.fetch(tf_user_login_username.getText(), tf_user_login_password.getText());

                if (user == null) {
                    Helper.showMessage("User not found");
                } else {
                    Helper.showMessage("success");
                    Helper.showMessage("Logging in...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    login(user);
                }

                }
        });
    }

    public void login(User user) {
        switch (user.getType()) {
            case "student":
                new StudentGUI(new Student(user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getType()));
                break;
            case "instructor":
                new InstructorGUI(new Instructor(user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getType()));
                break;
            case "operator":
                new OperatorGUI(new Operator(user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getType()));
        }
        dispose();
    }

    public static void main(String[] args) {
        Helper.setLayout("Nimbus");
        LoginGUI login = new LoginGUI();
    }
}
