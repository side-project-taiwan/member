package org.spt.member.member.repository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MemberDataService {
    MemberEntity create(MemberEntity memberEntity);

    Optional<MemberEntity> findByPk(Long pk);
}
