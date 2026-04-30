package designpattern.iterator;

public class Book {

    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// record Book(String name){}로 정의 할 수도 있음
