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
    private static final String FILE_PATH = "src/main/resources/travel.csv";
    private List<Travel> travels = new ArrayList<>();

    public TravelDao() {
        load();
    }

    public void load() {
        try (Reader reader = new InputStreamReader(new FileInputStream(FILE_PATH), StandardCharsets.UTF_8)) {
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
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(FILE_PATH), StandardCharsets.UTF_8)) {
            StatefulBeanToCsv<Travel> beanToCsv = new StatefulBeanToCsvBuilder<Travel>(writer).build();
            beanToCsv.write(travels);
        } catch (Exception e) {
            System.err.println("파일을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public List<Travel> findAll() {
        return travels.stream()
                .sorted((t1, t2) -> {
                    int res = t1.getDistrict().compareTo(t2.getDistrict());
                    if (res == 0) {
                        res = t1.getTitle().compareTo(t2.getTitle());
                    }
                    return res;
                })
                .toList();
    }

    public List<Travel> getPage(int page) {
        List<Travel> sortedList = findAll();
        int pageSize = 10;
        int fromIndex = (page - 1) * pageSize;
        if (fromIndex < 0 || fromIndex >= sortedList.size()) {
            return new ArrayList<>();
        }
        int toIndex = Math.min(fromIndex + pageSize, sortedList.size());
        return new ArrayList<>(sortedList.subList(fromIndex, toIndex));
    }

    public int getTotalPages() {
        int pageSize = 10;
        return (int) Math.ceil((double) travels.size() / pageSize);
    }

    public List<Travel> findByDistrict(String district) {
        return travels.stream()
                .filter(t -> t.getDistrict().equals(district))
                .sorted((t1, t2) -> t1.getTitle().compareTo(t2.getTitle()))
                .toList();
    }

    public List<Travel> search(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return travels.stream()
                .filter(t -> (t.getTitle() != null && t.getTitle().toLowerCase().contains(lowerKeyword)) ||
                             (t.getDescription() != null && t.getDescription().toLowerCase().contains(lowerKeyword)))
                .sorted((t1, t2) -> {
                    int res = t1.getDistrict().compareTo(t2.getDistrict());
                    if (res == 0) {
                        res = t1.getTitle().compareTo(t2.getTitle());
                    }
                    return res;
                })
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
