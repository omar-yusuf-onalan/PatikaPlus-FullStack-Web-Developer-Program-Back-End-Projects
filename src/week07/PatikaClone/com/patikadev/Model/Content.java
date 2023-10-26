package week07.PatikaClone.com.patikadev.Model;

import week07.PatikaClone.com.patikadev.Helper.DBConnector;
import week07.PatikaClone.com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    int id;
    int course_id;
    String title;
    String description;
    String yt_link;

    Course course;

    public Content() {}

    public Content(int id, int course_id, String title, String description, String yt_link) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.description = description;
        this.yt_link = yt_link;
        this.course = Course.fetch(course_id);
    }

    public static ArrayList<Content> getList() {
        ArrayList<Content> contentList = new ArrayList<>();
        String query = "SELECT * FROM content";
        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setTitle(rs.getString("title"));
                obj.setDescription(rs.getString("description"));
                obj.setYt_link(rs.getString("yt_link"));
                contentList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return contentList;
    }

    public static boolean add(int course_id, String title, String description, String yt_link) {
        String query = "INSERT INTO content (course_id, title, description, yt_link) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, course_id);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, yt_link);

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

    public static Content fetch(int id) {
        Content obj = null;
        String query = "SELECT * FROM content WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setTitle(rs.getString("title"));
                obj.setDescription(rs.getString("description"));
                obj.setYt_link(rs.getString("yt_link"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static Content fetch(String title) {
        Content obj = null;
        String query = "SELECT * FROM content WHERE title = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setTitle(rs.getString("title"));
                obj.setDescription(rs.getString("description"));
                obj.setYt_link(rs.getString("yt_link"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM content WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean update(int id, int course_id, String title, String description, String yt_link) {
        String query = "UPDATE content SET course_id = ?, title = ?, description = ?, yt_link = ? WHERE id = ?";

        if (fetch(title) != null && fetch(title).getId() != id) {
            Helper.showMessage("Content already exists\nEnter a different content title");
            return false;
        }

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);

            ps.setInt(1, course_id);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, yt_link);
            ps.setInt(5, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<Content> searchContentList(int course_id, String title, String description, String yt_link) {
        ArrayList<Content> contentList = new ArrayList<>();
        Object[] searchCriteria = {"course_id", course_id, "description", description, "yt_link", yt_link};

        String query = "SELECT * FROM content WHERE";
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

        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setTitle(rs.getString("title"));
                obj.setDescription(rs.getString("description"));
                obj.setYt_link(rs.getString("yt_link"));
                contentList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return contentList;
    }

    public static ArrayList<Content> searchContentListByCourseId(int course_id) {
        ArrayList<Content> contentList = new ArrayList<>();

        String query = "SELECT * FROM content WHERE course_id = '" + course_id + "'";

        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setTitle(rs.getString("title"));
                obj.setDescription(rs.getString("description"));
                obj.setYt_link(rs.getString("yt_link"));
                contentList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return contentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYt_link() {
        return yt_link;
    }

    public void setYt_link(String yt_link) {
        this.yt_link = yt_link;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
