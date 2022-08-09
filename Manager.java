import java. io. BufferedReader;
import java. io. IOException;
import java. io. InputStreamReader;
import java. util. HashMap;
import java. util. Map;
import java. io. FileInputStream;
import java. io. FileNotFoundException;
import java. io. FileReader;

import java. io. FileWriter;
import java. io. BufferedWriter;
import java. io. FileOutputStream;
import java. io. OutputStreamWriter;
import java. util. Scanner;
import java. io. File;

import java. text. DecimalFormat;
import java. util. Arrays;



public class Manager
{
   //메인프로그램 실행과 동시에 HashMap 데이터 로드를 위해 전역변수로 선언
   public static HashMap<String, Object> hashMap = new HashMap<String, Object>();
   static Scanner sc = new Scanner(System.in);
   public static HashMap<Integer, Integer> coinMap = new HashMap<Integer, Integer>();

   static int systemMoney = 0;

   // 관리자 인터페이스(main에서)
   public static void userInterface() 
   {
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t ▒▒▒    SIST TODAY LUNCH [관리자 모드]   ▒▒▒ ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t┌");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┐\n");
      System.out.println("\t\t\t\t\t\t\t│            1. 음식점    추가              │");
      System.out.println("\t\t\t\t\t\t\t│            2. 음식점    수정              │");
      System.out.println("\t\t\t\t\t\t\t│            3. 음식점    삭제              │");
      System.out.println("\t\t\t\t\t\t\t│            4. 음식점    조회              │");

      System.out.println("\t\t\t\t\t\t\t│            5. 식권    채우기              │");
      System.out.println("\t\t\t\t\t\t\t│            6. 잔고    채우기              │");
      System.out.println("\t\t\t\t\t\t\t│            7. 누적 매출 확인              │");
      
      System.out.println("\t\t\t\t\t\t\t│            8. 프로그램  종료              │");

      System.out.print("\t\t\t\t\t\t\t└");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┘\n");

      //////////////////////////////////////////////////////
      System.out.println("\t\t\t\t\t\t\t※ 관리자 알림");
      noMoney();
      System.out.println();
       //////////////////////////////////////////////////////

      
      Scanner sc = new Scanner(System.in);
      System.out.print("\t\t\t\t\t\t\t번호 선택 : ");
      String sel = sc.next();
   
