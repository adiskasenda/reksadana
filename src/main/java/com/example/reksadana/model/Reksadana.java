package com.example.reksadana.model;

import java.sql.Date;
import java.sql.Timestamp;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.reksadana.helper.ConstantHelper;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "reksadana" )
public class Reksadana {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String name;
    private Integer price;
    private String year_return;
    private String ratio;
    private String payment;
    private Date date;

    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConstantHelper.DATE_TIME, timezone = ConstantHelper.ASIA_JAKARTA)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConstantHelper.DATE_TIME, timezone = ConstantHelper.ASIA_JAKARTA)
    private Timestamp updatedAt;
}
