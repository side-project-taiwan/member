package org.spt.member.member.repository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MemberEntity {

    /**
     * 主鍵
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
    /**
     * email
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    /**
     * 密碼
     */
    @Column(name = "password", nullable = false)
    private String password;
    /**
     * 名稱
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * 是否啟用
     */
    @Column(name = "enable", nullable = false)
    private Boolean enable;

}
