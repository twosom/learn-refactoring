package com.icloud.refactoring._02_duplicated_code._04_pull_up_method;

import java.io.IOException;

public class ReviewerDashboard extends Dashboard {

    public void printReviewers() throws IOException {
        super.printParticipants(30);
    }

}
