package de.haw.landshut.itt;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "lecture")
public class XmlLecture {

    @XmlElement
    private String name;

    @XmlElement
    private String semester;

    @XmlElement
    private Course course;

    @XmlElement
    private Lecturer lecturer;

    @XmlElementWrapper(name = "books")
    @XmlElementRef
    private List<Book> books;

    @XmlElementWrapper(name = "classes")
    @XmlElementRef
    private List<Class> classes;

    public XmlLecture() {
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "Lecture{" +
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

    @XmlRootElement
    public enum Course {
        IF,
        WIF,
        DVM
    }

    @XmlRootElement
    public static class Lecturer {
        @XmlElement(name = "first-name")
        private String firstName;
        @XmlElement(name = "last-name")
        private String lastName;
        @XmlAttribute
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
            return "Lecturer{" +
                    "firstName='" +
                    firstName +
                    '\'' +
                    ", lastName='" +
                    lastName +
                    '\'' +
                    ", id='" +
                    id +
                    '\'' +
                    '}';
        }
    }

    @XmlRootElement
    public static class Book {
        @XmlElement
        private String title;
        @XmlElement
        private String author;
        @XmlElement
        private int year;
        @XmlElement
        private long isbn;
        @XmlAttribute
        private String id;

        public Book() {
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

        public long getIsbn() {
            return isbn;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" +
                    title +
                    '\'' +
                    ", author='" +
                    author +
                    '\'' +
                    ", year=" +
                    year +
                    ", isbn=" +
                    isbn +
                    ", id='" +
                    id +
                    '\'' +
                    '}';
        }
    }

    @XmlRootElement
    public static class Class {
        @XmlElement
        private Date date;

        public Class() {
        }

        public Date getData() {
            return date;
        }

        @Override
        public String toString() {
            return "Class{" + "date=" + date + '}';
        }
    }

    public static class DateAdapter extends XmlAdapter<String, Date> {

        @Override
        public Date unmarshal(String s) throws Exception {
            return Date.from(Instant.parse(s));
        }

        @Override
        public String marshal(Date date) throws Exception {
            throw new RuntimeException("implement");
        }
    }
}
