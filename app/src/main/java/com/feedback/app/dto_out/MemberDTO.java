package com.feedback.app.dto_out;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class MemberDTO {

    private String email;

    private int id;
}
