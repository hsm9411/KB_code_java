package org.scoula.travel.service;

import org.scoula.cli.ui.Input;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.domain.Travel;

import java.util.List;

public class TravelService {
    TravelDao dao = new TravelDao();

    public void getList() {
        List<Travel> travels = dao.findAll();
        printList(travels);
        System.out.println("총 " + travels.size() + "건의 데이터가 있습니다.");
    }

    public void getPage() {
        int page = 1;
        while (true) {
            List<Travel> list = dao.getPage(page);
            int totalPages = dao.getTotalPages();

            printList(list);
            System.out.printf("페이지: %d/%d\n", page, totalPages);

            String input = Input.getLine("페이지 번호(엔터: 종료)> ");
            if (input.isEmpty()) {
                break;
            }

            try {
                int nextPage = Integer.parseInt(input);
                if (nextPage > 0 && nextPage <= totalPages) {
                    page = nextPage;
                } else {
                    System.out.println("잘못된 페이지 번호입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    public void getByDistrict() {
        String district = Input.getLine("검역할 권역(예: 수도권, 충청권...)> ");
        List<Travel> travels = dao.findByDistrict(district);
        printList(travels);
        System.out.println("총 " + travels.size() + "건의 데이터가 검색되었습니다.");
    }

    public void search() {
        String keyword = Input.getLine("검색어(제목/내용)> ");
        List<Travel> travels = dao.search(keyword);
        printList(travels);
        System.out.println("총 " + travels.size() + "건의 데이터가 검색되었습니다.");
    }

    public void getDetail() {
        int no = Input.getInt("여행지 번호> ");
        dao.findById(no).ifPresentOrElse(
                t -> {
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("번호: " + t.getNo());
                    System.out.println("권역: " + t.getDistrict());
                    System.out.println("제목: " + t.getTitle());
                    System.out.println("설명: " + t.getDescription());
                    System.out.println("주소: " + t.getAddress());
                    System.out.println("전화: " + t.getPhone());
                    System.out.println("----------------------------------------------------------------------");
                },
                () -> System.out.println("해당 번호의 여행지가 존재하지 않습니다.")
        );
    }

    public void add() {
        System.out.println("[여행지 추가]");
        String district = Input.getLine("권역: ");
        String title = Input.getLine("제목: ");
        String description = Input.getLine("설명: ");
        String address = Input.getLine("주소: ");
        String phone = Input.getLine("전화: ");

        Travel travel = new Travel(0, district, title, description, address, phone);
        dao.create(travel);
        System.out.println("여행지가 성공적으로 추가되었습니다.");
    }

    public void delete() {
        int no = Input.getInt("삭제할 여행지 번호: ");
        if (dao.delete(no)) {
            System.out.println(no + "번 여행지가 삭제되었습니다.");
        } else {
            System.out.println("해당 번호의 여행지가 존재하지 않습니다.");
        }
    }

    private void printList(List<Travel> travels) {
        for (Travel t : travels) {
            System.out.printf("%d. [%s] %s\n", t.getNo(), t.getDistrict(), t.getTitle());
        }
    }
}
