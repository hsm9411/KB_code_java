package org.scoula;

import org.scoula.cli.App;
import org.scoula.cli.MenuItem;
import org.scoula.cli.command.ExitCommand;
import org.scoula.travel.service.TravelService;

public class TravelApp extends App {
    TravelService service = new TravelService();

    @Override
    public void init() {
        menu.add(new MenuItem("전체 목록", service::getList));
        menu.add(new MenuItem("페이지별 목록", service::getPage));
        menu.add(new MenuItem("권역별 목록", service::getByDistrict));
        menu.add(new MenuItem("키워드 검색", service::search));
        menu.add(new MenuItem("상세보기", service::getDetail));
        menu.add(new MenuItem("여행지 추가", service::add));
        menu.add(new MenuItem("여행지 삭제", service::delete));
        menu.add(new MenuItem("종료", new ExitCommand()));
    }

    @Override
    public void greeting() {
        System.out.println("======================================================================");
        System.out.println("                대한민국 구석구석 여행지 관리 시스템");
        System.out.println("======================================================================");
    }

    @Override
    public void goodbye() {
        System.out.println("======================================================================");
        System.out.println("                이용해 주셔서 감사합니다. 안녕히 가세요!");
        System.out.println("======================================================================");
    }

    public static void main(String[] args) {
        App app = new TravelApp();
        app.run();
    }
}
