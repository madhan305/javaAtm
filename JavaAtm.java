import java.util.*;

public class Atm {
   public static void checkBalance(int total){
     System.out.println("Your Balance is "+total);
     
   }
  public static void displayHistory(List<String> transactions){
    Iterator itr=transactions.iterator();
    while(itr.hasNext()){
      System.out.println(itr.next());
    }
  }
  public static void Withdraw(int withdrawalAmount,List<String> transactions,int total){
    if(total<withdrawalAmount){
            System.out.println("Insufficient balance");
          }
      else{
        total-=withdrawalAmount;
        String his=withdrawalAmount+"Withdrawal Successful";
        
        transactions.add(his);
      }
  }
  public static void Deposit(int amount,List<String>transactions,int total){
    if(amount<0){
      System.out.println("Please Enter Valid Amount");
      
    }
    else{
      total+=amount;
      String his=amount+ " Deposited Successfully";
      transactions.add(his);
    }
    
    
  }
  public static void Login(List<String> usernames, HashMap<String,String> passwords,String user,String pass1){
  
          if(usernames.contains(user) && passwords.containsValue(pass1)){
            System.out.println("Welcome");
            
            
          }
          else{
            System.out.println("Invalid username or password");
          }
  }
   public static void create(List<String> usernames, HashMap<String,String> passwords,String newUser,String newPass){
          usernames.add(newUser);
          passwords.put(newUser,newPass);
          System.out.println("Account Created Successfully Please Login with same creditials");
          Login(usernames,passwords,newUser,newPass);
   }
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int total=0;
      List<String> transactions=new ArrayList<>();
      List<String> usernames=new ArrayList<String>();
      HashMap<String,String> passwords=new HashMap<>();
      System.out.println("Welcome To The ATM ");
      while(true){
         System.out.println("Enter Operation number to continue");
         
        System.out.println("1.Create\n2.Login \n3.Deposit\n4.Withdraw\n5.View Trasactions\n6.Check balance\n7.Exit");
        int ch=sc.nextInt();
        switch(ch){
          case 1:
             System.out.println("Enter your new Username");
            String newUser=sc.next();
            System.out.println("Enter Your New Password");
            String newPass =sc.next();
            create(usernames,passwords,newUser,newPass);
            break;
        case 2:
          System.out.println("Enter Your Username");
          String user=sc.next();
          System.out.println("Enter Your password");
          String pass1=sc.next();
          Login(usernames,passwords,user,pass1);
          break;
        case 3:
            
            if(usernames.size()==0){
                System.out.println("Please Login First");
            }
            else{
              System.out.println("Enter Amount To Deposit");
              int depositAmount=sc.nextInt();
              Deposit(depositAmount,transactions,total);
              total+=depositAmount;
            }
          break;
        case 4:
          System.out.println("Enter Withdrawal Amount");
          int withdrawalAmount=sc.nextInt();
            Withdraw(withdrawalAmount,transactions,total);
            total-=withdrawalAmount;
          break;
        case 5:
          displayHistory(transactions);
          break;
        case 6:
          checkBalance(total);
          break;
        default:
          System.exit(0);
          
          
}
              
      }
  }
}