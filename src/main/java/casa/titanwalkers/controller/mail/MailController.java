package casa.titanwalkers.controller.mail;

import casa.titanwalkers.common.domain.dto.PaginationReq;
import casa.titanwalkers.common.domain.dto.PaginationRes;
import casa.titanwalkers.domain.mail.dto.SearchMailRes;
import casa.titanwalkers.domain.mail.dto.unit.SearchMail;
import casa.titanwalkers.domain.mail.enums.MailStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@RestController
@Tag(name = "Mail", description = "메일 정보")
@RequestMapping("/v1/mail")
@RequiredArgsConstructor
public class MailController {

    private static final String SEARCH_SUB_URI = "/search";

    @Operation(description = "상태별 메일 조회")
    @PostMapping(SEARCH_SUB_URI + "/{status}")
    public ResponseEntity<SearchMailRes> searchReceivedMail(@Parameter(name = "status", in = ParameterIn.PATH,
            schema = @Schema(allowableValues = {"received", "send", "trash", "spam"}))
                                                            @PathVariable String status,
                                                            HttpServletRequest request,
                                                            @RequestBody PaginationReq payload) {
        String userId = request.getHeader("userId");
        log.info("[POST] search {} mail - {}", status, userId);

        PaginationRes<SearchMail> mails = new PaginationRes<>(1, 10, 1, 1L,
                List.of(new SearchMail(1L,
                        "email",
                        "title",
                        true,
                        true,
                        ZonedDateTime.now())));

        SearchMailRes res = new SearchMailRes(mails);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
