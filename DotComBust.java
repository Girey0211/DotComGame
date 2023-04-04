package ch16.dotcom;

import java.util.ArrayList;

public class DotComBust {
    private ArrayList<DotCom> dotComs = new ArrayList<>();
    private GameHelper gameHelper = new GameHelper();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpgame();
        game.startPlaying();
    }

    private void setUpgame() {
        // dotcom 생성
        dotComs.add(new DotCom("google.com"));
        dotComs.add(new DotCom("bing.com"));
        dotComs.add(new DotCom("bssm.com"));

        // dotcom 위치값 추가
        for (DotCom dotCom : dotComs) {
            ArrayList<String> newLocation = gameHelper.placeDotCom();
            dotCom.setLocations(newLocation);
        }

        gameHelper.printAll();
    }

    private void startPlaying() {
        while (!dotComs.isEmpty()){
            String userGuess = gameHelper.getUserInput("enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for (DotCom dotCom : dotComs) {
            result = dotCom.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComs.remove(dotCom);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame() {
        System.out.println(numOfGuesses + " guesses.");
        if (numOfGuesses <= 18) {
            System.out.println("good job");
        } else {
            System.out.println("^_^;");
        }
    }
}
