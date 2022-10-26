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
                System.out.println("###################### Admin-Login ######################");
                System.out.print("Enter your ID : ");
                int id = sc.nextInt();
                System.out.print("Enter your Password : ");
                int adpass = sc.nextInt();
                if (Users.getPersonPassword(id) == adpass && Users.getPersonType(id) == "Admin") {
                    System.out.println("Hello Admin " + Users.getPersonName(id));
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
                        } else {
                            System.out.println("does not match options");
                        }
                        // (0) Logout
                    } while (selectadmin != 0);
                    System.out.println("<<<<<<<<<< Logout Admin >>>>>>>>>>");
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
                        System.out.println("            (3) View Once Order");
                        System.out.println("            (4) View All Order");
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
                                    System.out.println("#(0)Done");
                                    System.out.print("Select Product : ");
                                    select_product = sc.nextInt(); // input id product
                                    if (select_product == 0) {
                                        break;
                                    } else {
                                        int j = 0;
                                        for (int x = 1; true; x++) {
                                            if (sp.Aid[x] != 0)
                                                j++;
                                            else
                                                break;
                                        }
                                        int y = 1 + j;
                                        sp.Aid[y] = i;

                                        sp.SellproductId[y] = products.getProductId(select_product);

                                        sp.SellproductName[y] = products.getProductName(select_product);

                                        sp.SellproductPrice[y] = products.getProductPrice(select_product);

                                        System.out.print("Num of " + products.getProductName(select_product) + " : ");
                                        sp.SellproductNum[y] = sc.nextInt();

                                        sp.SellproductCustomerid[y] = Users.getid(Ownername);

                                        sp.SellproductCustomername[y] = Ownername;

                                        sp.SellproductCustomertel[y] = owner.getTel(Ownerpass);

                                        sp.SellproductOrderdate[y] = sp.getSellproductOrderdate();

                                    }
                                }
                                System.out.println("Select list");
                                System.out.println("List" + " | " + "ProductId" + " | " + "ProductName" + " | "
                                        + "ProductPrice" + " | " + "Number" + " | " + "CustomerName" + " | "
                                        + "CustomerTel" + " | " + "Pick up Date");

                                if (sp.getFilterName(Ownername) == true) {
                                    // Converting Set object to integer array
                                    Set<Integer> F = sp.getFilter(Ownername);
                                    int[] arr = new int[F.size()];
                                    int g = 0;
                                    for (int x : F) {
                                        arr[g++] = x;
                                    }
                                    // System.out.println(arr.length);
                                    for (int i = 0; i < F.size(); i++) {
                                        System.out.println((i + 1) + ".   |     " + sp.SellproductId[arr[i]]
                                                + "     |     "
                                                + sp.SellproductName[arr[i]]
                                                + "    |      " + sp.SellproductPrice[arr[i]]
                                                + "     |    "
                                                + sp.SellproductNum[arr[i]]
                                                + "   |      " + sp.SellproductCustomername[arr[i]]
                                                + "     | " + sp.SellproductCustomertel[arr[i]] + " | "
                                                + sp.SellproductOrderdate[arr[i]]);

                                    }
                                } else {
                                    break;
                                }
                                System.out.print(" Total of Piece : " + sp.getSellproductTotal(Ownername) + "   |   ");
                                System.out.println(sp.getSellproductOrderdate());
                                // (0) Exit
                                System.out.println("Please select (0) Done");
                                System.out.print("Your select : ");
                                make_sale = sc.nextInt();
                            } while (make_sale != 0);
                            System.out.println("*************** Order successfully saved ***************");
                        }
                        // (3) View Order
                        if (select_owner == 3) {
                            int view;
                            String aname, test;
                            System.out.println("******************** View Once Order ********************");
                            System.out.print("Enter Name (Customer,Owner) : ");
                            aname = sc.next();// input
                            do {
                                // Filter

                                // test zone---------------------------------------//
                                /*
                                 * for (int i = 0; i < sp.Aid.length; i++) {
                                 * System.out.print(sp.SellproductCustomername[i] + " ");
                                 * }
                                 * // System.out.println("\n" + sp.getDetailSellprodect());
                                 * System.out.println(Sellproduct.getFilter(Ownername));
                                 * System.out.println(Sellproduct.getFilterOrder(aname));
                                 * System.out.println(aname + " //" + Ownername);
                                 */
                                // ----- ---------------------------------------------//
                                // Order List By Name
                                System.out.println(" ==================== Order List ==================== ");
                                System.out.println(" ");
                                System.out.println(" Order Id : " + sp.getGenId(aname));
                                System.out.println(
                                        "CustomerName : " + aname + "   " + "CustomerTel : " + sp.getGenTel(aname));
                                System.out.println("List" + " | " + "ProductId" + " | " + "ProductName" + " | "
                                        + "ProductPrice" + " | " + "Number" + " | ");
                                List<Integer> G = Sellproduct.getFilterPerson(aname);
                                int[] grr = new int[G.size()];
                                // Converting Set object to integer array
                                int g = 0;
                                for (int x : G) {
                                    grr[g++] = x;
                                }
                                // System.out.println(G);
                                // System.out.println(G.size());
                                for (int i = 0; i < G.size(); i++) {
                                    System.out.println(
                                            i + 1 + ".   |     "
                                                    + sp.SellproductId[grr[i]] + "     |     "
                                                    + sp.SellproductName[grr[i]] + "    |      "
                                                    + sp.SellproductPrice[grr[i]] + "     |    "
                                                    + sp.SellproductNum[grr[i]]);
                                }

                                System.out.println(" ");
                                System.out.print(" Total of Piece : " + sp.getSellproductTotal(aname) + "   |   ");
                                System.out.println(sp.getSellproductOrderdate());
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
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        System.out.println(" ==================== Receipt ==================== ");
                                        System.out.println(" ");
                                        System.out.println("                    Bakery Shop                    ");
                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println(" Take a Receipt By : " + Ownername);
                                        System.out.print(" DateTime : ");
                                        System.out.println(sp.getSellproductOrderdate());
                                        System.out.println(" ");
                                        // Customer
                                        System.out.println(" CustomerName : " + aname + "   " + "CustomerTel : "
                                                + sp.getGenTel(aname));
                                        // Order
                                        System.out.println(" ");
                                        System.out.println(" Order Id : " + sp.getGenId(aname));

                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println(" List  ProductName                        Price    ");
                                        System.out.println(" ------------------------------------------------- ");

                                        List<Integer> Q = Sellproduct.getFilterPerson(aname);
                                        int[] qrr = new int[Q.size()];
                                        // Converting Set object to integer array
                                        int q = 0;
                                        for (int x : Q) {
                                            qrr[q++] = x;
                                        }
                                        for (int i = 0; i < Q.size(); i++) {
                                            System.out.println(
                                                    " " + i + 1 + "  " + sp.SellproductName[qrr[i]]
                                                            + "                        "
                                                            + sp.SellproductPrice[qrr[i]]);
                                            System.out.println(
                                                    "          Num : " + sp.SellproductNum[qrr[i]]);

                                        }
                                        for (int i = 0; i < Q.size(); i++) {
                                            System.out.println(" Pick up date : "
                                                    + sp.SellproductOrderdate[qrr[i]]);

                                        }
                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println("Total of Piece : " + sp.getSellproductTotal(aname));
                                        System.out.println(" ------------------------------------------------- ");
                                        System.out.println(" ************************************************* ");
                                        System.out.println("                Thank You Come Agin                ");
                                        System.out.println(" ************************************************* ");
                                        System.out.println("              SoftWare By NUStudent63              ");
                                        System.out.println("             -------------------------             ");
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        // Exit
                                        System.out.println("You want Exit From Receipt Please Select (0) Exit");
                                        System.out.print("Your select : ");
                                        receipts = sc.nextInt();
                                    } while (receipts != 0);
                                    System.out.println(" =========== Exit From Receipt ========== ");

                                }
                                // (0) Exit
                            } while (view != 0);
                            System.out.println(" =========== Exit From Order ========== ");

                        }
                        // (4) View All Order
                        if (select_owner == 4) {
                            int Ao;
                            System.out.println("******************** View All Order ********************");
                            do {
                                System.out.println(sp.getDetailSellprodect());
                                System.out.println("select (0) Exit");
                                System.out.print("Your select : ");
                                Ao = sc.nextInt();
                            } while (Ao != 0);
                        } else {
                            System.out.println("does not match options");
                        }
                        // (0) Logout
                    } while (select_owner != 0);
                    System.out.println("<<<<<<<<<< Logout Owner >>>>>>>>>>");
                } else {
                    System.out.println("Enter the wrong password. or Your Account not Owner.");
                }
            }
            // For Customer
            if (start == 3) {
                System.out.println("====================== Customer-Login ======================");
                System.out.print("Enter your Name : ");
                String Cname = sc.next();
                System.out.print("Enter your Password : ");
                int Cpass = sc.nextInt();
                if (customer.getCheckName(Cname, Cpass) == true) {
                    System.out.println("Hello Customer " + Cname);
                    int select_customer;
                    do {
                        System.out.println(" ====================== Customer_Menu ====================== ");
                        System.out.println("            (1) View Product");
                        System.out.println("            (2) Buy Product");
                        System.out.println("            (3) View Order");
                        System.out.println("            (0) Logout ");
                        System.out.print("Your select : ");
                        select_customer = sc.nextInt();

                        // (1) ViewProduct
                        if (select_customer == 1) {
                            int cview;
                            do {
                                System.out.println(" ====================== View Product ====================== ");
                                products.getProductList();
                                // (0) Exit
                                System.out.println(" (0) Exit");
                                System.out.print("Your select : ");
                                cview = sc.nextInt();
                                // (0) Exit from ViewProduct
                            } while (cview != 0);
                            System.out.println(" *====================* Exit from ViewProduct *====================* ");
                            System.out.println(" ");

                        }
                        // (2) BuyProduct
                        if (select_customer == 2) {
                            int select_cproduct;
                            int buypro;
                            do {
                                System.out.println("==================== Buy Product ====================");
                                products.getProductList(); // List Product
                                for (int i = 1; i < sp.Aid.length; i++) {
                                    System.out.println("#(0)Done");
                                    System.out.print("Select Product : ");
                                    select_cproduct = sc.nextInt(); // input id product
                                    if (select_cproduct == 0) {
                                        break;
                                    } else {
                                        int j = 0;
                                        for (int x = 1; true; x++) {
                                            if (sp.Aid[x] != 0)
                                                j++;
                                            else
                                                break;
                                        }
                                        int y = 1 + j;
                                        sp.Aid[y] = i;

                                        sp.SellproductId[y] = products.getProductId(select_cproduct);

                                        sp.SellproductName[y] = products.getProductName(select_cproduct);

                                        sp.SellproductPrice[y] = products.getProductPrice(select_cproduct);

                                        System.out.print("Num of " + products.getProductName(select_cproduct) + " : ");
                                        sp.SellproductNum[y] = sc.nextInt();

                                        sp.SellproductCustomername[y] = Cname;

                                        sp.SellproductCustomertel[y] = owner.getTel(Cpass);

                                        System.out.println("#Example : dd-MM-yyyy");
                                        System.out.print("Pick up Date : ");
                                        sp.SellproductOrderdate[y] = sc.next();

                                    }
                                }
                                System.out.println("Select list");
                                System.out.println(
                                        "CustomerName : " + Cname + " | " + "CustomerTel : " + customer.getTel(Cpass));
                                System.out.println("DateTime : " + sp.getSellproductOrderdate());
                                System.out.println("List" + " | " + "ProductId" + " | " + "ProductName" + " | "
                                        + "Number" + " | " + "ProductPrice" + " | " + "Pick-up_Date");

                                List<Integer> D = Sellproduct.getFilterPerson(Cname);
                                int[] drr = new int[D.size()];
                                // Converting Set object to integer array
                                int d = 0;
                                for (int x : D) {
                                    drr[d++] = x;
                                }

                                for (int i = 0; i < D.size(); i++) {
                                    System.out.println(" " + (i + 1) + ".   |     " + sp.SellproductId[drr[i]]
                                            + "     |   "
                                            + sp.SellproductName[drr[i]] + "   |    " + sp.SellproductNum[drr[i]]
                                            + "   |     " + sp.SellproductPrice[drr[i]] + "     |     "
                                            + sp.SellproductOrderdate[drr[i]]);

                                }
                                // (0) Exit
                                System.out.println("Total of Piece : " + sp.getSellproductTotal(Cname));
                                System.out.println("Please select (0) Done");
                                System.out.print("Your select : ");
                                buypro = sc.nextInt();
                            } while (buypro != 0);
                            System.out.println("*************** Order successfully saved ***************");
                        }
                        // (3) ViewOrder
                        if (select_customer == 3) {
                            int cview;
                            String OCName = Cname;
                            do {
                                System.out.println(" ------------------------------------------------- ");
                                System.out.println(" ***Please cap this page to receive the product.** ");
                                System.out.println(" ------------------------------------------------- ");
                                System.out.println(" ***Please cap this page to receive the product.** ");
                                System.out.println(" ------------------------------------------------- ");
                                System.out.println(" ***Please cap this page to receive the product.** ");
                                System.out.println(" ------------------------------------------------- ");
                                System.out.println(" ");
                                System.out.println(" ");
                                System.out.println(" ");
                                System.out.println(" ");
                                System.out.println(
                                        " ==================== Order with " + OCName + "   ==================== ");
                                System.out.println(" ");
                                System.out.println("                    Bakery Shop                    ");
                                System.out.println(" ------------------------------------------------- ");
                                System.out.print(" DateTime : ");
                                System.out.println(sp.getSellproductOrderdate());
                                System.out.println(" ");
                                // Customer
                                System.out.println(" CustomerName : " + OCName + "   " + "CustomerTel : "
                                        + sp.getGenTel(OCName));
                                // Order
                                System.out.println(" ");
                                System.out.println(" Order Id : " + sp.getGenId(OCName));

                                System.out.println(" ------------------------------------------------- ");
                                System.out.println(" List  ProductName           Price     PickUp Date ");
                                System.out.println(" ------------------------------------------------- ");

                                List<Integer> O = Sellproduct.getFilterPerson(Cname);
                                int[] orr = new int[O.size()];
                                // Converting Set object to integer array
                                int o = 0;
                                for (int x : O) {
                                    orr[o++] = x;
                                }
                                // System.out.println(G);
                                // System.out.println(G.size());
                                for (int i = 0; i < O.size(); i++) {
                                    System.out.println(" " + (i + 1) + "     " + sp.SellproductName[orr[i]]
                                            + "                     " + sp.SellproductPrice[orr[i]] + "    "
                                            + sp.SellproductOrderdate[orr[i]]);
                                    System.out.println("          Num : " + sp.SellproductNum[orr[i]]);
                                }
                                System.out.println(" ------------------------------------------------- ");
                                System.out.println("Total of Piece : " + sp.getSellproductTotal(OCName));
                                System.out.println(" ------------------------------------------------- ");
                                System.out.println(" ************************************************* ");
                                System.out.println("                Thank You Come Agin                ");
                                System.out.println(" ************************************************* ");
                                System.out.println("              SoftWare By NUStudent63              ");
                                System.out.println("             -------------------------             ");
                                System.out.println(" ");
                                System.out.println(" ");
                                System.out.println(" ");
                                System.out.println(" ");
                                // Exit
                                System.out.println("You want Exit From Receipt Please Select (0) Exit");
                                System.out.print("Your select : ");
                                cview = sc.nextInt();
                            } while (cview != 0);
                            System.out.println(" =========== Exit From Receipt ========== ");
                        } else {
                            System.out.println("does not match options");
                        }
                        // (0) LogOut
                    } while (select_customer != 0);
                } else {
                    System.out.println("Enter the wrong name or password.");
                }
            }
        } while (start != 0);
        System.out.println("<<<<<<==========### Close App ###===========>>>>>>");
        System.out.println(" ");
    }
}