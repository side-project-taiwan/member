package org.spt.member.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.repository.MemberEntity;
import org.spt.member.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final HomeRepository homeRepository;
    private final MemberRepository memberRepository;

    @GetMapping
    public MemberHomeResponse getAddress() {
        List<MemberHome> memberHomeList = homeRepository.getByMemberPk(1L);
        Optional<MemberHome> first = memberHomeList.stream().findFirst();
        if (first.isPresent()) {
            MemberHome memberHome = first.get();
            return new MemberHomeResponse(memberHome.getName(), memberHome.getAddress());
        }
        return null;
    }


    @GetMapping("demo01")
    public MemberHomeResponse getMemberAddressByMemberPk(){
        //指定member的主鍵編號
        long memberPk = 1;
        //使用主鍵向MEMBER資料表做查詢
        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(memberPk);
        //驗證有無資料
        if (memberEntityOptional.isEmpty()) {
            log.error("[HomeController][getMemberAddressByMemberPk][member not found]");
            throw new RuntimeException();
        }

        MemberEntity memberEntity = memberEntityOptional.get();

        //配置example
        HomeEntity homeEntity = new HomeEntity();
        homeEntity.setMemberPk(memberPk);
        Example<HomeEntity> homeEntityExample = Example.of(homeEntity);

        //開始查詢HOME表格
        Optional<HomeEntity> homeEntityOptional = homeRepository.findOne(homeEntityExample);

        if (homeEntityOptional.isEmpty()) {
        throw new RuntimeException("[HomeController][getMemberAddressByMemberPk][home not found]");
        }

        HomeEntity homeEntityResult = homeEntityOptional.get();
        return new MemberHomeResponse(memberEntity.getName(), homeEntityResult.getAddress());

    }
}
