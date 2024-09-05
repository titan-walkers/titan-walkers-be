package casa.titanwalkers.domain.mail.dto;

import casa.titanwalkers.common.dto.PaginationRes;
import casa.titanwalkers.domain.mail.dto.unit.ReceivedMail;
public record ReceivedMailRes(
        PaginationRes<ReceivedMail> receivedMails
        ) {
}
