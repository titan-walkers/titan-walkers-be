package casa.titanwalkers.domain.mail;

import casa.titanwalkers.common.domain.EntityBase;
import casa.titanwalkers.domain.mail.enums.MailStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mail extends EntityBase {
    @Column(name = "sender_email", nullable = false)
    private String senderEmail;
    @Column(name = "listen_email", nullable = false)
    private String receiverEmail;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "status", nullable = false, columnDefinition = "varchar(64)")
    @Enumerated(EnumType.STRING)
    private MailStatus mailStatus;
    @Column(name = "is_read")
    private Boolean isRead;
    @Column(name = "starred")
    private Boolean starred;
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;
    @Column(name = "reaed_at")
    private ZonedDateTime readAt;
}
