package bitcamp.project2.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mood {
    private Map<String, String> moodMap = new HashMap<>();
    private final String MOOD_FILE = "moods.txt";

    public void addMood(Scanner scanner) {
        System.out.print("날짜 (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.println("기분 선택:");
        System.out.println("1. HAPPY😄");
        System.out.println("2. MEH😐");
        System.out.println("3. SAD😭");
        System.out.println("4. STRESSED😫");
        System.out.println("5. PRODUCTIVE😏");
        System.out.println("6. TIRED😪");
        System.out.println("7. CONTENT😏");
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.print("\u001B[33m✔️입력:  \u001B[0m");
        int moodNumber = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        String mood;
        switch (moodNumber) {
            case 1:
                mood = "HAPPY";
                break;
            case 2:
                mood = "MEH";
                break;
            case 3:
                mood = "SAD";
                break;
            case 4:
                mood = "STRESSED";
                break;
            case 5:
                mood = "PRODUCTIVE";
                break;
            case 6:
                mood = "TIRED";
                break;
            case 7:
                mood = "CONTENT";
                break;
            default:
                System.out.println("잘못된 입력입니다. 기분은 기록되지 않습니다.");
                return;
        }
        moodMap.put(date, mood);
        System.out.println("기분이 추가되었습니다.");
    }

    public void viewMoodDiary() {
        System.out.println("기분 일기 조회:");
        for (Map.Entry<String, String> entry : moodMap.entrySet()) {
            System.out.println(entry.getKey() + " - 기분: " + entry.getValue());
        }
    }

    public void editMood(Scanner scanner) {
        System.out.print("수정할 날짜 (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        if (moodMap.containsKey(date)) {
            System.out.println("기존 기분: " + moodMap.get(date));
            System.out.println("수정할 기분 선택:");
            System.out.println("                                 ");
            System.out.println("*********************************");
            System.out.println("                                 ");
            System.out.println("기분 선택:");
            System.out.println("1. HAPPY😄");
            System.out.println("2. MEH😐");
            System.out.println("3. SAD😭");
            System.out.println("4. STRESSED😫");
            System.out.println("5. PRODUCTIVE😏");
            System.out.println("6. TIRED😪");
            System.out.println("7. CONTENT😏");
            System.out.println("                                 ");
            System.out.println("*********************************");
            System.out.println("                                 ");
            System.out.print("\u001B[33m✔️입력:  \u001B[0m");
            int moodNumber = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 제거
            String mood;
            switch (moodNumber) {
                case 1:
                    mood = "HAPPY";
                    break;
                case 2:
                    mood = "MEH";
                    break;
                case 3:
                    mood = "SAD";
                    break;
                case 4:
                    mood = "STRESSED";
                    break;
                case 5:
                    mood = "PRODUCTIVE";
                    break;
                case 6:
                    mood = "TIRED";
                    break;
                case 7:
                    mood = "CONTENT";
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 기분은 수정되지 않습니다.");
                    return;
            }
            moodMap.put(date, mood);
            System.out.println("기분이 수정되었습니다.");
        } else {
            System.out.println("해당 날짜의 기분 기록이 없습니다.");
        }
    }

    public void deleteMood(Scanner scanner) {
        System.out.print("삭제할 날짜 (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        if (moodMap.containsKey(date)) {
            moodMap.remove(date);
            System.out.println("기분 기록이 삭제되었습니다.");
        } else {
            System.out.println("해당 날짜의 기분 기록이 없습니다.");
        }
    }

}