package casa.titanwalkers.domain.mail.dto;

import casa.titanwalkers.common.domain.dto.PaginationRes;
import casa.titanwalkers.domain.mail.dto.unit.SearchMail;
public record SearchMailRes(
        PaginationRes<SearchMail> receivedMails
        ) {
}
