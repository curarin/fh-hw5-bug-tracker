package org.lecture;

public enum BugPriority {
    CRITICAL(3),
    HIGH(2),
    MEDIUM(1),
    LOW(0);

    // Umsetzung nach Rücksprache mit Phillip Reisinger
    private int order;

    BugPriority(int order) {
        this.order = order;
    }
}
