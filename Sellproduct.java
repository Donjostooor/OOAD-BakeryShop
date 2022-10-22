import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sellproduct {
    int[] Aid = new int[5];
    int[] SellproductId = new int[100]; // productID
    String[] SellproductName = new String[100]; // productName
    int[] SellproductPrice = new int[100]; // productPrice
    int[] SellproductNum = new int[100]; // Num of product
    int[] SellproductTotal = new int[100];// TotalPrice
    String[] SellproductCustomername = new String[100]; // CustomerName
    String[] SellproductCustomertel = new String[100]; // CustomerTel
    DateTimeFormatter[] SellproductOrderdate = new DateTimeFormatter[100]; // orderDateandTime giveProduct

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
            DateTimeFormatter[] SellproductOrderdate) {

        this.Aid = Aid;
        this.SellproductId = SellproductId;
        this.SellproductName = SellproductName;
        this.SellproductPrice = SellproductPrice;
        this.SellproductNum = SellproductNum;
        this.SellproductTotal = SellproductTotal;

        this.SellproductCustomername = SellproductCustomername;
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

    public void getSellproductOrderdate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println(formattedDate);
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

    public int getSellproductTotal(String Vname) {
        int SPTotal = 0;
        for (int i = 1; i < Aid.length; i++) {
            if (Vname.equals(SellproductCustomername[i]) == true) {
                SPTotal += SellproductPrice[i] * SellproductNum[i];
            }
        }
        return SPTotal;

    }

    public Boolean getFilterName(String Vname) {
        Boolean Check = false;
        for (int i = 1; i < Aid.length; i++) {
            if (Vname.equals(SellproductCustomername[i]) == true) {
                Check = true;
            }
        }
        return Check;
    }
}
