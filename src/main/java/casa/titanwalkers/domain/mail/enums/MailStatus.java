package casa.titanwalkers.domain.mail.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum MailStatus {
    RECEIVED("received"),
    SEND("send"),
    TRASH("trash"),
    SPAM("spam");

    private final String value;

    MailStatus(String value) {
        this.value = value;
    }

    public static MailStatus fromValue(String value) {
        for (MailStatus status : MailStatus.values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
