package org.lecture;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);
    private int mainMenuChoice;
    private BugPriority bugPriority;
    private BugStatus bugStatus;
    private String bugName;

    public void applicationStartTheme() {
        System.out.println("""
                =============================
                ==== BUG TRACKER BY PAUL ====
                =============================
                """);
    }

    public Integer mainMenu() throws Exception {
        System.out.println("""
                --- New bugs ---
                (1)\tAdd new bug
                (2)\tStart progress on a bug
                
                --- Working on bugs ---
                (3)\tMark bug as fixed
                (4)\tClose bug
                (6)\tDelete a bug
                
                --- Display bugs ---
                (6)\tDisplay all current bugs
                (7)\tDisplay bug by Status
                
                --- EXIT ---
                (0)\tExit
                =============================
                """);
        String input = scanner.nextLine();
        try {
            mainMenuChoice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer number.");
        }

        if (mainMenuChoice < 0 || mainMenuChoice > 7) {
            throw new InputMismatchException("Please enter a number between 0 and 7.");
        }
        return mainMenuChoice;
    }

    public void addBugMenu() {
        System.out.print("Please enter the bug name: ");
        this.bugName = scanner.nextLine();
        int bugPriorityInput = 0;
        System.out.println("""
                Please enter Bug Priority
                (1)\tCRITICAL
                (2)\tHIGH
                (3)\tMEDIUM
                (4)\tLOW
                """);
        String input = scanner.nextLine();
        try {
            bugPriorityInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer number.");
        }

        if (bugPriorityInput > 4 || bugPriorityInput < 1) {
            throw new InputMismatchException("Please enter a valid number between 1 and 4.");
        }
        switch (bugPriorityInput) {
            case 1 -> this.bugPriority = BugPriority.CRITICAL;
            case 2 -> this.bugPriority = BugPriority.HIGH;
            case 3 -> this.bugPriority = BugPriority.MEDIUM;
            case 4 -> this.bugPriority = BugPriority.LOW;
            default -> throw new InputMismatchException("Please enter a valid bug priority.");
        }
    }

    public BugStatus getBugStatusMenu() {
        int bugStatusInput = 0;

        System.out.println("""
                Please enter Bug Status
                (1)\tOPEN
                (2)\tIN_PROGRESS
                (3)\tFIXED
                (4)\tCLOSED
                """);
        String input = scanner.nextLine();
        try {
            bugStatusInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer number.");
        }
        if (bugStatusInput > 4 || bugStatusInput < 1) {
            throw new InputMismatchException("Please enter a valid number between 1 and 4.");
        }
        switch (bugStatusInput) {
            case 1 -> this.bugStatus = BugStatus.OPEN;
            case 2 -> this.bugStatus = BugStatus.IN_PROGRESS;
            case 3 -> this.bugStatus = BugStatus.FIXED;
            case 4 -> this.bugStatus = BugStatus.CLOSED;
            default -> throw new InputMismatchException("Please enter a valid bug status.");
        }
        return this.bugStatus;
    }

    public int getBugIndexMenu() {
        // Hier noch validierung sinnvoll bzgl. "Index vorhanden / Array Length"
        System.out.print("Please enter the wanted bug position: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer number.");
        }
        return 0;
    }

    public Bug getCurrentBug() {
        return new Bug(this.bugPriority, this.bugName);
    }
}
