public class Owner extends Person {
    /*
     * public void getOwner(int[] PersonId, String[] PersonName, int[]
     * PersonPassword, String[] PersonTel,
     * String[] PersonType) {
     * super(PersonId, PersonName, PersonPassword, PersonTel, PersonType);
     * }
     */
    public Boolean getCheckName(String Ownername, int Ownerpass) {
        Boolean Check = false;
        for (int i = 0; i < PersonId.length; i++) {
            if (Ownername.equals(PersonName[i]) == true) {
                if (Ownerpass == PersonPassword[i]) {
                    if (PersonType[i] == "Owner") {
                        Check = true;
                    }
                }

            }
        }
        return Check;
    }
}
