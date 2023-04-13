package com.feedback.app.dto_in;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class FeedbackPatchDTO {
    private int id;
    private int value;

}
