package com.feedback.app.dto_in;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@Component
public class FeedbackPostDTO {
    private int managerId;
    private int criterionId;
    private int memberId;
    private int value;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

}
