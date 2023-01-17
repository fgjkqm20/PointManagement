package view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import vo.Gold;
import vo.Grade;
import vo.Silver;
import vo.Vip;
import vo.Vvip;

public class PointView {
    private Scanner sc;

    public PointView() {
        sc = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n====== 포인트 관리 프로그램 ======");
        System.out.println("1. 회원 정보 등록");
        System.out.println("2. 전체 회원 조회");
        System.out.println("3. 회원 1명 조회");
        System.out.println("4. 회원 정보 수정");
        System.out.println("5. 회원 삭제");
        System.out.println("0. 프로그램 종료");

        return inputNum(0, 5, "선택 > ");
    }

    public Grade inputMember(String str) {
        System.out.println("\n====== " + str + "회원 정보 등록 ======");

        String grade;
        while (true) {
            System.out.print(str + "회원 등급 입력[silver/gold/vip/vvip] : ");
            grade = sc.next();

            if (grade.equals("silver") || grade.equals("gold") || grade.equals("vip")
                    || grade.equals("vvip")) {
                break;
            } else {
                System.out.println("다시 입력해주세요.\n");
            }
        }

        System.out.print(str + "회원 이름 입력 : ");
        String name = sc.next();

        int point = inputNum(0, Integer.MAX_VALUE, str + "회원 포인트 입력 : ");

        switch (grade) {
            case "silver":
                return new Silver(grade, name, point);
            case "gold":
                return new Gold(grade, name, point);
            case "vip":
                return new Vip(grade, name, point);
            case "vvip":
                return new Vvip(grade, name, point);
            default:
                return null;
        }
    }

    public void printAllMember(HashMap<String, Grade> members) {
        System.out.println("\n====== 전체 회원 출력 ======");
        System.out.println("등급\t이름\t포인트\t보너스");

        Set<String> names = members.keySet();

        for (String name : names) {
            System.out.println(members.get(name));
        }
    }

    public void printOneMember(Grade member) {
        System.out.println("등급 : " + member.getGrade());
        System.out.println("이름 : " + member.getName());
        System.out.println("포인트 : " + member.getPoint());
        System.out.printf("보너스 : %.2f\n", member.getBonus());
    }

    public void success(String str) {
        System.out.println(str + " 완료!");
    }

    public String getName(String str) {
        System.out.println("\n====== 회원 정보 " + str + " ======");
        System.out.print(str + " 할 회원 이름 입력 : ");
        return sc.next();
    }

    public void noSearchStudent() {
        System.out.println("회원 정보를 찾을 수 없습니다.");
    }

    public int inputNum(int start, int end, String str) {
        int num;

        while (true) {
            System.out.print(str);
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("다시 입력해주세요.\n");
                continue;
            }

            if (num >= start && num <= end) {
                break;
            } else {
                System.out.println("다시 입력해주세요.\n");
            }
        }

        return num;
    }
}
