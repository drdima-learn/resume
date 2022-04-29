package net.devstudy.resume.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotificationMessage {
    private String destinationAddress;
    private String destinationName;
    private String subject;
    private String content;

    public NotificationMessage(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}
