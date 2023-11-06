package com.ll;

import java.util.Scanner;

public class App {

    public static void run(){

        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명언) ");
            String command = sc.nextLine();

            if(command.equals("등록")){
                System.out.print("명언 : ");
                String famous_Saying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
            }

            if(command.equals("종료")){
                break;
            }
        }
    }
}
