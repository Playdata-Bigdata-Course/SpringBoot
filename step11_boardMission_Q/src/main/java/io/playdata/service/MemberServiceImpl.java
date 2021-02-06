package io.playdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.playdata.dao.MemberRepository;
import io.playdata.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepo;

	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepo.findById(member.getId());
		if (findMember.isPresent()) {
			return findMember.get();
		}else {
			return null;
		}
	}
}
