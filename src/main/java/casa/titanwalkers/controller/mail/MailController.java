package casa.titanwalkers.controller.mail;

import casa.titanwalkers.common.dto.PaginationReq;
import casa.titanwalkers.common.dto.PaginationRes;
import casa.titanwalkers.domain.mail.dto.ReceivedMailRes;
import casa.titanwalkers.domain.mail.dto.unit.ReceivedMail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@RestController
@Tag(name = "Mail", description = "메일 정보")
@RequestMapping("/v1/mail")
@RequiredArgsConstructor
public class MailController {

    @Operation(description = "받은 메일 조회")
    @PostMapping("/receive")
    public ResponseEntity<ReceivedMailRes> searchReceivedMail(@RequestBody Long userId,
                                                @RequestBody PaginationReq payload) {
        log.info("[POST] search receive mail - {}", userId);

        PaginationRes<ReceivedMail> mails = new PaginationRes<>(1, 10, 1, 1L,
                List.of(new ReceivedMail("email",
                        "title",
                        true,
                        true,
                        ZonedDateTime.now())));

        ReceivedMailRes res = new ReceivedMailRes(mails);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
