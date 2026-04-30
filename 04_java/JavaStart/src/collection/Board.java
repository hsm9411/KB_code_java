package collection;


public class Board {
    private int id;
    private String title;
    private String author;
    private String contents;
    private String regdate;

    public Board() {
    }

    public Board(int id, String title, String author, String contents, String regdate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", contents='" + contents + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
