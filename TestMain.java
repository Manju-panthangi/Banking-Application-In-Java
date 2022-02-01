import java.util.Scanner;


public class TestMain {

    public static void main(String[] args){
        Account[] userAccounts = new Account[30];
        int userAccountLimit=30;
        int noOfUsers=0;
        System.out.print("\t\t\t\t Welcome to Banking Sahaj \n");
        System.out.println("\t Options");
        System.out.println("Choose an option by entering the option number");
        System.out.println("1.Create an account");
        System.out.println("2.Money Deposit");
        System.out.println("3.Money Withdrawl");
        System.out.println("4.Money transfer");
        System.out.println("5.Check Balance");
        System.out.println("6.Exit");

        int choice=0;


        while (choice!=6){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = scan.nextInt();

            int acnumber,depositAmmount,index=0,withdrawlAmmount,targetAcNumber,transferAmmount;
            boolean find = false;

            switch (choice){


                case 1:
                    if(noOfUsers<30){
                        System.out.println("Creating an account for you");
                        System.out.print("Enter your name : ");
                        String name=scan.next();
                        userAccounts[noOfUsers] = new Account(name,noOfUsers);
                        noOfUsers++;
                        System.out.println(noOfUsers);
                    }
                    else {
                        System.out.println("No of users limit exceeds cant create an account for you Sorry :(");
                    }
                    break;


                case 2:
                    System.out.println("Deposit");

                    find = false;
                    System.out.println("Enter your account number :");
                    acnumber = scan.nextInt();
                    System.out.println("Enter ammount :");
                    depositAmmount = scan.nextInt();

                    for(index=0;index<noOfUsers;index++){
                        if(userAccounts[index].getAccountNumber() == acnumber){
                            find =true;
                            break;
                        }
                    }

                    if(find){
                        if(userAccounts[index].deposit(depositAmmount)==-1){
                            System.out.println("Can't deposit :(");
                        }
                        else {
                            System.out.println(userAccounts[index].getBalance());
                        }
                    }
                    else {
                        System.out.println("INVALID ACCOUNT NUMBER");
                    }
                    break;


                case 3:
                    System.out.println("Withdrawl");

                    find = false;
                    System.out.println("Enter your account number :");
                    acnumber = scan.nextInt();
                    System.out.println("Enter ammount :");
                    withdrawlAmmount = scan.nextInt();

                    for(index=0;index<noOfUsers;index++){
                        if(userAccounts[index].getAccountNumber() == acnumber){
                            find =true;
                            break;
                        }
                    }

                    if(find){
                        if(userAccounts[index].withDraw(withdrawlAmmount) == -1){
                            System.out.println("Can't withdraw :(");
                        }
                        else{
                            System.out.println(userAccounts[index].getBalance());
                        }
                    }
                    else {
                        System.out.println("INVALID ACCOUNT NUMBER");
                    }
                    break;


                case 4:
                    System.out.println("Transfer");

                    find=false;
                    boolean find2=false;
                    int index2=0;
                    System.out.println("Enter your account number :");
                    acnumber = scan.nextInt();
                    System.out.println("Enter target account number :");
                    targetAcNumber = scan.nextInt();
                    System.out.println("Enter the ammount you want to send : ");
                    transferAmmount = scan.nextInt();

                    for(index=0;index<noOfUsers;index++){
                        if(userAccounts[index].getAccountNumber() == acnumber){
                            find =true;
                            break;
                        }
                    }

                    for(index2=0;index2<noOfUsers;index2++){
                        if(userAccounts[index2].getAccountNumber() == targetAcNumber){
                            find2 =true;
                            break;
                        }
                    }

                    if(find && find2){
                        if(userAccounts[index].transfer(userAccounts[index2],transferAmmount)){
                            System.out.println("Successfully");
                        }
                        else{
                            System.out.println("Failure");
                        }
                    }
                    else {
                        System.out.println("INVALID ACCOUNT NUMBER");
                    }
                    break;


                case 5:
                    find = false;
                    System.out.println("Enter your account number :");
                    acnumber = scan.nextInt();

                    for(index=0;index<noOfUsers;index++){
                        if(userAccounts[index].getAccountNumber() == acnumber){
                            find =true;
                            break;
                        }
                    }

                    if(find){
                        System.out.println(userAccounts[index].getBalance());
                    }
                    else {
                        System.out.println("INVALID ACCOUNT NUMBER");
                    }
                    break;


                case 6:
                    break;
                default:
                    System.out.println("INVALID OPTION");

            }
            if(choice==6){
                System.out.println("\t\t\t THANK YOU");
                break;
            }

            System.out.println();
            System.out.print("\t\t\t\t Welcome to Banking Sahaj \n");
            System.out.println("\t Options");
            System.out.println("Choose an option by entering the option number");
            System.out.println("1.Create an account");
            System.out.println("2.Money Deposit");
            System.out.println("3.Money Withdrawl");
            System.out.println("4.Money transfer");
            System.out.println("5.Check Balance");
            System.out.println("6.Exit");

        }

    }
}
