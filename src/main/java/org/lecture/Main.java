package org.lecture;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        BugTracker bugTracker = new BugTracker();
        boolean isRunning = true;
        int menuChoice = 0;

        userInput.applicationStartTheme();

        do {
            try {
                menuChoice = userInput.mainMenu();
                switch (menuChoice) {
                    case 0 -> {
                        isRunning = false;
                        System.out.println("Thanks for using the BUG TRACKER.");
                    }
                    case 1 -> {
                        userInput.addBugMenu();
                        bugTracker.addBug(userInput.getCurrentBug());
                    }
                    case 2 -> {
                        bugTracker.printAll();
                        bugTracker.markBugAsStarted(userInput.getBugIndexMenu());
                    }
                    case 3 -> {
                        bugTracker.printAll();
                        bugTracker.markBugAsFixed(userInput.getBugIndexMenu());
                    }
                    case 4 -> {
                        bugTracker.printAll();
                        bugTracker.markBugAsClosed(userInput.getBugIndexMenu());
                    }
                    case 5 -> {
                        bugTracker.printAll();
                        bugTracker.deleteBug(userInput.getBugIndexMenu());
                    }
                    case 6 -> bugTracker.printAll();
                    case 7 -> {
                        BugStatus currentUserBugStatus = userInput.getBugStatusMenu();
                        bugTracker.printAllFilteredByStatus(currentUserBugStatus);
                    }
                    case 8 -> bugTracker.printAllSortedByPriority();
                    case 9 -> bugTracker.printAllSortedByStatus();
                    case 10 -> bugTracker.printCountSortedByStatus();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (isRunning);
    }

}
