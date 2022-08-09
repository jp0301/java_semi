
public class SetData
	{
      
   private String restName;
   private String menu1;
   private String menu2;
   private String menu3;
   private int price1;
   private int price2;
   private int price3;
   private int stock1;
   private int stock2;
   private int stock3;
   private int time;
   private String category;
   private int countSell;
   
    @Override
   public String toString() {
      return "@@menu1=" + menu1 + ", price1=" + price1 + ", stock1=" + stock1 + "\n"
				  + ", menu2=" + menu2 + ", price2=" + price2 + ", stock2=" + stock2 + "\n"
				  + ", menu3=" + menu3 + ", price3=" + price3 + ", stock3=" + stock3 + "\n"
				  + "Time=" + time + ", category=" + category + "@@";
   }
   
   public String getRestName() {
      return restName;
   }
   public void setRestName(String restName) {
      this.restName = restName;
   }

   public String getMenu1() {
      return menu1;
   }
   public void setMenu1(String menu1) {
      this.menu1 = menu1;
   }

   public String getMenu2() {
      return menu2;
   }
   public void setMenu2(String menu2) {
      this.menu2 = menu2;
   }

   public String getMenu3() {
      return menu3;
   }
   public void setMenu3(String menu3) {
      this.menu3 = menu3;
   }

   public int getPrice1() {
      return price1;
   }
   public void setPrice1(int price1) {
      this.price1 = price1;
   }

   public int getPrice2() {
      return price2;
   }
   public void setPrice2(int price2) {
      this.price2 = price2;
   }

   public int getPrice3() {
      return price3;
   }
   public void setPrice3(int price3) {
      this.price3 = price3;
   }

   public int getStock1() {
      return stock1;
   }
   public void setStock1(int stock1) {
      this.stock1 = stock1;
   }

   public int getStock2() {
      return stock2;
   }
   public void setStock2(int stock2) {
      this.stock2 = stock2;
   }

   public int getStock3() {
      return stock3;
   }
   public void setStock3(int stock3) {
      this.stock3 = stock3;
   }

   public int getTime() {
      return time;
   }
   public void setTime(int time) {
      this.time = time;
   }

   public String getCategory() {
      return category;
   }
   public void setCategory(String category) {
      this.category = category;
   }

   public int getCountSell() {
      return countSell;
   }
   public void setCountSell(int countSell) {
      this.countSell = countSell;
   }
   
}