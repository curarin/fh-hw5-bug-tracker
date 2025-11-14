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
                logger.warning("We already got 10 critical bugs. Bug was still added to the list.");
            }
            trackedBugsList.add(newBug);
        } else {
            trackedBugsList.add(newBug);
        }
    }

    // Löschen eines Bugs anhand seines Indexes.
    public void deleteBug(Integer bugIndex) {
        this.trackedBugsList.remove(bugIndex); // Versteh die Error Message hier nicht, laut JavaDoc und auch https://www.w3schools.com/java/ref_arraylist_remove.asp sollte hier bei Übergabe eines Ints auf Basis des Index gelöscht werden
    }

    // Änderung des Status eines Bugs anhand seines Indexes (nach den Regeln: OPEN -> IN_PROGRESS -> FIXED -> CLOSED).
    public void progressBugStatus(Integer wantedBugIndex) {
        Bug wantedBug = this.trackedBugsList.get(wantedBugIndex);

        if (wantedBug.getBugStatus() == BugStatus.OPEN) {
            try {
                wantedBug.startProgress();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (wantedBug.getBugStatus() == BugStatus.IN_PROGRESS) {
            try {
                wantedBug.markFixed();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (wantedBug.getBugStatus() == BugStatus.FIXED) {
            try {
                wantedBug.closeBug();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        this.trackedBugsList.set(wantedBugIndex, wantedBug);
    }

    // Ausgabe aller Bugs mit ihren Details.
    public void printAll() {
        for (Bug bug : this.trackedBugsList) {
            bug.printDetails();
        }
    }

    // Ausgabe aller Bugs mit einem bestimmten Status.
    public void printAllFilteredByStatus(BugStatus wantedBugStatus) {
        for (Bug bug : this.trackedBugsList) {
            if (bug.getBugStatus() == wantedBugStatus) {
                System.out.printf("Index: %d", this.trackedBugsList.indexOf(bug));
                bug.printDetails();
            }
        }
    }

    // Ausgabe aller Bugs einer bestimmten Priorität.
    public void printAllFilteredByPriority(BugPriority wantedBugPriority) {
        for (Bug bug : this.trackedBugsList) {
            if (bug.getBugPriority() == wantedBugPriority) {
                bug.printDetails();
            }
        }
    }
}
