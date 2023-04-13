package com.feedback.app.services;

import com.feedback.app.dto_out.MemberDTO;
import com.feedback.app.models.Member;
import com.feedback.app.repositories.MemberRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Iterable<MemberDTO> getMembersByManagerId(int managerId){
        Iterable<Member> members = memberRepository.findByManagerId(managerId);
        return buildDTOsFromEntity(members);
    }

    private Iterable<MemberDTO> buildDTOsFromEntity(Iterable<Member> members) {
        ArrayList<MemberDTO> memberDTOS = new ArrayList<>();
        for (Member member : members) {
            ModelMapper modelMapper = new ModelMapper();
            MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);
            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }
}
