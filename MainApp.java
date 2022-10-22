import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // All_User / Admin_User 0 / Owner_User 1 / Customer_User 10++
        Person Users = new Person();
        Owner owner = new Owner();
        Customer customer = new Customer();
        // SellProduct /Order /Receipt
        Sellproduct sp = new Sellproduct();
        Order order = new Order();
        Receipt receipt = new Receipt();
        // Product
        Product products = new Product();
        /*--------------------------------------------------------------------------------------------------------------*/
        // Test Zone
        /*--------------------------------------------------------------------------------------------------------------*/
        // UI Program
        int start;
        do {
            // Section
            System.out.println("<<<<<<<<<<<<<<<<<<<< Bakery Shop >>>>>>>>>>>>>>>>>>>>");
            System.out.println("Please select your status");
            System.out.println("            (1) Admin");
            System.out.println("            (2) Owner");
            System.out.println("            (3) Customer");
            System.out.println("            (0) Exit");
            System.out.print("Enter your num : ");
            start = sc.nextInt();

            // For Admin
            if (start == 1) {
                System.out.println("########## Admin-Login ###########");
                System.out.print("Enter your ID : ");
                int id = sc.nextInt();
                System.out.print("Enter your Password : ");
                int adpass = sc.nextInt();
                if (Users.getPersonPassword(id) == adpass && Users.getPersonType(id) == "Admin") {
                    System.out.println("Hello Admin" + Users.getPersonName(id));
                    int selectadmin;
                    do {
                        System.out.println("########### Menu ##########");
                        System.out.println("            (1) View User-list");
                        System.out.println("            (2) View Product");
                        System.out.println("            (0) Logout");
                        System.out.print("Your select : ");
                        selectadmin = sc.nextInt();

                        // (1) User-list
                        if (selectadmin == 1) {
                            System.out.println("########## User-List ##########");
                            Users.getDetailUser();
                        }
                        // (2) Product
                        if (selectadmin == 2) {
                            System.out.println("########## Product ##########");
                            products.getProductList();
                        }
                        // (0) Logout
                    } while (selectadmin != 0);
                } else {
                    System.out.println("Enter the wrong password or Your Account not Admin.");
                }
            }
            // For Owner
            if (start == 2) {
                System.out.println("********************** Owner-Login **********************");
                System.out.print("Enter your Name : ");
                String Ownername = sc.next();
                System.out.print("Enter your Password : ");
                int Ownerpass = sc.nextInt();
                if (owner.getCheckName(Ownername, Ownerpass) == true) {
                    System.out.println("Hello Owner " + Ownername);
                    int select_owner;
                    do {
                        System.out.println("********************* Owner_Menu ********************");
                        System.out.println("            (1) View Product");
                        System.out.println("            (2) Make a sale");
                        System.out.println("            (3) View Order");
                        System.out.println("            (0) Logout ");
                        System.out.print("Your select : ");
                        select_owner = sc.nextInt();

                        // (1) View Product
                        if (select_owner == 1) {
                            int view_product;
                            do {
                                System.out.println("******************** View Product ********************");
                                products.getProductList();
                                // (0) Exit
                                System.out.println(" (0) Exit");
                                System.out.print("Your select : ");
                                view_product = sc.nextInt();
                            } while (view_product != 0);
                        }
                        // (2) Make a sale
                        if (select_owner == 2) {
                            int make_sale;
                            int select_product;
                            do {
                                System.out.println("******************** Make a sale ********************");
                                products.getProductList(); // List Product
                                for (int i = 1; i < sp.Aid.length; i++) {
                                    System.out.print("Select Product : ");
                                    select_product = sc.nextInt(); // input id product
                                    if (select_product == 0) {
                                        break;
                                    } else {
                                        sp.Aid[i] = i;
                                        sp.SellproductId[i] = products.getProductId(select_product);
                                        sp.SellproductName[i] = products.getProductName(select_product);
                                        sp.SellproductPrice[i] = products.getProductPrice(select_product);
                                        System.out.print("Num of " + products.getProductId(select_product) + " : ");
                                        sp.SellproductNum[i] = sc.nextInt();
                                        sp.SellproductCustomername[i] = Ownername;
                                        sp.SellproductCustomertel[i] = Users.getTel(Ownerpass);
                                    }
                                }
                                System.out.println("Select list");
                                System.out.println("List" + " | " + "ProductId" + " | " + "ProductName" + " | "
                                        + "ProductPrice" + " | " + "Number" + " | " + "CustomerName" + " | "
                                        + "CustomerTel" + " | ");
                                for (int i = 1; i < sp.Aid.length; i++) {
                                    if (sp.SellproductId[i] != 0) {
                                        System.out.println(i + ".   |     " + sp.SellproductId[i] + "     |     "
                                                + sp.SellproductName[i]
                                                + "    |      " + sp.SellproductPrice[i] + "     |    "
                                                + sp.SellproductNum[i]
                                                + "   |      " + sp.SellproductCustomername[i]
                                                + "     | " + sp.SellproductCustomertel[i] + " | ");
                                    } else {
                                        break;
                                    }
                                }
                                // (0) Exit
                                System.out.println("Please select (0) Done");
                                System.out.print("Your select : ");
                                make_sale = sc.nextInt();
                            } while (make_sale != 0);
                        }
                        // (3) View Order
                        if (select_owner == 3) {
                            int view;
                            String Vname;
                            do {
                                System.out.println("******************** View Order ********************");
                                // Filter
                                System.out.print("Enter Name (Customer,Owner) : ");
                                Vname = sc.next();
                                // Order List By Name
                                System.out.println(" ==================== Order List ==================== ");
                                System.out.println(" ");
                                System.out.println(" Order Id : " + sp.getGenId(Vname));
                                System.out.println("CustomerName : " + Vname + "   " + "CustomerTel : ");
                                System.out.println("List" + " | " + "ProductId" + " | " + "ProductName" + " | "
                                        + "ProductPrice" + " | " + "Number" + " | ");
                                for (int i = 1; i < sp.Aid.length; i++) {
                                    if (sp.SellproductId[i] != 0 && sp.getFilterName(Vname) == true) {
                                        System.out.println(i + ".   |     " + sp.SellproductId[i] + "     |     "
                                                + sp.SellproductName[i]
                                                + "    |      " + sp.SellproductPrice[i] + "     |    "
                                                + sp.SellproductNum[i]);
                                    } else {
                                        break;
                                    }
                                }
                                System.out.println(" ");
                                System.out.print(" Total of Piece : " + sp.getSellproductTotal(Vname) + "   |   ");
                                sp.getSellproductOrderdate();
                                System.out.println(" ====================================================");
                                System.out.println("You want ??");
                                System.out.println("            (1) Make Receipt");
                                System.out.println("            (0) Exit");
                                System.out.print("Your select : ");
                                view = sc.nextInt();
                                // (1) Make Receipt
                                if (view == 1) {
                                    int receipts;
                                    do {
                                        System.out.println(" ==================== Receipt ==================== ");
                                        System.out.println(" ");
                                        System.out.println("                    Bakery Shop                    ");
                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println(" Take a Receipt By : " + Ownerpass);
                                        System.out.print(" DateTime : ");
                                        sp.getSellproductOrderdate();
                                        System.out.println(" ");
                                        // Customer
                                        System.out.println(" CustomerName : " + Vname + "   " + "CustomerTel : ");
                                        // Order
                                        System.out.println(" ");
                                        System.out.println(" Order Id : " + sp.getGenId(Vname));

                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println(" List  ProductName                        Price    ");
                                        System.out.println(" ------------------------------------------------- ");
                                        for (int i = 1; i < sp.Aid.length; i++) {
                                            if (sp.SellproductId[i] != 0 && sp.getFilterName(Vname) == true) {
                                                System.out.println(" " + i + "  " + sp.SellproductName[i]
                                                        + "                        " + sp.SellproductPrice[i]);
                                                System.out.println("          Num : " + sp.SellproductNum[i]);
                                            } else {
                                                break;
                                            }
                                        }
                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println("Total of Piece : " + sp.getSellproductTotal(Vname));
                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println(" ************************************************* ");
                                        System.out.println("                Thank You Come Agin                ");
                                        System.out.println(" ************************************************* ");
                                        System.out.println("              SoftWare By NUStudent63              ");
                                        System.out.println("             -------------------------             ");
                                        // Exit
                                        System.out.println("You want Exit From Receipt Please Select (0) Exit");
                                        System.out.print("Your select : ");
                                        receipts = sc.nextInt();
                                    } while (receipts != 0);
                                    System.out.println("You want Exit From Order list Please Select (0) Exit");
                                    System.out.print("Your select : ");
                                }
                                // (0) Exit
                            } while (view != 0);
                            System.out.println("You want Logout Please Select (0) LogOut");
                            System.out.print("Your select : ");
                        }
                        // (0) Logout
                    } while (select_owner != 0);

                } else {
                    System.out.println("Enter the wrong password. or Your Account not Owner.");
                }
            }
            // For Customer
            if (start == 3) {
                /*
                 * System.out.println("========== Customer-Login ===========");
                 * System.out.println("Enter your Name : ");
                 * String Cname = sc.next();
                 * System.out.println("Enter your Password");
                 * int Cpass = sc.nextInt();
                 * // (1) ViewProduct
                 * // (2) BuyProduct
                 * // (3) ViewOrder
                 * // (0) LogOut
                 */
            }
        } while (start != 0);
        System.out.println("<<<<<<<<<< Close App >>>>>>>>>>");
        System.out.println(" ");

    }
}