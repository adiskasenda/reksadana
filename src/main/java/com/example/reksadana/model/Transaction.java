package com.example.reksadana.model;
import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.reksadana.helper.ConstantHelper;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "transaction" )
public class Transaction {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String no_order;
    private String name;
    private Integer reksadana_id;
    private Integer nominal;
    private String payment_method;

    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConstantHelper.DATE_TIME, timezone = ConstantHelper.ASIA_JAKARTA)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConstantHelper.DATE_TIME, timezone = ConstantHelper.ASIA_JAKARTA)
    private Timestamp updatedAt;
}
