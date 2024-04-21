package org.spt.member.member.repository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateMemberDataServiceImpl implements CreateMemberDataService {

    private final MemberRepository memberRepository;

    public CreateMemberDataServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public MemberEntity create(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }

    @Override
    public Optional<MemberEntity> findByPk(long pk) {
        return memberRepository.findById(pk);
    }
}
