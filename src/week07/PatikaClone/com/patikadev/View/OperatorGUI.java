package week07.PatikaClone.com.patikadev.View;
import week07.PatikaClone.com.patikadev.Helper.*;
import week07.PatikaClone.com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JPanel pnl_user_list;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JScrollPane scrl_user_list;

    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JLabel lbl_username;
    private JTextField tf_username;
    private JTextField tf_name;
    private JLabel lbl_name;
    private JLabel lbl_password;
    private JTextField tf_password;
    private JLabel lbl_type;
    private JButton btn_add_user;
    private JComboBox cmb_user_type;
    private JTextField tf_userid;
    private JLabel lbl_userid;
    private JButton btn_delete_user;
    private JTextField tf_search_name;
    private JTextField tf_search_username;
    private JComboBox cmb_search_type;
    private JLabel lbl_search_name;
    private JLabel lbl_search_username;
    private JLabel lbl_search_type;
    private JButton btn_search;
    private JPanel pnl_search_user;
    private JPanel pnl_pathway_list;
    private JScrollPane scrl_pathway_list;
    private JTable tbl_pathway_list;
    private JPanel pnl_pathway_add;
    private JTextField tf_pathway_name;
    private JButton btn_add_pathway;
    private JLabel lbl_pathway_name;
    private JTextField tf_pathway_id;
    private JButton button_delete_pathway;
    private JLabel lbl_pathway_id;
    private JButton btn_search_pathway;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JTextField tf_course_name;
    private JTextField tf_course_lang;
    private JComboBox cmb_course_pathway;
    private JComboBox cmb_course_instructor;
    private JButton btn_add_course;
    private JLabel lbl_course_name;
    private JLabel lbl_course_lang;
    private JLabel lbl_course_pathway;
    private JLabel lbl_course_instructor;
    private JButton btn_search_course;
    private JButton btn_delete_course;
    private JTextField tf_course_id;
    private JLabel lbl_course_id;
    private JPanel pnl_content;
    private JScrollPane scrl_content_list;
    private JTable tbl_content_list;
    private JPanel pnl_content_form;
    private JLabel lbl_content_title;
    private JTextField tf_content_title;
    private JLabel lbl_content_description;
    private JTextField tf_content_description;
    private JLabel lbl_content_ytlink;
    private JTextField tf_content_ytlink;
    private JButton btn_add_content;
    private JButton btn_delete_content;
    private JTextField tf_content_id;
    private JComboBox cmb_content_course_title;
    private JButton btn_search_content;
    private JPanel pnl_quiz;
    private JScrollPane scrl_quiz_list;
    private JTable tbl_quiz_list;
    private JLabel lbl_quiz_question;
    private JTextField tf_quiz_question;
    private JLabel lbl_quiz_a;
    private JTextField tf_quiz_a;
    private JLabel lbl_quiz_b;
    private JTextField tf_quiz_b;
    private JLabel lbl_quiz_c;
    private JTextField tf_quiz_c;
    private JLabel lbl_quiz_d;
    private JTextField tf_quiz_d;
    private JLabel lbl_quiz_answer;
    private JTextField tf_quiz_answer;
    private JButton btn_add_quiz;
    private JButton btn_search_quiz;
    private JLabel lbl_quiz_id;
    private JTextField tf_quiz_id;
    private JButton btn_delete_quiz;
    private JComboBox cmb_quiz_content_name;
    private JLabel lbl_quiz_content;

    private static DefaultTableModel mdl_user_list;
    private static Object[] row_user_list;

    private static DefaultTableModel mdl_pathway_list;
    private static Object[] row_pathway_list;

    private static DefaultTableModel mdl_course_list;
    private static Object[] row_course_list;

    private static DefaultTableModel mdl_content_list;
    private static Object[] row_content_list;

    private static DefaultTableModel mdl_quiz_list;
    private static Object[] row_quiz_list;

    private final Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;

        initWindow(operator);

        initUserList();
        initUserListeners();

        initPathwayList();
        initPathwayListeners();

        initCourseList();
        initCourseListeners();

        initContentList();
        initContentListeners();

        initQuizList();
        initQuizListeners();
    }

    // Window
    private void initWindow(Operator operator) {
        add(wrapper);

        setSize(1200, 600);

        int x = Helper.getScreenCenter("x", getSize());
        int y = Helper.getScreenCenter("y", getSize());

        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Welcome " + operator.getName());
    }



    // User
    private void initUserList() {
        createUserModel();
        createUserTable();
    }
    private void createUserModel() {
        mdl_user_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_user_list = {"ID", "Name", "Username", "Password", "Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];
        loadUserModel();
    }
    private void createUserTable() {
        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }
    private void initUserListeners() {
        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {

            try {
                String selected_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                tf_userid.setText(selected_user_id);
            } catch (Exception ignored) {

            }
        });

        tbl_user_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                String username = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                String password = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                String type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString();

                if (User.update(id, name, username, password, type)) {
                    Helper.showMessage("success");

                }

                loadUserModel();
            }
        });

        btn_add_user.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_name) || Helper.isFieldEmpty(tf_username) || Helper.isFieldEmpty(tf_password)) {
                Helper.showMessage("fill");
                return;
            }

            String name = tf_name.getText();
            String username = tf_username.getText();
            String password = tf_password.getText();
            String type = cmb_user_type.getSelectedItem().toString();

            if (User.add(name, username, password, type)) {
                Helper.showMessage("success");
                loadUserModel();

                tf_name.setText(null);
                tf_username.setText(null);
                tf_password.setText(null);
            }
        });

        btn_delete_user.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_userid)) {
                Helper.showMessage("fill");
                return;
            }

            if(User.delete(Integer.parseInt(tf_userid.getText()))) {
                Helper.showMessage("success");

                ArrayList<Course> coursesToBeDeleted = Course.searchCourseListByUserId(Integer.parseInt(tf_userid.getText()));

                for (Course course : coursesToBeDeleted) {
                    Course.delete(course.getId());
                }

                tf_userid.setText(null);

                loadUserModel();
                loadCourseModel();

                return;
            }

            Helper.showMessage("error");
        });

        btn_search.addActionListener(e -> {
            String name = tf_search_name.getText();
            String username = tf_search_username.getText();
            String type = cmb_search_type.getSelectedItem().toString();

            if (name.isEmpty() && username.isEmpty() && type.isEmpty()) {
                loadUserModel();
                return;
            }

            ArrayList<User> filteredUsers = User.searchUserList(name, username, type);

            loadUserModel(filteredUsers);
        });

        btn_logout.addActionListener(e -> {
            dispose();
        });
    }
    private void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (User obj : User.getList()) {
            i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUsername();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }
    private void loadUserModel(ArrayList<User> userList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);

        for (User obj : userList) {
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUsername();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }



    // Pathway
    private void initPathwayList() {
        createPathwayModel();
        createPathwayTable();
    }
    private void createPathwayModel() {
        mdl_pathway_list = new DefaultTableModel();
        Object[] col_pathway_list = {"ID", "Pathway Name"};
        mdl_pathway_list.setColumnIdentifiers(col_pathway_list);
        row_pathway_list = new Object[col_pathway_list.length];
        loadPathwayModel();
    }
    private void createPathwayTable() {
        tbl_pathway_list.setModel(mdl_pathway_list);
        tbl_pathway_list.getTableHeader().setReorderingAllowed(false);
        tbl_pathway_list.getColumnModel().getColumn(0).setMaxWidth(75);
    }
    private void initPathwayListeners() {
        tbl_pathway_list.getSelectionModel().addListSelectionListener(e -> {

            try {
                String selected_pathway_id = tbl_pathway_list.getValueAt(tbl_pathway_list.getSelectedRow(), 0).toString();
                tf_pathway_id.setText(selected_pathway_id);
            } catch (Exception ignored) {

            }
        });

        tbl_pathway_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int id = Integer.parseInt(tbl_pathway_list.getValueAt(tbl_pathway_list.getSelectedRow(), 0).toString());
                String name = tbl_pathway_list.getValueAt(tbl_pathway_list.getSelectedRow(), 1).toString();

                if (Pathway.update(id, name)) {
                    Helper.showMessage("success");

                }

                loadPathwayModel();
            }
        });

        btn_add_pathway.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_pathway_name)) {
                Helper.showMessage("Fill");
                return;
            }

            String name = tf_pathway_name.getText();

            if (Pathway.add(name)) {
                Helper.showMessage("success");
                loadPathwayModel();

                tf_pathway_name.setText(null);
            }
        });

        button_delete_pathway.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_pathway_id)) {
                Helper.showMessage("fill");
                return;
            }

            if(Pathway.delete(Integer.parseInt(tf_pathway_id.getText()))) {
                Helper.showMessage("success");

                ArrayList<Course> coursesToBeDeleted = Course.searchCourseListByPathwayId(Integer.parseInt(tf_pathway_id.getText()));

                for (Course course : coursesToBeDeleted) {
                    Course.delete(course.getId());
                }

                tf_pathway_id.setText(null);

                loadPathwayModel();
                loadCourseModel();

                return;
            }

            Helper.showMessage("error");
        });

        btn_search_pathway.addActionListener(e -> {
            String name = tf_pathway_name.getText();

            if (name.isEmpty()) {
                loadPathwayModel();
                return;
            }

            ArrayList<Pathway> filteredPathways = Pathway.searchPathwayList(name);

            loadPathwayModel(filteredPathways);
        });
    }
    private void loadPathwayModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_pathway_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Pathway obj : Pathway.getList()) {
            i = 0;
            row_pathway_list[i++] = obj.getId();
            row_pathway_list[i++] = obj.getName();
            mdl_pathway_list.addRow(row_pathway_list);
        }
    }
    private void loadPathwayModel(ArrayList<Pathway> pathwayList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_pathway_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Pathway obj : pathwayList) {
            i = 0;
            row_pathway_list[i++] = obj.getId();
            row_pathway_list[i++] = obj.getName();
            mdl_pathway_list.addRow(row_pathway_list);
        }
    }



    // Course
    private void initCourseList() {
        createCourseModel();
        createCourseTable();
    }
    private void createCourseModel() {
        mdl_course_list = new DefaultTableModel();
        Object[] col_course_list = {"ID", "Course Name", "Programming Language", "Pathway", "Instructor"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];
        loadCourseModel();
    }
    private void createCourseTable() {
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
    }
    private void initCourseListeners() {
        tbl_course_list.getSelectionModel().addListSelectionListener(e -> {

            try {
                String selected_course_id = tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 0).toString();
                tf_course_id.setText(selected_course_id);
            } catch (Exception ignored) {

            }
        });

        tbl_course_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int id = Integer.parseInt(tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 0).toString());
                String name = tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 1).toString();
                String lang = tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 2).toString();
                int pathway_id = Integer.parseInt(tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 3).toString());
                int user_id = Integer.parseInt(tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 4).toString());


                if (Course.update(id, user_id, pathway_id, name, lang)) {
                    Helper.showMessage("success");
                }

                loadCourseModel();
            }
        });

        btn_add_course.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_course_name) || Helper.isFieldEmpty(tf_course_lang)
                    || Helper.isComboBoxEmpty(cmb_course_pathway) || Helper.isComboBoxEmpty(cmb_course_instructor)) {
                Helper.showMessage("fill");
                return;
            }

            String name = tf_course_name.getText();
            String lang = tf_course_lang.getText();

            User instructor = User.fetchWithName(cmb_course_instructor.getSelectedItem().toString());
            int user_id = instructor.getId();

            Pathway pathway = Pathway.fetch(cmb_course_pathway.getSelectedItem().toString());
            int pathway_id = pathway.getId();


            if (Course.add(user_id, pathway_id, name, lang)) {
                Helper.showMessage("success");
                loadCourseModel();

                tf_course_name.setText(null);
                tf_course_lang.setText(null);
            }
        });

        btn_delete_course.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_course_id)) {
                Helper.showMessage("fill");
                return;
            }

            if(Course.delete(Integer.parseInt(tf_course_id.getText()))) {
                Helper.showMessage("success");
                loadCourseModel();
                tf_course_id.setText(null);
                return;
            }

            Helper.showMessage("error");
        });

        btn_search_course.addActionListener(e -> {
            String name = tf_course_name.getText();
            String lang = tf_course_lang.getText();

            User instructor = User.fetchWithName(cmb_course_instructor.getSelectedItem().toString());
            int user_id = instructor.getId();

            Pathway pathway = Pathway.fetch(cmb_course_pathway.getSelectedItem().toString());
            int pathway_id = pathway.getId();

            if (Helper.isFieldEmpty(tf_course_name) && Helper.isFieldEmpty(tf_course_lang)
                    && Helper.isComboBoxEmpty(cmb_course_pathway) && Helper.isComboBoxEmpty(cmb_course_instructor)) {
                loadCourseModel();
                return;
            }

            ArrayList<Course> filteredCourses = Course.searchCourseList(user_id, pathway_id, name, lang);

            loadCourseModel(filteredCourses);
        });
    }
    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Course obj : Course.getList()) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPathway_id();
            row_course_list[i++] = obj.getUser_id();

            mdl_course_list.addRow(row_course_list);
        }

        cmb_course_pathway.removeAllItems();
        ArrayList<Pathway> pathwayList = Pathway.getList();

        for (Pathway obj : pathwayList) {
            cmb_course_pathway.addItem(obj.getName());
        }

        cmb_course_instructor.removeAllItems();
        ArrayList<User> instructorList = User.getList("instructor");

        for (User obj : instructorList) {
            cmb_course_instructor.addItem(obj.getName());
        }
    }
    private void loadCourseModel(ArrayList<Course> courseList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Course obj : courseList) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPathway_id();
            row_course_list[i++] = obj.getUser_id();

            mdl_course_list.addRow(row_course_list);
        }
    }



    // Content
    private void initContentList() {
        createContentModel();
        createContentTable();
    }
    private void createContentModel() {
        mdl_content_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_content_list = {"ID", "Course ID", "Title", "Description", "Youtube Link"};
        mdl_content_list.setColumnIdentifiers(col_content_list);
        row_content_list = new Object[col_content_list.length];
        loadContentModel();
    }
    private void createContentTable() {
        tbl_content_list.setModel(mdl_content_list);
        tbl_content_list.getTableHeader().setReorderingAllowed(false);
    }
    private void initContentListeners() {
        tbl_content_list.getSelectionModel().addListSelectionListener(e -> {

            try {
                String selected_content_id = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 0).toString();
                tf_content_id.setText(selected_content_id);
            } catch (Exception ignored) {

            }
        });

        tbl_content_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {

                int id = Integer.parseInt(tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 0).toString());
                int course_id = Integer.parseInt(tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 1).toString());
                String title = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 2).toString();
                String description = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 3).toString();
                String yt_link = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 4).toString();

                if (Content.update(id, course_id, title, description, yt_link)) {
                    Helper.showMessage("success");
                }

                loadContentModel();
            }
        });

        btn_add_content.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_content_title) || Helper.isFieldEmpty(tf_content_description) || Helper.isFieldEmpty(tf_content_ytlink)
                    || Helper.isComboBoxEmpty(cmb_content_course_title)) {
                Helper.showMessage("fill");
                return;
            }

            Course course = Course.fetch(cmb_content_course_title.getSelectedItem().toString());

            int course_id = course.getId();
            String title = tf_content_title.getText();
            String description = tf_content_description.getText();
            String yt_link = tf_content_ytlink.getText();

            if (Content.add(course_id, title, description, yt_link)) {
                Helper.showMessage("success");
                loadContentModel();
                loadQuizModel();

                tf_content_title.setText(null);
                tf_content_description.setText(null);
                tf_content_ytlink.setText(null);
            }
        });

        btn_delete_content.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_content_id)) {
                Helper.showMessage("fill");
                return;
            }

            if(Content.delete(Integer.parseInt(tf_content_id.getText()))) {
                Helper.showMessage("success");

                ArrayList<Comment> commentsToBeDeleted = Comment.searchCommentListByContentId(Integer.parseInt(tf_content_id.getText()));

                for (Comment comment : commentsToBeDeleted) {
                    Comment.delete(comment.getId());
                }

                ArrayList<Quiz> quizzesToBeDeleted = Quiz.searchQuizListByContentId(Integer.parseInt(tf_content_id.getText()));

                for (Quiz quiz : quizzesToBeDeleted) {
                    Quiz.delete(quiz.getId());
                }

                tf_content_id.setText(null);

                loadContentModel();
                loadQuizModel();

                return;
            }

            Helper.showMessage("error");
        });

        btn_search_content.addActionListener(e -> {
            Course course = Course.fetch(cmb_content_course_title.getSelectedItem().toString());

            String course_id = String.valueOf(course.getId());
            String title = tf_content_title.getText();
            String description = tf_content_description.getText();
            String yt_link = tf_content_ytlink.getText();

            if (title.isEmpty() && description.isEmpty() && yt_link.isEmpty() && course_id.isEmpty()) {
                loadContentModel();
                return;
            }

            ArrayList<Content> filteredContent = Content.searchContentList(Integer.parseInt(course_id), title, description, yt_link);

            loadContentModel(filteredContent);
        });

        btn_logout.addActionListener(e -> {
            dispose();
        });
    }
    private void loadContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Content obj : Content.getList()) {
            i = 0;
            row_content_list[i++] = obj.getId();
            row_content_list[i++] = obj.getCourse_id();
            row_content_list[i++] = obj.getTitle();
            row_content_list[i++] = obj.getDescription();
            row_content_list[i++] = obj.getYt_link();
            mdl_content_list.addRow(row_content_list);
        }

        cmb_content_course_title.removeAllItems();

        for (Course obj : Course.getList()) {
            cmb_content_course_title.addItem(obj.getName());
        }
    }
    private void loadContentModel(ArrayList<Content> contentList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);

        int i;
        for (Content obj : contentList) {
            i = 0;
            row_content_list[i++] = obj.getId();
            row_content_list[i++] = obj.getCourse_id();
            row_content_list[i++] = obj.getTitle();
            row_content_list[i++] = obj.getDescription();
            row_content_list[i++] = obj.getYt_link();
            mdl_content_list.addRow(row_content_list);
        }

        cmb_content_course_title.removeAllItems();

        for (Course obj : Course.getList()) {
            cmb_content_course_title.addItem(obj.getName());
        }
    }



    // Quiz
    private void initQuizList() {
        createQuizModel();
        createQuizTable();
    }
    private void createQuizModel() {
        mdl_quiz_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_quiz_list = {"ID", "Content ID", "Question", "A", "B", "C", "D", "Answer"};
        mdl_quiz_list.setColumnIdentifiers(col_quiz_list);
        row_quiz_list = new Object[col_quiz_list.length];
        loadQuizModel();
    }
    private void createQuizTable() {
        tbl_quiz_list.setModel(mdl_quiz_list);
        tbl_quiz_list.getTableHeader().setReorderingAllowed(false);
    }
    private void initQuizListeners() {
        tbl_quiz_list.getSelectionModel().addListSelectionListener(e -> {

            try {
                String selected_quiz_id = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 0).toString();
                tf_quiz_id.setText(selected_quiz_id);
            } catch (Exception ignored) {

            }
        });

        tbl_quiz_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {

                int id = Integer.parseInt(tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 0).toString());
                int content_id = Integer.parseInt(tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 1).toString());
                String question = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 2).toString();
                String a = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 3).toString();
                String b = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 4).toString();
                String c = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 5).toString();
                String d = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 6).toString();
                String answer = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 7).toString();

                if (Quiz.update(id, content_id, question, a, b, c, d, answer)) {
                    Helper.showMessage("success");
                }

                loadQuizModel();
            }
        });

        btn_add_quiz.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_quiz_question) || Helper.isFieldEmpty(tf_quiz_a) || Helper.isFieldEmpty(tf_quiz_b)
                    || Helper.isFieldEmpty(tf_quiz_c) || Helper.isFieldEmpty(tf_quiz_d) || Helper.isFieldEmpty(tf_quiz_answer)
                    || Helper.isComboBoxEmpty(cmb_quiz_content_name)) {
                Helper.showMessage("fill");
                return;
            }

            Content content = Content.fetch(cmb_quiz_content_name.getSelectedItem().toString());

            int content_id = content.getId();
            String question = tf_quiz_question.getText();
            String a = tf_quiz_a.getText();
            String b = tf_quiz_b.getText();
            String c = tf_quiz_c.getText();
            String d = tf_quiz_d.getText();
            String answer = tf_quiz_answer.getText();


            if (Quiz.add(content_id, question, a, b, c, d, answer)) {
                Helper.showMessage("success");

                tf_quiz_question.setText(null);
                tf_quiz_a.setText(null);
                tf_quiz_b.setText(null);
                tf_quiz_c.setText(null);
                tf_quiz_d.setText(null);
                tf_quiz_answer.setText(null);
            }

            loadQuizModel();
        });

        btn_delete_quiz.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_quiz_id)) {
                Helper.showMessage("fill");
                return;
            }

            if(Quiz.delete(Integer.parseInt(tf_quiz_id.getText()))) {
                Helper.showMessage("success");

                tf_content_id.setText(null);

                loadQuizModel();

                return;
            }

            Helper.showMessage("error");
        });

        btn_search_quiz.addActionListener(e -> {
            Content content = Content.fetch(cmb_quiz_content_name.getSelectedItem().toString());

            String content_id = String.valueOf(content.getId());
            String question = tf_quiz_question.getText();
            String a = tf_quiz_a.getText();
            String b = tf_quiz_b.getText();
            String c = tf_quiz_c.getText();
            String d = tf_quiz_d.getText();
            String answer = tf_quiz_answer.getText();

            if (content_id.isEmpty() && question.isEmpty() && a.isEmpty() && b.isEmpty()
                    && c.isEmpty() && d.isEmpty() && answer.isEmpty()) {
                loadQuizModel();
                return;
            }

            ArrayList<Quiz> filteredQuizzes = Quiz.searchQuizList(Integer.parseInt(content_id), question, a, b, c, d, answer);

            loadQuizModel(filteredQuizzes);
        });
    }
    private void loadQuizModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Quiz obj : Quiz.getList()) {
            i = 0;
            row_quiz_list[i++] = obj.getId();
            row_quiz_list[i++] = obj.getContent_id();
            row_quiz_list[i++] = obj.getQuestion();
            row_quiz_list[i++] = obj.getA();
            row_quiz_list[i++] = obj.getB();
            row_quiz_list[i++] = obj.getC();
            row_quiz_list[i++] = obj.getD();
            row_quiz_list[i++] = obj.getAnswer();
            mdl_quiz_list.addRow(row_quiz_list);
        }

        cmb_quiz_content_name.removeAllItems();
        ArrayList<Content> contentList = Content.getList();

        for (Content obj : contentList) {
            cmb_quiz_content_name.addItem(obj.getTitle());
        }
    }
    private void loadQuizModel(ArrayList<Quiz> quizList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Quiz obj : quizList) {
            i = 0;
            row_quiz_list[i++] = obj.getId();
            row_quiz_list[i++] = obj.getContent_id();
            row_quiz_list[i++] = obj.getQuestion();
            row_quiz_list[i++] = obj.getA();
            row_quiz_list[i++] = obj.getB();
            row_quiz_list[i++] = obj.getC();
            row_quiz_list[i++] = obj.getD();
            row_quiz_list[i++] = obj.getAnswer();
            mdl_quiz_list.addRow(row_quiz_list);
        }

        cmb_quiz_content_name.removeAllItems();
        ArrayList<Content> contentList = Content.getList();

        for (Content obj : contentList) {
            cmb_quiz_content_name.addItem(obj.getTitle());
        }
    }



    public static void main(String[] args) {
        Helper.setLayout("Nimbus");
        Operator op = new Operator(1, "John Doe", "johndoe", "1234", "operator");

        OperatorGUI opGUI = new OperatorGUI(op);
    }
}
