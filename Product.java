public class Product {
    int[] ProductId = { 1, 2, 3, 4, 5, 6, 7, 8 }; // NO Null
    String[] ProductName = { "Cookies", "Crispy bread", "Chiffon", "Spring rolls", "Brownies", "Banana cake", "Tea",
            "Coffee" };
    int[] ProductPrice = { 100, 50, 100, 100, 70, 100, 35, 35 };
    String[] ProductDeTail = { "Crispy cookies", "Crispy bread", "Soft chiffon", "Soft spring rolls", "Soft brownies",
            "Soft Banana Cake", "Iced Tea  Hot Tea", "Hot Coffee Iced Coffee" };

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
                    + " Bath" + "\nDetail : " + ProductDeTail[i];
            System.out.println(ProList);
            System.out.println("---------------------------");
        }
        return ProList;
    }
}
