package bitcamp.project2;

import bitcamp.project2.util.TodoList;
import bitcamp.project2.vo.Mood;
import bitcamp.project2.vo.Motivation;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();
        Motivation motivation = new Motivation();
        Mood mood = new Mood();

        GodLifeTitleScreen.showTitleScreen();
        GodLifeTitleScreen.waitForEnter();
        System.out.println(GodLifeTitleScreen.GREEN + "To-do List 프로그램이 시작되었습니다." + GodLifeTitleScreen.RESET);


        // 데이터 로드
//        todoList.loadData();
//        motivation.loadData();
//        mood.loadData();

        while (true) {
            showMainMenu(motivation);
            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 제거

            switch (choice) {
                case 1:
                    showAddMenu(scanner, todoList, motivation, mood);
                    break;
                case 2:
                    showViewMenu(scanner, todoList, motivation, mood);
                    break;
                case 3:
                    showEditMenu(scanner, todoList, motivation, mood);
                    break;
                case 4:
                    showDeleteMenu(scanner, todoList, motivation, mood);
                    break;
                case 5:
                    // 데이터 저장 및 프로그램 종료
//                    todoList.saveData();
//                    motivation.saveData();
//                    mood.saveData();
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                default:

                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private static void showMainMenu(Motivation motivation) {
        motivation.viewRandomMotivation();  // 랜덤 동기부여 출력
        System.out.println("*********************************");
        System.out.println("                                ");
        System.out.println("1. 추가");
        System.out.println("2. 조회");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 종료");
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.print("입력: ");
    }

    private static void showAddMenu(Scanner scanner, TodoList todoList, Motivation motivation, Mood mood) {
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.println("1. 오늘 할 일 추가");
        System.out.println("2. 올해 목표 추가");
        System.out.println("3. 동기부여 추가");
        System.out.println("4. 오늘의 기분 추가");
        System.out.println("5. 이전");
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        switch (choice) {
            case 1:
                todoList.addTodo(scanner);
                break;
            case 2:
                todoList.addGoal(scanner);
                break;
            case 3:
                motivation.addMotivation(scanner);
                break;
            case 4:
                mood.addMood(scanner);
                break;
            case 5:
                // 이전
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    private static void showViewMenu(Scanner scanner, TodoList todoList, Motivation motivation, Mood mood) {
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.println("1. 일 단위 조회");
        System.out.println("2. 월 단위 조회");
        System.out.println("3. 기분 일기 조회");
        System.out.println("4. 이전");
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        switch (choice) {
            case 1:
                todoList.viewDaily(scanner);
                break;
            case 2:
                todoList.viewMonthly(scanner);
                break;
            case 3:
                mood.viewMoodDiary();
                break;
            case 4:
                // 이전
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    private static void showEditMenu(Scanner scanner, TodoList todoList, Motivation motivation, Mood mood) {
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.println("1. 오늘의 할 일 수정");
        System.out.println("2. 올해 목표 수정");
        System.out.println("3. 동기부여 수정");
        System.out.println("4. 오늘의 기분 수정");
        System.out.println("5. 완료 여부 변경");
        System.out.println("6. 이전");
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        switch (choice) {
            case 1:
                todoList.editTodo(scanner);
                break;
            case 2:
                todoList.editGoal(scanner);
                break;
            case 3:
                motivation.deleteMotivation(scanner);
                motivation.addMotivation(scanner);
                break;
            case 4:
                mood.editMood(scanner);
                break;
            case 5:
                todoList.changeStatus(scanner);
            case 6:
                // 이전
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    private static void showDeleteMenu(Scanner scanner, TodoList todoList, Motivation motivation, Mood mood) {
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.println("1. 오늘의 할 일 삭제");
        System.out.println("2. 올해 목표 삭제");
        System.out.println("3. 동기부여 삭제");
        System.out.println("4. 오늘의 기분 삭제");
        System.out.println("5. 이전");
        System.out.println("                                 ");
        System.out.println("*********************************");
        System.out.println("                                 ");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        switch (choice) {
            case 1:
                todoList.deleteTodo(scanner);
                break;
            case 2:
                todoList.deleteGoal(scanner);
                break;
            case 3:
                motivation.deleteMotivation(scanner);
                break;
            case 4:
                mood.deleteMood(scanner);
                break;
            case 5:
                // 이전
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
}