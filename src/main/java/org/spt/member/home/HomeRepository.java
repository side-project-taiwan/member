package org.spt.member.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HomeRepository extends JpaRepository<HomeEntity, Long> {

    @Query("SELECT m.name AS name, h.address AS address FROM MemberEntity m INNER JOIN HomeEntity h ON h.memberPk= m.pk WHERE m.pk = :memberPk")
    List<MemberHome> getByMemberPk(@Param("memberPk") Long memberPk);

    @Query(value = "SELECT m.name AS name, h.address AS address FROM member m INNER JOIN home h ON h.member_pk = m.pk WHERE m.pk = :memberPk", nativeQuery = true)
    List<MemberHome> getByMemberPkNative(@Param("memberPk") Long memberPk);



}
