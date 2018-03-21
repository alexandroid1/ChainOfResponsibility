package com.globallogic;

import com.globallogic.abstractNotifier.Notifier;
import com.globallogic.concreteNotifier.EmailNotifier;
import com.globallogic.concreteNotifier.SMSNotifier;
import com.globallogic.concreteNotifier.SimpleReportNotifier;
import com.globallogic.stubs.Priority;

public class BugTracker {

    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is OK", Priority.ROUTINE);
        reportNotifier.notifyManager("Something went wrong", Priority.IMPORTANT);
        reportNotifier.notifyManager("Houston, we've had a problem here!!!", Priority.ASAP);
    }
}
