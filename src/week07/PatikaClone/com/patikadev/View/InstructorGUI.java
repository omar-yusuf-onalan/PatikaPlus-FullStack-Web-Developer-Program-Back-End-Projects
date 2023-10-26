package week07.PatikaClone.com.patikadev.View;

import week07.PatikaClone.com.patikadev.Helper.Config;
import week07.PatikaClone.com.patikadev.Helper.Helper;
import week07.PatikaClone.com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class InstructorGUI extends JFrame {
    private JPanel wrapper;
    private JButton btn_logout;
    private JLabel lbl_welcome;
    private JScrollPane scrl_content_list;
    private JTable tbl_content_list;
    private JTextField tf_content_title;
    private JTextField tf_content_description;
    private JTextField tf_content_ytlink;
    private JButton btn_add_content;
    private JButton btn_search_content;
    private JButton btn_delete_content;
    private JPanel pnl_content_form;
    private JLabel lbl_content_description;
    private JLabel lbl_content_ytlink;
    private JLabel lbl_content_title;
    private JTextField tf_content_id;
    private JComboBox cmb_content_course_title;
    private JTabbedPane tab_instructor;
    private JPanel pnl_content;
    private JPanel pnl_quiz;
    private JTable tbl_quiz_list;
    private JScrollPane scrl_quiz_list;
    private JTextField tf_quiz_question;
    private JTextField tf_quiz_a;
    private JTextField tf_quiz_b;
    private JTextField tf_quiz_c;
    private JTextField tf_quiz_d;
    private JTextField tf_quiz_answer;
    private JButton btn_add_quiz;
    private JButton btn_search_quiz;
    private JTextField tf_quiz_id;
    private JButton btn_delete_quiz;
    private JComboBox cmb_quiz_content_name;
    private JLabel lbl_quiz_question;
    private JLabel lbl_quiz_a;
    private JLabel lbl_quiz_b;
    private JLabel lbl_quiz_c;
    private JLabel lbl_quiz_d;
    private JLabel lbl_quiz_answer;
    private JLabel lbl_quiz_id;
    private JLabel lbl_quiz_content;

    private static DefaultTableModel mdl_content_list;
    private static Object[] row_content_list;

    private static DefaultTableModel mdl_quiz_list;
    private static Object[] row_quiz_list;

    private final Instructor instructor;

    public InstructorGUI(Instructor instructor) {
        this.instructor = instructor;

        initWindow(instructor);


        initContentList();
        initContentListeners();

        initQuizList();
        initQuizListeners();
    }

    private void initWindow(Instructor instructor) {
        add(wrapper);

        setSize(1200, 700);

        int x = Helper.getScreenCenter("x", getSize());
        int y = Helper.getScreenCenter("y", getSize());

        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Welcome " + instructor.getName());
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
        ArrayList<Course> courseList = Course.searchCourseListByUserId(instructor.getId());

        for (Course obj : courseList) {
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
        ArrayList<Course> courseList = Course.searchCourseListByUserId(instructor.getId());

        for (Course obj : courseList) {
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
        Instructor steveray = new Instructor(11, "Steve Ray", "steveray", "12345514", "instructor");
        InstructorGUI instructorGUI = new InstructorGUI(steveray);
    }
}
