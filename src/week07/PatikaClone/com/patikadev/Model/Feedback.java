package week07.PatikaClone.com.patikadev.Model;

import week07.PatikaClone.com.patikadev.Helper.DBConnector;
import week07.PatikaClone.com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Feedback {
    int id;
    int content_id;
    int student_id;
    int point;

    Content content;
    User student;

    public Feedback() {}

    public Feedback(int id, int content_id, int student_id, int point) {
        this.id = id;
        this. content_id = content_id;
        this.student_id = content_id;
        this.point = point;

        this.content = Content.fetch(content_id);
        this.student = User.fetch(student_id);
    }

    public static ArrayList<Feedback> getList() {
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        String query = "SELECT * FROM feedback";
        Feedback obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Feedback();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setPoint(rs.getInt("point"));
                feedbackList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return feedbackList;
    }

    public static boolean add(int content_id, int student_id, int point) {
        String query = "INSERT INTO feedback (content_id, student_id, point) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, content_id);
            ps.setInt(2, student_id);
            ps.setInt(3, point);

            int response = ps.executeUpdate();

            if (response == -1) {
                Helper.showMessage("error");
            }
            ps.close();
            return response != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static Feedback fetch(int id) {
        Feedback obj = null;
        String query = "SELECT * FROM feedback WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Feedback();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setPoint(rs.getInt("point"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM feedback WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean update(int id, int content_id, int student_id, int point) {
        String query = "UPDATE feedback content_id = ?, student_id = ?, description = ? WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, content_id);
            ps.setInt(2, student_id);
            ps.setInt(3, point);
            ps.setInt(4, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<Feedback> searchFeedbackList(int id, int content_id, int student_id, int point) {
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        Object[] searchCriteria = {"id", id, "content_id", content_id, "student_id", student_id, "point", point};

        String query = "SELECT * FROM feedback WHERE";
        boolean prefixAnd = false;

        for (int i = 0; i < searchCriteria.length; i += 2) {
            if (searchCriteria[i + 1] == null || searchCriteria[i + 1].toString().isEmpty()) {
                continue;
            }

            if (prefixAnd) {
                query += " AND";
            }

            query += " " + searchCriteria[i] + " LIKE " + "'%" + searchCriteria[i + 1] + "%'";

            if (!prefixAnd) {
                prefixAnd = true;
            }
        }

        Feedback obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Feedback();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setPoint(rs.getInt("point"));
                feedbackList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return feedbackList;
    }

    public static ArrayList<Feedback> searchFeedbackListByContentId(int content_id) {
        ArrayList<Feedback> feedbackList = new ArrayList<>();

        String query = "SELECT * FROM feedback WHERE content_id = '" + content_id + "'";

        Feedback obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Feedback();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setPoint(rs.getInt("point"));
                feedbackList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return feedbackList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
