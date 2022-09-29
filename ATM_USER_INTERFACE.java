import java.util.Scanner;

public class ATM_USER_INTERFACE {
    static Scanner in = new Scanner(System.in);

    static String user_Id;
    static String private_code;
    static int Account_num;
    static int pin;
    static double current_balance = 250000f;
    static int transfer = 0;
    static String transfer_History = "";

   // FUNCTION TO CREATE NEW MEMBER

    public static void NEW_MEMBER(){

        System.out.println("\nEnter your User_ID  :");
        user_Id = in.next();
        System.out.println("ENTER YOUR PRIVATE CODE :");
        private_code = in.next();
        System.out.println("ENTER YOUR ACCOUNT NUMBER  :");
        Account_num = in.nextInt();
        System.out.println("ENTER YOUR ATM SECREAT PIN  :");
        pin=in.nextInt();
        System.out.println("\n YOU ARE NOW SUCCESFULLY REGISTERD");
        System.out.println("**************************************************************************");
        System.out.println("YOU CAN NOW LOGIN !!");

    }
// THIS FUNCTION IS USED FOR SIGN IN
    public static boolean SIGNIN(){
        boolean is_Login = false;
        while(!is_Login)
        {
            System.out.println("\n ENTER YOUR ACCOUNT NUMBER :");
            int Accnum = in.nextInt();
            if(Accnum == Account_num)
            {
                System.out.println("ENTER YOUR ATM SECREAT PIN ");
                int pinenter = in.nextInt();
                while(!is_Login)
                {
                    if(pinenter == pin)
                    {
                        System.out.println("\n LOGIN SUCCESSFUL");
                        is_Login = true;
                    }
                    else
                    {
                        System.out.println("\nENTER CORRECT PIN");
                        break;
                    }

                }
            }
            else
            {
                System.out.println("\nENTER VALID ACCOUNT NUMBER");
            }
        }
        System.out.println("************************************************************************");
        return is_Login;

    }

    //  THIS FUNCTION IS USED FOR CHECKING BALANCE
    public static void CHECK_BALANCE(){
        System.out.println("\nYOUR CURRENT BALANCE IS  : "+current_balance);
    }


    // THIS FUNCTION IS USED TO DEPOSIT MONEY
    public static void DEPOSITE(){
        System.out.println("\nAMOUNT TO BE DEPOSITED ");
        float DEPOSITE_A = in.nextFloat();
        current_balance = current_balance+DEPOSITE_A;
        System.out.println("\nAMOUNT SUCCESSFULLY DEPOSITED");
        System.out.println("After depositing "+DEPOSITE_A+", balance is "+current_balance);
        transfer+=1;
        String s = "Rs. "+DEPOSITE_A+" deposited to account\n";
        transfer_History = transfer_History.concat(s);

        System.out.println("************************************************************************");
    }

    // THIS FUNCTION IS USED TO WITHDRAW MONEY


    public static void WITHDRAWN_F(){
        System.out.println("\nAMOUNT TO  BE WITHDRAW");
        float WITHDRAWN_A = in.nextFloat();
        if(WITHDRAWN_A<=current_balance)
        {
            System.out.println("\nYOU HAVE WITHDRAWN AMOUNT : "+WITHDRAWN_A);
            current_balance = current_balance-WITHDRAWN_A;
            System.out.println("YOUR REMAINING BALANCE "+current_balance);
            transfer+=1;
            String s = "Rs. "+WITHDRAWN_A+" AMOUNT WITHDRAWN\n";
            transfer_History = transfer_History.concat(s);
        }
        else
        {
            System.out.println("\nINSUFFICIENT BALANCE");
            System.out.println("YOUR CURRENT BALANCE "+current_balance);
        }

        System.out.println("**********************************************************************");
    }
// THIS FUNCTION IS USED TO TRANSFER THE MONEY

    public static void TRANSFER(){
        System.out.println("\nENTER ACCOUNT NUMBER FOR TRANSFER : ");
        String ACCOUNT = in.next();
        System.out.println("ENTER AMOUNT TO BE TRANSFERRED ");
        float TRANSFER_A = in.nextInt();

        if(TRANSFER_A<=current_balance)
        {
            System.out.println("\nTRANSACTION SUCCESSFUL");
            current_balance = current_balance-TRANSFER_A;
            System.out.println("REMAINING BALANCE "+current_balance);
            transfer+=1;
            String s = "Rs. "+TRANSFER_A+" AMOUNT TRANSFERRED\n";
            transfer_History = transfer_History.concat(s);
        }
        else
        {
            System.out.println("\nINSUFFICIENT AMOUNT FOR TRANSFER");
            System.out.println("BALANCE : "+current_balance);
        }
        System.out.println("****************************************************************");
    }

// THIS FUNCTION TRANSACTION HISTORY
    public static void TRANSACTION_HISTORY(){
        if(transfer==0){
            System.out.println("0 TRANSACTION");
        }
        else
        {
            System.out.println(transfer_History);
        }
        System.out.println("********************************************************************");
    }

    public static void main(String args[]){

        System.out.println("\nWELCOME !!");
        System.out.println("                                                                   ");
        System.out.println("********************************************************************");
        System.out.println("\nSELECT AN OPTION");
        System.out.println("1.REGISTER\n2.EXIT");
        System.out.println("\nENTER YOUR OPTIION:");

        int SELECTION = in.nextInt();

        if(SELECTION == 1)
        {
            NEW_MEMBER();
            while(SELECTION == 1){
                System.out.println("\nSELECT ONE OPTION");
                System.out.println("1.LOGIN\n2.EXIT");
                System.out.println("\nYOUR OPTION :");
                int OPTION=in.nextInt();
                if (OPTION==1)
                {
                    if(SIGNIN())
                    {
                        boolean is_FINISH = false;
                        while(!is_FINISH)
                        {
                            System.out.println("\nSELSECT AN OPTION: ");
                            System.out.println("1.WITHDRAW\n2.TRANSACTION HISTORY\n3.CHECK BALANCE\n4.TRANSFER\n5.DEPOSIT\n6.EXIT");
                            System.out.println("\nENTER YOUR OPTION:");
                            int c=in.nextInt();
                            switch(c){
                                case 1 : WITHDRAWN_F();
                                    break;
                                case 2 : TRANSACTION_HISTORY();
                                    break;
                                case 3 : CHECK_BALANCE();
                                    break;
                                case 4 : TRANSFER();
                                    break;
                                case 5 : DEPOSITE();
                                    break;
                                case 6 : is_FINISH=true;
                                    System.out.println("\nCOLLECT YOUR CARD !!!!");
                                    break;
                                default: System.out.println("ENTER INVALID OPTION !!!");
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("\nCOLLECT YOUR CARD !!!!");
                    System.exit(0);
                }
                break;
            }

        }
        else
        {
            System.out.println("\nCOLLECT YOUR CARD !!!!");
            System.exit(0);
        }
    }
}


