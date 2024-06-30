package org.spt.member.member.member.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao {
    private final MemberRepository memberRepository;

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
