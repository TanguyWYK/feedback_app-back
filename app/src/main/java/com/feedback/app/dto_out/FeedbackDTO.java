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

    private int id;
    private int value;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int criterionId;
    private String memberEmail;

    private String managerEmailThisMonth;

    @Override
    public String toString() {
        return date + " " + memberEmail + " criterionId: " + criterionId + " value:" + value;
    }
}
