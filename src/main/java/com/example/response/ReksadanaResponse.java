package com.example.response;

import java.util.List;
import com.example.reksadana.model.Reksadana;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReksadanaResponse {
    private int statusCode;
    private String message;
    private List<Reksadana> data;
}