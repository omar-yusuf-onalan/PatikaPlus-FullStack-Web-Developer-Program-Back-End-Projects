package week07.PatikaClone.com.patikadev.View;

import week07.PatikaClone.com.patikadev.Helper.Config;
import week07.PatikaClone.com.patikadev.Helper.Helper;
import week07.PatikaClone.com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JTabbedPane tab_student;
    private JPanel pnl_content;
    private JPanel pnl_contents;
    private JScrollPane scrl_contents_list;
    private JTable tbl_contents_list;
    private JButton btn_search_content;
    private JComboBox cmb_available_courses;
    private JLabel lbl_available_courses;
    private JPanel pnl_pathway;
    private JTable tbl_pathway_list;
    private JScrollPane scrl_pathway_list;
    private JButton btn_view_content;
    private JPanel pnl_welcome;
    private JButton btn_submit_answer;
    private JTextField tf_content_feedback;
    private JButton btn_submit_feedback;
    private JButton btn_load_comment;
    private JComboBox cmb_content_answer1;
    private JButton btn_submit_comment;
    private JTextField tf_comment_description;
    private JList list_comment_list;
    private JLabel lbl_content_ytlink;
    private JScrollPane scrl_content_quiz;
    private JLabel lbl_content_question1;
    private JLabel lbl_content_a1;
    private JLabel lbl_content_b1;
    private JLabel lbl_content_c1;
    private JLabel lbl_content_d1;
    private JLabel lbl_content_youranswer1;
    private JLabel lbl_rate;
    private JPanel pnl_comment;
    private JLabel lbl_comment_whatdoyouthink;
    private JScrollPane scrl_comment_list;
    private JTextField tf_pathway_name;
    private JButton btn_search_pathway;
    private JLabel lbl_pathway_name;
    private JButton btn_add_pathway;
    private JTextField tf_pathway_id;
    private JComboBox cmb_content_answer2;
    private JLabel lbl_content_question2;
    private JLabel lbl_content_a2;
    private JLabel lbl_content_b2;
    private JLabel lbl_content_c2;
    private JLabel lbl_content_d2;
    private JLabel lbl_content_youranswer2;
    private JComboBox cmb_content_answer3;
    private JLabel lbl_content_question3;
    private JLabel lbl_content_a3;
    private JLabel lbl_content_b3;
    private JLabel lbl_content_c3;
    private JLabel lbl_content_d3;
    private JLabel lbl_content_youranswer3;
    private JTextField tf_content_id;
    private JLabel lbl_content_youareviewing;
    private JTable tbl_comment_list;
    private JPanel pnl_comment_list;
    private JLabel lbl_comment_comments;

    private static DefaultTableModel mdl_pathway_list;
    private static Object[] row_pathway_list;

    private static DefaultTableModel mdl_content_list;
    private static Object[] row_content_list;

    private static DefaultTableModel mdl_comment_list;
    private static Object[] row_comment_list;

    Student student;

    public StudentGUI(Student student) {
        initWindow(student);

        initPathwayList();
        initPathwayListeners();

        initContentsList();
        initContentsListeners();

        initContentListeners();

        initCommentListeners();
    }



    private void initWindow(Student student) {
        this.student = student;

        add(wrapper);

        setSize(1200, 600);

        int x = Helper.getScreenCenter("x", getSize());
        int y = Helper.getScreenCenter("y", getSize());

        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
    }



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

        btn_add_pathway.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_pathway_name)) {
                Helper.showMessage("fill");
                return;
            }

            String name = tf_pathway_name.getText();

            if (AddedPathway.add(student.getId(), Integer.parseInt(tf_pathway_id.getText()))) {
                Helper.showMessage("success");
                loadPathwayModel();

                tf_pathway_name.setText(null);
            }
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



    private void initContentsList() {
        createContentsModel();
        createContentsTable();
    }
    private void createContentsModel() {
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
        loadContentsModel();
    }
    private void createContentsTable() {
        tbl_contents_list.setModel(mdl_content_list);
        tbl_contents_list.getTableHeader().setReorderingAllowed(false);
    }
    private void initContentsListeners() {
        tbl_contents_list.getSelectionModel().addListSelectionListener(e -> {

            try {
                String selected_content_id = tbl_contents_list.getValueAt(tbl_contents_list.getSelectedRow(), 0).toString();
                tf_content_id.setText(selected_content_id);
            } catch (Exception ignored) {

            }
        });

        btn_search_content.addActionListener(e -> {
            Course course = Course.fetch(cmb_available_courses.getSelectedItem().toString());

            String course_id = String.valueOf(course.getId());

            if (course_id.isEmpty()) {
                loadContentsModel();
                return;
            }

            ArrayList<Content> filteredContent = Content.searchContentListByCourseId(Integer.parseInt(course_id));

            loadContentsModel(filteredContent);
        });

        btn_view_content.addActionListener(e -> {
            loadContentModel(Content.fetch(Integer.parseInt(tf_content_id.getText())));
        });

        btn_logout.addActionListener(e -> {
            dispose();
        });
    }
    private void loadContentsModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_contents_list.getModel();
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

        cmb_available_courses.removeAllItems();
        ArrayList<AddedPathway> list = AddedPathway.searchAddedPathwayList(student.getId());
        String courseName;

        for (AddedPathway obj : list) {
            Pathway pathway = Pathway.fetch(obj.getPathway_id());

            ArrayList<Course> coursesInThePathway = Course.searchCourseListByPathwayId(pathway.getId());

            for (Course course : coursesInThePathway) {
                cmb_available_courses.addItem(course.getName());
            }

        }
    }
    private void loadContentsModel(ArrayList<Content> contentList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_contents_list.getModel();
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

        cmb_available_courses.removeAllItems();
        ArrayList<AddedPathway> list = AddedPathway.searchAddedPathwayList(student.getId());
        String courseName;

        for (AddedPathway obj : list) {
            Pathway pathway = Pathway.fetch(obj.getPathway_id());

            ArrayList<Course> coursesInThePathway = Course.searchCourseListByPathwayId(pathway.getId());

            for (Course course : coursesInThePathway) {
                cmb_available_courses.addItem(course.getName());
            }

        }
    }



    private void initContentListeners() {
        btn_submit_answer.addActionListener(e -> {
            if (Helper.isComboBoxEmpty(cmb_content_answer1)
                    || Helper.isComboBoxEmpty(cmb_content_answer2)
                    || Helper.isComboBoxEmpty(cmb_content_answer3)) {
                Helper.showMessage("fill");
                return;
            }

            ArrayList<Quiz> quizList = Quiz.searchQuizListByContentId(Content.fetch(lbl_content_youareviewing.getText()).getId());

            if (cmb_content_answer1.getSelectedItem().equals(quizList.get(0).getAnswer())) {
                cmb_content_answer1.setBackground(Color.green);
            } else {
                cmb_content_answer1.setBackground(Color.red);
            }

            if (cmb_content_answer2.getSelectedItem().equals(quizList.get(1).getAnswer())) {
                cmb_content_answer2.setBackground(Color.green);
            } else {
                cmb_content_answer2.setBackground(Color.red);
            }

            if (cmb_content_answer3.getSelectedItem().equals(quizList.get(2).getAnswer())) {
                cmb_content_answer3.setBackground(Color.green);
            } else {
                cmb_content_answer3.setBackground(Color.red);
            }
        });
        btn_submit_feedback.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_content_feedback)) {
                Helper.showMessage("fill");
                return;
            }

            int content_id = Content.fetch(lbl_content_youareviewing.getText()).getId();
            int student_id = student.getId();
            int feedback = Integer.parseInt(tf_content_feedback.getText());

            if (Feedback.add(content_id, student_id, feedback))
                Helper.showMessage("Thank you for your feedback!");

        });
        btn_load_comment.addActionListener(e -> {
            initCommentList();
            int content_id = Content.fetch(lbl_content_youareviewing.getText()).getId();
            loadCommentModel(Comment.searchCommentListByContentId(content_id));
        });
    }
    private void loadContentModel(Content content) {
        lbl_content_ytlink.setText(content.getYt_link());
        ArrayList<Quiz> quizList = Quiz.searchQuizListByContentId(content.getId());

        lbl_content_youareviewing.setText(content.getTitle());

        // Question 1
        lbl_content_question1.setText(quizList.get(0).getQuestion());
        lbl_content_a1.setText("A) " + quizList.get(0).getA());
        lbl_content_b1.setText("B) " + quizList.get(0).getB());
        lbl_content_c1.setText("C) " + quizList.get(0).getC());
        lbl_content_d1.setText("D) " + quizList.get(0).getD());

        // Question 2
        lbl_content_question2.setText(quizList.get(1).getQuestion());
        lbl_content_a2.setText("A) " + quizList.get(1).getA());
        lbl_content_b2.setText("B) " + quizList.get(1).getB());
        lbl_content_c2.setText("C) " + quizList.get(1).getC());
        lbl_content_d2.setText("D) " + quizList.get(1).getD());


        // Question 3
        lbl_content_question3.setText(quizList.get(2).getQuestion());
        lbl_content_a3.setText("A) " + quizList.get(2).getA());
        lbl_content_b3.setText("B) " + quizList.get(2).getB());
        lbl_content_c3.setText("C) " + quizList.get(2).getC());
        lbl_content_d3.setText("D) " + quizList.get(2).getD());
    }


    private void initCommentList() {
        createCommentModel();
        createCommentTable();
    }
    private void createCommentModel() {
        mdl_comment_list = new DefaultTableModel();
        Object[] col_comment_list = {"User", "Comment"};
        mdl_comment_list.setColumnIdentifiers(col_comment_list);
        row_comment_list = new Object[col_comment_list.length];
    }
    private void createCommentTable() {
        tbl_comment_list.setModel(mdl_comment_list);
        tbl_comment_list.getTableHeader().setReorderingAllowed(false);
        tbl_comment_list.getColumnModel().getColumn(0);
    }
    private void initCommentListeners() {
        btn_submit_comment.addActionListener(e -> {
            if (Helper.isFieldEmpty(tf_comment_description)) {
                Helper.showMessage("fill");
                return;
            }

            int content_id = Content.fetch(lbl_content_youareviewing.getText()).getId();
            int student_id = student.getId();

            if (Comment.add(content_id, student_id, tf_comment_description.getText())) {
                Helper.showMessage("success");
            }

            loadCommentModel(Comment.searchCommentListByContentId(content_id));
        });
    }
    private void loadCommentModel(ArrayList<Comment> commentList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_comment_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Comment obj : commentList) {
            i = 0;
            row_comment_list[i++] = User.fetch(obj.getStudent_id()).getName();
            row_comment_list[i++] = obj.getDescription();
            mdl_comment_list.addRow(row_comment_list);
        }
    }




    public static void main(String[] args) {
        Helper.setLayout("Nimbus");
        Student johndoe = new Student(1, "John Doe", "johndoe", "johndoe", "student");
        StudentGUI studentGUI = new StudentGUI(johndoe);
    }
}
