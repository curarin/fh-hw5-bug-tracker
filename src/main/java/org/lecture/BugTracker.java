package org.lecture;

import java.util.ArrayList;

public class BugTracker {
    // Der BugTracker hält alle Bugs in einer Liste vor.
    ArrayList<Bug> trackedBugsList = new ArrayList<Bug>();
    //  Zusätzlich gibt es ein Array von 10 Bugs mit der Priorität CRITICAL. Werden diese 10 Einträge überschritten, soll eine Warnung ausgegeben werden.
    ArrayList<Bug> trackedCriticalBugsList = new ArrayList<Bug>();
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger("BugTrackerLogger"); // Source: https://stackoverflow.com/questions/54822478/print-stack-trace-saying-warning-instead-of-error


    //     Über den BugTracker sollen folgende Operationen möglich sein:
    //  Hinzufügen eines Bugs mit Titel und Priorität.
    public void addBug(Bug newBug) {
        if (newBug.getBugPriority() == BugPriority.CRITICAL) {
            // Wird die maximale Anzahl von 10 Bugs überschritten, soll eine Meldung ausgegeben werden, der Bug aber trotzdem angelegt werden.
            trackedCriticalBugsList.add(newBug);
            if (trackedCriticalBugsList.size() >= 10) {
                logger.warning("We already got 10 critical bugs. Please keep our devs sane. (FYI: Bug was still added to the list.)");
            }
            trackedBugsList.add(newBug);
        } else {
            trackedBugsList.add(newBug);
        }
    }

    // Löschen eines Bugs anhand seines Indexes.
    public void deleteBug(int bugIndex) {
        Bug removedBug = this.trackedBugsList.get(bugIndex);
        this.trackedBugsList.remove(bugIndex);

        // Zusatz Lösche Critical Bugs ebenfalls auf Basis der UUID
        for (Bug bug : this.trackedCriticalBugsList) {
            if (bug.getBugId().equals(removedBug.getBugId())) {
                this.trackedCriticalBugsList.remove(bug);
            }
        }
    }

    public void markBugAsStarted(int wantedBugIndex) throws Exception {
        Bug wantedBug = this.trackedBugsList.get(wantedBugIndex);
        if (wantedBug.getBugStatus() == BugStatus.OPEN) {
            try {
                wantedBug.startProgress();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            throw new IllegalStateException("Start Process only allowed for OPEN Bug Status.");
        }
        this.trackedBugsList.set(wantedBugIndex, wantedBug);
    }

    public void markBugAsFixed(int wantedBugIndex) throws Exception {
        Bug wantedBug = this.trackedBugsList.get(wantedBugIndex);
        if (wantedBug.getBugStatus() == BugStatus.IN_PROGRESS) {
            try {
                wantedBug.markFixed();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            throw new IllegalStateException("Mark Process only allowed for IN_PROGRESS Bug Status.");
        }
    }

    public void markBugAsClosed(int wantedBugIndex) throws Exception {
        Bug wantedBug = this.trackedBugsList.get(wantedBugIndex);
        if (wantedBug.getBugStatus() == BugStatus.FIXED) {
            try {
                wantedBug.closeBug();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            throw new IllegalStateException("Mark Process only allowed for FIXED Bug Status.");
        }
    }

    // Ausgabe aller Bugs mit ihren Details.
    public void printAll() {
        for (Bug bug : this.trackedBugsList) {
            bug.printDetails(this.trackedBugsList.indexOf(bug));
        }
    }

    // Ausgabe aller Bugs mit einem bestimmten Status.
    public void printAllFilteredByStatus(BugStatus wantedBugStatus) {
        //this.trackedBugsList.sort();
        // Beim Sort muss man nur Print Filtereted By Prio
        for (Bug bug : this.trackedBugsList) {
            if (bug.getBugStatus() == wantedBugStatus) {
                bug.printDetails(this.trackedBugsList.indexOf(bug));
            }
        }
    }

    public void printAllSortedByPriority() {
        for (Bug bug : this.trackedBugsList) {
            switch (bug.getBugPriority()) {
                case BugPriority.LOW -> {
                    System.out.println("--- Low Priority Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }
                case BugPriority.MEDIUM -> {
                    System.out.println("--- Medium Priority Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }
                case BugPriority.HIGH -> {
                    System.out.println("--- High Priority Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }
                case BugPriority.CRITICAL -> {
                    System.out.println("--- Critical Priority Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }


            }
        }
    }

    public void printAllSortedByStatus() {
        for (Bug bug : this.trackedBugsList) {
            switch (bug.getBugStatus()) {
                case BugStatus.OPEN -> {
                    System.out.println("--- Open Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }
                case BugStatus.IN_PROGRESS -> {
                    System.out.println("--- In Progress Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }
                case BugStatus.FIXED -> {
                    System.out.println("--- Fixed Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }
                case BugStatus.CLOSED -> {
                    System.out.println("--- Closed Bugs ---");
                    bug.printDetails(this.trackedBugsList.indexOf(bug));
                }
            }
        }
    }

    public void printCountSortedByStatus() {
        int openBugCount = 0;
        int closedBugCount = 0;
        int inProgressBugCount = 0;
        int fixedBugCount = 0;

        for (Bug bug : this.trackedBugsList) {
            switch (bug.getBugStatus()) {
                case BugStatus.OPEN -> openBugCount++;
                case BugStatus.FIXED -> fixedBugCount++;
                case BugStatus.IN_PROGRESS -> inProgressBugCount++;
                case BugStatus.CLOSED -> closedBugCount++;
            }
        }
        System.out.printf("Open Bug Count: %d\n", openBugCount);
        System.out.printf("Fixed Bug Count: %d\n", fixedBugCount);
        System.out.printf("In Progress Bug Count: %d\n", inProgressBugCount);
        System.out.printf("Closed Bug Count: %d\n", closedBugCount);
        System.out.println("=============================\n");

    }
}