         switch (sel)
         {
            case "1": addRestData();break;
            case "2": modifyRestData();break;
            case "3": deleteRestData();break;
            case "4": printAllRestData();break;
            case "5": fillStock();break;
            case "6": fillBalance();break;
            case "7": sellList();break;
            case "8": endMachine();break;
            default: userInterface();break;
         }
   }
 public static void sellList()
   {
      int count = 0;
      int money = 0;

          
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t==============================================");
        System.out.println("\t\t\t\t\t\t\t        ▒▒▒    누적매출 확인   ▒▒▒ ");   
        System.out.println("\t\t\t\t\t\t\t==============================================");
        System.out.println();

       for (String key : Manager.hashMap.keySet())
         {
            if(((SetData)Manager.hashMap.get(key)).getCountSell() != 0)
          {
             count++;
             System.out.printf("\n\t%-7s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t %s\t\r\n",
              "상호명","메뉴1","가격1","재고","메뉴2","가격2","재고","메뉴3","가격3","재고","누적판매");
             System.out.print("\t");
              for(int i=0; i < 145; i++) 
                System.out.print("=");

              System.out.print("\n");

              SetData objValue = (SetData) hashMap.get(key);

              System.out.printf("\t%-7s\t %-7s\t %-5s원\t%s개\t %-7s\t%-5s원\t\t%s개\t%-7s\t%-5s원\t%10s개\t%6s개\t\r\n",
                  objValue.getRestName(),
                  objValue.getMenu1(), objValue.getPrice1(), objValue.getStock1(),
                  objValue.getMenu2(), objValue.getPrice2(), objValue.getStock2(),
                  objValue.getMenu3(), objValue.getPrice3(), objValue.getStock3(),
                  objValue.getCountSell());


              System.out.println();      
              System.out.print("\t");
              for(int i=0; i < 145; i++) 
                System.out.print("=");
              System.out.println();

          }

      }

        System.out.print("\t");
        System.out.print("\n\t자판기 총 잔액 : ");

        money = ((coinMap.get(10000)*10000) + (coinMap.get(5000)*5000) + (coinMap.get(1000)*1000) + (coinMap.get(500)*500) + (coinMap.get(100)*100));

        System.out.println("\t" + money + "원\n");

      if (count == 0)
      {
         System.out.println("\t\t\t\t\t\t\t※ 아무것도 판매되지 않았습니다. ※");
      }
      userInterface();
 }

   //추가 메소드(음식점 데이터 추가)
   //1. hashMap 조작(데이터 입력)
   //2. writeCsv(hashMap) (CSV 생성)
   public static void addRestData()
   {   
      char input = 'Y';

      while(!(input != 'y' && input != 'Y'))
      {
         try
         {
            System.out.print("\n\t\t\t\t\t\t\t상호명을 입력하세요 : ");
            String restName = sc.next();

            if(hashMap.get(restName) == null)
            {
               System.out.print("\t\t\t\t\t\t\t메뉴1을  입력하세요 : ");
               String restMenu1 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t가격1을  입력하세요 : ");
               String restPrice1 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t메뉴2을  입력하세요 : ");
               String restMenu2 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t가격2을  입력하세요 : ");
               String restPrice2 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t메뉴3을  입력하세요 : ");
               String restMenu3 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t가격3을  입력하세요 : ");
               String restPrice3 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t소요 시간을 입력하세요 : ");
               String restTime = sc.next();

               System.out.print("\t\t\t\t\t\t\t분류를   입력하세요 : ");
               String restCategory = sc.next();

               String[] dataArr = {restName, restMenu1, restPrice1, restMenu2, restPrice2, restMenu3, restPrice3, restTime, restCategory};

               SetData addSetData = new SetData();

            // countSell, Stock은 추가안해 자동 0 초기화+
               addSetData.setRestName(dataArr[0]);
               addSetData.setMenu1(dataArr[1]);
               addSetData.setPrice1(Integer.parseInt(dataArr[2]));
               addSetData.setMenu2(dataArr[3]);
               addSetData.setPrice2(Integer.parseInt(dataArr[4]));
               addSetData.setMenu3(dataArr[5]);
               addSetData.setPrice3(Integer.parseInt(dataArr[6]));
               addSetData.setTime(Integer.parseInt(dataArr[7]));
               addSetData.setCategory(dataArr[8]);

               hashMap.put(dataArr[0], addSetData);

               System.out.println("\n\t\t\t\t\t\t\t>>>>> 추가 완료");
               System.out.println("\n\t\t\t\t\t\t\t[ " + restName + "의 추가 데이터 ]");
               printKeyRestData(restName);

               System.out.print("\t\t\t\t\t\t\t계속 추가하시겠습니까?(Y/N)");
               input = sc.next().charAt(0);
               
            }
            else if(hashMap.get(restName) != null)
            {
               System.out.println("\n\t\t\t\t\t\t\t※ 해당 음식점은 이미 등록되어 있습니다. ※");
               System.out.println("\n\t\t\t\t\t\t\t[ " + restName + "의 내역 ]");
               printKeyRestData(restName);

               System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N)");
               input = sc.next().charAt(0);
            }
         }
          catch (NumberFormatException e )
         {
            System.out.println("\n\t\t\t\t\t\t\t※ 알맞은 데이터 타입을 입력하세요. ");
            System.out.println("\t\t\t\t\t\t\t※ 가격과 소요시간은 숫자만 입력 가능합니다. ");
            System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N)");
            input = sc.next().charAt(0);
         }
      }
      writeRestData();
      userInterface();
   } 

   //수정 메소드(음식점 데이터 수정)
   //1. hashMap 조작(데이터 수정)
   //2. writeRestData()   
      public static void modifyRestData() 
      {
         char input = 'Y';
         String sowhat = "";
         String updateStr = "";
         int updateInt = 0;

         while(!(input != 'y' && input != 'Y'))
         {
            try
            {
               String key = "";
      
               while(!(input != 'y' && input != 'Y'))
               {
                  System.out.print("\n\t\t\t\t\t\t\t수정할 식당명을 입력하세요 : ");
                  key = sc.next();

                  if(hashMap.get(key) == null)
                  {
                     System.out.println("\n\t\t\t\t\t\t\t※ 해당 식당이 없습니다.");
                     System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N) : ");
                     input = sc.next().charAt(0);
                  }
                  else
                  {

                     System.out.print("\n\t\t\t\t\t\t\t[식당명 / 메뉴1 / 가격1 / 메뉴2 / 가격2 / 메뉴3 / 가격3 / 소요시간 / 분류]\n");
                     printKeyRestData(key);
                     System.out.print("\t\t\t\t\t\t\t무엇을 수정하시겠습니까? : ");
                     sowhat = sc.next();

                     break;
                  }
               }
                  
               
               if(sowhat.equals("식당명"))
               {
                  String[] backup = new String[12];
                  String beforekey = key;

                  backup[0] = ((SetData) hashMap.get(key)).getMenu1();
                  backup[1] = Integer.toString(((SetData) hashMap.get(key)).getPrice1());
                  backup[2] = Integer.toString(((SetData) hashMap.get(key)).getStock1());
                  backup[3] = ((SetData) hashMap.get(key)).getMenu2();
                  backup[4] = Integer.toString(((SetData) hashMap.get(key)).getPrice2());
                  backup[5] = Integer.toString(((SetData) hashMap.get(key)).getStock2());
                  backup[6] = ((SetData) hashMap.get(key)).getMenu3();
                  backup[7] = Integer.toString(((SetData) hashMap.get(key)).getPrice3());
                  backup[8] = Integer.toString(((SetData) hashMap.get(key)).getStock3());
                  backup[9] = Integer.toString(((SetData) hashMap.get(key)).getTime());
                  backup[10] = ((SetData) hashMap.get(key)).getCategory();
                  backup[11] = Integer.toString(((SetData) hashMap.get(key)).getCountSell());

                  hashMap.remove(key);
                  System.out.print("\n\t\t\t\t\t\t\t변경할 상호명을 입력하세요 : ");
                  key = sc.next();
                  SetData newSetData = new SetData();

                  newSetData.setRestName(key);
                  newSetData.setMenu1(backup[0]);
                  newSetData.setPrice1(Integer.parseInt(backup[1]));
                  newSetData.setStock1(Integer.parseInt(backup[2]));
                  newSetData.setMenu2(backup[3]);
                  newSetData.setPrice2(Integer.parseInt(backup[4]));
                  newSetData.setStock2(Integer.parseInt(backup[5]));
                  newSetData.setMenu3(backup[6]);
                  newSetData.setPrice3(Integer.parseInt(backup[7]));
                  newSetData.setStock3(Integer.parseInt(backup[8]));
                  newSetData.setTime(Integer.parseInt(backup[9]));
                  newSetData.setCategory(backup[10]);
                  newSetData.setCountSell(Integer.parseInt(backup[11]));

                  hashMap.put(key,newSetData);

                  System.out.println("\n\t\t\t\t\t\t\t>>>>> 변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[" + beforekey + "->" + key +" 변경 완료 후 조회 내역]");

                  printKeyRestData(key);

                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);

                  //hashMap.remove(key);
                  //((SetData) hashMap.get(key)).setRestName(updateStr);
               }

               else if(sowhat.equals("메뉴1"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 메뉴1를 입력해주세요 : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setMenu1(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);

               }

               else if(sowhat.equals("가격1"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 가격1를 입력해주세요 : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setPrice1(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("메뉴2"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 메뉴2를 입력해주세요 : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setMenu2(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("가격2"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 가격2를 입력해주세요 : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setPrice2(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("메뉴3"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 메뉴3을 입력해주세요 : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setMenu3(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("가격3"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 가격3을 입력해주세요 : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setPrice3(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("소요시간"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 소요시간을 입력해주세요 : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setTime(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("분류"))
               {
                  System.out.print("\t\t\t\t\t\t\t수정할 분류를 입력해주세요 : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setCategory(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t변경이 완료 되었습니다.");
                  System.out.println("\n\t\t\t\t\t\t\t[변경 완료 후 조회 내역]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t계속 수정하시겠습니까?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals(false))
               {
                  System.out.println("\t\t\t\t\t\t\t※ 해당 조건은 수정하지 못합니다.");
               }
            }

            catch (NumberFormatException e )
            {
               System.out.println("\n\t\t\t알맞은 데이터 타입을 입력하세요.");
               System.out.println("\t\t\t\t\t\t\t가격과 소요시간은 숫자만 입력 가능합니다.");
               System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N)");
               input = sc.next().charAt(0);
            }
         }

      writeRestData();
      userInterface();
   }
   //삭제 메소드(음식점 데이터 삭제)
   //1. hashMap 조작(데이터 삭제)
   //2. writeRestData()  
   public static void deleteRestData() 
   {
       String key;
      char input = 'Y';

      while(!(input != 'y' && input != 'Y'))
      {
         System.out.print("\t\t\t\t\t\t\t삭제할 상호명을 입력하세요 : ");
         key = sc.next();

         if (hashMap.get(key) != null)
         {
            hashMap.remove(key);

            System.out.println("\n\t\t\t\t\t\t\t>>>>> 삭제 완료");
            System.out.print("\n\t\t\t\t\t\t\t계속 삭제하시겠습니까?(Y/N)");
            input = sc.next().charAt(0);

         }
         else if (hashMap.get(key) == null)
         {
            System.out.println("\n\t\t\t\t\t\t\t상호명이 존재하지 않습니다. ");
            System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N)");
            input = sc.next().charAt(0);
         } 
         
      }
      writeRestData();
      userInterface();
      
   } 

   // 조회 메소드
   // 모든 음식점의 데이터를 출력
   public static void printAllRestData()
   {
      System.out.printf("\n\t%-7s\t %-7s\t %-5s\t %-7s\t %-5s\t %-7s\t %s\t %-4s\t %-4s\t %-4s\t\r\n ",
      "상호명","메뉴1","가격1","메뉴2","가격2","메뉴3","가격3","소요시간","분류", "누적판매");
      System.out.print("\t");
      for(int i=0; i < 145; i++) System.out.print("=");
      System.out.print("\n");
      for(String strKey : hashMap.keySet())
      {
         SetData objValue = (SetData) hashMap.get(strKey);

         System.out.printf("\t%-7s\t %-7s\t %-5s원\t %-7s\t %-5s원\t %-7s\t %s\t %-7s분\t %-4s\t %-4s회\t\r\n",
            objValue.getRestName(),
            objValue.getMenu1(), objValue.getPrice1(),
            objValue.getMenu2(), objValue.getPrice2(),
            objValue.getMenu3(), objValue.getPrice3(),
            objValue.getTime(), objValue.getCategory(), objValue.getCountSell());
         System.out.println();
        }
      System.out.print("\t");
      for(int i=0; i < 145; i++) System.out.print("=");
      System.out.println();

   userInterface();
   }// end printAllRestData()
   
   // 식권 채우기 메소드(식권의 재고 추가)
   //1. hashMap 조작(데이터 수정)
   //2. writeRestData() 호출
   public static void fillStock()
   {
      int stock, sum;
      char input = 'Y';

      while(!(input != 'y' && input != 'Y'))
      {
         System.out.print("\n\t\t\t\t\t\t\t상호명을 입력하세요 : ");
         String key = sc.next();

         if (hashMap.get(key) != null)
         {
            System.out.println("\n\t\t\t\t\t\t\t[ " + key + "의 현재 재고 ]");
            printKeyRestData(key);

            System.out.print("\n\t\t\t\t\t\t\t재고를 추가할 메뉴를 입력하세요 : ");
            String inputMenu = sc.next();

            if ( inputMenu.equals(((SetData)hashMap.get(key)).getMenu1()) )
            {
               System.out.print("\t\t\t\t\t\t\t추가할 수량을 입력하세요 : ");
               stock = sc.nextInt();

               sum = ((SetData)hashMap.get(key)).getStock1();
               //System.out.println(sum);

               ((SetData)hashMap.get(key)).setStock1(stock + sum);
               System.out.println("\n\t\t\t\t\t\t\t>>>>> 재고 추가 완료");
               System.out.println();
               System.out.println("\n\t\t\t\t\t\t\t[ " + key + "의 추가 후 재고 ]");
               printKeyRestData(key);
               System.out.print("\n\t\t\t계속 추가하시겠습니까?(Y/N)");
               input = sc.next().charAt(0);

            }
            else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu2()))
            {
               System.out.print("\t\t\t\t\t\t\t추가할 수량을 입력하세요 : ");
               stock = sc.nextInt();

               sum = ((SetData)hashMap.get(key)).getStock2();
               //System.out.println(sum);

               ((SetData)hashMap.get(key)).setStock2(stock + sum);
               System.out.println("\n\t\t\t\t\t\t\t>>>>> 재고 추가 완료");
               System.out.println();
               System.out.println("\n\t\t\t\t\t\t\t[ " + key + "의 추가 후 재고 ]");
               printKeyRestData(key);
               System.out.print("\n\t\t\t\t\t\t\t계속 추가하시겠습니까?(Y/N)");
               input = sc.next().charAt(0);

            }

            else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu3()))
            {
               System.out.print("\t\t\t\t\t\t\t추가할 수량을 입력하세요 : ");
               stock = sc.nextInt();

               sum = ((SetData)hashMap.get(key)).getStock3();
               //System.out.println(sum);

               ((SetData)hashMap.get(key)).setStock3(stock + sum);
               System.out.println("\t\t\t\t\t\t\t>>>>> 재고 추가 완료");
               System.out.println();
               System.out.println("\n\t\t\t\t\t\t\t[ " + key + "의 추가 후 재고 ]");
               printKeyRestData(key);
               System.out.print("\n\t\t\t\t\t\t\t계속 추가하시겠습니까?(Y/N)");
               input = sc.next().charAt(0);
            }
            else
            {
               System.out.println("\n\t\t\t\t\t\t\t※ 해당 메뉴가 존재하지 않습니다.");
               System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N)");
               input = sc.next().charAt(0);   
            }
         }
         else if(hashMap.get(key) == null)
         {
            System.out.println("\n\t\t\t\t\t\t\t※ 상호명이 존재하지 않습니다.");
            System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N)");
            input = sc.next().charAt(0);
         }
      }
      writeRestData();
      userInterface();
   }

   
   public static void noMoney()
   {
      int[] coinUnit = {10000, 5000, 1000, 500, 100};

      System.out.print("\t\t\t\t\t\t\t┌");

      for(int i = 0; i < 43; i++) 
      {
        System.out.print("─");
      }
      System.out.print("┐\n");

      for(int i = 0; i < coinUnit.length; i++)
      {
          if(coinMap.get(coinUnit[i]) == 0)
          {
            System.out.printf("\t\t\t\t\t\t\t│    ! 잔고 [%5d원]의 개수가 부족합니다.  │\n", coinUnit[i]);
          }
      }

      System.out.print("\t\t\t\t\t\t\t└");

      for(int i = 0; i < 43; i++) 
      {
        System.out.print("─");
      }
      System.out.print("┘\n");
   }
   
 
   public static void readCoinData()
   {
      String file = "C:\\JavaStudy\\Java_semi\\coin.csv";

      try
      {
         BufferedReader br = new BufferedReader(new FileReader(file));

         String coinEa;
         String[] coins = new String[5];
         while((coinEa = br.readLine()) != null)
         {
            coins = coinEa.split(",");
         }

         int[] coinUnit = {10000, 5000, 1000, 500, 100};

         for(int i = 0; i < 5; i++)
         {
            coinMap.put(coinUnit[i], Integer.parseInt(coins[i]));
            //System.out.println(coinMap.get(coinUnit[i]));
            //System.out.println("\t\t\t" + coinUnit[i] + "원 - " + coinMap.get(coinUnit[i]) + "개");
         }
         br.close();
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
      catch (NullPointerException ne)
      {
         ne.printStackTrace();
      }
   }

   public static void writeCoinData()
   {
      String file = "C:\\JavaStudy\\Java_semi\\coin.csv";

      try
      {
         BufferedWriter bw = new BufferedWriter(new FileWriter(file)); 
         String coinEa;         

         /*
         이제 coinMap을 건들고 writeCoinData 호출해서쓰면 바뀔 수 있을지도...?
         */

         coinEa = coinMap.get(10000) 
            + "," + coinMap.get(5000) 
            + "," + coinMap.get(1000)
            + "," + coinMap.get(500)
            + "," + coinMap.get(100);
         
         bw.write(coinEa);

         if(bw != null)
         {
            bw.flush();
            bw.close();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   // Machine의 현금입력 메소드
   public static int inputMoney(int money, int tot)
   {
      readCoinData();
      try
      {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int man, ocheon, cheon, obaek, baek;
         man = ocheon = cheon = obaek = baek = 0;
          
         System.out.printf("\n\t\t\t\t\t\t\t※ 총 %7d원입니다.\n",tot);
         System.out.println("\t\t\t\t\t\t\t※ [10,000·5,000·1,000·500·100]원의 개수를 입력합니다.");

         while(true)
         {
            System.out.printf("\n\t\t\t\t\t\t\t%7s","10,000원 : ");
            man = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","5,000원 : ");
            ocheon = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","1,000원 : ");
            cheon = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","500원 : ");
            obaek = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","100원 : ");
            baek = Integer.parseInt(br.readLine());

            money = (10000 * man) + (5000 * ocheon) + (1000 * cheon) + (500 * obaek) + (100 * baek);
            
            //현재 코인데이터에서의 잔고 총합금액
            int checkCoin = 0;
            int[] coinUnit = {10000,5000,1000,500,100};
            for(int i=0; i< 5; i++)
               checkCoin += coinMap.get(coinUnit[i]) * coinUnit[i];
   
            if(money < tot)
               System.out.println("\t\t\t\t\t\t\t※ 넣은 금액이 구매 가격보다 부족합니다.");
            else if(money >= checkCoin)
               System.out.println("\t\t\t\t\t\t\t※ 넣은 금액이 잔고를 초과! 관리자 호출 필요");
            else
               break;
         }
         // 넣은 권종 개수만큼 Manager.class의 sendMoney로 보내준다.
         sendMoney(man, ocheon, cheon, obaek, baek);   

      }
      catch (NumberFormatException nfe)
      {
         System.out.println("\t\t\t\t\t\t\t※ 잔고초과! 금액을 다시 입력해주세요.");
         inputMoney(money, tot);
      }
      catch (Exception e)
      {
       e.printStackTrace();
      }

      return money;
   }


   // Machine에서 권종 별 개수만큼 받아와서 저장한다.
   public static void sendMoney(int man, int ocheon, int cheon, int obaek, int baek)
   {   
      coinMap.put(10000, coinMap.get(10000) + man);
      coinMap.put(5000, coinMap.get(5000) + ocheon);
      coinMap.put(1000, coinMap.get(1000) + cheon);
      coinMap.put(500, coinMap.get(500) + obaek);
      coinMap.put(100, coinMap.get(100) + baek);
   }

   // 넣은 금액과 티켓 총 판매 금액을 가져와서
   // 거스름돈을 계산하고 거스름돈을 권종별로 나눠서 coinMap에서 개수만큼 빼준다.
   
   public static void exchangeMoney(int money, int tot)
   {
        writeCoinData();

      /*
      try
      {
         System.out.println("\n\t\t\t사용자가 넣은 금액 : " + money); // 사용자가 넣은 금액
         System.out.println("\t\t\t티켓 총 판매 금액 : " + tot); // 티켓 총 판매 금액

         int[] coinUnit = {10000, 5000, 1000, 500, 100};
         int exchange = money - tot;

         for(int i=0; i< coinUnit.length; i++) 
         {
          coinMap.put(coinUnit[i], coinMap.get(coinUnit[i]) - (exchange/coinUnit[i]));
          exchange %= coinUnit[i]; 
         }

         exchangePrint(money, tot);
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
      */
      // 화폐 종류
      int[] coinUnit = {10000, 5000, 1000, 500, 100}; // 화폐 종류
      // 현재 잔고 값
      int[] coinNow = {coinMap.get(10000),coinMap.get(5000),coinMap.get(1000),coinMap.get(500),coinMap.get(100)}; // 현재 잔고 값
      // 거스름돈 개수 잔고 배열
      int[] giveMoney = {0,0,0,0,0};
      money = money;
      int won = 10000;
      int sw = 1; // 권종 변경 변수
      int exchange = money - tot; // 현재 거스름돈
      // 현재 잔고의 총 금액
      int totalNow = 0;

      for(int i=0; i< coinUnit.length; i++)
         totalNow += (coinMap.get(coinUnit[i]) * coinUnit[i]);

      int lack = 0; //(현재 잔고가 되지만) 화폐가 모자를때 거르는 변수

      int x = 0;
      int count = 1;
      int temple = exchange;

      // 현재 잔고 총 금액 < 거스름돈
      if(totalNow < exchange)
      {
         System.out.println("\t\t\t\t\t\t\t※ 거스름돈이 부족합니다.");
         System.out.println("\t\t\t\t\t\t\t※ 재고를 추가/삭제해주세요.");
         
         System.out.println();
         System.out.println("\t\t\t\t\t\t\t 필요 시 관리자에게 전화주세요...");
         System.out.println("\t\t\t\t\t\t\t 관리자 : 4조");
         System.out.println("\t\t\t\t\t\t\t ☎ 010-1544-8282");
         userInterface();
      }

      // 현재 잔고 총 금액 > 거스름돈
      else
      {
         // 거스름돈 권종별 수량 계산
         while(true)
         {
            if(coinNow[x] == 0 || exchange - won < 0)
            {
               count = 1;
               x++;
               if(sw == 1)
               {
                  won = won/2;
                  sw = 0;
               }
               else
               {
                  won = won/5;
                  sw = 1;
               }
            }
            else
            {
               exchange = exchange - won;
               giveMoney[x] = count++;
               coinNow[x] -= 1;
            }

            if(x == 5)
            {
               for(int b = 0; b < giveMoney.length; b++)
               {
                  lack += coinUnit[b] * giveMoney[b];
               }
               break;
            }
         }

      }
      // 총 금액 > 거스름돈(그러나 수량부족)
      if (temple != lack)
      {
         System.out.println("\t\t\t\t\t\t\t※ 거스름돈이 부족합니다.");
         System.out.println("\t\t\t\t\t\t\t※ 재고를 추가/삭제해주세요.");
         
         System.out.println();
         System.out.println("\t\t\t\t\t\t\t 필요 시 관리자에게 전화주세요...");
         System.out.println("\t\t\t\t\t\t\t 관리자 : 4조");
         System.out.println("\t\t\t\t\t\t\t ☎ 010-1544-8282");
         userInterface();
      }

      for (int i =0; i<5; i++)
      {
         System.out.printf("\t\t\t\t\t\t\t%5d원 : %2d개\n", coinUnit[i],giveMoney[i]);
         coinMap.put(coinUnit[i], coinMap.get(coinUnit[i]) - giveMoney[i]);
      }

      System.out.println("\n\t\t\t\t\t\t\t※ 거스름돈 : " + temple + "원이 반환되었습니다.");
      writeCoinData();
   }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////




   // 6. 잔고, 동전, 지폐 채우기 메소드
   public static void fillBalance()
   {   
   
      systemMoney = 0; // 시스템이 가지고 있는 잔고
      for(Integer key : coinMap.keySet()) // 현재 잔고 계산
         systemMoney += key * coinMap.get(key);
      sc = new Scanner(System.in);
      char input = 'Y';
      int coinSum = 0;
      while(!(input != 'y' && input != 'Y'))
      {
         try
         {
           System.out.print("\t\t\t\t\t\t\t┌");
           for(int i = 0; i < 43; i++) System.out.print("─");
           System.out.print("┐\n");

           //System.out.println("\t\t\t\t\t\t\t│         [ 현재 잔고  " + systemMoney + " 원]            │");
           System.out.printf("\t\t\t\t\t\t\t│          [ 현재 잔고  %-8d원]         │\n", systemMoney);
              


           System.out.print("\t\t\t\t\t\t\t└");
           for(int i = 0; i < 43; i++) System.out.print("─");
           System.out.print("┘\n");
           System.out.println();

           for(Integer key : coinMap.keySet())
            { //System.out.println("\t\t\t\t\t\t\t"+ key + "원 - " + coinMap.get(key));
              System.out.printf("\t\t\t\t\t\t\t%5d원\t- %d\n", key, coinMap.get(key));
            }

           


            System.out.print("\n\t\t\t\t\t\t\t추가할 지폐 또는 동전을 입력하세요 : ");
            int coinKey = sc.nextInt();

            if(coinMap.containsKey(coinKey))
            {

               System.out.print("\n\t\t\t\t\t\t\t지폐 또는 동전의 개수를 입력하세요 : ");
            

           

               int coinEa = sc.nextInt();
               coinSum = coinMap.get(coinKey) + coinEa;
               coinMap.put(coinKey, coinSum);

            System.out.print("\t\t\t\t\t\t\t┌");
            for(int i = 0; i < 43; i++) System.out.print("─");
            System.out.print("┐\n");

               System.out.println("\t\t\t\t\t\t\t│              [  채워진 잔고  ]            │");

            System.out.print("\t\t\t\t\t\t\t└");
            for(int i = 0; i < 43; i++) System.out.print("─");
            System.out.print("┘\n");
            System.out.println();


               for(Integer key : coinMap.keySet())
                  System.out.println("\t\t\t\t\t\t\t"+ key + "원 - " + coinMap.get(key));

               System.out.println();
               System.out.println("\t\t\t\t\t\t\t>>>>> 개수 추가 완료");

               System.out.print("\n\t\t\t\t\t\t\t계속 추가하시겠습니까?(Y/N) : ");
               input = sc.next().charAt(0);
               System.out.println();
            }
            else if(!(coinMap.containsKey(coinKey)))
            {
               System.out.println("\t\t\t\t\t\t\t※ 규격에 맞는 지폐 또는 동전만 넣을 수 있습니다.");
               System.out.print("\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N) : ");
               input = sc.next().charAt(0);
            }
         
            systemMoney = 0;
            for(Integer key : coinMap.keySet()) // 현재 잔고 계산
               systemMoney += key * coinMap.get(key);

              System.out.print("\t\t\t\t\t\t\t┌");
           for(int i = 0; i < 43; i++) System.out.print("─");
           System.out.print("┐\n");

           //System.out.println("\t\t\t\t\t\t\t│          [ 현재 잔고  " + systemMoney + "원]          │");
           System.out.printf("\t\t\t\t\t\t\t│          [ 현재 잔고  %-8d원]         │\n", systemMoney);
              

           System.out.print("\t\t\t\t\t\t\t└");
           for(int i = 0; i < 43; i++) System.out.print("─");
           System.out.print("┘\n");
           System.out.println();

            System.out.println();
         }
          catch (NumberFormatException e )
         {
            System.out.println("\t\t\t\t\t\t\t※ 규격 외입니다..");
            System.out.println("\t\t\t\t\t\t\t입력 가능합니다.");
            System.out.print("\n\t\t\t\t\t\t\t다시 입력하시겠습니까?(Y/N)");
            input = sc.next().charAt(0);
         }
      }
     writeCoinData();
     writeRestData(); 
     userInterface();
   }

   // writeeRestData() 생성
   // 변경된 HashMap을 .csv파일에 쓰기
   public static void writeRestData() 
   {
       File csv = new File("C:\\JavaStudy\\Java_semi\\Restinfo.csv");
       BufferedWriter bw = null; // 출력 스트림 생성
       try 
       {
           bw = new BufferedWriter(new FileWriter(csv));
           
           for(String strKey : hashMap.keySet())
         {
           SetData objValue = (SetData) hashMap.get(strKey);
           /*
           //테스트 출력
           System.out.println("-------------------");
           System.out.println(strKey);
           System.out.println();
           System.out.println(objValue.getMenu1());   
           System.out.println(objValue.getPrice1()); 
           System.out.println(objValue.getStock1()); 
           
           System.out.println(objValue.getMenu2());   
           System.out.println(objValue.getPrice2());
           System.out.println(objValue.getStock2());
           
           System.out.println(objValue.getMenu3());         
           System.out.println(objValue.getPrice3());
           System.out.println(objValue.getStock3());

           System.out.println(objValue.getTime());
           System.out.println(objValue.getCategory());
           System.out.println("-------------------");
           System.out.println();
           */
           
                
              //한 줄에 넣을 각 데이터 사이에 ,를 넣는다
           String aData = objValue.getRestName() + "," + objValue.getMenu1() + "," + objValue.getPrice1() + "," + objValue.getStock1() + ","
                      + objValue.getMenu2() + "," + objValue.getPrice2() + "," + objValue.getStock2() + ","
                      + objValue.getMenu3() + "," + objValue.getPrice3() + "," + objValue.getStock3() + ","
                      + objValue.getTime() + "," + objValue.getCategory() + "," + objValue.getCountSell();

              //작성한 데이터를 파일에 넣는다
              bw.write(aData);
               
              //개행
              bw.newLine(); 
           }
         if (bw != null) 
               {
                   bw.flush(); // 남아있는 데이터까지 보내 준다
                   bw.close(); // 사용한 BufferedWriter를 닫아 준다
               }
       }
      catch (Exception e) 
       {
           e.printStackTrace();
       } 
   }// endWriteRestData

  
   
   
   public static void readRestData() 
   {
      String file = "C:\\JavaStudy\\Java_semi\\Restinfo.csv"; //Restinfo.csv파일의 절대 경로
      String line = " "; // while문으로 읽어올 데이터 배열 초기화
      
      try (BufferedReader br = new BufferedReader(new FileReader(file))) //br을 FileReader의 역할로 사용할 예정
      { 
        //int rowCnt = 1; // 첫째 줄부터 읽어올 예정
        
        while((line = br.readLine()) != null) // readLine()메소드로 파일에서 더이상 데이터 값이 없을 때까지 읽어들임
                                   // .csv 파일은 엔터로 각 행을 구분하는데 엔터는 null값 X
        {
           String rowStr = ""; // line으로 읽어올 데이터를 저장할 변수 초기화
           
           //System.out.println(line);                        
          
           rowStr = line; //rowStr String에 line을 담음
           String[] items = rowStr.split(","); //items라는 배열에 ","를 기준으로 구분된 rowStr을 "," 단위로 잘라 담음
           String key = items[0]; // 배열에 가장 먼저 담기는 값은 csv구조상 상호명이므로 상호명을 Key값으로 담음
           
           //System.out.println("----------------------------------------------------------------------------------------------------------------------");
           //System.out.println("Key : " + key); // Key값이 제대로 담겼는지 테스트 출력
           
           SetData newSetData = new SetData(); //getter, setter가 있는 SetData 클래스 인스턴스 생성
         

         // test라는 객체로 생성된 SetData의 getter,setter에 각 항목을 초기화
         /*
         읽어온 데이터에 따라 
         items[0] = 상호명(Key값이 될 속성)    
         items[1] = 1번 메뉴, items[2] = 1번 메뉴의 가격
         items[3] = 2번 메뉴, items[4] = 2번 메뉴의 가격
         items[5] = 3번 메뉴, items[6] = 3번 메뉴의 가격
         items[7] = 소요시간, items[8] = 카테고리
         
         의 데이터가 담김 -> 즉 getter, setter에도 동일하게 넘겨줌
         */
            newSetData.setRestName(items[0]);
            newSetData.setMenu1(items[1]);
            newSetData.setPrice1(Integer.parseInt(items[2]));
            newSetData.setStock1(Integer.parseInt(items[3]));
            newSetData.setMenu2(items[4]);
            newSetData.setPrice2(Integer.parseInt(items[5]));
            newSetData.setStock2(Integer.parseInt(items[6]));
            newSetData.setMenu3(items[7]);
            newSetData.setPrice3(Integer.parseInt(items[8]));
            newSetData.setStock3(Integer.parseInt(items[9]));
            newSetData.setTime(Integer.parseInt(items[10]));
            newSetData.setCategory(items[11]);
            newSetData.setCountSell(Integer.parseInt(items[12]));

            hashMap.put(key, newSetData); 
         //hashtemp로 선언해서 
         // getter,setter로 SetData 클래스의 각 속성들을 초기화 했다면
                                 // 상호명을 담은 Key값과 데이터가 담긴 SetData클래스를 value에 객체로 전달
                                 // 즉 HashMap.put(Key(상호명),value(1번 메뉴, 1번 메뉴의 가격,2번 메뉴, 2번 메뉴의 가격,3번 메뉴, 3번 메뉴의 가격, 소요시간, 카테고리 )
            
            //System.out.println(test.toString() + "\n"); // toString 메소드를 재정의 한 내용대로 출력
            //System.out.println("rowCnt" + rowCnt);
            
          }

         //rowCnt++; // 한줄의 속성들을 전부 담았다면 rowCnt++ 하여 다음 라인을 읽어올 수 있도록 함
            
            
     } 
      catch (Exception e) //예외처리
      { 
         System.out.println(e); 
      }

   } // end readRestData() 
   
   // 선택한 키 값의 데이터의 출력을 위한 메소드
   // (fillStock() 잔고 채우기 메소드에서 호출)
   public static void printKeyRestData(String restName) 
   {
      // hashMap.get()메소드를 통해 key값으로 전달받은 파라미터 전달.각 객체의 속성값 출력
      // 속성들이 모두 private 형이며 SetData 클래스가 외부 클래스이기때문에 
      // SetData형으로 캐스팅 해서 각 속성들에 접근할 수 있도록 함
     
      //test
      //System.out.println("Type 확인");
      String key = (((SetData) hashMap.get(restName)).getRestName());
      //System.out.println(key);
      //System.out.println("--------------------");

     System.out.printf("\n\t%-7s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t\t\r\n",
      "상호명","메뉴1","가격1","재고","메뉴2","가격2","재고","메뉴3","가격3","재고");

     System.out.print("\t");
      for(int i=0; i < 135; i++) 
         System.out.print("=");

      System.out.print("\n");

      SetData objValue = (SetData) hashMap.get(restName);

     //System.out.printf("\t%-7s\t %-7s\t %-5s원\t %-7s\t %-5s원\t %-7s\t %s\t %-7s분\t %-4s\t %-4s회\t\r\n",
     //System.out.printf("\t%-7s\t %-7s\t %-5s원\t%s개\t %-7s\t%-5s원\t\t%s개\t%-7s\t%-5s원\t%10s개\t%6s개\t\r\n"

      System.out.printf("\t%-7s\t %-7s\t %-5s원\t%s개\t %-7s\t%-5s원\t\t%s개\t%-7s\t%-5s원\t%10s개\t \t\r\n",
            objValue.getRestName(),
            objValue.getMenu1(), objValue.getPrice1(), objValue.getStock1(),
            objValue.getMenu2(), objValue.getPrice2(), objValue.getStock2(),
            objValue.getMenu3(), objValue.getPrice3(), objValue.getStock3());
      System.out.println();      
     
      System.out.print("\t");

      for(int i=0; i < 135; i++) 
         System.out.print("=");
      System.out.println();
     /*
     System.out.println("\n\t\t\t 메뉴 이름 | 메뉴 가격 | 재고 ");
     System.out.println("\t\t\t------------------------------");
      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu1() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice1() + "원 | ");
     System.out.print(((SetData) hashMap.get(key)).getStock1() + " 개 |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu2() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice2() + " 원 | ");
     System.out.print(((SetData) hashMap.get(key)).getStock2() + " 개 |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu3() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice3() + " 원 |");
     System.out.print(((SetData) hashMap.get(key)).getStock3() + " 개 |\n");
      //System.out.print(((SetData) hashMap.get(key)).getTime() + "|");
      //System.out.println(((SetData) hashMap.get(key)).getCategory() + "|");
     */

   }// end printKeyRestData()

   public static void endMachine()
   {
      System.out.println("\n\t\t\t\t\t\t\t※ 식권 발급 시스템을 종료합니다...\n");
      System.exit(-1);
      writeRestData();
   }

   public static void main(String[] args) throws IOException
   {
      readRestData();
      readCoinData();
      userInterface();


   }//end main

}