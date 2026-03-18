package de.haw.landshut.itt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class JsonLecture {

    @JsonProperty
    private String name;

    @JsonProperty
    private String semester;

    @JsonProperty
    private Course course;

    @JsonProperty
    private Lecturer lecturer;

    @JsonProperty
    private List<Book> books;

    @JsonProperty
    private List<Class> classes;

    public JsonLecture() {
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public Course getCourse() {
        return course;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Class> getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "JsonLecture{" +
                "name='" +
                name +
                '\'' +
                ", semester='" +
                semester +
                '\'' +
                ", course=" +
                course +
                ", lecturer=" +
                lecturer +
                ", books=" +
                books +
                ", classes=" +
                classes +
                '}';
    }

    public enum Course {
        IF, WIF, DVM
    }

    public static class Lecturer {
        @JsonProperty("first-name")
        private String firstName;
        @JsonProperty("last-name")
        private String lastName;
        @JsonProperty("_id")
        private String id;

        public Lecturer() {
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public record Book(@JsonProperty String title,
                       @JsonProperty String author,
                       @JsonProperty int year,
                       @JsonProperty long isbn) {
    }

    public static class Class {

        private final int id;
        private final String date;

        public Class(@JsonProperty("_id") final int id,
                     @JsonProperty("date") final String date) {
            this.id = id;
            this.date = date;
        }

        public String getData() {
            return date;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Class{" + "id=" + id + ", date='" + date + '\'' + '}';
        }
    }
}
