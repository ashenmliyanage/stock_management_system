import java.util.*;
class main{
    public static Scanner input = new Scanner(System.in);
    public static String[] bar = {"LOGIN", "WELCOME TO IJSE STOCK MANAGEMENT SYSTEM", "CREDENTIAL MANAGE", "SUPPLIER MANAGE", "ADD SUPPLIER", "UPDATE SUPPLIER","DELETE SUPPLIER"," VIEW SUPPLIER","SEARCH SUPPLIER","STOCK MANAGE","MANAGE ITEM CATEGORIES","ADD NEW CATEGORY","DELETE ITEM CATEGORY","UPDATE CATEGORY", "ADD ITEM","SUPPLIER WISE","VIEW ITEM","VIEW CATEGORY","RANKING"};
    public static String[][] supplier =new String[0][0];
    public static String[][] category = new String[0][];
    public static String[][] itemCode = new String[0][0];
    public static String[][] item = new String[0][0];
    public static String[][] temp = new String[0][0];
    public static String[][] iTemp = new String[0][0];
    public static String[][] Uname = new String[1][2];
    public static int[]min = new int[0];
    public static void main(String args[]){

        Uname[0][0] = "1";
        Uname[0][1] = "1";
        login();
        Uname = homePage(Uname);
    }
    public static void tBar(String bar){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.printf("| %46s"+"%46s %n",bar,"|" );
        System.out.println("+--------------------------------------------------------------------------------------------+\n\n");
    }
    public static void login(){
        tBar(bar[0]);
        boolean flag = false;
        while (flag != true) {
            System.out.print("User Name : ");
            String x = input.next();

            if (x.equals(Uname[0][0])) {
                while (flag != true){
                    System.out.print("Password : ");
                    String pass = input.next();

                    if (pass.equals(Uname[0][1])) {
                        flag = true;
                    }
                    else{
                        System.out.println("password incorrect.please try again");
                    }
                }
            }
            else{
                System.out.println("Username incorrect.please try again");
            }
        }
    }
    public static String[][] homePage(String[][] Uname){
        tBar(bar[1]);
        System.out.print("[1] Change the Credentials ");
        System.out.printf("%26s [2] Supplier Manage \n","");
        System.out.print("[3] Stock Manage");
        System.out.printf("%37s [4] log out\n","");
        System.out.println("[5] Exit the System");


        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();

        if (option == 1) {
            Uname = ChangeTheCredentials(Uname);
        }
        if(option == 4){
            login();
            homePage(Uname);
        }
        if (option == 2) {
            supplierManage();
        }
        if (option == 3) {
            stockManage();
        }
        if (option == 5){
            System.exit(0);
        }
        return Uname;
    }
    public static String[][] ChangeTheCredentials(String Uname[][]){
        tBar(bar[2]);
        boolean flag = false;

        while(flag != true){
            System.out.print("Please enter the user name to verify it's you : ");
            String name = input.next();

            if (name.equals(Uname[0][0])) {
                System.out.println("Hey "+Uname[0][0]);
                while (flag != true){
                    System.out.print("Enter your current password : ");
                    String pass = input.next();

                    if (pass.equals(Uname[0][1])) {
                        System.out.print("Enter your new password : ");
                        Uname[0][1] = input.next();
                        flag = true;
                    }
                    else{
                        System.out.println("incorrect password. try again");
                    }
                }
            }
            else {
                System.out.println("Invalid User name. try again");
            }
        }
        System.out.print("Password change is successful !. Do you want to go home page (Y/N) : ");
        char replay = input.next().charAt(0);

        if(replay == 'Y' || replay == 'y'){
            homePage(Uname);
        }
        else{
			System.exit(0);
		}

        return Uname;
    }
    public static void supplierManage(){
        tBar(bar[3]);
        System.out.print("[1] Add Supplier ");
        System.out.printf("%26s [2] Update Supplier \n","");
        System.out.print("[3] Delete Supplier");
        System.out.printf("%24s [4] View Supplier\n","");
        System.out.print("[5] Search Supplier");
        System.out.printf("%24s [6] Home\n","");

        System.out.print("Enter the option to continue : ");
        int option = input.nextInt();

        if (option == 1) {
            supplier = addSupplier();
        }
        if (option == 2) {
            updateSupplier();
        }
        if (option == 3) {
            deleteSupplier();
        }
        if (option == 4) {
            viewSupplier();
        }
        if (option == 5) {
            searchSupplier();
        }
        if (option == 6){
            homePage(supplier);
        }
    }
    public static String[][] addSupplier(){
        tBar(bar[4]);
        supplier = grow(supplier,2);
        int count = 0;
        boolean flag = false;
        while (flag != true){
            System.out.print("Supplier Id \t: ");
            String x = input.next();
            temp = grow(temp,1);
            temp[temp.length-1][0] = x;
            count = check(x,temp,0);
            if (count == 1 || count == 0) {
                supplier[supplier.length-1][0] = x;
                System.out.print("Supplier name\t: ");
                String name  = input.next();
                supplier[supplier.length-1][1] = name;
                break;
            }
            else {
                System.out.println("Already used.try again");
            }
        }
        System.out.print("added successfully. Do you want to add another supplier (Y/N) : ");
        char option = input.next().charAt(0);

        if (option == 'Y' || option == 'y') {
            addSupplier();
        }
        else{
            supplierManage();
        }
        return supplier;
    }
    public static String[][] grow(String[][] supplier,int length) {

        String[][] temp = new String[supplier.length + 1][length];
        for (int i = 0; i < supplier.length; i++) {
            for (int j = 0; j < supplier[i].length; j++) {
                temp[i][j] = supplier[i][j];
            }
        }
        return temp;
    }
    public static void updateSupplier(){
        tBar(bar[5]);
        boolean flag = false;
        while (flag != true){
            System.out.print("Supplier ID : ");
            String id = input.next();

            for (int i = 0; i < supplier.length; i++) {
                if (id.equals(supplier[i][0])) {
                    System.out.println("Supplier name : "+supplier[i][1]);
                    System.out.print("Enter the new supplier name : ");
                    supplier[i][1] = input.next();
                    flag = true;
                }
            }
            if (flag != true) {
                System.out.println("can't find supplier.try again");
            }
        }
        System.out.print("Update is Successful. Do you want to update another supplier(Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y'|| option == 'y') {
            updateSupplier();
        }
        if (option == 'N' || option == 'n') {
            supplierManage();
        }
    }
    public static void deleteSupplier(){
        tBar(bar[6]);
        boolean flag = false;
        while (flag != true){
            System.out.print("Supplier Id : ");
            String id = input.next();
            for (int i = 0; i < supplier.length; i++) {
                if (id.equals(supplier[i][0])) {
                    flag = true;
                    supplier = growLess(supplier,i);
                }
            }
            if (flag != true) {
                System.out.println("Can't find supplier Id.Try again.");
            }
        }
        System.out.print("deleted successful. Do you want to delete another(Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            deleteSupplier();
        }
        else {
            supplierManage();
        }

    }
    public static String[][] growLess(String supplier[][],int index) {
        String[][] temp = new String[supplier.length - 1][supplier[0].length];
        int k = 0;
        for (int i = 0; i < supplier.length; i++) {
            if(i == index) continue;
            for (int j = 0; j < supplier[i].length; j++) {
                temp[k][j] = supplier[i][j];
            }
            k++;
        }
        return temp;
    }

