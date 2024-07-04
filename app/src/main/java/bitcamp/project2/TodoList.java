package bitcamp.project2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> todos = new ArrayList<>();
    private ArrayList<String> goals = new ArrayList<>();
    private final String TODO_FILE = "todos.txt";
    private final String GOAL_FILE = "goals.txt";

    public void addTodo(Scanner scanner) {
        System.out.print("날짜 (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("카테고리: ");
        String category = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("완료 여부 (Y/N): ");
        String status = scanner.nextLine().trim().equalsIgnoreCase("Y") ? "완료" : "미완료";
        todos.add(date + " - [" + category + "] " + content + " (" + status + ")");
        System.out.println("할 일이 추가되었습니다.");
    }

    public void addGoal(Scanner scanner) {
        System.out.print("시작 날짜 (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
        System.out.print("완료 날짜 (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();
        System.out.print("카테고리: ");
        String category = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        goals.add("[" + startDate + " - " + endDate + "]의 목표:\n" + content);
        System.out.println("목표가 추가되었습니다.");
    }

    public void viewDaily(Scanner scanner) {
        System.out.print("날짜 (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("[" + date + "]의 할 일:");
        boolean found = false;
        for (String todo : todos) {
            if (todo.startsWith(date)) {
                System.out.println(todo);
                found = true;
            }
        }
        if (!found) {
            System.out.println("해당 날짜의 할 일이 없습니다.");
        }
    }

    public void viewMonthly(Scanner scanner) {
        System.out.print("날짜 (YYYY-MM): ");
        String month = scanner.nextLine();
        System.out.println("[" + month + "]의 할 일:");
        boolean found = false;
        for (String todo : todos) {
            if (todo.startsWith(month)) {
                System.out.println(todo);
                found = true;
            }
        }
        if (!found) {
            System.out.println("해당 월의 할 일이 없습니다.");
        }
    }

    public void editTodo(Scanner scanner) {
        System.out.println("수정할 할 일을 선택하세요. (0: 이전으로 돌아가기):");
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ". " + todos.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        if (choice > 0 && choice <= todos.size()) {
            System.out.print("날짜 (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            System.out.print("카테고리: ");
            String category = scanner.nextLine();
            System.out.print("내용: ");
            String content = scanner.nextLine();
            System.out.print("완료 여부 (Y/N): ");
            String status = scanner.nextLine().trim().equalsIgnoreCase("Y") ? "완료" : "미완료";
            todos.set(choice - 1, date + " - [" + category + "] " + content + " (" + status + ")");
            System.out.println("할 일이 수정되었습니다.");
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    public void editGoal(Scanner scanner) {
        System.out.println("수정할 목표를 선택하세요. (0: 이전으로 돌아가기):");
        for (int i = 0; i < goals.size(); i++) {
            System.out.println((i + 1) + ". " + goals.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        if (choice > 0 && choice <= goals.size()) {
            System.out.print("시작 날짜 (YYYY-MM-DD): ");
            String startDate = scanner.nextLine();
            System.out.print("완료 날짜 (YYYY-MM-DD): ");
            String endDate = scanner.nextLine();
            System.out.print("카테고리: ");
            String category = scanner.nextLine();
            System.out.print("내용: ");
            String content = scanner.nextLine();
            goals.set(choice - 1, "[" + startDate + " - " + endDate + "]의 목표:\n" + content);
            System.out.println("목표가 수정되었습니다.");
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    public void deleteTodo(Scanner scanner) {
        System.out.println("삭제할 할 일을 선택하세요. (0: 이전으로 돌아가기):");
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ". " + todos.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        if (choice > 0 && choice <= todos.size()) {
            todos.remove(choice - 1);
            System.out.println("할 일이 삭제되었습니다.");
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    public void deleteGoal(Scanner scanner) {
        System.out.println("삭제할 목표를 선택하세요. (0: 이전으로 돌아가기):");
        for (int i = 0; i < goals.size(); i++) {
            System.out.println((i + 1) + ". " + goals.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 제거
        if (choice > 0 && choice <= goals.size()) {
            goals.remove(choice - 1);
            System.out.println("목표가 삭제되었습니다.");
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    public void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(TODO_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                todos.add(line);
            }
        } catch (IOException e) {
            System.out.println("할 일 데이터를 로드하는 중 오류가 발생했습니다.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(GOAL_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                goals.add(line);
            }
        } catch (IOException e) {
            System.out.println("목표 데이터를 로드하는 중 오류가 발생했습니다.");
        }
    }

    public void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TODO_FILE))) {
            for (String todo : todos) {
                bw.write(todo);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("할 일 데이터를 저장하는 중 오류가 발생했습니다.");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(GOAL_FILE))) {
            for (String goal : goals) {
                bw.write(goal);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("목표 데이터를 저장하는 중 오류가 발생했습니다.");
        }
    }
}
