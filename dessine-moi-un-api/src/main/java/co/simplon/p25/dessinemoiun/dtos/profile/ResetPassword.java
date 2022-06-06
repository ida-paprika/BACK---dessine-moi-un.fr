package co.simplon.p25.dessinemoiun.dtos.profile;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ResetPassword {

    private UUID userUuid;

    @NotBlank(message = "old_password_required")
    private String oldPassword;

    @NotBlank(message = "new_password_required")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "password_pattern")
    private String newPassword;

    public ResetPassword() {
	//
    }

    public UUID getUserUuid() {
	return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
	this.userUuid = userUuid;
    }

    public String getOldPassword() {
	return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
	return newPassword;
    }

    public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
    }

    @Override
    public String toString() {
	return String.format(
		"ResetPassword [userUuid=%s, oldPassword=%s, newPassword=%s]",
		userUuid, "[PROTECTED]", "[PROTECTED]");
    }
}
