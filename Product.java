public class Product {
    int[] ProductId = { 1, 2 }; // NO Null
    String[] ProductName = { "Cake", "Tea" };
    int[] ProductPrice = { 120, 30 };
    String[] ProductDeTail = { "Good ", "Hot" };

    public void setProduct(int[] ProductId, String[] ProductName, int[] ProductPrice, String[] ProductDeTail) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.ProductDeTail = ProductDeTail;

    }

    public int getProductId(int pid) {
        int Proid = 0;
        for (int i = 0; i < ProductId.length; i++) {
            if (pid == ProductId[i]) {
                Proid = ProductId[i];
            }
        }
        return Proid;
    }

    public String getProductName(int pid) {
        String ProName = "";
        for (int i = 0; i < ProductId.length; i++) {
            if (pid == ProductId[i]) {
                ProName = ProductName[i];
            }
        }
        return ProName;
    }

    public int getProductPrice(int pid) {
        int ProPrice = 0;
        for (int i = 0; i < ProductId.length; i++) {
            if (pid == ProductId[i]) {
                ProPrice = ProductPrice[i];
            }
        }
        return ProPrice;
    }

    public String getProductDeTail(int pid) {
        String ProDetail = "";
        for (int i = 0; i < ProductId.length; i++) {
            if (pid == ProductId[i]) {
                ProDetail = ProductDeTail[i];
            }
        }
        return ProDetail;
    }

    public String getProductList() {
        String ProList = "";
        for (int i = 0; i < ProductId.length; i++) {
            ProList = "Product Id : " + ProductId[i] + "\nName : " + ProductName[i] + "\nPrice : " + ProductPrice[i]
                    + " Baht" + "\nDetail : " + ProductDeTail[i];
            System.out.println(ProList);
            System.out.println("---------------------------");
        }
        return ProList;
    }
}
