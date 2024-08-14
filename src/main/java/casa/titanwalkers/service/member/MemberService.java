package casa.titanwalkers.service.member;

import casa.titanwalkers.domain.member.Member;
import casa.titanwalkers.domain.member.dto.SigninRequest;
import casa.titanwalkers.domain.member.dto.TokenDto;
import casa.titanwalkers.jwt.TokenProvider;
import casa.titanwalkers.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;

    public TokenDto signin(SigninRequest signinRequest) {

        Member member = memberRepository.findByEmail(signinRequest.email())
                .orElseThrow(RuntimeException::new);

        return tokenProvider.generateToken(member);
    }
}
