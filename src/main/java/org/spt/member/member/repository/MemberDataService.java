package org.spt.member.member.repository;

import java.util.Optional;

public interface MemberDataService {
    MemberEntity create(MemberEntity memberEntity);

    MemberEntity update(MemberEntity memberEntity);

    void delete(Long pk);

    Optional<MemberEntity> findByPk(Long pk);

    Optional<MemberEntity> findByEmail(String email);
}
