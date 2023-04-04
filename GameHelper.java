package ch16.dotcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
    private int[][] grid = new int[7][7];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine;
        System.out.print(prompt + " ");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            inputLine = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputLine;
    }

    public ArrayList<String> placeDotCom() {
        ArrayList<String> location = new ArrayList<>();
        comCount++;
        while (true) {
            int n1 = (int)(Math.random() * 1000 % 7);
            int n2 = (int)(Math.random() * 1000 % 7);
            if (grid[n1][n2] == 1) {
                continue;
            }
            if (comCount % 2 == 1) { // 홀수의 경우 가로
                if (n2 == 0 || n2 == 6 || grid[n1][n2-1] == 1 || grid[n1][n2+1] == 1){
                    continue;
                }
                location.add(alphabet[n1] + Integer.toString(n2));         // 중앙
                location.add(alphabet[n1] + Integer.toString(n2 - 1)); // 좌
                location.add(alphabet[n1] + Integer.toString(n2 + 1)); // 우
                grid[n1][n2] = 1;
                grid[n1][n2-1] = 1;
                grid[n1][n2+1] = 1;
            } else { // 짝수의 경우 세로
                if (n1 == 0 || n1 == 6 || grid[n1-1][n2] == 1 || grid[n1+1][n2] == 1){
                    continue;
                }
                location.add(alphabet[n1]     + Integer.toString(n2)); // 중앙
                location.add(alphabet[n1 - 1] + Integer.toString(n2)); // 위
                location.add(alphabet[n1 + 1] + Integer.toString(n2)); // 아래
                grid[n1][n2] = 1;
                grid[n1-1][n2] = 1;
                grid[n1+1][n2] = 1;
            }
            break;
        }
        return location;
    }

    public void printAll() {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}