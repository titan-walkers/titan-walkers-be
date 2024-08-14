package casa.titanwalkers.service.member;

import casa.titanwalkers.domain.member.Member;
import casa.titanwalkers.domain.member.dto.SigninDto;
import casa.titanwalkers.domain.member.dto.SigninRequest;
import casa.titanwalkers.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SigninDto signin(SigninRequest signinRequest) {

        Member member = memberRepository.findByEmail(signinRequest.email())
                .orElseThrow(RuntimeException::new);

        return SigninDto.of(member.getEmail());
    }
}
