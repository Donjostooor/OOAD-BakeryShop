public class Customer extends Person {
    /*
     * public getCustomer(int[] PersonId, String[] PersonName, int[] PersonPassword,
     * String[] PersonTel,
     * String[] PersonType) {
     * super(PersonId, PersonName, PersonPassword, PersonTel, PersonType);
     * }
     */
    public Boolean getCheckName(String Cname, int Cpass) {
        Boolean Check = false;
        for (int i = 0; i < PersonId.length; i++) {
            if (Cname.equals(PersonName[i]) == true) {
                if (Cpass == PersonPassword[i]) {
                    if (PersonType[i] == "Customer") {
                        Check = true;
                    }
                }
            }
        }
        return Check;
    }

}
