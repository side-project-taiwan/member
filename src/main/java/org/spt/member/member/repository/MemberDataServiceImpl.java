package org.spt.member.member.repository;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MemberDataServiceImpl implements MemberDataService {
    private final MemberRepository memberRepository;

    public MemberDataServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberEntity create(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }

    @Override
    public MemberEntity update(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }

    @Override
    public void delete(Long pk) {
        memberRepository.deleteById(pk);
    }

    @Override
    public Optional<MemberEntity> findByPk(Long pk) {
        return memberRepository.findById(pk);
    }

    @Override
    public Optional<MemberEntity> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
