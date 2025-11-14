package org.lecture;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        BugTracker bugTracker = new BugTracker();
        boolean isRunning = true;
        int menuChoice = 0;

        userInput.applicationStartTheme();

        while (isRunning) {
            try {
                menuChoice = userInput.mainMenu();
                switch (menuChoice) {
                    case 0:
                        isRunning = false;
                        break;
                    case 1:
                        userInput.addBugMenu();
                        bugTracker.addBug(userInput.getCurrentBug());
                        break;
                    case 6:
                        bugTracker.printAll();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
