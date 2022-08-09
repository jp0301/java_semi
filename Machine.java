import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Map.Entry;
import java.util.Comparator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;


public class Machine
{

   // 로고 및 메인 선택 화면 출력 메소드
   public static void startMenu() throws IOException
   {
      Manager.readRestData(); //Hashmap에 엑셀 데이터 저장
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t        ▒▒▒      TODAY LUNCH      ▒▒▒ ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();


      System.out.print("\t\t\t\t\t\t\t┌");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┐\n");
      System.out.println("\t\t\t\t\t\t\t│              1. 티켓 구매                 │");
      System.out.print("\t\t\t\t\t\t\t└");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┘\n");
      System.out.println();

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String num; 
      do
      {
         System.out.print("\t\t\t\t\t\t\t번호 선택 : ");
         num = br.readLine();
         if (num.equals("1"))
         {
            //티켓
            buyTicket();
         }
         else if (num.equals("1234"))
         {
            Manager.userInterface();
         }
         
      }
      while (!num.equals("1"));
      
      
   }




   // 1. 티켓 구매 화면 출력 메소드
      public static void buyTicket() throws IOException
   {
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t        ▒▒▒        티켓 구매       ▒▒▒ ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t┌");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┐\n");
      
      System.out.println("\t\t\t\t\t\t\t│            1. 메뉴 추천받기               │");
      System.out.println("\t\t\t\t\t\t\t│            2. 메뉴 검색하기               │");
      System.out.print("\t\t\t\t\t\t\t└");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┘\n");
      System.out.println();

      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String num;       
      do
      {
         System.out.print("\t\t\t\t\t\t\t번호 선택(뒤로가기는 0번) : ");
         num = br.readLine();
         if (num.equals("1"))
         {
            //메뉴추천 받기
            rcMenu();
         }
         else if (num.equals("2"))
         {
            //메뉴 검색
            searchAllRest();
         }
       else if (num.equals("0"))
       {
          startMenu();

       }
      }
         while (!num.equals("1") && !num.equals("2"));
      }
   
   public static void rcMenu()throws IOException //1.1 메뉴 추천 받기
   {
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t         ▒▒▒     메뉴 추천 받기    ▒▒▒ ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t┌");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┐\n");
      
      System.out.println("\t\t\t\t\t\t\t│           1. 가까운  거리  식당           │");
      System.out.println("\t\t\t\t\t\t\t│           2. 누적판매 식당 랭킹           │");
      System.out.println("\t\t\t\t\t\t\t│           3. 카테고리  별  메뉴           │");
      System.out.print("\t\t\t\t\t\t\t└");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┘\n");

      System.out.println();
      System.out.println();
    
         int num; //입력받을 숫자
      try
      {
         do
      {
         System.out.print("\t\t\t\t\t\t\t번호를 입력해 주세요(뒤로가기는 0번): ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         num = Integer.parseInt(br.readLine());
       if(num==0)
        {
          buyTicket();
        }
      }
      while (num<1 || num>3);
   
      switch (num)
      {
      case 1:  distanceRC(); break; //distanceRC();
      case 2:  rankingRC(); break;  //
      case 3:  categoryRC(); break;  //categoryRC();
      }     
      
      }
      catch (NumberFormatException e)
      {
        rcMenu();
      }
      
   }



     public static void distanceRC() throws IOException
   {
      
      //1.1.1 가까운 거리의 식당
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t        ▒▒▒   가까운 거리 식당    ▒▒▒ ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");

      System.out.print("\t\t\t\t\t\t\t┌");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┐\n");
      
      System.out.println("\t\t\t\t\t\t\t│             ※ 소요   시간                │");
      System.out.println("\t\t\t\t\t\t\t│             1.  0분 ~  5분                │");
      System.out.println("\t\t\t\t\t\t\t│             2.  5분 ~ 10분                │");
      System.out.println("\t\t\t\t\t\t\t│             3. 10분 ~ 15분                │");
      System.out.print("\t\t\t\t\t\t\t└");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┘\n");

      //번호 입력받기 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num;
      
      do
      {
       System.out.println();
         System.out.print("\t\t\t\t\t\t\t번호를 입력해 주세요(뒤로가기는 0번): ");
         num = Integer.parseInt(br.readLine());
       if(num==0)
        {
          rcMenu();
        }
      }
      while (num < 1 || num > 3);

      //5분, 10분, 15분별 화면 출력을 위한 변수값 설정
        num = num*5;
      
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t============================================");
      System.out.printf("\t\t\t\t\t\t\t    ▒▒▒     %d분 ~ %d분 거리     ▒▒▒ \n ",(num-5), num);   
      System.out.println("\t\t\t\t\t\t\t============================================");   
      System.out.println();               
           

      
      /*
      System.out.println("\t\t\t│     식당명\t메뉴\t  가격\t  시간\t        │");
      System.out.println("\t\t\t│-------------------------------------------│");
      */

      //Manager 데이터 읽어오기
      //Manager.readRestData();
      //모든 키값 불러오기 : keySet() 메소드
      Set<String> keySet = Manager.hashMap.keySet();



      //Map<Integer> map = new (((SetData)Manager.hashMap.get(key)).getTime())<>();

      //키값 오름차순정렬
      //Set을 List로 변환
      //List<Integer> listTimeSet = new ArrayList<>(Manager.hashMap.values());
      //List 정렬

      // 
      Map<String,Integer> map = new HashMap<String,Integer>();
      

      for (String key:keySet )
      {
         map.put(key,(((SetData)Manager.hashMap.get(key)).getTime()));
      }
      List<String> listTime = new ArrayList<>(map.keySet());
      //오름차순정렬
      Collections.sort(listTime,(value1,value2)->(map.get(value1).compareTo(map.get(value2))));



      /*
      //Map.Entry리스트
      List<Entry<String,Integer>> entryList=new ArrayList<Entry<String,Integer>>(map.entrySet());
      //Comparatoe사용해 정렬
      Collections.sort(entryList, new Comparator<Entry<String,Integer>>)()
      {
         public int compara(Entry<String,Integer>obj1,Entry<String,Integer>obj2)
         {
            return obj1.getValue().comparaTo(obj2.getValue());
         }
      }
      */


      //1.1.1 거리별 음식점 정보 출력(5분 / 10분 / 15분)
      for(String key : listTime)
      {
         if ((num-5)<=(((SetData)Manager.hashMap.get(key)).getTime()) && (((SetData)Manager.hashMap.get(key)).getTime()) <= num )
         {
           System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t◎%s(%d분)\n",key,(((SetData)Manager.hashMap.get(key)).getTime()));            
            System.out.print("\t\t\t\t\t\t\t┌");
            for(int i = 0; i < 39; i++) System.out.print("─");
            System.out.print("┐\n");         
            System.out.println("\t\t\t\t\t\t\t│\t\t  차림표\t\t│");
            System.out.println("\t\t\t\t\t\t\t│---------------------------------------│");
            System.out.printf("\t\t\t\t\t\t\t│[1]%s(%d원)\t\t\t│\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu1()),
                  (((SetData)Manager.hashMap.get(key)).getPrice1()));                  
            System.out.printf("\t\t\t\t\t\t\t│[2]%s(%d원)\t\t\t│\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu2()),
                  (((SetData)Manager.hashMap.get(key)).getPrice2()));                  
            System.out.printf("\t\t\t\t\t\t\t│[3]%s(%d원)\t\t\t│\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu3()),
                  (((SetData)Manager.hashMap.get(key)).getPrice3()));                  

            System.out.print("\t\t\t\t\t\t\t└");
            for(int i = 0; i < 39; i++) System.out.print("─");
            System.out.print("┘\n");      
         }
      }

      ticketingCT();

   }

   // 1.1.2 누적판매 식당 랭킹
    public static void rankingRC()throws IOException //1.1.2 식당 랭킹
    {
      int count = 0;
      Scanner sc = new Scanner(System.in);

      Map<String,Integer> map = new HashMap<String,Integer>();
      
        for (String key : Manager.hashMap.keySet())
        {
          if((((SetData)Manager.hashMap.get(key)).getCountSell() != 0))
          map.put(key,(((SetData)Manager.hashMap.get(key)).getCountSell()));
        }
        //System.out.println(map);

        List<Entry<String, Integer>> rank_list = new ArrayList<Entry<String, Integer>>(map.entrySet());

        Collections.sort(rank_list, new Comparator<Entry<String, Integer>>() 
           {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
               // 내림 차순으로 정렬
               return obj2.getValue().compareTo(obj1.getValue());
            }
         });

      // 출력부
     System.out.println();
     System.out.println();
     System.out.println("\t\t\t\t\t\t\t============================================");
      System.out.println("\t\t\t\t\t\t\t      ▒▒▒   누적 판매 식당  랭킹    ▒▒▒  ");   
      System.out.println("\t\t\t\t\t\t\t============================================");

     for(Entry<String, Integer> entry : rank_list) 
      {
         //System.out.println(entry.getKey()); // 키출력완료
         count++;
        
          System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t◎TOP%d [%s]\n",count,entry.getKey());            
           // System.out.print("\t\t\t\t\t\t\t┌");
           // for(int i = 0; i < 43; i++) System.out.print("─");
            //System.out.print("┐\n");
         //System.out.println("\t\t\t\t\t\t\t==============================================");
            //System.out.println("\t\t\t\t\t\t\t\t\t  차림표\t\t    ");
         //System.out.println("\t\t\t\t\t\t\t==============================================");
            //System.out.println("\t\t\t\t\t\t\t│-------------------------------------------│");
         System.out.print("\t\t\t\t\t\t\t");
         for(int i = 0; i < 43; i++) System.out.print("─");
         System.out.println();
         System.out.println();
            System.out.printf("\t\t\t\t\t\t\t[1] %s(%d원) 재고:%d개\t\t    \n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu1(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice1(), 
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock1());
            System.out.printf("\t\t\t\t\t\t\t[2] %s(%d원) 재고:%d개\t\t    \n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu2(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice2(),  
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock2());
            System.out.printf("\t\t\t\t\t\t\t[3] %s(%d원) 재고:%d개\t\t    \n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu3(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice3(),
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock3());
         System.out.println();
         System.out.print("\t\t\t\t\t\t\t");
         for(int i = 0; i < 43; i++) System.out.print("─");
         System.out.println();
            //System.out.print("\t\t\t\t\t\t\t└");
            //for(int i = 0; i < 43; i++) System.out.print("─");
            //System.out.print("┘\n");     
       
       /*
       System.out.print("\t\t\t\t\t\t\t┌");
         for(int i = 0; i < 39; i++) System.out.print("─");
            System.out.print("┐\n");
         System.out.println("\t\t\t\t\t\t\t│\t\t" + count + "위 " + entry.getKey() + "\t\t│");
         System.out.println("\t\t\t\t\t\t\t│---------------------------------------│");
         System.out.println("\t\t\t\t\t\t\t│\t\t  차림표\t\t│");
            System.out.println("\t\t\t\t\t\t\t│---------------------------------------│");
         System.out.println("\t\t\t\t\t\t\t│" + ((SetData)Manager.hashMap.get(entry.getKey())).getMenu1() + "\t"+ ((SetData)Manager.hashMap.get(entry.getKey())).getPrice1() + "원 " + "  재고 : " + ((SetData)Manager.hashMap.get(entry.getKey())).getStock1() + "개   │");
         System.out.println("\t\t\t\t\t\t\t│" + ((SetData)Manager.hashMap.get(entry.getKey())).getMenu2() + "\t"+ ((SetData)Manager.hashMap.get(entry.getKey())).getPrice2() + "원 " + "  재고 : " + ((SetData)Manager.hashMap.get(entry.getKey())).getStock2() + "개   │");
         System.out.println("\t\t\t\t\t\t\t│" + ((SetData)Manager.hashMap.get(entry.getKey())).getMenu3() + "\t"+ ((SetData)Manager.hashMap.get(entry.getKey())).getPrice3() + "원 " + "  재고 : " + ((SetData)Manager.hashMap.get(entry.getKey())).getStock3() + "개   │");
         System.out.println("\t\t\t\t\t\t\t│---------------------------------------│");
       */

       /*
       
          System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t◎TOP%d.%s\n",count,entry.getKey());            
            System.out.print("\t\t\t\t\t\t\t┌");
            for(int i = 0; i < 39; i++) System.out.print("─");
            System.out.print("┐\n");         
            System.out.println("\t\t\t\t\t\t\t│\t\t  차림표\t\t│");
            System.out.println("\t\t\t\t\t\t\t│---------------------------------------│");
            System.out.printf("\t\t\t\t\t\t\t│[1]%s(%d원)  재고:%d개\t\t\t│\n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu1(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice1(); 
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock1()
            System.out.printf("\t\t\t\t\t\t\t│[2]%s(%d원)\t\t\t│\n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu2(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice2();  
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock2()
            System.out.printf("\t\t\t\t\t\t\t│[3]%s(%d원)\t\t\t│\n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu3(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice3();
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock3()
            System.out.print("\t\t\t\t\t\t\t└");
            for(int i = 0; i < 39; i++) System.out.print("─");
            System.out.print("┘\n");      
*/
         if (count >= 5)
         {
            break;
         }
       
      }
     
     if(count==0)
      {
        System.out.print("\t\t\t\t\t\t\t판매 내역이 없습니다 뒤로 돌아갑니다.");
        rcMenu();
      }
     

      //System.out.print("\t\t\t\t\t\t\t 식권을 구매하시겠습니까?(Y/N)");
      System.out.println("\t\t\t\t\t\t\t※ 구매하지 않으시면 초기화면으로 돌아갑니다.");
     System.out.print("\t\t\t\t\t\t\t 식권을 구매하시겠습니까?(Y/N)");
      char input = sc.next().charAt(0);

      if (input == 'Y' || input =='y')
      {
         ticketingCT();
      }
      else
         buyTicket();

   }

   //1.1.3 카테고리 추천
   public static void categoryRC() throws IOException
   {

      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t         ▒▒▒    카테고리 선택    ▒▒▒     ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t┌");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┐\n");
      System.out.println("\t\t\t\t\t\t\t│                 ○ 한식                   │");
      System.out.println("\t\t\t\t\t\t\t│                 ○ 중식                   │");
      System.out.println("\t\t\t\t\t\t\t│                 ○ 일식                   │");
      System.out.println("\t\t\t\t\t\t\t│                 ○ 양식                   │");
      System.out.print("\t\t\t\t\t\t\t└");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.print("┘\n");

      String ca;

      do
      {
         System.out.println();
         System.out.print("\t\t\t\t\t\t\t 카테고리 입력(뒤로가기는 0번) : ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         ca = br.readLine();
       if(ca.equals("0"))/////////////////////////////////////////
        {
          rcMenu();
        }
      }
      while (!ca.equals("한식") && !ca.equals("중식") && !ca.equals("일식") && !ca.equals("양식"));
      //ca!="한식" || ca!="중식" || ca!="일식" || ca!="양식"
      //!ca.equals("한식") || !ca.equals("중식") || !ca.equals("일식") || !ca.equals("양식")


      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.printf("\t\t\t\t\t\t\t         ▒▒▒   카테고리 [ " + ca +" ]   ▒▒▒\n");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      
      System.out.println();
      

      Set<String> keySet = Manager.hashMap.keySet();

      for(String key : keySet)
      {
         
         if ((((SetData)Manager.hashMap.get(key)).getCategory()).equals(ca))
         {
            
              System.out.println();            
            //System.out.printf("\t\t\t│\t\t◎%s(%d분)\t\t│\n\n",key,(((SetData)Manager.hashMap.get(key)).getTime()));            
            //System.out.print("\t\t\t┌");
            //for(int i = 0; i < 43; i++) System.out.print("─");
            //System.out.print("┐\n");
         System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t◎%s(%d분)\n",key,(((SetData)Manager.hashMap.get(key)).getTime()));            
            System.out.print("\t\t\t\t\t\t\t┌");
            for(int i = 0; i < 39; i++) System.out.print("─");
            System.out.print("┐\n"); 
                  
            System.out.println("\t\t\t\t\t\t\t│\t\t  차림표\t\t│");
            System.out.println("\t\t\t\t\t\t\t│---------------------------------------│");
            System.out.printf("\t\t\t\t\t\t\t│[1]%s(%d원)\t\t\t│\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu1()),
                  (((SetData)Manager.hashMap.get(key)).getPrice1()));                  
            System.out.printf("\t\t\t\t\t\t\t│[2]%s(%d원)\t\t\t│\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu2()),
                  (((SetData)Manager.hashMap.get(key)).getPrice2()));                  
            System.out.printf("\t\t\t\t\t\t\t│[3]%s(%d원)\t\t\t│\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu3()),
                  (((SetData)Manager.hashMap.get(key)).getPrice3()));                  

            System.out.print("\t\t\t\t\t\t\t└");
            for(int i = 0; i < 39; i++) System.out.print("─");
            System.out.print("┘\n");  
         //System.out.println("\t\t\t==============================================");
                    
         }
         
      }     
      ticketingCT();
   }

   //1.2 음식 메뉴 검색
   public static void searchAllRest() throws IOException
   {
      Scanner sc = new Scanner(System.in);

      String[] keyArray = new String[Manager.hashMap.size()];
      //System.out.println(Manager.hashMap.size()); //13
      char input = 'Y';
      int count = 0;

      System.out.println("\t\t\t\t\t\t\t============================================");
      System.out.println("\t\t\t\t\t\t\t        ▒▒▒     직접 메뉴 검색     ▒▒▒  ");   
      System.out.println("\t\t\t\t\t\t\t============================================");
      
      while(!(input != 'y' && input != 'Y'))
      {
         System.out.print("\n\t\t\t\t\t\t\t 어떤 음식을 드시겠습니까?(뒤로가기는 0번): ");
         String userMenu = sc.next();
       if(userMenu.equals("0"))
        {
         buyTicket();
        }

          System.out.println();
        System.out.println("\t\t\t\t\t\t\t============================================");
        System.out.printf("\t\t\t\t\t\t\t\t  >>>>>●%s●검색결과...\n", userMenu); 
        System.out.println("\t\t\t\t\t\t\t============================================");
        System.out.println();      
         
         System.out.print("\t\t\t\t\t\t\t");
       for(int i = 0; i < 43; i++) System.out.print("─");
       System.out.println();
         for (String key : Manager.hashMap.keySet())
         {
            if(((SetData)Manager.hashMap.get(key)).getMenu1().contains(userMenu) == true || 
               ((SetData)Manager.hashMap.get(key)).getMenu2().contains(userMenu) == true || 
               ((SetData)Manager.hashMap.get(key)).getMenu3().contains(userMenu) == true)
            {                        
               count++;

               if(((SetData)Manager.hashMap.get(key)).getMenu1().contains(userMenu) == true)
               {
               System.out.printf("\t\t\t\t\t\t\t[%s] %s(%d원)  재고:%d   \t\n",
                     ((SetData)Manager.hashMap.get(key)).getRestName(),
                     ((SetData)Manager.hashMap.get(key)).getMenu1(),
                     ((SetData)Manager.hashMap.get(key)).getPrice1(),
                     ((SetData)Manager.hashMap.get(key)).getStock1());
                                       
               }

               if(((SetData)Manager.hashMap.get(key)).getMenu2().contains(userMenu) == true)
               {
               System.out.printf("\t\t\t\t\t\t\t[%s] %s(%d원)  재고:%d   \t\n", 
                     ((SetData)Manager.hashMap.get(key)).getRestName(),
                     ((SetData)Manager.hashMap.get(key)).getMenu2(),
                     ((SetData)Manager.hashMap.get(key)).getPrice2(),
                     ((SetData)Manager.hashMap.get(key)).getStock2());
               }

               if(((SetData)Manager.hashMap.get(key)).getMenu3().contains(userMenu) == true)
               {
               System.out.printf("\t\t\t\t\t\t\t[%s] %s(%d원)   재고:%d   \t\n", 
                     ((SetData)Manager.hashMap.get(key)).getRestName(),
                     ((SetData)Manager.hashMap.get(key)).getMenu2(),
                     ((SetData)Manager.hashMap.get(key)).getPrice2(),
                     ((SetData)Manager.hashMap.get(key)).getStock2());                     
               }           
            }
         }
       //System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.println();


        
         if(count == 0)
         {
            System.out.println("\n\t\t\t\t\t\t\t※ 제휴 음식점에 찾으시는 음식이 없습니다.");
            System.out.print("\t\t\t\t\t\t\t다시 찾으시겠습니까?(Y/N) : ");
            input = sc.next().charAt(0);
            if (input != 'y' && input != 'Y')
            {
                buyTicket();
                break;
            }
         }

         else if(count != 0)
         {
            //System.out.print("\t\t\t\t\t\t\t☞식권을 구매하시겠습니까?(Y/N) ");
            //System.out.println("\n\t\t\t\t\t\t\t구매하지 않으시면 초기화면으로 돌아갑니다.");
            //System.out.print("\n\t\t\t\t\t\t\t구매여부를 입력하세요 : ");
         System.out.println("\t\t\t\t\t\t\t※ 구매하지 않으시면 초기화면으로 돌아갑니다.");
         System.out.print("\t\t\t\t\t\t\t 식권을 구매하시겠습니까?(Y/N)");
            input = sc.next().charAt(0);
            if (input != 'y' && input != 'Y')
            {
               buyTicket();
               break;
            }
            else
            {
               ticketingCT();
               break;
            }
         }

      }
         System.out.print("\t\t\t\t\t\t\t└");
         for(int i = 0; i < 39; i++) System.out.print("─");
         System.out.print("┘\n");
   }

   //티켓 발급 메소드
   public static void ticketingCT()throws IOException
   {
      
      
      Set<String> keySet = Manager.hashMap.keySet();
      //Set → 배열
      //배열의 크기를 0으로 설정하면 자동으로 배열크기 지정
      //String[] keyArr = keySet.toArray(new String[0]);
      //되는고만

      
      
      String restName;      //왜 restName로는 안되지 ㅜ
      boolean result = false;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      do
      {
         System.out.print("\n\t\t\t\t\t\t\t식당명을 입력하세요 : ");
         restName = br.readLine();
         //set에 요소확인
         result = keySet.contains(restName);
      }
      while (result==false); //key값과 일치하지않을때?????
     
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t===========================================");
      System.out.printf("\t\t\t\t\t\t\t      ▒▒▒  [ "+restName+" ] 티켓 발급  ▒▒▒\n");   
      System.out.println("\t\t\t\t\t\t\t===========================================");
      System.out.println();
      //System.out.print("\t\t\t┌");
      //for(int i = 0; i < 39; i++) System.out.print("─");
      //System.out.print("┐\n");
      //System.out.printf("\t\t\t\t\t◎%s\n",restName);
      //System.out.print("\t\t\t└");
      //for(int i = 0; i < 39; i++) System.out.print("─");
      //System.out.print("┘\n");
      //System.out.printf("\t\t\t  메뉴\t\t\t 가격\t   수량\n ");
        System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 43; i++) System.out.print("─");
      System.out.println();
      //restName2랑 일치하는 key값의 value가져오기?
      //SetData key =(SetData)Manager.hashMap.get(restName2);
      //Object key =(SetData)Manager.hashMap.get(restName2);

       System.out.printf("\t\t\t\t\t\t\t[1] %s(%d원)   재고:%d   \t\n",((SetData)Manager.hashMap.get(restName)).getMenu1()
                     ,((SetData)Manager.hashMap.get(restName)).getPrice1()
                     ,((SetData)Manager.hashMap.get(restName)).getStock1());
     System.out.printf("\t\t\t\t\t\t\t[2] %s(%d원)   재고:%d   \t\n",((SetData)Manager.hashMap.get(restName)).getMenu2()
                     ,((SetData)Manager.hashMap.get(restName)).getPrice2()
                     ,((SetData)Manager.hashMap.get(restName)).getStock2());
     System.out.printf("\t\t\t\t\t\t\t[3] %s(%d원)   재고:%d   \t\n",((SetData)Manager.hashMap.get(restName)).getMenu3()
                     ,((SetData)Manager.hashMap.get(restName)).getPrice3()
                     ,((SetData)Manager.hashMap.get(restName)).getStock3());
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 43; i++) System.out.print("─");
     System.out.println();
      String plus="";
      ArrayList<String> menuList = new ArrayList<String>();
      SetData ob = ((SetData)Manager.hashMap.get(restName));
     
     System.out.println("\t\t\t\t\t\t\t[ 메뉴 추천 ] 으로 뒤로가기 → 0번 ");
    System.out.println("\t\t\t\t\t\t\t[ 메뉴 검색 ] 으로 뒤로가기 → 1번");
      do
      {   String menu=" ";
         String su=" ";
         System.out.print("\t\t\t\t\t\t\t구입할 메뉴입력 : ");
         menu = br.readLine();
       if(menu.equals("0"))
        {
          rcMenu();
        //와드
        }
       else if(menu.equals("1"))
        {
          searchAllRest();
         
        }
       else if((ob.getMenu1().equals(menu) || ob.getMenu2().equals(menu) || ob.getMenu3().equals(menu))==false) //메뉴이름이 다르면 걸리는곳
       {
          System.out.println("\t\t\t\t\t\t\t※ "+restName+"의 메뉴가 아닙니다.");

       }
         else if(menuList.contains(menu)==true) //메뉴이름이 같으면 걸리는곳
         {
            System.out.println("\t\t\t\t\t\t\t동일한 메뉴는 담으실수 없습니다 결제전 메뉴 개수를 추가해주세요");
         }
       System.out.print("\t\t\t\t\t\t\t개수 입력 : ");
       su = br.readLine();

         if(menu.equals(ob.getMenu1()) && Integer.parseInt(su) > ob.getStock1())
         {
            System.out.println("\t\t\t\t\t\t\t※ 재고보다 많이 구매하실수는 없습니다");
         
         }
         else if(menu.equals(ob.getMenu2()) && Integer.parseInt(su) > ob.getStock2())
         {
            System.out.println("\t\t\t\t\t\t\t※ 재고보다 많이 구매하실수는 없습니다");
         
         }
         else if(menu.equals(ob.getMenu3()) && Integer.parseInt(su) > ob.getStock3())
         {
            System.out.println("\t\t\t\t\t\t\t※ 재고보다 많이 구매하실수는 없습니다");   
         }
         else
         {
         menuList.add(menu);
         menuList.add(su);
       menuList.trimToSize();
         }


         if(menuList.size()==6)
          continue;
         System.out.println("\t\t\t\t\t\t\t메뉴를 더 담으시겠습니까(최대 3개)?");
         System.out.print("\t\t\t\t\t\t\t메뉴 구매 확정 (N) :");
         plus = br.readLine();
         plus = plus.toUpperCase();
         menuList.trimToSize();
      }
      while (menuList.size() != 6 && !plus.equals("N") ); 

      String[][] menus = new String[menuList.size()/2][5];
      int money=0;
      int count=0;
      
      Iterator<String> it = menuList.iterator();
      //restName,메뉴,가격,재고,개수

      while(it.hasNext()) //1개면 1개를 2개면 2개를 전달 3개면 3개 배열에 저장해야 근데 고른 순서, 메뉴,가격,재고
      {
         String i = it.next(); //다음꺼는 메뉴의 개수다

         if(i.equals(ob.getMenu1()))
         {
            menus[count][0] = restName;
            menus[count][1] = ob.getMenu1();
            menus[count][2]=  String.valueOf(ob.getPrice1());
            menus[count][3] = it.next(); //구입개수
            menus[count][4] = String.valueOf(ob.getStock1());
         }

         else if(i.equals(ob.getMenu2()))
         {
            menus[count][0] = restName;
            menus[count][1] = ob.getMenu2();
            menus[count][2]=  String.valueOf(ob.getPrice2());
            menus[count][3] = it.next();
            menus[count][4] = String.valueOf(ob.getStock2());
            
         }
         else if(i.equals(ob.getMenu3()))
         {
            menus[count][0] = restName;
            menus[count][1] = ob.getMenu3();
            menus[count][2]=  String.valueOf(ob.getPrice3());
            menus[count][3] = it.next();
            menus[count][4] = String.valueOf(ob.getStock3());
            
         }
            count++;
      }
