package co.simplon.p25.dessinemoiun.dtos;

public class Mail {

    private String replyTo;

    private String from;

    private String to;

    private String subject;

    private String content;

    public Mail() {
	//
    }

    public String getReplyTo() {
	return replyTo;
    }

    public void setReplyTo(String replyTo) {
	this.replyTo = replyTo;
    }

    public String getFrom() {
	return from;
    }

    public void setFrom(String from) {
	this.from = from;
    }

    public String getTo() {
	return to;
    }

    public void setTo(String to) {
	this.to = to;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    @Override
    public String toString() {
	return String.format(
		"Mail [replyTo=%s, from=%s, to=%s, subject=%s, content=%s]",
		replyTo, from, to, subject, content);
    }

}
