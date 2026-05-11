package org.scoula.travel.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.scoula.travel.domain.Travel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDao {
    private static final String FILE_NAME = "travel.csv";
    private static final int PAGE_SIZE = 10;
    private static final java.util.Comparator<Travel> BY_DISTRICT_TITLE =
            java.util.Comparator.comparing(Travel::getDistrict).thenComparing(Travel::getTitle);
    private List<Travel> travels = new ArrayList<>();

    public TravelDao() {
        ensureCsvExists();
        load();
    }

    // JAR 배포 시 최초 실행이면 내장 리소스를 현재 디렉토리에 복사
    private void ensureCsvExists() {
        File file = new File(FILE_NAME);
        if (file.exists()) return;
        try (InputStream is = TravelDao.class.getResourceAsStream("/travel.csv")) {
            if (is == null) {
                System.err.println("내장 리소스에서 travel.csv를 찾을 수 없습니다.");
                return;
            }
            try (OutputStream os = new FileOutputStream(file)) {
                is.transferTo(os);
            }
            System.out.println("travel.csv를 현재 디렉토리에 초기화했습니다.");
        } catch (IOException e) {
            System.err.println("travel.csv 초기화 중 오류: " + e.getMessage());
        }
    }

    public void load() {
        try (Reader reader = new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8)) {
            travels = new CsvToBeanBuilder<Travel>(reader)
                    .withType(Travel.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            travels = new ArrayList<>();
        }
    }

    public void save() {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(FILE_NAME), StandardCharsets.UTF_8)) {
            StatefulBeanToCsv<Travel> beanToCsv = new StatefulBeanToCsvBuilder<Travel>(writer).build();
            beanToCsv.write(travels);
        } catch (Exception e) {
            System.err.println("파일을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public List<Travel> findAll() {
        return travels.stream()
                .sorted(BY_DISTRICT_TITLE)
                .toList();
    }

    public List<Travel> getPage(int page) {
        List<Travel> sortedList = findAll();
        int fromIndex = (page - 1) * PAGE_SIZE;
        if (fromIndex < 0 || fromIndex >= sortedList.size()) {
            return new ArrayList<>();
        }
        int toIndex = Math.min(fromIndex + PAGE_SIZE, sortedList.size());
        return new ArrayList<>(sortedList.subList(fromIndex, toIndex));
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) travels.size() / PAGE_SIZE);
    }

    public List<Travel> findByDistrict(String district) {
        String lower = district.toLowerCase();
        return travels.stream()
                .filter(t -> t.getDistrict().toLowerCase().contains(lower))
                .sorted(java.util.Comparator.comparing(Travel::getTitle))
                .toList();
    }

    public List<Travel> search(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return travels.stream()
                .filter(t -> (t.getTitle() != null && t.getTitle().toLowerCase().contains(lowerKeyword)) ||
                             (t.getDescription() != null && t.getDescription().toLowerCase().contains(lowerKeyword)))
                .sorted(BY_DISTRICT_TITLE)
                .toList();
    }

    public Optional<Travel> findById(int no) {
        return travels.stream()
                .filter(t -> t.getNo() == no)
                .findFirst();
    }

    public void create(Travel travel) {
        int maxNo = travels.stream()
                .mapToInt(Travel::getNo)
                .max()
                .orElse(0);
        travel.setNo(maxNo + 1);
        travels.add(travel);
        save();
    }

    public boolean update(Travel travel) {
        for (int i = 0; i < travels.size(); i++) {
            if (travels.get(i).getNo() == travel.getNo()) {
                travels.set(i, travel);
                save();
                return true;
            }
        }
        return false;
    }

    public boolean delete(int no) {
        boolean removed = travels.removeIf(t -> t.getNo() == no);
        if (removed) {
            save();
        }
        return removed;
    }
}
