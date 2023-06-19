package com.hks713.demo.entity;

import com.hks713.demo.repository.MemberRepository;
import com.hks713.demo.repository.TeamRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void save_member() {
        // given
        Team team1 = new Team();
        team1.setName("teamA");
        Team team2 = new Team();
        team2.setName("teamB");

        teamRepository.save(team1);
        teamRepository.save(team2);

        Member member1 = new Member();
        member1.setUsername("memberA");
        member1.setTeam(team1);
        Member member2 = new Member();
        member2.setUsername("memberB");
        member2.setTeam(team2);

        // when
        Member findMember1 = memberRepository.save(member1);
        Member findMember2 = memberRepository.save(member2);

        // then
        Assertions.assertThat(findMember1.getTeam().getName()).isEqualTo("teamA");
        Assertions.assertThat(findMember2.getTeam().getName()).isEqualTo("teamB");


    }

}