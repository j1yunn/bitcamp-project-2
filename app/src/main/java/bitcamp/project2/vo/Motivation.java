package bitcamp.project2.vo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Motivation {
    private ArrayList<String> motivations = new ArrayList<>();
    private final String MOTIVATION_FILE = "motivations.txt";
    private final Random random = new Random();

    public void addMotivation(Scanner scanner) {
        System.out.print("동기부여 내용: ");
        String content = scanner.nextLine();
        motivations.add(content);
        System.out.println("동기부여가 추가되었습니다.");
    }

    public void viewRandomMotivation() {
        if (motivations.isEmpty()) {
            System.out.println("오늘의 문장");
            System.out.println("성공은 매일 반복한 작은 노력들의 합이다. - 로버트 콜리어");
        } else {
            int index = random.nextInt(motivations.size());
            System.out.println("오늘의 문장\n" + motivations.get(index));
        }
    }

    public void deleteMotivation(Scanner scanner) {
        System.out.println("삭제할 동기부여를 선택하세요. (0: 이전으로 돌아가기):");
        for (int i = 0; i < motivations.size(); i++) {
            System.out.println((i + 1) + ". " + motivations.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거0
        if (choice > 0 && choice <= motivations.size()) {
            motivations.remove(choice - 1);
            System.out.println("동기부여가 삭제되었습니다.");
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

}
