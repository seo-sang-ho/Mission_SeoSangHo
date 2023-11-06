package com.ll;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void run(){

        Scanner sc = new Scanner(System.in);
        List<Famous_Saying> Famous_Sayings = new ArrayList<>();
        int index = 1;

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명언) ");
            String command = sc.nextLine();

            if(command.equals("등록")){
                System.out.print("명언 : ");
                String famous_Saying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                Famous_Saying famous_saying = new Famous_Saying(index,famous_Saying,author);
                Famous_Sayings.add(famous_saying);

                System.out.println(index + "번 명언이 등록되었습니다.");
                index++;
            }

            if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");

                for (Famous_Saying famous_saying : Famous_Sayings) {
                    System.out.println(famous_saying.getId() + "/" + famous_saying.getFamous_Saying() + "/" + famous_saying.getAuthor());
                }
            }

            if(command.equals("삭제")){
                try {
                    System.out.print("삭제할 명언의 번호) ");
                    int removeId = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기

                    List<Famous_Saying> remove_Famous_Sayings = new ArrayList<>();

                    for (Famous_Saying famous_saying : Famous_Sayings) {
                        if (famous_saying.getId() == removeId) {
                            remove_Famous_Sayings.add(famous_saying);
                        }
                    }

                    if (!remove_Famous_Sayings.isEmpty()) {
                        Famous_Sayings.removeAll(remove_Famous_Sayings);
                        System.out.println(removeId + "번이 삭제되었습니다.");
                    } else {
                        System.out.println(removeId + "번이 존재하지 않습니다.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("번호를 입력하세요");
                    sc.nextLine();
                }
            }

            if(command.equals("종료")){
                break;
            }
        }
    }
}
