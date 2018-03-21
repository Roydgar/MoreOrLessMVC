package ua.training;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private Scanner userInputScanner = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view  = view;
    }

    public void processUser() {
        int userValue;
        do {
            view.printAttemptHistory(model);
            view.printInputMessage(model);
            userValue = getUserInput();
        } while (!model.guessed(userValue));

        view.printCongratulations(model);
    }

    public int getUserInput() {
        int inputValue;
        do {
            while (!userInputScanner.hasNextInt()) {
                view.printWrongIntInput(model);
                userInputScanner.next();
            }
            inputValue = userInputScanner.nextInt();

            if (inputValue <= model.getMinBarrier() || inputValue >= model.getMaxBarrier()) {
                view.printWrongRangeInput(model);
            }
        } while(inputValue <= model.getMinBarrier() || inputValue >= model.getMaxBarrier());

        return inputValue;
    }
}
