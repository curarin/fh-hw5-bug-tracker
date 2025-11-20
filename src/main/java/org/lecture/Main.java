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
                    case 0:
                        isRunning = false;
                        System.out.println("Thanks for using the BUG TRACKER.");
                        break;
                    case 1:
                        userInput.addBugMenu();
                        bugTracker.addBug(userInput.getCurrentBug());
                        break;
                    case 2:
                        bugTracker.printAll();
                        bugTracker.markBugAsStarted(userInput.getBugIndexMenu());
                        break;
                    case 3:
                        bugTracker.printAll();
                        bugTracker.markBugAsFixed(userInput.getBugIndexMenu());
                        break;
                    case 4:
                        bugTracker.printAll();
                        bugTracker.markBugAsClosed(userInput.getBugIndexMenu());
                        break;
                    case 5:
                        bugTracker.printAll();
                        bugTracker.deleteBug(userInput.getBugIndexMenu());
                        break;
                    case 6:
                        bugTracker.printAll();
                        break;
                    case 7:
                        BugStatus currentUserBugStatus = userInput.getBugStatusMenu();
                        bugTracker.printAllFilteredByStatus(currentUserBugStatus);
                        break;
                    case 8:
                        bugTracker.printAllSortedByPriority();
                        break;
                    case 9:
                        bugTracker.printAllSortedByStatus();
                        break;
                    case 10:
                        bugTracker.printCountSortedByStatus();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (isRunning);
    }

}
