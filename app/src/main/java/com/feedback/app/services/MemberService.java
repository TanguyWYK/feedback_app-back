package com.feedback.app.services;

import com.feedback.app.models.Manager;
import com.feedback.app.models.Member;
import com.feedback.app.repositories.ManagerRepository;
import com.feedback.app.repositories.MemberRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public Iterable<Member> getMemberByManagerId(int managerId){
        return memberRepository.findByManagerId(managerId);
    }
}
