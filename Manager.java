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
   //�������α׷� ����� ���ÿ� HashMap ������ �ε带 ���� ���������� ����
   public static HashMap<String, Object> hashMap = new HashMap<String, Object>();
   static Scanner sc = new Scanner(System.in);
   public static HashMap<Integer, Integer> coinMap = new HashMap<Integer, Integer>();

   static int systemMoney = 0;

   // ������ �������̽�(main����)
   public static void userInterface() 
   {
      System.out.println();
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println("\t\t\t\t\t\t\t �ƢƢ�    SIST TODAY LUNCH [������ ���]   �ƢƢ� ");   
      System.out.println("\t\t\t\t\t\t\t==============================================");
      System.out.println();

      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");
      System.out.println("\t\t\t\t\t\t\t��            1. ������    �߰�              ��");
      System.out.println("\t\t\t\t\t\t\t��            2. ������    ����              ��");
      System.out.println("\t\t\t\t\t\t\t��            3. ������    ����              ��");
      System.out.println("\t\t\t\t\t\t\t��            4. ������    ��ȸ              ��");

      System.out.println("\t\t\t\t\t\t\t��            5. �ı�    ä���              ��");
      System.out.println("\t\t\t\t\t\t\t��            6. �ܰ�    ä���              ��");
      System.out.println("\t\t\t\t\t\t\t��            7. ���� ���� Ȯ��              ��");
      
      System.out.println("\t\t\t\t\t\t\t��            8. ���α׷�  ����              ��");

      System.out.print("\t\t\t\t\t\t\t��");
      for(int i = 0; i < 43; i++) System.out.print("��");
      System.out.print("��\n");

      //////////////////////////////////////////////////////
      System.out.println("\t\t\t\t\t\t\t�� ������ �˸�");
      noMoney();
      System.out.println();
       //////////////////////////////////////////////////////

      
      Scanner sc = new Scanner(System.in);
      System.out.print("\t\t\t\t\t\t\t��ȣ ���� : ");
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
        System.out.println("\t\t\t\t\t\t\t        �ƢƢ�    �������� Ȯ��   �ƢƢ� ");   
        System.out.println("\t\t\t\t\t\t\t==============================================");
        System.out.println();

       for (String key : Manager.hashMap.keySet())
         {
            if(((SetData)Manager.hashMap.get(key)).getCountSell() != 0)
          {
             count++;
             System.out.printf("\n\t%-7s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t %s\t\r\n",
              "��ȣ��","�޴�1","����1","���","�޴�2","����2","���","�޴�3","����3","���","�����Ǹ�");
             System.out.print("\t");
              for(int i=0; i < 145; i++) 
                System.out.print("=");

              System.out.print("\n");

              SetData objValue = (SetData) hashMap.get(key);

              System.out.printf("\t%-7s\t %-7s\t %-5s��\t%s��\t %-7s\t%-5s��\t\t%s��\t%-7s\t%-5s��\t%10s��\t%6s��\t\r\n",
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
        System.out.print("\n\t���Ǳ� �� �ܾ� : ");

        money = ((coinMap.get(10000)*10000) + (coinMap.get(5000)*5000) + (coinMap.get(1000)*1000) + (coinMap.get(500)*500) + (coinMap.get(100)*100));

        System.out.println("\t" + money + "��\n");

      if (count == 0)
      {
         System.out.println("\t\t\t\t\t\t\t�� �ƹ��͵� �Ǹŵ��� �ʾҽ��ϴ�. ��");
      }
      userInterface();
 }

   //�߰� �޼ҵ�(������ ������ �߰�)
   //1. hashMap ����(������ �Է�)
   //2. writeCsv(hashMap) (CSV ����)
   public static void addRestData()
   {   
      char input = 'Y';

      while(!(input != 'y' && input != 'Y'))
      {
         try
         {
            System.out.print("\n\t\t\t\t\t\t\t��ȣ���� �Է��ϼ��� : ");
            String restName = sc.next();

            if(hashMap.get(restName) == null)
            {
               System.out.print("\t\t\t\t\t\t\t�޴�1��  �Է��ϼ��� : ");
               String restMenu1 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t����1��  �Է��ϼ��� : ");
               String restPrice1 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t�޴�2��  �Է��ϼ��� : ");
               String restMenu2 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t����2��  �Է��ϼ��� : ");
               String restPrice2 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t�޴�3��  �Է��ϼ��� : ");
               String restMenu3 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t����3��  �Է��ϼ��� : ");
               String restPrice3 = sc.next();
               
               System.out.print("\t\t\t\t\t\t\t�ҿ� �ð��� �Է��ϼ��� : ");
               String restTime = sc.next();

               System.out.print("\t\t\t\t\t\t\t�з���   �Է��ϼ��� : ");
               String restCategory = sc.next();

               String[] dataArr = {restName, restMenu1, restPrice1, restMenu2, restPrice2, restMenu3, restPrice3, restTime, restCategory};

               SetData addSetData = new SetData();

            // countSell, Stock�� �߰����� �ڵ� 0 �ʱ�ȭ+
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

               System.out.println("\n\t\t\t\t\t\t\t>>>>> �߰� �Ϸ�");
               System.out.println("\n\t\t\t\t\t\t\t[ " + restName + "�� �߰� ������ ]");
               printKeyRestData(restName);

               System.out.print("\t\t\t\t\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
               input = sc.next().charAt(0);
               
            }
            else if(hashMap.get(restName) != null)
            {
               System.out.println("\n\t\t\t\t\t\t\t�� �ش� �������� �̹� ��ϵǾ� �ֽ��ϴ�. ��");
               System.out.println("\n\t\t\t\t\t\t\t[ " + restName + "�� ���� ]");
               printKeyRestData(restName);

               System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
               input = sc.next().charAt(0);
            }
         }
          catch (NumberFormatException e )
         {
            System.out.println("\n\t\t\t\t\t\t\t�� �˸��� ������ Ÿ���� �Է��ϼ���. ");
            System.out.println("\t\t\t\t\t\t\t�� ���ݰ� �ҿ�ð��� ���ڸ� �Է� �����մϴ�. ");
            System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
            input = sc.next().charAt(0);
         }
      }
      writeRestData();
      userInterface();
   } 

   //���� �޼ҵ�(������ ������ ����)
   //1. hashMap ����(������ ����)
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
                  System.out.print("\n\t\t\t\t\t\t\t������ �Ĵ���� �Է��ϼ��� : ");
                  key = sc.next();

                  if(hashMap.get(key) == null)
                  {
                     System.out.println("\n\t\t\t\t\t\t\t�� �ش� �Ĵ��� �����ϴ�.");
                     System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N) : ");
                     input = sc.next().charAt(0);
                  }
                  else
                  {

                     System.out.print("\n\t\t\t\t\t\t\t[�Ĵ�� / �޴�1 / ����1 / �޴�2 / ����2 / �޴�3 / ����3 / �ҿ�ð� / �з�]\n");
                     printKeyRestData(key);
                     System.out.print("\t\t\t\t\t\t\t������ �����Ͻðڽ��ϱ�? : ");
                     sowhat = sc.next();

                     break;
                  }
               }
                  
               
               if(sowhat.equals("�Ĵ��"))
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
                  System.out.print("\n\t\t\t\t\t\t\t������ ��ȣ���� �Է��ϼ��� : ");
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

                  System.out.println("\n\t\t\t\t\t\t\t>>>>> ������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[" + beforekey + "->" + key +" ���� �Ϸ� �� ��ȸ ����]");

                  printKeyRestData(key);

                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);

                  //hashMap.remove(key);
                  //((SetData) hashMap.get(key)).setRestName(updateStr);
               }

               else if(sowhat.equals("�޴�1"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ �޴�1�� �Է����ּ��� : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setMenu1(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);

               }

               else if(sowhat.equals("����1"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ ����1�� �Է����ּ��� : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setPrice1(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("�޴�2"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ �޴�2�� �Է����ּ��� : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setMenu2(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("����2"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ ����2�� �Է����ּ��� : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setPrice2(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("�޴�3"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ �޴�3�� �Է����ּ��� : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setMenu3(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("����3"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ ����3�� �Է����ּ��� : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setPrice3(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("�ҿ�ð�"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ �ҿ�ð��� �Է����ּ��� : ");
                  updateInt = sc.nextInt();
                  ((SetData) hashMap.get(key)).setTime(updateInt);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals("�з�"))
               {
                  System.out.print("\t\t\t\t\t\t\t������ �з��� �Է����ּ��� : ");
                  updateStr = sc.next();
                  ((SetData) hashMap.get(key)).setCategory(updateStr);
                  System.out.println("\n\t\t\t\t\t\t\t������ �Ϸ� �Ǿ����ϴ�.");
                  System.out.println("\n\t\t\t\t\t\t\t[���� �Ϸ� �� ��ȸ ����]");
                  printKeyRestData(key);
                  System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N) : ");
                  input = sc.next().charAt(0);
               }
               else if(sowhat.equals(false))
               {
                  System.out.println("\t\t\t\t\t\t\t�� �ش� ������ �������� ���մϴ�.");
               }
            }

            catch (NumberFormatException e )
            {
               System.out.println("\n\t\t\t�˸��� ������ Ÿ���� �Է��ϼ���.");
               System.out.println("\t\t\t\t\t\t\t���ݰ� �ҿ�ð��� ���ڸ� �Է� �����մϴ�.");
               System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
               input = sc.next().charAt(0);
            }
         }

      writeRestData();
      userInterface();
   }
   //���� �޼ҵ�(������ ������ ����)
   //1. hashMap ����(������ ����)
   //2. writeRestData()  
   public static void deleteRestData() 
   {
       String key;
      char input = 'Y';

      while(!(input != 'y' && input != 'Y'))
      {
         System.out.print("\t\t\t\t\t\t\t������ ��ȣ���� �Է��ϼ��� : ");
         key = sc.next();

         if (hashMap.get(key) != null)
         {
            hashMap.remove(key);

            System.out.println("\n\t\t\t\t\t\t\t>>>>> ���� �Ϸ�");
            System.out.print("\n\t\t\t\t\t\t\t��� �����Ͻðڽ��ϱ�?(Y/N)");
            input = sc.next().charAt(0);

         }
         else if (hashMap.get(key) == null)
         {
            System.out.println("\n\t\t\t\t\t\t\t��ȣ���� �������� �ʽ��ϴ�. ");
            System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
            input = sc.next().charAt(0);
         } 
         
      }
      writeRestData();
      userInterface();
      
   } 

   // ��ȸ �޼ҵ�
   // ��� �������� �����͸� ���
   public static void printAllRestData()
   {
      System.out.printf("\n\t%-7s\t %-7s\t %-5s\t %-7s\t %-5s\t %-7s\t %s\t %-4s\t %-4s\t %-4s\t\r\n ",
      "��ȣ��","�޴�1","����1","�޴�2","����2","�޴�3","����3","�ҿ�ð�","�з�", "�����Ǹ�");
      System.out.print("\t");
      for(int i=0; i < 145; i++) System.out.print("=");
      System.out.print("\n");
      for(String strKey : hashMap.keySet())
      {
         SetData objValue = (SetData) hashMap.get(strKey);

         System.out.printf("\t%-7s\t %-7s\t %-5s��\t %-7s\t %-5s��\t %-7s\t %s\t %-7s��\t %-4s\t %-4sȸ\t\r\n",
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
   
   // �ı� ä��� �޼ҵ�(�ı��� ��� �߰�)
   //1. hashMap ����(������ ����)
   //2. writeRestData() ȣ��
   public static void fillStock()
   {
      int stock, sum;
      char input = 'Y';

      while(!(input != 'y' && input != 'Y'))
      {
         System.out.print("\n\t\t\t\t\t\t\t��ȣ���� �Է��ϼ��� : ");
         String key = sc.next();

         if (hashMap.get(key) != null)
         {
            System.out.println("\n\t\t\t\t\t\t\t[ " + key + "�� ���� ��� ]");
            printKeyRestData(key);

            System.out.print("\n\t\t\t\t\t\t\t��� �߰��� �޴��� �Է��ϼ��� : ");
            String inputMenu = sc.next();

            if ( inputMenu.equals(((SetData)hashMap.get(key)).getMenu1()) )
            {
               System.out.print("\t\t\t\t\t\t\t�߰��� ������ �Է��ϼ��� : ");
               stock = sc.nextInt();

               sum = ((SetData)hashMap.get(key)).getStock1();
               //System.out.println(sum);

               ((SetData)hashMap.get(key)).setStock1(stock + sum);
               System.out.println("\n\t\t\t\t\t\t\t>>>>> ��� �߰� �Ϸ�");
               System.out.println();
               System.out.println("\n\t\t\t\t\t\t\t[ " + key + "�� �߰� �� ��� ]");
               printKeyRestData(key);
               System.out.print("\n\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
               input = sc.next().charAt(0);

            }
            else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu2()))
            {
               System.out.print("\t\t\t\t\t\t\t�߰��� ������ �Է��ϼ��� : ");
               stock = sc.nextInt();

               sum = ((SetData)hashMap.get(key)).getStock2();
               //System.out.println(sum);

               ((SetData)hashMap.get(key)).setStock2(stock + sum);
               System.out.println("\n\t\t\t\t\t\t\t>>>>> ��� �߰� �Ϸ�");
               System.out.println();
               System.out.println("\n\t\t\t\t\t\t\t[ " + key + "�� �߰� �� ��� ]");
               printKeyRestData(key);
               System.out.print("\n\t\t\t\t\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
               input = sc.next().charAt(0);

            }

            else if (inputMenu.equals(((SetData)hashMap.get(key)).getMenu3()))
            {
               System.out.print("\t\t\t\t\t\t\t�߰��� ������ �Է��ϼ��� : ");
               stock = sc.nextInt();

               sum = ((SetData)hashMap.get(key)).getStock3();
               //System.out.println(sum);

               ((SetData)hashMap.get(key)).setStock3(stock + sum);
               System.out.println("\t\t\t\t\t\t\t>>>>> ��� �߰� �Ϸ�");
               System.out.println();
               System.out.println("\n\t\t\t\t\t\t\t[ " + key + "�� �߰� �� ��� ]");
               printKeyRestData(key);
               System.out.print("\n\t\t\t\t\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N)");
               input = sc.next().charAt(0);
            }
            else
            {
               System.out.println("\n\t\t\t\t\t\t\t�� �ش� �޴��� �������� �ʽ��ϴ�.");
               System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
               input = sc.next().charAt(0);   
            }
         }
         else if(hashMap.get(key) == null)
         {
            System.out.println("\n\t\t\t\t\t\t\t�� ��ȣ���� �������� �ʽ��ϴ�.");
            System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
            input = sc.next().charAt(0);
         }
      }
      writeRestData();
      userInterface();
   }

   
   public static void noMoney()
   {
      int[] coinUnit = {10000, 5000, 1000, 500, 100};

      System.out.print("\t\t\t\t\t\t\t��");

      for(int i = 0; i < 43; i++) 
      {
        System.out.print("��");
      }
      System.out.print("��\n");

      for(int i = 0; i < coinUnit.length; i++)
      {
          if(coinMap.get(coinUnit[i]) == 0)
          {
            System.out.printf("\t\t\t\t\t\t\t��    ! �ܰ� [%5d��]�� ������ �����մϴ�.  ��\n", coinUnit[i]);
          }
      }

      System.out.print("\t\t\t\t\t\t\t��");

      for(int i = 0; i < 43; i++) 
      {
        System.out.print("��");
      }
      System.out.print("��\n");
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
            //System.out.println("\t\t\t" + coinUnit[i] + "�� - " + coinMap.get(coinUnit[i]) + "��");
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
         ���� coinMap�� �ǵ�� writeCoinData ȣ���ؼ����� �ٲ� �� ��������...?
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
   // Machine�� �����Է� �޼ҵ�
   public static int inputMoney(int money, int tot)
   {
      readCoinData();
      try
      {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int man, ocheon, cheon, obaek, baek;
         man = ocheon = cheon = obaek = baek = 0;
          
         System.out.printf("\n\t\t\t\t\t\t\t�� �� %7d���Դϴ�.\n",tot);
         System.out.println("\t\t\t\t\t\t\t�� [10,000��5,000��1,000��500��100]���� ������ �Է��մϴ�.");

         while(true)
         {
            System.out.printf("\n\t\t\t\t\t\t\t%7s","10,000�� : ");
            man = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","5,000�� : ");
            ocheon = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","1,000�� : ");
            cheon = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","500�� : ");
            obaek = Integer.parseInt(br.readLine());
            System.out.printf("\t\t\t\t\t\t\t%7s","100�� : ");
            baek = Integer.parseInt(br.readLine());

            money = (10000 * man) + (5000 * ocheon) + (1000 * cheon) + (500 * obaek) + (100 * baek);
            
            //���� ���ε����Ϳ����� �ܰ� ���ձݾ�
            int checkCoin = 0;
            int[] coinUnit = {10000,5000,1000,500,100};
            for(int i=0; i< 5; i++)
               checkCoin += coinMap.get(coinUnit[i]) * coinUnit[i];
   
            if(money < tot)
               System.out.println("\t\t\t\t\t\t\t�� ���� �ݾ��� ���� ���ݺ��� �����մϴ�.");
            else if(money >= checkCoin)
               System.out.println("\t\t\t\t\t\t\t�� ���� �ݾ��� �ܰ� �ʰ�! ������ ȣ�� �ʿ�");
            else
               break;
         }
         // ���� ���� ������ŭ Manager.class�� sendMoney�� �����ش�.
         sendMoney(man, ocheon, cheon, obaek, baek);   

      }
      catch (NumberFormatException nfe)
      {
         System.out.println("\t\t\t\t\t\t\t�� �ܰ��ʰ�! �ݾ��� �ٽ� �Է����ּ���.");
         inputMoney(money, tot);
      }
      catch (Exception e)
      {
       e.printStackTrace();
      }

      return money;
   }


   // Machine���� ���� �� ������ŭ �޾ƿͼ� �����Ѵ�.
   public static void sendMoney(int man, int ocheon, int cheon, int obaek, int baek)
   {   
      coinMap.put(10000, coinMap.get(10000) + man);
      coinMap.put(5000, coinMap.get(5000) + ocheon);
      coinMap.put(1000, coinMap.get(1000) + cheon);
      coinMap.put(500, coinMap.get(500) + obaek);
      coinMap.put(100, coinMap.get(100) + baek);
   }

   // ���� �ݾװ� Ƽ�� �� �Ǹ� �ݾ��� �����ͼ�
   // �Ž������� ����ϰ� �Ž������� �������� ������ coinMap���� ������ŭ ���ش�.
   
   public static void exchangeMoney(int money, int tot)
   {
        writeCoinData();

      /*
      try
      {
         System.out.println("\n\t\t\t����ڰ� ���� �ݾ� : " + money); // ����ڰ� ���� �ݾ�
         System.out.println("\t\t\tƼ�� �� �Ǹ� �ݾ� : " + tot); // Ƽ�� �� �Ǹ� �ݾ�

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
      // ȭ�� ����
      int[] coinUnit = {10000, 5000, 1000, 500, 100}; // ȭ�� ����
      // ���� �ܰ� ��
      int[] coinNow = {coinMap.get(10000),coinMap.get(5000),coinMap.get(1000),coinMap.get(500),coinMap.get(100)}; // ���� �ܰ� ��
      // �Ž����� ���� �ܰ� �迭
      int[] giveMoney = {0,0,0,0,0};
      money = money;
      int won = 10000;
      int sw = 1; // ���� ���� ����
      int exchange = money - tot; // ���� �Ž�����
      // ���� �ܰ��� �� �ݾ�
      int totalNow = 0;

      for(int i=0; i< coinUnit.length; i++)
         totalNow += (coinMap.get(coinUnit[i]) * coinUnit[i]);

      int lack = 0; //(���� �ܰ� ������) ȭ�� ���ڸ��� �Ÿ��� ����

      int x = 0;
      int count = 1;
      int temple = exchange;

      // ���� �ܰ� �� �ݾ� < �Ž�����
      if(totalNow < exchange)
      {
         System.out.println("\t\t\t\t\t\t\t�� �Ž������� �����մϴ�.");
         System.out.println("\t\t\t\t\t\t\t�� ��� �߰�/�������ּ���.");
         
         System.out.println();
         System.out.println("\t\t\t\t\t\t\t �ʿ� �� �����ڿ��� ��ȭ�ּ���...");
         System.out.println("\t\t\t\t\t\t\t ������ : 4��");
         System.out.println("\t\t\t\t\t\t\t �� 010-1544-8282");
         userInterface();
      }

      // ���� �ܰ� �� �ݾ� > �Ž�����
      else
      {
         // �Ž����� ������ ���� ���
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
      // �� �ݾ� > �Ž�����(�׷��� ��������)
      if (temple != lack)
      {
         System.out.println("\t\t\t\t\t\t\t�� �Ž������� �����մϴ�.");
         System.out.println("\t\t\t\t\t\t\t�� ��� �߰�/�������ּ���.");
         
         System.out.println();
         System.out.println("\t\t\t\t\t\t\t �ʿ� �� �����ڿ��� ��ȭ�ּ���...");
         System.out.println("\t\t\t\t\t\t\t ������ : 4��");
         System.out.println("\t\t\t\t\t\t\t �� 010-1544-8282");
         userInterface();
      }

      for (int i =0; i<5; i++)
      {
         System.out.printf("\t\t\t\t\t\t\t%5d�� : %2d��\n", coinUnit[i],giveMoney[i]);
         coinMap.put(coinUnit[i], coinMap.get(coinUnit[i]) - giveMoney[i]);
      }

      System.out.println("\n\t\t\t\t\t\t\t�� �Ž����� : " + temple + "���� ��ȯ�Ǿ����ϴ�.");
      writeCoinData();
   }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////




   // 6. �ܰ�, ����, ���� ä��� �޼ҵ�
   public static void fillBalance()
   {   
   
      systemMoney = 0; // �ý����� ������ �ִ� �ܰ�
      for(Integer key : coinMap.keySet()) // ���� �ܰ� ���
         systemMoney += key * coinMap.get(key);
      sc = new Scanner(System.in);
      char input = 'Y';
      int coinSum = 0;
      while(!(input != 'y' && input != 'Y'))
      {
         try
         {
           System.out.print("\t\t\t\t\t\t\t��");
           for(int i = 0; i < 43; i++) System.out.print("��");
           System.out.print("��\n");

           //System.out.println("\t\t\t\t\t\t\t��         [ ���� �ܰ�  " + systemMoney + " ��]            ��");
           System.out.printf("\t\t\t\t\t\t\t��          [ ���� �ܰ�  %-8d��]         ��\n", systemMoney);
              


           System.out.print("\t\t\t\t\t\t\t��");
           for(int i = 0; i < 43; i++) System.out.print("��");
           System.out.print("��\n");
           System.out.println();

           for(Integer key : coinMap.keySet())
            { //System.out.println("\t\t\t\t\t\t\t"+ key + "�� - " + coinMap.get(key));
              System.out.printf("\t\t\t\t\t\t\t%5d��\t- %d\n", key, coinMap.get(key));
            }

           


            System.out.print("\n\t\t\t\t\t\t\t�߰��� ���� �Ǵ� ������ �Է��ϼ��� : ");
            int coinKey = sc.nextInt();

            if(coinMap.containsKey(coinKey))
            {

               System.out.print("\n\t\t\t\t\t\t\t���� �Ǵ� ������ ������ �Է��ϼ��� : ");
            

           

               int coinEa = sc.nextInt();
               coinSum = coinMap.get(coinKey) + coinEa;
               coinMap.put(coinKey, coinSum);

            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 43; i++) System.out.print("��");
            System.out.print("��\n");

               System.out.println("\t\t\t\t\t\t\t��              [  ä���� �ܰ�  ]            ��");

            System.out.print("\t\t\t\t\t\t\t��");
            for(int i = 0; i < 43; i++) System.out.print("��");
            System.out.print("��\n");
            System.out.println();


               for(Integer key : coinMap.keySet())
                  System.out.println("\t\t\t\t\t\t\t"+ key + "�� - " + coinMap.get(key));

               System.out.println();
               System.out.println("\t\t\t\t\t\t\t>>>>> ���� �߰� �Ϸ�");

               System.out.print("\n\t\t\t\t\t\t\t��� �߰��Ͻðڽ��ϱ�?(Y/N) : ");
               input = sc.next().charAt(0);
               System.out.println();
            }
            else if(!(coinMap.containsKey(coinKey)))
            {
               System.out.println("\t\t\t\t\t\t\t�� �԰ݿ� �´� ���� �Ǵ� ������ ���� �� �ֽ��ϴ�.");
               System.out.print("\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N) : ");
               input = sc.next().charAt(0);
            }
         
            systemMoney = 0;
            for(Integer key : coinMap.keySet()) // ���� �ܰ� ���
               systemMoney += key * coinMap.get(key);

              System.out.print("\t\t\t\t\t\t\t��");
           for(int i = 0; i < 43; i++) System.out.print("��");
           System.out.print("��\n");

           //System.out.println("\t\t\t\t\t\t\t��          [ ���� �ܰ�  " + systemMoney + "��]          ��");
           System.out.printf("\t\t\t\t\t\t\t��          [ ���� �ܰ�  %-8d��]         ��\n", systemMoney);
              

           System.out.print("\t\t\t\t\t\t\t��");
           for(int i = 0; i < 43; i++) System.out.print("��");
           System.out.print("��\n");
           System.out.println();

            System.out.println();
         }
          catch (NumberFormatException e )
         {
            System.out.println("\t\t\t\t\t\t\t�� �԰� ���Դϴ�..");
            System.out.println("\t\t\t\t\t\t\t�Է� �����մϴ�.");
            System.out.print("\n\t\t\t\t\t\t\t�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)");
            input = sc.next().charAt(0);
         }
      }
     writeCoinData();
     writeRestData(); 
     userInterface();
   }

   // writeeRestData() ����
   // ����� HashMap�� .csv���Ͽ� ����
   public static void writeRestData() 
   {
       File csv = new File("C:\\JavaStudy\\Java_semi\\Restinfo.csv");
       BufferedWriter bw = null; // ��� ��Ʈ�� ����
       try 
       {
           bw = new BufferedWriter(new FileWriter(csv));
           
           for(String strKey : hashMap.keySet())
         {
           SetData objValue = (SetData) hashMap.get(strKey);
           /*
           //�׽�Ʈ ���
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
           
                
              //�� �ٿ� ���� �� ������ ���̿� ,�� �ִ´�
           String aData = objValue.getRestName() + "," + objValue.getMenu1() + "," + objValue.getPrice1() + "," + objValue.getStock1() + ","
                      + objValue.getMenu2() + "," + objValue.getPrice2() + "," + objValue.getStock2() + ","
                      + objValue.getMenu3() + "," + objValue.getPrice3() + "," + objValue.getStock3() + ","
                      + objValue.getTime() + "," + objValue.getCategory() + "," + objValue.getCountSell();

              //�ۼ��� �����͸� ���Ͽ� �ִ´�
              bw.write(aData);
               
              //����
              bw.newLine(); 
           }
         if (bw != null) 
               {
                   bw.flush(); // �����ִ� �����ͱ��� ���� �ش�
                   bw.close(); // ����� BufferedWriter�� �ݾ� �ش�
               }
       }
      catch (Exception e) 
       {
           e.printStackTrace();
       } 
   }// endWriteRestData

  
   
   
   public static void readRestData() 
   {
      String file = "C:\\JavaStudy\\Java_semi\\Restinfo.csv"; //Restinfo.csv������ ���� ���
      String line = " "; // while������ �о�� ������ �迭 �ʱ�ȭ
      
      try (BufferedReader br = new BufferedReader(new FileReader(file))) //br�� FileReader�� ���ҷ� ����� ����
      { 
        //int rowCnt = 1; // ù° �ٺ��� �о�� ����
        
        while((line = br.readLine()) != null) // readLine()�޼ҵ�� ���Ͽ��� ���̻� ������ ���� ���� ������ �о����
                                   // .csv ������ ���ͷ� �� ���� �����ϴµ� ���ʹ� null�� X
        {
           String rowStr = ""; // line���� �о�� �����͸� ������ ���� �ʱ�ȭ
           
           //System.out.println(line);                        
          
           rowStr = line; //rowStr String�� line�� ����
           String[] items = rowStr.split(","); //items��� �迭�� ","�� �������� ���е� rowStr�� "," ������ �߶� ����
           String key = items[0]; // �迭�� ���� ���� ���� ���� csv������ ��ȣ���̹Ƿ� ��ȣ���� Key������ ����
           
           //System.out.println("----------------------------------------------------------------------------------------------------------------------");
           //System.out.println("Key : " + key); // Key���� ����� ������ �׽�Ʈ ���
           
           SetData newSetData = new SetData(); //getter, setter�� �ִ� SetData Ŭ���� �ν��Ͻ� ����
         

         // test��� ��ü�� ������ SetData�� getter,setter�� �� �׸��� �ʱ�ȭ
         /*
         �о�� �����Ϳ� ���� 
         items[0] = ��ȣ��(Key���� �� �Ӽ�)    
         items[1] = 1�� �޴�, items[2] = 1�� �޴��� ����
         items[3] = 2�� �޴�, items[4] = 2�� �޴��� ����
         items[5] = 3�� �޴�, items[6] = 3�� �޴��� ����
         items[7] = �ҿ�ð�, items[8] = ī�װ�
         
         �� �����Ͱ� ��� -> �� getter, setter���� �����ϰ� �Ѱ���
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
         //hashtemp�� �����ؼ� 
         // getter,setter�� SetData Ŭ������ �� �Ӽ����� �ʱ�ȭ �ߴٸ�
                                 // ��ȣ���� ���� Key���� �����Ͱ� ��� SetDataŬ������ value�� ��ü�� ����
                                 // �� HashMap.put(Key(��ȣ��),value(1�� �޴�, 1�� �޴��� ����,2�� �޴�, 2�� �޴��� ����,3�� �޴�, 3�� �޴��� ����, �ҿ�ð�, ī�װ� )
            
            //System.out.println(test.toString() + "\n"); // toString �޼ҵ带 ������ �� ������ ���
            //System.out.println("rowCnt" + rowCnt);
            
          }

         //rowCnt++; // ������ �Ӽ����� ���� ��Ҵٸ� rowCnt++ �Ͽ� ���� ������ �о�� �� �ֵ��� ��
            
            
     } 
      catch (Exception e) //����ó��
      { 
         System.out.println(e); 
      }

   } // end readRestData() 
   
   // ������ Ű ���� �������� ����� ���� �޼ҵ�
   // (fillStock() �ܰ� ä��� �޼ҵ忡�� ȣ��)
   public static void printKeyRestData(String restName) 
   {
      // hashMap.get()�޼ҵ带 ���� key������ ���޹��� �Ķ���� ����.�� ��ü�� �Ӽ��� ���
      // �Ӽ����� ��� private ���̸� SetData Ŭ������ �ܺ� Ŭ�����̱⶧���� 
      // SetData������ ĳ���� �ؼ� �� �Ӽ��鿡 ������ �� �ֵ��� ��
     
      //test
      //System.out.println("Type Ȯ��");
      String key = (((SetData) hashMap.get(restName)).getRestName());
      //System.out.println(key);
      //System.out.println("--------------------");

     System.out.printf("\n\t%-7s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t %-10s\t %-5s\t %s\t\t\r\n",
      "��ȣ��","�޴�1","����1","���","�޴�2","����2","���","�޴�3","����3","���");

     System.out.print("\t");
      for(int i=0; i < 135; i++) 
         System.out.print("=");

      System.out.print("\n");

      SetData objValue = (SetData) hashMap.get(restName);

     //System.out.printf("\t%-7s\t %-7s\t %-5s��\t %-7s\t %-5s��\t %-7s\t %s\t %-7s��\t %-4s\t %-4sȸ\t\r\n",
     //System.out.printf("\t%-7s\t %-7s\t %-5s��\t%s��\t %-7s\t%-5s��\t\t%s��\t%-7s\t%-5s��\t%10s��\t%6s��\t\r\n"

      System.out.printf("\t%-7s\t %-7s\t %-5s��\t%s��\t %-7s\t%-5s��\t\t%s��\t%-7s\t%-5s��\t%10s��\t \t\r\n",
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
     System.out.println("\n\t\t\t �޴� �̸� | �޴� ���� | ��� ");
     System.out.println("\t\t\t------------------------------");
      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu1() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice1() + "�� | ");
     System.out.print(((SetData) hashMap.get(key)).getStock1() + " �� |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu2() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice2() + " �� | ");
     System.out.print(((SetData) hashMap.get(key)).getStock2() + " �� |\n");

      System.out.print("\t\t\t" + ((SetData) hashMap.get(key)).getMenu3() + " | ");
      System.out.print(((SetData) hashMap.get(key)).getPrice3() + " �� |");
     System.out.print(((SetData) hashMap.get(key)).getStock3() + " �� |\n");
      //System.out.print(((SetData) hashMap.get(key)).getTime() + "|");
      //System.out.println(((SetData) hashMap.get(key)).getCategory() + "|");
     */

   }// end printKeyRestData()

   public static void endMachine()
   {
      System.out.println("\n\t\t\t\t\t\t\t�� �ı� �߱� �ý����� �����մϴ�...\n");
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