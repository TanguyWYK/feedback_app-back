package com.feedback.app.controllers;

import com.feedback.app.dto_out.MemberDTO;
import com.feedback.app.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value = "/members/{managerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<MemberDTO>> getMembersByManagerId(@PathVariable String managerId) throws InvocationTargetException, IllegalAccessException {
        Iterable<MemberDTO> memberDTOS = memberService.getMembersByManagerId(Integer.parseInt(managerId));
        return new ResponseEntity<>(memberDTOS, HttpStatus.OK);
    }


}
