package com.feedback.app.dto_out;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Setter
@Getter
@Component
public class FeedbackDTO {
    int value;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    String criterionName;
    String memberEmail;
}
