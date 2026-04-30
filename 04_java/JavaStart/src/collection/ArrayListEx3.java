package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx3 {
    Scanner scanner=new Scanner(System.in);
    ArrayList<Board>list=new ArrayList<Board>();
    public boolean idCheck(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id)return true;
        }
        return false;
    }
    //	private int id;
//	private String title;
//	private String author;
//	private String contents;
//	private String regdate;
    public void addBoard() {
        Board board=new Board();
        int id=-1;
        do {
            System.out.println("ID");
            id=scanner.nextInt();
        }while(idCheck(id));
        board.setId(id);
        System.out.println("title");
        board.setTitle(scanner.next());
        System.out.println("author");
        board.setAuthor(scanner.next());
        System.out.println("contents");
        board.setContents(scanner.next());
        System.out.println("regdate");
        board.setRegdate(scanner.next());
        list.add(board);

    }
    public void listBoard() {
        for(Board board:list) {
            System.out.println(board);
        }
    }
    public int searchBoardIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id)return i;
        }
        return -1;
    }
    public Board getBoard(int index) {
        return list.get(index);
    }
    public void infoBoard() {//상세정보
        System.out.println("Serarch Id:");
        int index=searchBoardIndex(scanner.nextInt());

        System.out.println(index==-1?"No SuchElement ":getBoard(index));
    }
    public void deleteBoard() {
        System.out.println("Delete할 ID입력");
        int index=searchBoardIndex(scanner.nextInt());
        if(index==-1) {
            System.out.println("No SuchEmlemt!");
            return;
        }
        Board board= list.remove(index);
        System.out.println(board.getAuthor().concat("남삭제"));

    }
    public void modifyBoard() {
        System.out.println("수정할 ID:");
        int index=searchBoardIndex(scanner.nextInt());
        if(index==-1) {
            System.out.println("No SuchEmlemt!");
            return;
        }
        Board board=getBoard(index);
        System.out.println("Modifytitle");
        board.setTitle(scanner.next());
        System.out.println("Modifyauthor");
        board.setAuthor(scanner.next());
        System.out.println("Modifycontents");
        board.setContents(scanner.next());
        System.out.println("Modifyregdate");
        board.setRegdate(scanner.next());
    }
    public void menu() {
        while(true) {
            System.out.println("1.Add 2.List 3.Info 4.Modify 5.Delete 6.Exit");
            switch (scanner.nextInt()) {
                case 1:
                    addBoard();
                    break;
                case 2:
                    listBoard();
                    break;
                case 3:
                    infoBoard();break;
                case 4:
                    modifyBoard();
                    break;
                case 5:
                    deleteBoard();
                    break;

            }//switch
        }//while
    }//menu

    public static void main(String[] args) {
        ArrayListEx3 a=new ArrayListEx3();
        a.menu();
    }

}

