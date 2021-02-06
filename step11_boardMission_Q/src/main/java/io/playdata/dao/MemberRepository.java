package io.playdata.dao;

import org.springframework.data.repository.CrudRepository;

import io.playdata.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
