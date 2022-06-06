package co.simplon.p25.dessinemoiun.dtos.profile;

import java.util.UUID;

import javax.validation.constraints.NotNull;

public class LostPassword {

    @NotNull
    private UUID userUuid;

    private String mailHeader;

    private String mailFooter;

    public LostPassword() {
	//
    }

    public UUID getUserUuid() {
	return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
	this.userUuid = userUuid;
    }

    public String getMailHeader() {
	return mailHeader;
    }

    public void setMailHeader(String mailHeader) {
	this.mailHeader = mailHeader;
    }

    public String getMailFooter() {
	return mailFooter;
    }

    public void setMailFooter(String mailFooter) {
	this.mailFooter = mailFooter;
    }

    @Override
    public String toString() {
	return String.format(
		"LostPassword [userUuid=%s, mailHeader=%s, mailFooter=%s]",
		userUuid, mailHeader, mailFooter);
    }
}