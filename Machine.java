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

   // �ΰ� �� ���� ���� ȭ�� ��� �޼ҵ�
   public static void startMenu() throws IOException
   {
      Manager.readRestData(); //Hashmap�� ���� ������ ����
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t        �ƢƢ�      TODAY LUNCH      �ƢƢ� ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();


      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      System.out.println("\t\t\t\t\t\t\t��              1. Ƽ�� ����                 ��");
      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      System.out.println();

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String num; 
      do
      {
         System.out.print("\t\t\t\t\t\t\t��ȣ ���� : ");
         num = br.readLine();
         if (num.equals("1"))
         {
            //Ƽ��
            buyTicket();
         }
         else if (num.equals("1234"))
         {
            Manager.userInterface();
         }
         
      }
      while (!num.equals("1"));
      
      
   }




   // 1. Ƽ�� ���� ȭ�� ��� �޼ҵ�
      public static void buyTicket() throws IOException
   {
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t        �ƢƢ�        Ƽ�� ����       �ƢƢ� ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      
      System.out.println("\t\t\t\t\t\t\t��            1. �޴� ��õ�ޱ�               ��");
      System.out.println("\t\t\t\t\t\t\t��            2. �޴� �˻��ϱ�               ��");
      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      System.out.println();

      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String num;       
      do
      {
         System.out.print("\t\t\t\t\t\t\t��ȣ ����(�ڷΰ���� 0��) : ");
         num = br.readLine();
         if (num.equals("1"))
         {
            //�޴���õ �ޱ�
            rcMenu();
         }
         else if (num.equals("2"))
         {
            //�޴� �˻�
            searchAllRest();
         }
       else if (num.equals("0"))
       {
          startMenu();

       }
      }
         while (!num.equals("1") && !num.equals("2"));
      }
   
   public static void rcMenu()throws IOException //1.1 �޴� ��õ �ޱ�
   {
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t         �ƢƢ�     �޴� ��õ �ޱ�    �ƢƢ� ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      
      System.out.println("\t\t\t\t\t\t\t��           1. �����  �Ÿ�  �Ĵ�           ��");
      System.out.println("\t\t\t\t\t\t\t��           2. �����Ǹ� �Ĵ� ��ŷ           ��");
      System.out.println("\t\t\t\t\t\t\t��           3. ī�װ�  ��  �޴�           ��");
      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");

      System.out.println();
      System.out.println();
    
         int num; //�Է¹��� ����
      try
      {
         do
      {
         System.out.print("\t\t\t\t\t\t\t��ȣ�� �Է��� �ּ���(�ڷΰ���� 0��): ");
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
      
      //1.1.1 ����� �Ÿ��� �Ĵ�
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t        �ƢƢ�   ����� �Ÿ� �Ĵ�    �ƢƢ� ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");

      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      
      System.out.println("\t\t\t\t\t\t\t��             �� �ҿ�   �ð�                ��");
      System.out.println("\t\t\t\t\t\t\t��             1.  0�� ~  5��                ��");
      System.out.println("\t\t\t\t\t\t\t��             2.  5�� ~ 10��                ��");
      System.out.println("\t\t\t\t\t\t\t��             3. 10�� ~ 15��                ��");
      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");

      //��ȣ �Է¹ޱ� 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num;
      
      do
      {
       System.out.println();
         System.out.print("\t\t\t\t\t\t\t��ȣ�� �Է��� �ּ���(�ڷΰ���� 0��): ");
         num = Integer.parseInt(br.readLine());
       if(num==0)
        {
          rcMenu();
        }
      }
      while (num < 1 || num > 3);

      //5��, 10��, 15�к� ȭ�� ����� ���� ������ ����
        num = num*5;
      
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t============================================");
      System.out.printf("\t\t\t\t\t\t\t    �ƢƢ�     %d�� ~ %d�� �Ÿ�     �ƢƢ� \n ",(num-5), num);   
      System.out.println("\t\t\t\t\t\t\t============================================");   
      System.out.println();               
           

      
      /*
      System.out.println("\t\t\t��     �Ĵ��\t�޴�\t  ����\t  �ð�\t        ��");
      System.out.println("\t\t\t��-------------------------------------------��");
      */

      //Manager ������ �о����
      //Manager.readRestData();
      //��� Ű�� �ҷ����� : keySet() �޼ҵ�
      Set<String> keySet = Manager.hashMap.keySet();



      //Map<Integer> map = new (((SetData)Manager.hashMap.get(key)).getTime())<>();

      //Ű�� ������������
      //Set�� List�� ��ȯ
      //List<Integer> listTimeSet = new ArrayList<>(Manager.hashMap.values());
      //List ����

      // 
      Map<String,Integer> map = new HashMap<String,Integer>();
      

      for (String key:keySet )
      {
         map.put(key,(((SetData)Manager.hashMap.get(key)).getTime()));
      }
      List<String> listTime = new ArrayList<>(map.keySet());
      //������������
      Collections.sort(listTime,(value1,value2)->(map.get(value1).compareTo(map.get(value2))));



      /*
      //Map.Entry����Ʈ
      List<Entry<String,Integer>> entryList=new ArrayList<Entry<String,Integer>>(map.entrySet());
      //Comparatoe����� ����
      Collections.sort(entryList, new Comparator<Entry<String,Integer>>)()
      {
         public int compara(Entry<String,Integer>obj1,Entry<String,Integer>obj2)
         {
            return obj1.getValue().comparaTo(obj2.getValue());
         }
      }
      */


      //1.1.1 �Ÿ��� ������ ���� ���(5�� / 10�� / 15��)
      for(String key : listTime)
      {
         if ((num-5)<=(((SetData)Manager.hashMap.get(key)).getTime()) && (((SetData)Manager.hashMap.get(key)).getTime()) <= num )
         {
           System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t��%s(%d��)\n",key,(((SetData)Manager.hashMap.get(key)).getTime()));            
            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 39; i++) System.out.print("��");
            System.out.print("��\n");         
            System.out.println("\t\t\t\t\t\t\t��\t\t  ����ǥ\t\t��");
            System.out.println("\t\t\t\t\t\t\t��---------------------------------------��");
            System.out.printf("\t\t\t\t\t\t\t��[1]%s(%d��)\t\t\t��\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu1()),
                  (((SetData)Manager.hashMap.get(key)).getPrice1()));                  
            System.out.printf("\t\t\t\t\t\t\t��[2]%s(%d��)\t\t\t��\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu2()),
                  (((SetData)Manager.hashMap.get(key)).getPrice2()));                  
            System.out.printf("\t\t\t\t\t\t\t��[3]%s(%d��)\t\t\t��\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu3()),
                  (((SetData)Manager.hashMap.get(key)).getPrice3()));                  

            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 39; i++) System.out.print("��");
            System.out.print("��\n");      
         }
      }

      ticketingCT();

   }

   // 1.1.2 �����Ǹ� �Ĵ� ��ŷ
    public static void rankingRC()throws IOException //1.1.2 �Ĵ� ��ŷ
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
               // ���� �������� ����
               return obj2.getValue().compareTo(obj1.getValue());
            }
         });

      // ��º�
     System.out.println();
     System.out.println();
     System.out.println("\t\t\t\t\t\t\t============================================");
      System.out.println("\t\t\t\t\t\t\t      �ƢƢ�   ���� �Ǹ� �Ĵ�  ��ŷ    �ƢƢ�  ");   
      System.out.println("\t\t\t\t\t\t\t============================================");

     for(Entry<String, Integer> entry : rank_list) 
      {
         //System.out.println(entry.getKey()); // Ű��¿Ϸ�
         count++;
        
          System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t��TOP%d [%s]\n",count,entry.getKey());            
           // System.out.print("\t\t\t\t\t\t\t��");
           // for(int i = 0; i < 43; i++) System.out.print("��");
            //System.out.print("��\n");
         //System.out.println("\t\t\t\t\t\t\t==============================================");
            //System.out.println("\t\t\t\t\t\t\t\t\t  ����ǥ\t\t    ");
         //System.out.println("\t\t\t\t\t\t\t==============================================");
            //System.out.println("\t\t\t\t\t\t\t��-------------------------------------------��");
         System.out.print("\t\t\t\t\t\t\t");
         for(int i = 0; i < 43; i++) System.out.print("��");
         System.out.println();
         System.out.println();
            System.out.printf("\t\t\t\t\t\t\t[1] %s(%d��) ���:%d��\t\t    \n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu1(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice1(), 
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock1());
            System.out.printf("\t\t\t\t\t\t\t[2] %s(%d��) ���:%d��\t\t    \n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu2(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice2(),  
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock2());
            System.out.printf("\t\t\t\t\t\t\t[3] %s(%d��) ���:%d��\t\t    \n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu3(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice3(),
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock3());
         System.out.println();
         System.out.print("\t\t\t\t\t\t\t");
         for(int i = 0; i < 43; i++) System.out.print("��");
         System.out.println();
            //System.out.print("\t\t\t\t\t\t\t��");
            //for(int i = 0; i < 43; i++) System.out.print("��");
            //System.out.print("��\n");     
       
       /*
       System.out.print("\t\t\t\t\t\t\t��");
         for(int i = 0; i < 39; i++) System.out.print("��");
            System.out.print("��\n");
         System.out.println("\t\t\t\t\t\t\t��\t\t" + count + "�� " + entry.getKey() + "\t\t��");
         System.out.println("\t\t\t\t\t\t\t��---------------------------------------��");
         System.out.println("\t\t\t\t\t\t\t��\t\t  ����ǥ\t\t��");
            System.out.println("\t\t\t\t\t\t\t��---------------------------------------��");
         System.out.println("\t\t\t\t\t\t\t��" + ((SetData)Manager.hashMap.get(entry.getKey())).getMenu1() + "\t"+ ((SetData)Manager.hashMap.get(entry.getKey())).getPrice1() + "�� " + "  ��� : " + ((SetData)Manager.hashMap.get(entry.getKey())).getStock1() + "��   ��");
         System.out.println("\t\t\t\t\t\t\t��" + ((SetData)Manager.hashMap.get(entry.getKey())).getMenu2() + "\t"+ ((SetData)Manager.hashMap.get(entry.getKey())).getPrice2() + "�� " + "  ��� : " + ((SetData)Manager.hashMap.get(entry.getKey())).getStock2() + "��   ��");
         System.out.println("\t\t\t\t\t\t\t��" + ((SetData)Manager.hashMap.get(entry.getKey())).getMenu3() + "\t"+ ((SetData)Manager.hashMap.get(entry.getKey())).getPrice3() + "�� " + "  ��� : " + ((SetData)Manager.hashMap.get(entry.getKey())).getStock3() + "��   ��");
         System.out.println("\t\t\t\t\t\t\t��---------------------------------------��");
       */

       /*
       
          System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t��TOP%d.%s\n",count,entry.getKey());            
            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 39; i++) System.out.print("��");
            System.out.print("��\n");         
            System.out.println("\t\t\t\t\t\t\t��\t\t  ����ǥ\t\t��");
            System.out.println("\t\t\t\t\t\t\t��---------------------------------------��");
            System.out.printf("\t\t\t\t\t\t\t��[1]%s(%d��)  ���:%d��\t\t\t��\n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu1(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice1(); 
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock1()
            System.out.printf("\t\t\t\t\t\t\t��[2]%s(%d��)\t\t\t��\n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu2(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice2();  
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock2()
            System.out.printf("\t\t\t\t\t\t\t��[3]%s(%d��)\t\t\t��\n", 
                 ((SetData)Manager.hashMap.get(entry.getKey())).getMenu3(),
                 ((SetData)Manager.hashMap.get(entry.getKey())).getPrice3();
             ((SetData)Manager.hashMap.get(entry.getKey())).getStock3()
            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 39; i++) System.out.print("��");
            System.out.print("��\n");      
*/
         if (count >= 5)
         {
            break;
         }
       
      }
     
     if(count==0)
      {
        System.out.print("\t\t\t\t\t\t\t�Ǹ� ������ �����ϴ� �ڷ� ���ư��ϴ�.");
        rcMenu();
      }
     

      //System.out.print("\t\t\t\t\t\t\t �ı��� �����Ͻðڽ��ϱ�?(Y/N)");
      System.out.println("\t\t\t\t\t\t\t�� �������� �����ø� �ʱ�ȭ������ ���ư��ϴ�.");
     System.out.print("\t\t\t\t\t\t\t �ı��� �����Ͻðڽ��ϱ�?(Y/N)");
      char input = sc.next().charAt(0);

      if (input == 'Y' || input =='y')
      {
         ticketingCT();
      }
      else
         buyTicket();

   }

   //1.1.3 ī�װ� ��õ
   public static void categoryRC() throws IOException
   {

      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t         �ƢƢ�    ī�װ� ����    �ƢƢ�     ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      System.out.println("\t\t\t\t\t\t\t��                 �� �ѽ�                   ��");
      System.out.println("\t\t\t\t\t\t\t��                 �� �߽�                   ��");
      System.out.println("\t\t\t\t\t\t\t��                 �� �Ͻ�                   ��");
      System.out.println("\t\t\t\t\t\t\t��                 �� ���                   ��");
      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");

      String ca;

      do
      {
         System.out.println();
         System.out.print("\t\t\t\t\t\t\t ī�װ� �Է�(�ڷΰ���� 0��) : ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         ca = br.readLine();
       if(ca.equals("0"))/////////////////////////////////////////
        {
          rcMenu();
        }
      }
      while (!ca.equals("�ѽ�") && !ca.equals("�߽�") && !ca.equals("�Ͻ�") && !ca.equals("���"));
      //ca!="�ѽ�" || ca!="�߽�" || ca!="�Ͻ�" || ca!="���"
      //!ca.equals("�ѽ�") || !ca.equals("�߽�") || !ca.equals("�Ͻ�") || !ca.equals("���")


      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.printf("\t\t\t\t\t\t\t         �ƢƢ�   ī�װ� [ " + ca +" ]   �ƢƢ�\n");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      
      System.out.println();
      

      Set<String> keySet = Manager.hashMap.keySet();

      for(String key : keySet)
      {
         
         if ((((SetData)Manager.hashMap.get(key)).getCategory()).equals(ca))
         {
            
              System.out.println();            
            //System.out.printf("\t\t\t��\t\t��%s(%d��)\t\t��\n\n",key,(((SetData)Manager.hashMap.get(key)).getTime()));            
            //System.out.print("\t\t\t��");
            //for(int i = 0; i < 43; i++) System.out.print("��");
            //System.out.print("��\n");
         System.out.println();            
            System.out.printf("\t\t\t\t\t\t\t\t\t��%s(%d��)\n",key,(((SetData)Manager.hashMap.get(key)).getTime()));            
            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 39; i++) System.out.print("��");
            System.out.print("��\n"); 
                  
            System.out.println("\t\t\t\t\t\t\t��\t\t  ����ǥ\t\t��");
            System.out.println("\t\t\t\t\t\t\t��---------------------------------------��");
            System.out.printf("\t\t\t\t\t\t\t��[1]%s(%d��)\t\t\t��\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu1()),
                  (((SetData)Manager.hashMap.get(key)).getPrice1()));                  
            System.out.printf("\t\t\t\t\t\t\t��[2]%s(%d��)\t\t\t��\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu2()),
                  (((SetData)Manager.hashMap.get(key)).getPrice2()));                  
            System.out.printf("\t\t\t\t\t\t\t��[3]%s(%d��)\t\t\t��\n", 
                  (((SetData)Manager.hashMap.get(key)).getMenu3()),
                  (((SetData)Manager.hashMap.get(key)).getPrice3()));                  

            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 39; i++) System.out.print("��");
            System.out.print("��\n");  
         //System.out.println("\t\t\t==============================================");
                    
         }
         
      }     
      ticketingCT();
   }

   //1.2 ���� �޴� �˻�
   public static void searchAllRest() throws IOException
   {
      Scanner sc = new Scanner(System.in);

      String[] keyArray = new String[Manager.hashMap.size()];
      //System.out.println(Manager.hashMap.size()); //13
      char input = 'Y';
      int count = 0;

      System.out.println("\t\t\t\t\t\t\t============================================");
      System.out.println("\t\t\t\t\t\t\t        �ƢƢ�     ���� �޴� �˻�     �ƢƢ�  ");   
      System.out.println("\t\t\t\t\t\t\t============================================");
      
      while(!(input != 'y' && input != 'Y'))
      {
         System.out.print("\n\t\t\t\t\t\t\t � ������ ��ðڽ��ϱ�?(�ڷΰ���� 0��): ");
         String userMenu = sc.next();
       if(userMenu.equals("0"))
        {
         buyTicket();
        }

          System.out.println();
        System.out.println("\t\t\t\t\t\t\t============================================");
        System.out.printf("\t\t\t\t\t\t\t\t  >>>>>��%s�ܰ˻����...\n", userMenu); 
        System.out.println("\t\t\t\t\t\t\t============================================");
        System.out.println();      
         
         System.out.print("\t\t\t\t\t\t\t");
       for(int i = 0; i < 43; i++) System.out.print("��");
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
               System.out.printf("\t\t\t\t\t\t\t[%s] %s(%d��)  ���:%d   \t\n",
                     ((SetData)Manager.hashMap.get(key)).getRestName(),
                     ((SetData)Manager.hashMap.get(key)).getMenu1(),
                     ((SetData)Manager.hashMap.get(key)).getPrice1(),
                     ((SetData)Manager.hashMap.get(key)).getStock1());
                                       
               }

               if(((SetData)Manager.hashMap.get(key)).getMenu2().contains(userMenu) == true)
               {
               System.out.printf("\t\t\t\t\t\t\t[%s] %s(%d��)  ���:%d   \t\n", 
                     ((SetData)Manager.hashMap.get(key)).getRestName(),
                     ((SetData)Manager.hashMap.get(key)).getMenu2(),
                     ((SetData)Manager.hashMap.get(key)).getPrice2(),
                     ((SetData)Manager.hashMap.get(key)).getStock2());
               }

               if(((SetData)Manager.hashMap.get(key)).getMenu3().contains(userMenu) == true)
               {
               System.out.printf("\t\t\t\t\t\t\t[%s] %s(%d��)   ���:%d   \t\n", 
                     ((SetData)Manager.hashMap.get(key)).getRestName(),
                     ((SetData)Manager.hashMap.get(key)).getMenu2(),
                     ((SetData)Manager.hashMap.get(key)).getPrice2(),
                     ((SetData)Manager.hashMap.get(key)).getStock2());                     
               }           
            }
         }
       //System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.println();


        
         if(count == 0)
         {
            System.out.println("\n\t\t\t\t\t\t\t�� ���� �������� ã���ô� ������ �����ϴ�.");
            System.out.print("\t\t\t\t\t\t\t�ٽ� ã���ðڽ��ϱ�?(Y/N) : ");
            input = sc.next().charAt(0);
            if (input != 'y' && input != 'Y')
            {
                buyTicket();
                break;
            }
         }

         else if(count != 0)
         {
            //System.out.print("\t\t\t\t\t\t\t�ѽı��� �����Ͻðڽ��ϱ�?(Y/N) ");
            //System.out.println("\n\t\t\t\t\t\t\t�������� �����ø� �ʱ�ȭ������ ���ư��ϴ�.");
            //System.out.print("\n\t\t\t\t\t\t\t���ſ��θ� �Է��ϼ��� : ");
         System.out.println("\t\t\t\t\t\t\t�� �������� �����ø� �ʱ�ȭ������ ���ư��ϴ�.");
         System.out.print("\t\t\t\t\t\t\t �ı��� �����Ͻðڽ��ϱ�?(Y/N)");
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
         System.out.print("\t\t\t\t\t\t\t��");
         for(int i = 0; i < 39; i++) System.out.print("��");
         System.out.print("��\n");
   }

   //Ƽ�� �߱� �޼ҵ�
   public static void ticketingCT()throws IOException
   {
      
      
      Set<String> keySet = Manager.hashMap.keySet();
      //Set �� �迭
      //�迭�� ũ�⸦ 0���� �����ϸ� �ڵ����� �迭ũ�� ����
      //String[] keyArr = keySet.toArray(new String[0]);
      //�Ǵ°�

      
      
      String restName;      //�� restName�δ� �ȵ��� ��
      boolean result = false;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      do
      {
         System.out.print("\n\t\t\t\t\t\t\t�Ĵ���� �Է��ϼ��� : ");
         restName = br.readLine();
         //set�� ���Ȯ��
         result = keySet.contains(restName);
      }
      while (result==false); //key���� ��ġ����������?????
     
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t===========================================");
      System.out.printf("\t\t\t\t\t\t\t      �ƢƢ�  [ "+restName+" ] Ƽ�� �߱�  �ƢƢ�\n");   
      System.out.println("\t\t\t\t\t\t\t===========================================");
      System.out.println();
      //System.out.print("\t\t\t��");
      //for(int i = 0; i < 39; i++) System.out.print("��");
      //System.out.print("��\n");
      //System.out.printf("\t\t\t\t\t��%s\n",restName);
      //System.out.print("\t\t\t��");
      //for(int i = 0; i < 39; i++) System.out.print("��");
      //System.out.print("��\n");
      //System.out.printf("\t\t\t  �޴�\t\t\t ����\t   ����\n ");
        System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.println();
      //restName2�� ��ġ�ϴ� key���� value��������?
      //SetData key =(SetData)Manager.hashMap.get(restName2);
      //Object key =(SetData)Manager.hashMap.get(restName2);

       System.out.printf("\t\t\t\t\t\t\t[1] %s(%d��)   ���:%d   \t\n",((SetData)Manager.hashMap.get(restName)).getMenu1()
                     ,((SetData)Manager.hashMap.get(restName)).getPrice1()
                     ,((SetData)Manager.hashMap.get(restName)).getStock1());
     System.out.printf("\t\t\t\t\t\t\t[2] %s(%d��)   ���:%d   \t\n",((SetData)Manager.hashMap.get(restName)).getMenu2()
                     ,((SetData)Manager.hashMap.get(restName)).getPrice2()
                     ,((SetData)Manager.hashMap.get(restName)).getStock2());
     System.out.printf("\t\t\t\t\t\t\t[3] %s(%d��)   ���:%d   \t\n",((SetData)Manager.hashMap.get(restName)).getMenu3()
                     ,((SetData)Manager.hashMap.get(restName)).getPrice3()
                     ,((SetData)Manager.hashMap.get(restName)).getStock3());
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 43; i++) System.out.print("��");
     System.out.println();
      String plus="";
      ArrayList<String> menuList = new ArrayList<String>();
      SetData ob = ((SetData)Manager.hashMap.get(restName));
     
     System.out.println("\t\t\t\t\t\t\t[ �޴� ��õ ] ���� �ڷΰ��� �� 0�� ");
    System.out.println("\t\t\t\t\t\t\t[ �޴� �˻� ] ���� �ڷΰ��� �� 1��");
      do
      {   String menu=" ";
         String su=" ";
         System.out.print("\t\t\t\t\t\t\t������ �޴��Է� : ");
         menu = br.readLine();
       if(menu.equals("0"))
        {
          rcMenu();
        //�͵�
        }
       else if(menu.equals("1"))
        {
          searchAllRest();
         
        }
       else if((ob.getMenu1().equals(menu) || ob.getMenu2().equals(menu) || ob.getMenu3().equals(menu))==false) //�޴��̸��� �ٸ��� �ɸ��°�
       {
          System.out.println("\t\t\t\t\t\t\t�� "+restName+"�� �޴��� �ƴմϴ�.");

       }
         else if(menuList.contains(menu)==true) //�޴��̸��� ������ �ɸ��°�
         {
            System.out.println("\t\t\t\t\t\t\t������ �޴��� �����Ǽ� �����ϴ� ������ �޴� ������ �߰����ּ���");
         }
       System.out.print("\t\t\t\t\t\t\t���� �Է� : ");
       su = br.readLine();

         if(menu.equals(ob.getMenu1()) && Integer.parseInt(su) > ob.getStock1())
         {
            System.out.println("\t\t\t\t\t\t\t�� ����� ���� �����ϽǼ��� �����ϴ�");
         
         }
         else if(menu.equals(ob.getMenu2()) && Integer.parseInt(su) > ob.getStock2())
         {
            System.out.println("\t\t\t\t\t\t\t�� ����� ���� �����ϽǼ��� �����ϴ�");
         
         }
         else if(menu.equals(ob.getMenu3()) && Integer.parseInt(su) > ob.getStock3())
         {
            System.out.println("\t\t\t\t\t\t\t�� ����� ���� �����ϽǼ��� �����ϴ�");   
         }
         else
         {
         menuList.add(menu);
         menuList.add(su);
       menuList.trimToSize();
         }


         if(menuList.size()==6)
          continue;
         System.out.println("\t\t\t\t\t\t\t�޴��� �� �����ðڽ��ϱ�(�ִ� 3��)?");
         System.out.print("\t\t\t\t\t\t\t�޴� ���� Ȯ�� (N) :");
         plus = br.readLine();
         plus = plus.toUpperCase();
         menuList.trimToSize();
      }
      while (menuList.size() != 6 && !plus.equals("N") ); 

      String[][] menus = new String[menuList.size()/2][5];
      int money=0;
      int count=0;
      
      Iterator<String> it = menuList.iterator();
      //restName,�޴�,����,���,����

      while(it.hasNext()) //1���� 1���� 2���� 2���� ���� 3���� 3�� �迭�� �����ؾ� �ٵ� �� ����, �޴�,����,���
      {
         String i = it.next(); //�������� �޴��� ������

         if(i.equals(ob.getMenu1()))
         {
            menus[count][0] = restName;
            menus[count][1] = ob.getMenu1();
            menus[count][2]=  String.valueOf(ob.getPrice1());
            menus[count][3] = it.next(); //���԰���
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
      //���߿� ���ļ� ������  ���ƴ� �̹�

      //�� �ݾװ� ������ �ִ� ����
      int tot=0;

      for(int i=0;i<menus.length;i++)
      {
         for(int j=2;j<=2;j++)
         {
            tot += Integer.parseInt(menus[i][j]) * Integer.parseInt(menus[i][j+1]);         
         }
      }


      // ���� �Է� �޼ҵ�
      // ���� ���� �Է� �ް� money�� ��ȯ���ش�.money�� ��� ���������ϱ⶧����...
      money = Manager.inputMoney(money, tot);

      checkCT(menus,money,tot);
      //tot�� money�� �������� ��Ʈ�� �𸣹Ƿ� ������ �ʿ��ϸ� �ٽ� ����
   }


   public static void checkCT(String[][] menus,int money,int tot)throws IOException ///�Ÿ���,ī�װ��� ��õ ���� �Ѿ���� ����â -> check()�� �̵��ؼ� ��������â
   {
      //Manager.readRestData(); //�����ڰ� Ƽ�� ��� ä��� ���������Ϳ� ����ǹǷ� �ٽ� hashMap�� ������ ����
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t         �ƢƢ�    �Ĵ� Ƽ�� �߱�    �ƢƢ�     ");
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 44; i++) System.out.print("��");
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t �Ĵ�� : "+menus[0][0]);
      System.out.println();
      for(int i=0;i<menus.length;i++)
      {
      System.out.println("\t\t\t\t\t\t\t ���ĸ� : "+menus[i][1]);
      System.out.println("\t\t\t\t\t\t\t ���� : "+Integer.parseInt(menus[i][3]));
      System.out.println();
      }
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t �� �ݾ� : "+tot);
      System.out.println("\t\t\t\t\t\t\t ���� ���� : "+money);
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 44; i++) System.out.print("��");
      System.out.println();
      System.out.println();
      /*menus[count][0] = restName;
            menus[count][1] = ob.getMenu1();
            menus[count][2]=  String.valueOf(ob.getPrice1());
            menus[count][3] = it.next(); //���԰���
            menus[count][4] = String.valueOf(ob.getStock1());
            */
      System.out.println("\t\t\t\t\t\t\t���� �Ϸ�� ����� �� �����ϴ�.");
      
      String check = ""; 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      do
      {
      System.out.print("\t\t\t\t\t\t\t�߱��Ͻðڽ��ϱ�? (Y/N)");
      check = br.readLine();
      check = check.toUpperCase();
      }
      while (!check.equals("Y") && !check.equals("N"));
      
      if(check.equals("Y"))
      {
      System.out.print("\n\t\t\t\t\t\t\t>>>> Ƽ���� �߱����Դϴ�...\n");
     System.out.println();

      Manager.exchangeMoney(money,tot);

      inputResultoExcel(menus,money,tot);
      }
      else if(check.equals("N"))
      {
      System.out.print("\n\t\t\t\t\t\t\t�˻�or��õȭ������ ���ư��ϴ�.");
         buyTicket();
      }   
   
   }


   public static void ticketing(String[][] menus) throws IOException  //ī�װ� ��ŷ��õ���� �Ѿ���� ����â -> check()�� �̵��ؼ� ��������â
   {   
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t          �ƢƢ�    �Ĵ� Ƽ�� �߱�    �ƢƢ�     ");
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("��");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t �Ĵ��     �޴�    ����     ���\n");
      System.out.println("\t\t\t\t\t\t\t "+menus[0][0]+"  "+menus[0][1]+"  "+menus[0][2]+"  "+menus[0][4]+"��");
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("��");
      System.out.println();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num;
      do
      {
      System.out.print("\t\t\t\t\t\t���� �޴��� Ƽ�� ���� "+menus[0][4]+"�Դϴ�. ������ �������ּ��� : ");
      num = Integer.parseInt(br.readLine());       //�Ŀ� �ش� �޴��� ��� �����ؾ��� ����
      }
      while (num>Integer.parseInt(menus[0][4]));
         menus[0][3] = String.valueOf(num);


      int tot = (Integer.parseInt(menus[0][3])*Integer.parseInt(menus[0][2]));
      

      // ���� �Է� �޼ҵ�
      // ���� ���� �Է� �ް� money�� ��ȯ���ش�.money�� ��� ���������ϱ⶧����...
      int money = 0;
      money = Manager.inputMoney(money, tot);


      check(menus,money,tot);
      //�����̰� ���� UI�� ������ �߱�����Ȯ��(check�޼ҵ�)������ �Ĵ�,����,�Է��� �߱ǰ���, ����*�߱ǰ���,���������� �ʿ��ϴ�.
   }
   
   


   public static void check(String[][] menus,int money,int tot)throws IOException
   {
      Manager.readRestData(); //�����ڰ� Ƽ�� ��� ä��� ���������Ϳ� ����ǹǷ� �ٽ� hashMap�� ������ ����
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t          �ƢƢ�    �Ĵ� Ƽ�� �߱�    �ƢƢ�     ");
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("��");
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t �Ĵ�� : "+menus[0][0]);
      System.out.println("\t\t\t\t\t\t\t ���ĸ� : "+menus[0][1]);
      System.out.println("\t\t\t\t\t\t\t ���� : "+menus[0][3]);
      System.out.println("\t\t\t\t\t\t\t �� �ݾ� : "+tot);
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t ���� ���� : "+money);
      System.out.print("\t\t\t\t\t\t\t");
      for(int i = 0; i < 34; i++) System.out.print("��");
      System.out.println();
      System.out.println();
      
      System.out.println("\t\t\t\t\t\t\t�� ���� �Ϸ�� ����� �� �����ϴ�.");
      String check = ""; 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      do
      {
         System.out.print("\t\t\t\t\t\t\t�߱��Ͻðڽ��ϱ�? (Y/N)");
         check = br.readLine();
         check = check.toUpperCase();
      }
      while (!check.equals("Y") && !check.equals("N"));
      
      if(check.equals("Y"))
      {
         System.out.print("\n\t\t\t\t\t\t\t>>>>> Ƽ���� �߱����Դϴ�...");
         inputResultoExcel(menus,money,tot);
      }
      else if(check.equals("N"))
      {
         System.out.print("\n\t\t\t\t\t\t\t�˻�or��õȭ������ ���ư��ϴ�.");
         buyTicket();
      }
      
      //���⼭ �ؽ��� �����ؼ� ��� ���ҽ�ų��?
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

         // �Ǹŷ� �÷�
          int rank = ((SetData)Manager.hashMap.get(menus[i][0])).getCountSell();
           ((SetData)Manager.hashMap.get(menus[i][0])).setCountSell(rank+1);

        }

        else if(((SetData)Manager.hashMap.get(menus[i][0])).getMenu2().equals(menus[i][1]))
        {
          int change = ((SetData)Manager.hashMap.get(menus[i][0])).getStock2()-Integer.parseInt(menus[i][3]);
          ((SetData)Manager.hashMap.get(menus[i][0])).setStock2(change);
         
         // �Ǹŷ� �÷�
          int rank = ((SetData)Manager.hashMap.get(menus[i][0])).getCountSell();
          ((SetData)Manager.hashMap.get(menus[i][0])).setCountSell(rank+1);
          
        }
        
        else if(((SetData)Manager.hashMap.get(menus[i][0])).getMenu3().equals(menus[i][1]))
        {
          int change = ((SetData)Manager.hashMap.get(menus[i][0])).getStock3()-Integer.parseInt(menus[i][3]);
          ((SetData)Manager.hashMap.get(menus[i][0])).setStock3(change);
         
         // �Ǹŷ� �÷�
          int rank = ((SetData)Manager.hashMap.get(menus[i][0])).getCountSell();
          ((SetData)Manager.hashMap.get(menus[i][0])).setCountSell(rank+1);
        }
      }

      Manager.writeRestData();
      startMenu();
      }
   }