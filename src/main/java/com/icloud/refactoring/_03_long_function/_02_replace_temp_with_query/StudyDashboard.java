package com.icloud.refactoring._03_long_function._02_replace_temp_with_query;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudyDashboard {

    private void print() throws IOException, InterruptedException {
        GHRepository repository = getGitHubRepository();
        ExecutorService service = Executors.newFixedThreadPool(8);

        int totalNumberOfEvents = 15;
        CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

        List<Participant> participants = new CopyOnWriteArrayList<>();
        for (int index = 1; index <= totalNumberOfEvents; index++) {
            int eventId = index;
            service.execute(() -> {
                try {
                    getIssueComment(repository, eventId)
                            .forEach(comment -> {
                                String username = comment.getUserName();
                                Participant participant = null;
                                if (isNewUser(username, participants)) {
                                    participant = new Participant(username);
                                    participants.add(participant);
                                } else {
                                    participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
                                }
                                participant.setHomeworkDone(eventId);
                            });
                    latch.countDown();
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            });
        }

        latch.await();
        service.shutdown();

        try (FileWriter fileWriter = new FileWriter("participants.md");
             PrintWriter writer = new PrintWriter(fileWriter)) {
            participants.sort(Comparator.comparing(Participant::username));
            writer.print(header(totalNumberOfEvents, participants.size()));
            participants.forEach(p -> {
                String markdownForHomework = getMarkdownForParticipant(totalNumberOfEvents, p);
                writer.print(markdownForHomework);
            });
        }
    }

    private double getRate(int totalNumberOfEvents, Participant p) {
        long count = p.homework().values().stream()
                .filter(Boolean.TRUE::equals)
                .count();
        return (double) (count * 100 / totalNumberOfEvents);
    }

    private String getMarkdownForParticipant(int totalNumberOfEvents, Participant p) {
        return String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, totalNumberOfEvents), getRate(totalNumberOfEvents, p));
    }

    private boolean isNewUser(String username, List<Participant> participants) {
        return participants.stream().noneMatch(p -> p.username().equals(username));
    }

    private List<GHIssueComment> getIssueComment(GHRepository repository, int eventId) throws IOException {
        GHIssue issue = repository.getIssue(eventId);
        return issue.getComments();
    }

    private GHRepository getGitHubRepository() throws IOException {
        GitHub gitHub = GitHub.connect();
        return gitHub.getRepository("whiteship/live-study");
    }

    /**
     * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 |
     * | --- | --- | --- | --- | --- |
     */
    private String header(int totalEvents, int totalNumberOfParticipants) {
        StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", totalNumberOfParticipants));

        for (int index = 1; index <= totalEvents; index++) {
            header.append(String.format(" %d주차 |", index));
        }
        header.append(" 참석율 |\n");

        header.append("| --- ".repeat(Math.max(0, totalEvents + 2)));
        header.append("|\n");

        return header.toString();
    }

    /**
     * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
     */
    private String checkMark(Participant p, int totalEvents) {
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= totalEvents; i++) {
            if (p.homework().containsKey(i) && p.homework().get(i)) {
                line.append("|:white_check_mark:");
            } else {
                line.append("|:x:");
            }
        }
        return line.toString();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.print();
    }
}
