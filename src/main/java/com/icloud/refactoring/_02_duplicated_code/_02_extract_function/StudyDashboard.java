package com.icloud.refactoring._02_duplicated_code._02_extract_function;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class StudyDashboard {


    public void printParticipants(int eventId) throws IOException {
        GHIssue issue = getGitHubIssue(eventId);
        Set<String> participants = getUsernames(issue);
        print(participants);
    }

    public void printReviewers() throws IOException {
        GHIssue issue = getGitHubIssue(30);
        Set<String> reviewers = getUsernames(issue);
        print(reviewers);
    }

    private GHIssue getGitHubIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        return repository.getIssue(eventId);
    }

    private Set<String> getUsernames(GHIssue issue) throws IOException {
        return issue.getComments()
                .stream()
                .map(GHIssueComment::getUserName)
                .collect(Collectors.toSet());
    }

    private void print(Set<String> participants) {
        participants.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }

}
