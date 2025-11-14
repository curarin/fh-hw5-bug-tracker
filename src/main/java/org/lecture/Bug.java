package org.lecture;

import java.util.UUID;

public class Bug {
    // Initialisiert wird der Bug immer im Status OPEN und mit einer vom Benutzer angegebenen Priorität.
    private BugStatus currentBugStatus = BugStatus.OPEN;
    final private BugPriority currentBugPriority; // muss nicht zwingend final sein, aber ich mags nicht wenn Stakeholder an der Prio rumdoktorn (:
    final private String currentBugName;
    final private String Id;

    public Bug(BugPriority currentBugPriority, String currentBugName) {
        this.currentBugPriority = currentBugPriority;
        this.currentBugName = currentBugName;
        this.Id = UUID.randomUUID().toString(); // Source > https://www.uuidgenerator.net/dev-corner/java
    }
    // Ein Bug ist definiert durch seinen Titel, Status und seine Priorität
    // Benötigte Methoden sind
    /*
    startProgress():
    Setzt den Status auf IN_PROGRESS. Dies ist nur erlaubt, wenn der aktuelle Status OPEN ist.
    Ist der Status FIXED oder CLOSED, soll eine Exception geworfen werden, die in der Main-Klasse behandelt wird. */

    public void startProgress() throws Exception {
        if (this.currentBugStatus == BugStatus.OPEN) {
            this.currentBugStatus = BugStatus.IN_PROGRESS;
        } else if (this.currentBugStatus == BugStatus.FIXED || this.currentBugStatus == BugStatus.CLOSED) {
            throw new IllegalStateException("Status fixed / closed");
        } else {
            throw new Exception("Random andere Exception");
        }
    }

    /*
    markFixed():
Setzt den Status auf FIXED. Dies ist nur erlaubt, wenn der aktuelle Status IN_PROGRESS ist.
Bei anderen Zuständen wird eine Exception geworfen.
     */
    public void markFixed() throws Exception {
        if (this.currentBugStatus == BugStatus.IN_PROGRESS) {
            this.currentBugStatus = BugStatus.FIXED;
        } else {
            throw new IllegalStateException("Status muss In Progress sein");
        }
    }

    /*
    closeBug():
Setzt den Status auf CLOSED. Dies ist nur erlaubt, wenn der aktuelle Status FIXED ist.
Ansonsten wird eine Exception geworfen.
     */
    public void closeBug() throws Exception {
        if (this.currentBugStatus == BugStatus.FIXED) {
            this.currentBugStatus = BugStatus.CLOSED;
        } else {
            throw new IllegalStateException("Status muss FIXED sein");
        }
    }

    // Damit wir im Tracker nach Prio Status filtern können brauchen wir hier einen Getter
    public BugPriority getBugPriority() {
        return this.currentBugPriority;
    }

    // Selbiges hier mit nach Bug Status Filter
    public BugStatus getBugStatus() {
        return this.currentBugStatus;
    }

    public String getBugId() {
        return this.Id;
    }

    /*
    printDetails():
    Gibt den Titel, den Status und die Priorität mit einer entsprechenden Meldung aus
     */
    public void printDetails(Integer bugIndex) {
        System.out.print("------------------------------------------------------------------------------------------\n");
        System.out.printf("Pos[%d] | Name: %s\t\t Status: %s\t\t Priority: %s\n", bugIndex, currentBugName, currentBugStatus, currentBugPriority);
        System.out.print("------------------------------------------------------------------------------------------\n");
    }

}
