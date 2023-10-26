package week07.PatikaClone.com.patikadev.Model;

import week07.PatikaClone.com.patikadev.Helper.DBConnector;
import week07.PatikaClone.com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Comment {
    int id;
    int content_id;
    int student_id;
    String description;

    User student;

    public Comment() {}
    public Comment(int id, int content_id, int student_id, String description) {
        this.id = id;
        this.content_id = content_id;
        this.student_id = student_id;
        this.description = description;
        this.student = User.fetch(student_id);
    }

    public static ArrayList<Comment> getList() {
        ArrayList<Comment> commentList = new ArrayList<>();
        String query = "SELECT * FROM comment";
        Comment obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Comment();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setDescription(rs.getString("description"));
                commentList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return commentList;
    }

    public static boolean add(int content_id, int student_id, String description) {
        String query = "INSERT INTO comment (content_id, student_id, description) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, content_id);
            ps.setInt(2, student_id);
            ps.setString(3, description);

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

    public static Comment fetch(int id) {
        Comment obj = null;
        String query = "SELECT * FROM comment WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Comment();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setDescription(rs.getString("description"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM comment WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean update(int id, int content_id, int student_id, String description) {
        String query = "UPDATE comment content_id = ?, student_id = ?, description = ? WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, content_id);
            ps.setInt(2, student_id);
            ps.setString(3, description);
            ps.setInt(4, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<Comment> searchCommentList(int id, int content_id, int student_id, String description) {
        ArrayList<Comment> commentList = new ArrayList<>();
        Object[] searchCriteria = {"id", id, "content_id", content_id, "student_id", student_id, "description", description};

        String query = "SELECT * FROM comment WHERE";
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

        Comment obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Comment();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setDescription(rs.getString("description"));
                commentList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return commentList;
    }

    public static ArrayList<Comment> searchCommentListByContentId(int content_id) {
        ArrayList<Comment> commentList = new ArrayList<>();

        String query = "SELECT * FROM comment WHERE content_id = '" + content_id + "'";

        Comment obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Comment();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setDescription(rs.getString("description"));
                commentList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return commentList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
