package org.spt.member.member.repository;

import java.util.Optional;

public interface CreateMemberDataService {

    MemberEntity create(MemberEntity memberEntity);

    Optional<MemberEntity> findByPk(long pk);
}
