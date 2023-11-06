package com.ll;

import java.util.ArrayList;
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

                for(int i = 0 ; i < Famous_Sayings.size(); i++){
                    Famous_Saying famous_saying = Famous_Sayings.get(i);
                    System.out.println(famous_saying.getId() + "/" + famous_saying.getFamous_Saying() + "/" + famous_saying.getAuthor() );
                }
            }

            if(command.equals("종료")){
                break;
            }
        }
    }
}
