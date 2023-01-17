package controller;

import java.util.HashMap;

import view.PointView;
import vo.Grade;

public class PointController {
    // Silver, Gold, Vip, Vvip가 모두 저장 가능한 타입 -> Grade
    private HashMap<String, Grade> members;
    private PointView view;

    public PointController() {
        members = new HashMap<String, Grade>();
        view = new PointView();
    }

    public void main() {
        while (true) {
            int sel = view.showMenu();

            switch (sel) {
                case 1:
                    insertMember(); // 회원 정보 등록
                    break;
                case 2:
                    printAllMember(); // 전체 회원 조회
                    break;
                case 3:
                    printOneMember(); // 회원 1명 조회
                    break;
                case 4:
                    updateMember(); // 회원 정보 수정
                    break;
                case 5:
                    deleteMember(); // 회원 삭제
                    break;
                case 0:
                    return; // 프로그램 종료
            }
        }
    }

    public void insertMember() {
        Grade g = view.inputMember("");
        members.put(g.getName(), g);
        view.success("회원 정보 등록");
    }

    public void printAllMember() {
        view.printAllMember(members);
    }

    public void printOneMember() {
        String name = view.getName("조회");

        if (members.containsKey(name)) {
            view.printOneMember(members.get(name));
        } else {
            view.noSearchStudent();
        }
    }

    public void updateMember() {
        String name = view.getName("수정");

        if (members.containsKey(name)) {
            Grade g = view.inputMember("수정 할 ");
            members.put(g.getName(), g);
            if (!name.equals(g.getName())) {
                members.remove(name);
            }
            view.success("회원 정보 수정");
        } else {
            view.noSearchStudent();
        }
    }

    public void deleteMember() {
        String name = view.getName("삭제");

        if (members.containsKey(name)) {
            members.remove(name);
        } else {
            view.noSearchStudent();
        }
    }
}
