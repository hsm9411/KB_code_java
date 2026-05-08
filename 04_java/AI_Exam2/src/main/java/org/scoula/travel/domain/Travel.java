package org.scoula.travel.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @CsvBindByName(column = "no")
    private int no;

    @CsvBindByName(column = "district")
    private String district;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "phone")
    private String phone;
}
