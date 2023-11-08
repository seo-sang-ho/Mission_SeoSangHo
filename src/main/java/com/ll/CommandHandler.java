package com.ll;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class CommandHandler {

    public static final FileHandler fileHandler = new FileHandler();

    public void buildJsonFile() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));
            String line;
            List<Map<String, String>> list = new ArrayList<>();

            while((line = reader.readLine()) != null){
                String[] parts = line.split("/");
                Map<String, String> map = new HashMap<>();
                map.put("id", parts[0]);
                map.put("content", parts[1]);
                map.put("author", parts[2]);
                list.add(map);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("data.json"),list);
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(Scanner sc, List<Famous_Saying> Famous_Sayings) {
        System.out.println("수정할 명언의 번호) ");
        int updateId = sc.nextInt();
        sc.nextLine();

        for(Famous_Saying famous_saying : Famous_Sayings){
            if(famous_saying.getId() == updateId){
                System.out.println("명언(기존) : " + famous_saying.getFamous_Saying());
                System.out.println("명언(수정) : ");
                String update_Famous_Saying = sc.nextLine();
                System.out.println("작가(기존) : " + famous_saying.getAuthor());
                System.out.println("작가(수정) : ");
                String update_Author = sc.nextLine();

                Famous_Saying update_Saying = new Famous_Saying(updateId,update_Famous_Saying,update_Author);
                Famous_Sayings.set(updateId-1,update_Saying);

                System.out.println(updateId + "번이 수정되었습니다.");
            }
        }
    }

    public void delete(Scanner sc, List<Famous_Saying> Famous_Sayings) {
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
                for (Famous_Saying famous_saying : Famous_Sayings){
                    fileHandler.documentation2(famous_saying);
                }

            } else {
                System.out.println(removeId + "번이 존재하지 않습니다.");
            }
        }catch (InputMismatchException e){
            System.out.println("번호를 입력하세요");
            sc.nextLine();
        }
    }

    public void list(List<Famous_Saying> Famous_Sayings) {
        System.out.println("번호 / 명언 / 작가");
        System.out.println("-------------------");

        for (Famous_Saying famous_saying : Famous_Sayings) {
            System.out.println(famous_saying.getId() + "/" + famous_saying.getFamous_Saying() + "/" + famous_saying.getAuthor());
        }
    }

    public int register(Scanner sc, int index, List<Famous_Saying> Famous_Sayings) {
        System.out.print("명언 : ");
        String famous_Saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        Famous_Saying famous_saying = new Famous_Saying(index,famous_Saying,author);
        Famous_Sayings.add(famous_saying);
        fileHandler.documentation(famous_saying);

        System.out.println(index + "번 명언이 등록되었습니다.");
        index++;
        return index;
    }
}