/*
      for(int i=0;i<menus.length;i++)
      {
         for(int j=0;j<menus[i].length;j++)
         {
            System.out.printf("%7s",menus[i][j]);
         }
         System.out.println();
      }*/
      //나중에 합쳐서 던지자  합쳤다 이미

      //총 금액과 현금을 넣는 구문
      int tot=0;

      for(int i=0;i<menus.length;i++)
      {
         for(int j=2;j<=2;j++)
         {
            tot += Integer.parseInt(menus[i][j]) * Integer.parseInt(menus[i][j+1]);         
         }
      }


      // 현금 입력 메소드
      // 권종 별로 입력 받고 money는 반환해준다.money는 계속 내려가야하기때문에...
      money = Manager.inputMoney(money, tot);

      checkCT(menus,money,tot);
      //tot과 money은 권종구분 파트를 모르므로 빼놓고 필요하면 다시 넣자
   }


   public static void checkCT(String[][] menus,int money,int tot)throws IOException ///거리순,카테고리별 추천 에서 넘어오는 결제창 -> check()로 이동해서 최종결제창
   {
      //Manager.readRestData(); //관리자가 티켓 재고를 채울시 엑셀데이터에 저장되므로 다시 hashMap에 데이터 저장
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t         ▒▒▒    식당 티켓 발급    ▒▒▒     ");
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 44; i++) System.out.print("─");
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t 식당명 : "+menus[0][0]);
      System.out.println();
      for(int i=0;i<menus.length;i++)
      {
      System.out.println("\t\t\t\t\t\t\t 음식명 : "+menus[i][1]);
      System.out.println("\t\t\t\t\t\t\t 개수 : "+Integer.parseInt(menus[i][3]));
      System.out.println();
      }
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t 총 금액 : "+tot);
      System.out.println("\t\t\t\t\t\t\t 넣은 현금 : "+money);
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 44; i++) System.out.print("─");
      System.out.println();
      System.out.println();
      /*menus[count][0] = restName;
            menus[count][1] = ob.getMenu1();
            menus[count][2]=  String.valueOf(ob.getPrice1());
            menus[count][3] = it.next(); //구입개수
            menus[count][4] = String.valueOf(ob.getStock1());
            */
      System.out.println("\t\t\t\t\t\t\t결제 완료시 취소할 수 없습니다.");
      
      String check = ""; 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      do
      {
      System.out.print("\t\t\t\t\t\t\t발급하시겠습니까? (Y/N)");
      check = br.readLine();
      check = check.toUpperCase();
      }
      while (!check.equals("Y") && !check.equals("N"));
      
      if(check.equals("Y"))
      {
      System.out.print("\n\t\t\t\t\t\t\t>>>> 티켓이 발급중입니다...\n");
     System.out.println();

      Manager.exchangeMoney(money,tot);

      inputResultoExcel(menus,money,tot);
      }
      else if(check.equals("N"))
      {
      System.out.print("\n\t\t\t\t\t\t\t검색or추천화면으로 돌아갑니다.");
         buyTicket();
      }   
   
   }


   public static void ticketing(String[][] menus) throws IOException  //카테고리 랭킹추천에서 넘어오는 결제창 -> check()로 이동해서 최종결제창
   {   
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t          ▒▒▒    식당 티켓 발급    ▒▒▒     ");
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("─");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t 식당명     메뉴    가격     재고\n");
      System.out.println("\t\t\t\t\t\t\t "+menus[0][0]+"  "+menus[0][1]+"  "+menus[0][2]+"  "+menus[0][4]+"개");
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("─");
      System.out.println();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num;
      do
      {
      System.out.print("\t\t\t\t\t\t고르신 메뉴의 티켓 재고는 "+menus[0][4]+"입니다. 개수를 선택해주세요 : ");
      num = Integer.parseInt(br.readLine());       //후에 해당 메뉴의 재고에 접근해야할 변수
      }
      while (num>Integer.parseInt(menus[0][4]));
         menus[0][3] = String.valueOf(num);


      int tot = (Integer.parseInt(menus[0][3])*Integer.parseInt(menus[0][2]));
      

      // 현금 입력 메소드
      // 권종 별로 입력 받고 money는 반환해준다.money는 계속 내려가야하기때문에...
      int money = 0;
      money = Manager.inputMoney(money, tot);


      check(menus,money,tot);
      //원석이가 만든 UI에 따르면 발급재차확인(check메소드)에서는 식당,음식,입력한 발권개수, 가격*발권개수,넣은현금이 필요하다.
   }
   
   


   public static void check(String[][] menus,int money,int tot)throws IOException
   {
      Manager.readRestData(); //관리자가 티켓 재고를 채울시 엑셀데이터에 저장되므로 다시 hashMap에 데이터 저장
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t          ▒▒▒    식당 티켓 발급    ▒▒▒     ");
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("─");
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t 식당명 : "+menus[0][0]);
      System.out.println("\t\t\t\t\t\t\t 음식명 : "+menus[0][1]);
      System.out.println("\t\t\t\t\t\t\t 개수 : "+menus[0][3]);
      System.out.println("\t\t\t\t\t\t\t 총 금액 : "+tot);
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t 넣은 현금 : "+money);
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("─");
      System.out.println();
      System.out.println();
      
      System.out.println("\t\t\t\t\t\t\t※ 결제 완료시 취소할 수 없습니다.");
      String check = ""; 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      do
      {
         System.out.print("\t\t\t\t\t\t\t발급하시겠습니까? (Y/N)");
         check = br.readLine();
         check = check.toUpperCase();
      }
      while (!check.equals("Y") && !check.equals("N"));
      
      if(check.equals("Y"))
      {
         System.out.print("\n\t\t\t\t\t\t\t>>>>> 티켓이 발급중입니다...");
         inputResultoExcel(menus,money,tot);
      }
      else if(check.equals("N"))
      {
         System.out.print("\n\t\t\t\t\t\t\t검색or추천화면으로 돌아갑니다.");
         buyTicket();
      }
      
      //여기서 해쉬에 접속해서 재고를 감소시킬것?
   }


  private static void inputResultoExcel(String[][] menus, int money, int tot)throws IOException
   {
    
      for(int i=0;i<menus.length;i++)
      {
       //System.out.println(menus[i][0]);

        if(((SetData)Manager.hashMap.get(menus[i][0])).getMenu1().equals(menus[i][1]))
        {

          int change = ((SetData)Manager.hashMap.get(menus[i][0])).getStock1()-Integer.parseInt(menus[i][3]);
          ((SetData)Manager.hashMap.get(menus[i][0])).setStock1(change);

         // 판매량 올려
          int rank = ((SetData)Manager.hashMap.get(menus[i][0])).getCountSell();
           ((SetData)Manager.hashMap.get(menus[i][0])).setCountSell(rank+1);

        }

        else if(((SetData)Manager.hashMap.get(menus[i][0])).getMenu2().equals(menus[i][1]))
        {
          int change = ((SetData)Manager.hashMap.get(menus[i][0])).getStock2()-Integer.parseInt(menus[i][3]);
          ((SetData)Manager.hashMap.get(menus[i][0])).setStock2(change);
         
         // 판매량 올려
          int rank = ((SetData)Manager.hashMap.get(menus[i][0])).getCountSell();
          ((SetData)Manager.hashMap.get(menus[i][0])).setCountSell(rank+1);
          
        }
        
        else if(((SetData)Manager.hashMap.get(menus[i][0])).getMenu3().equals(menus[i][1]))
        {
          int change = ((SetData)Manager.hashMap.get(menus[i][0])).getStock3()-Integer.parseInt(menus[i][3]);
          ((SetData)Manager.hashMap.get(menus[i][0])).setStock3(change);
         
         // 판매량 올려
          int rank = ((SetData)Manager.hashMap.get(menus[i][0])).getCountSell();
          ((SetData)Manager.hashMap.get(menus[i][0])).setCountSell(rank+1);
        }
      }

      Manager.writeRestData();
      startMenu();
      }
   }