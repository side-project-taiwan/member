package org.spt.member.home;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "HOME")
public class HomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK")
    private String pk;

    @Column(name = "MEMBER_PK")
    private Long memberPk;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

}
