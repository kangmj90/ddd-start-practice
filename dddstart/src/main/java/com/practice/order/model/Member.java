package com.practice.order.model;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class Member {
    private Password password;

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchException();
        }
        this.password = new Password(newPassword);
    }
}
