package org.spt.member.member.repository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Setter
@Table(name = "MEMBER")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK")
    private Long pk;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ENABLE", nullable = false)
    private Boolean enable;

}