    public static void viewSupplier(){
        tBar(bar[7]);
        System.out.println("+--------+--------+----------------+----------------+----------------+");
        System.out.printf("| %18s"+"%16s"+"%16s"+"%18s","name","|","Id","|" );
        System.out.println("\n+--------+--------+----------------+----------------+----------------+");
        for (int i = 0; i < supplier.length; i++) {
            for (int j = 0; j < supplier[i].length; j++) {

                System.out.printf("|%19s", supplier[i][j++]);
                System.out.printf("%16s" + "%17s " + "%16s" + "\n", "|", supplier[i][j], "|");
            }
        }
        System.out.println("+--------+--------+----------------+----------------+----------------+");
        System.out.print("Do you want to go supplier manage page(Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            supplierManage();
        }
        if (option == 'N'|| option == 'n') {
			System.exit(0);
		}


    }
    public static void searchSupplier(){
        tBar(bar[8]);
        boolean flag = false;
        while (flag != true){
            System.out.print("Supplier Id : ");
            String id = input.next();
            for (int i = 0; i < supplier.length; i++) {
                if (id.equals(supplier[i][0])) {
                    System.out.println("Name : "+supplier[i][1]);
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("can't find supplier. try again.");
            }
        }
        System.out.print("added successful. do you want to another find(Y/N): ");
        char option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            searchSupplier();
        }
        else {
            supplierManage();
        }
    }
    public static void stockManage(){
        tBar(bar[9]);
        System.out.print("[1] Manage item categories ");
        System.out.printf("%24s [2] Add item \n","");
        System.out.print("[3] Get item supplier wise");
        System.out.printf("%25s [4] View Items\n","");
        System.out.print("[5] Rank item per unit price ");
        System.out.printf("%22s [6] Home\n","");
        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();

        if (option == 1) {
            manageItem();
        }
        if (option == 2) {
            addItem();
        }
        if (option == 3) {
            supplierWise();
        }
        if (option == 4){
            viewCatagory();
        }
        if (option == 5) {
            min();
        }
        if (option == 6) {
           homePage(supplier);
        }
    }
    public static void manageItem(){
        tBar(bar[10]);
        System.out.print("[1] Add new item category ");
        System.out.printf("%24s [2] Delete item category \n","");
        System.out.print("[3] Update item category");
        System.out.printf("%26s [4] Stock management\n","");
        System.out.print("\nEnter an option to continue > ");
        int option =  input.nextInt();

        if (option == 1) {
            addCategory();
        }
        if (option == 2) {
            deleteCategory();
        }
        if (option == 3) {
            updateCategory();
        }
        if (option == 4) {
            stockManage();
        }
    }
    public static void addCategory(){
        tBar(bar[11]);
        category = grow(category,1);
        boolean flag = false;
        int count = 0;
        while(flag != true){
        System.out.print("Enter the new item category : ");
        String cat = input.next();
        count=check(cat,category,0);
        if(count == 0){
			category[category.length-1][0] = cat;
			flag = true;
		}
		else{
			System.out.println("Already used.Try again");
		}
	}
        System.out.print("Added successfully!. Do you want to add another category(Y/N) : ");
        char option = input.next().charAt(0);

        if (option == 'Y' || option == 'y') {
            addCategory();
        }
        else {
            stockManage();
        }
    }
    public static void deleteCategory(){
        tBar(bar[12]);
        boolean flag = false;
        while (flag != true){
            System.out.print("Enter Category for delete : ");
            String delete = input.next();
            for (int i = 0; i < category.length; i++) {
                if (delete.equals(category[i][0])) {
                    flag = true;
                    category = growLess(category,i);
                }
            }
            if (flag != true) {
                System.out.println("Can't find category.Try again.");
            }
        }
        System.out.print("deleted successful. Do you want to delete another(Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            deleteCategory();
        }
        else {
            stockManage();
        }
    }
    public static void updateCategory(){
        tBar(bar[13]);
        boolean flag = false;
        while (flag != true){
            System.out.print("Enter category : ");
            String id = input.next();

            for (int i = 0; i < category.length; i++) {
                if (id.equals(category[i][0])) {
                    System.out.print("Enter the new category name : ");
                    category[i][0] = input.next();
                    flag = true;
                }
            }
            if (flag != true) {
                System.out.println("can't find category.try again");
            }
        }
        System.out.print("Update is Successful. Do you want to update another category(Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y'|| option == 'y') {
            updateCategory();
        }
        if (option == 'N'|| option == 'n') {
            stockManage();
        }
    }
    public static void addItem(){
        tBar(bar[14]);
        if (category.length == 0) {
            System.out.println("OOPS! It seem that you don't have any item category in the system.");
            System.out.print("Do you want to add new item category(Y/N) : ");
            char option = input.next().charAt(0);

            if (option == 'Y'|| option == 'y') {
                addCategory();
            }
            if (option == 'N'|| option == 'n') {
                manageItem();
            }
        }
        if (supplier.length == 0) {
            System.out.println("OOPS! It seem that you don't have any supplier in the system.");
            System.out.print("Do you want to add new supplier(Y/N) : ");
            char option = input.next().charAt(0);

            if (option == 'Y'|| option == 'y') {
                addSupplier();
            }
            if (option == 'N'|| option == 'n') {
                manageItem();
            }
        }
        itemCode = grow(itemCode,6);
        min = intGrow(min);
        int count = 0;
        boolean flag = false;
        while (flag != true) {
            System.out.print("Enter Item code : ");
            String x = input.next();
            iTemp = grow(iTemp, 1);
            iTemp[iTemp.length - 1][0] = x;
            count = check(x, iTemp, 0);
            if (count == 1 || count == 0) {
                itemCode[itemCode.length - 1][1] = x;
                flag = true;
            } else {
                System.out.println("Already added.Try again.");
            }
        }
        System.out.println("Supplier List : ");
        System.out.println("+-------------------+--------------------------+--------------------------+");
        System.out.println("|        #          |        SUPPLIER ID       |       SUPPLIER NAME      |");
        System.out.println("+-------------------+--------------------------+--------------------------+");
        for (int i = 0; i < supplier.length; i++){
            for (int j = 0; j < 1; j++){
                System.out.printf("|%10S         |%16S          |%18S        |\n",(i+1),supplier[i][j++],supplier[i][j]);
            }
        }
        System.out.println("+-------------------+--------------------------+--------------------------+");
        System.out.print("Enter supplier number : ");
        int number = input.nextInt();
        itemCode[itemCode.length-1][0] = supplier[number-1][0];
        System.out.println("+-------------------+--------------------------+");
        System.out.println("|        #          |        CATEGORY NAME     |");
        System.out.println("+-------------------+--------------------------+");
        for (int i = 0; i < category.length; i++){
            for (int j = 0; j < 1; j++){
                System.out.printf("|%10S         |%16S          |\n",(i+1),category[i][j]);
            }
        }
        System.out.println("+-------------------+--------------------------+");
        System.out.print("Enter category number : ");

        int Number = input.nextInt();
        itemCode[itemCode.length-1][2] = category[Number-1][0];

        System.out.print("Description : ");
        itemCode[itemCode.length-1][3] = input.next();
        System.out.print("Unite price : ");
        int price = input.nextInt();
        itemCode[itemCode.length-1][4] =""+price;
        min[min.length-1] = price;
        System.out.print("Qty on hand : ");
        itemCode[itemCode.length-1][5] = input.next();
      
        System.out.print("Do you want add new item(Y/N) : ");
        char option = input.next().charAt(0);

        if (option == 'Y'|| option == 'y') {
            addItem();
        }
        else {
            stockManage();
        }
    }
    public static void supplierWise(){
        tBar(bar[15]);
        boolean flag1 = false;
        boolean flag = false;
        int count = 0;
        String id = " ";
        
        while(flag1 != true){
        System.out.print("Enter supplier id : ");
        String tempId = input.next();
        count=check(tempId,supplier,0);
        if(count == 0){
			System.out.println("Not found.try again");
		}
		else{
			for (int i = 0; i < itemCode.length; i++) {
				if (tempId.equals(itemCode[i][0])) {
					System.out.println("Name : "+supplier[i][1]);
					flag = true;
					id = tempId; 
					break;
				}
            
			}
		if(flag == false){
		 System.out.println("no items for supplier");
		}
		flag1 = true;
		}
	}
        
        if (flag == true) {
            System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
            //System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |       CAT      |");
            System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n","SID","CODE","DESC","PRICE","QTY","CAT");
            System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
            for (int i = 0; i < itemCode.length; i++) {
                if (id.equals(itemCode[i][0])) {
                        System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n",itemCode[i][0],itemCode[i][1],itemCode[i][3],itemCode[i][4],itemCode[i][5],itemCode[i][2]);
                }
            }
            System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
        }
        System.out.print("Search success. Do you want search again(Y/N) : ");
        char option = input.next().charAt(0);

        if (option == 'Y'|| option == 'y') {
            supplierWise();
        }
        else {
            stockManage();
        }
    }
    public static void viewCatagory(){
        tBar(bar[16]);
        String[][] view = new String[itemCode.length][1];
        for (int i = 0; i < category.length; i++) {
            boolean flag = true;
            for (int j = 0; j < itemCode.length; j++) {
                if (category[i][0].equals(itemCode[j][2])) {
                    if (flag == true) {
                        System.out.println(category[i][0]);
                        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
                        System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |");
                        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
                        flag = false;
                    }
                    for (int k = 0; k < 1 ; k++) {
                        System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |\n",itemCode[j][k++],itemCode[j][1],itemCode[j][3],itemCode[j][4],itemCode[j][5]);
                    }
                    System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
                }
            }
        }
        System.out.print("Do you want to go stock manage page(Y/N) :");
        char option = input.next().charAt(0);

        if (option == 'Y' || option == 'y') {
            stockManage();
        }
        else{
			System.exit(0);
		}
    }
    public static void min(){
        tBar("RANKING");
        for (int i = 0; i < min.length-1; i++){
            for (int j = 0; j < min.length-1; j++){
                if(min[j]>min[j+1]){
                    int x=min[j];
                    min[j]=min[j+1];
                    min[j+1]=x;
                }
            }
        }
        String[] temp = new String[min.length];
        for (int i = 0; i < min.length; i++) {
            temp[i] =""+min[i];
        }
        
        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
        //System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |       CAT      |");
        System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n","SID","CODE","DESC","PRICE","QTY","CAT");
        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < itemCode.length; j++) {
                if (temp[i].equals(itemCode[j][4])) {
                    System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n",itemCode[j][0],itemCode[j][1],itemCode[j][3],itemCode[j][4],itemCode[j][5],itemCode[j][2]);
                }
            }
        }
        System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
        System.out.print("Do you want to go to stock manage page(Y/N) : ");
        char option = input.next().charAt(0);
        if (option == 'Y'){
            stockManage();
        }
        else {
            return;
        }
    }
    public static int[] intGrow(int[] a) {
        int[] temp = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        return temp;
    }
    public static int check(String x, String itemcode[][],int y){
        int count = 0;
        for (int i = 0; i <itemcode.length; i++) {
            if (x.equals(itemcode[i][y])){
                count++;
            }
        }
        return count;
    }
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Windows 10")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

