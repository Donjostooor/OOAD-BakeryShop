import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sellproduct {
    int[] Aid = new int[10];
    int[] SellproductId = new int[10]; // productID
    String[] SellproductName = new String[10]; // productName
    int[] SellproductPrice = new int[10]; // productPrice
    int[] SellproductNum = new int[10]; // Num of product
    int[] SellproductTotal = new int[10];// TotalPrice
    int[] SellproductCustomerid = new int[10]; // CustomerName
    static String[] SellproductCustomername = new String[10]; // CustomerName
    String[] SellproductCustomertel = new String[10]; // CustomerTel
    String[] SellproductOrderdate = new String[10]; // orderDateandTime giveProduct

    public void extendsSellproduct(
            int[] Aid,
            int[] SellproductId,
            String[] SellproductName,
            int[] SellproductPrice,
            int[] SellproductNum,
            int[] SellproductTotal,
            int[] SellproductCustomerid,
            String[] SellproductCustomername,
            String[] SellproductCustomertel,
            String[] SellproductOrderdate) {

        this.Aid = Aid;
        this.SellproductId = SellproductId;
        this.SellproductName = SellproductName;
        this.SellproductPrice = SellproductPrice;
        this.SellproductNum = SellproductNum;
        this.SellproductTotal = SellproductTotal;

        Sellproduct.SellproductCustomername = SellproductCustomername;
        this.SellproductCustomertel = SellproductCustomertel;

        this.SellproductOrderdate = SellproductOrderdate;
    }

    public int getId(int sid) {
        int SPId = 0;
        for (int i = 0; i < SellproductId.length; i++) {
            if (sid == Aid[i]) {
                SPId = Aid[i];
            }
        }
        return SPId;
    }

    public int getSellproductId(int sid) {
        int SPId = 0;
        for (int i = 0; i < SellproductId.length; i++) {
            if (sid == SellproductId[i]) {
                SPId = SellproductId[i];
            }
        }
        return SPId;
    }

    public String getSellproductName(int sid) {
        String SPName = "";
        for (int i = 0; i < SellproductId.length; i++) {
            if (sid == SellproductId[i]) {
                SPName = SellproductName[i];
            }
        }
        return SPName;
    }

    public int getSellproductPrice(int sid) {
        int SPPrice = 0;
        for (int i = 0; i < SellproductId.length; i++) {
            if (sid == SellproductId[i]) {
                SPPrice = SellproductPrice[i];
            }
        }
        return SPPrice;
    }

    public int getSellproductNum(int sid) {
        int SPNum = 0;
        for (int i = 0; i < SellproductId.length; i++) {
            if (sid == SellproductId[i]) {
                SPNum = SellproductPrice[i];
            }
        }
        return SPNum;
    }

    public String getSellproductCustomername(int sid) {
        String SPCName = "";
        for (int i = 0; i < SellproductId.length; i++) {
            if (sid == SellproductId[i]) {
                SPCName = SellproductCustomername[i];
            }
        }
        return SPCName;
    }

    public String SellproductCustomertel(int sid) {
        String SPCTel = "";
        for (int i = 0; i < SellproductId.length; i++) {
            if (sid == SellproductId[i]) {
                SPCTel = SellproductCustomertel[i];
            }
        }
        return SPCTel;
    }

    public String getSellproductOrderdate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public String getDetailSellprodect() {
        String Ds = "";
        System.out.println("List" + " | " + "ProductId" + " | " + "ProductName" + " | " + "ProductPrice" + " | "
                + "Number" + " | " + "CustomerName" + " | " + "CustomerTel" + " | " + "Pick up date");
        for (int i = 1; i < SellproductId.length; i++) {
            if (SellproductId[i] != 0) {
                System.out.println(i + ".   |     "
                        + SellproductId[i] + "     |     "
                        + SellproductName[i] + "    |      "
                        + SellproductPrice[i] + "     |    "
                        + SellproductNum[i] + "   |   "
                        + SellproductCustomername[i] + "   |   "
                        + SellproductCustomertel[i] + "   |   "
                        + SellproductOrderdate[i] + "   |   ");
            }
        }
        return Ds;
    }

    public int getGenId(String Vname) {
        int SId = 0;
        for (int i = 0; i < Aid.length; i++) {
            if (Vname.equals(SellproductCustomername[i]) == true) {
                SId = Aid[i];
            }
        }
        return SId;
    }

    public String getGenTel(String Vname) {
        String STel = "";
        for (int i = 0; i < Aid.length; i++) {
            if (Vname.equals(SellproductCustomername[i]) == true) {
                STel = SellproductCustomertel[i];
            }
        }
        return STel;
    }

    public int getSellproductTotal(String Vname) {
        int SPTotal = 0;
        for (int i = 1; i < Aid.length; i++) {
            if (Vname.equals(SellproductCustomername[i]) == true) {
                SPTotal += SellproductPrice[i] * SellproductNum[i];
            }
        }
        return SPTotal;

    }

    public static Set<Integer> getFilter(String name) {
        Set<Integer> result1 = new HashSet<Integer>(); // List
        Set<String> result2 = new HashSet<String>(); // input name
        String[] array = SellproductCustomername;
        String[] input = new String[array.length];
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (input[i] == array[i]) {
                    result1.add(i);
                    result2.add(array[i]);
                }
                input[0] = name;
                input[1] = name;
                input[2] = name;
                input[3] = name;
                input[4] = name;
                input[5] = name;
                input[6] = name;
                input[7] = name;
                input[8] = name;
                input[9] = name;
            }
        }
        return result1;
    }

    public static List<Integer> getFilterOrder(String search) {

        int p;
        List<Integer> indexs = new ArrayList<Integer>();
        for (p = 1; p < SellproductCustomername.length; p++) {
            if (search.equals(SellproductCustomername[p])) {
                indexs.add(p);
            }
        }
        return indexs;

    }

    public Boolean getFilterName(String name) {
        Boolean Check = false;
        for (int i = 1; i < Aid.length; i++) {
            if (name.equals(SellproductCustomername[i]) == true) {
                Check = true;
            }
        }
        return Check;
    }

    public Boolean getFilterPick(String name) {
        Boolean Check = false;
        for (int i = 1; i < Aid.length; i++) {
            if (name.equals(SellproductOrderdate[i]) == true) {
                Check = true;
            }
        }
        return Check;
    }
}
