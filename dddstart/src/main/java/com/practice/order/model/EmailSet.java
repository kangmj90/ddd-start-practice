package com.practice.order.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
public class EmailSet {
    private Set<Email> emails = new HashSet<>();

    private EmailSet() {}
    private EmailSet(Set<Email> emails) {
        this.emails.addAll(emails);
    }

    public Set<Email> getEmails() {
        return Collections.unmodifiableSet(emails);
    }
}
