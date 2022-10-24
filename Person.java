public class Person {
    // Admin_User :0 / Owner_User :1 / Customer_User :10++
    int[] PersonId = { 0, 1, 10 };
    String[] PersonName = { "kan", "ken", "jom" };
    int[] PersonPassword = { 1234, 4567, 9876 };
    String[] PersonTel = { "083xxxxxx", "0845555555", "null" };
    String[] PersonType = { "Admin", "Owner", "Customer" };

    public void setPerson(int PersonId[], String PersonName[], int PersonPassword[],
            String PersonTel[],
            String PersonType[]) {
        this.PersonId = PersonId;
        this.PersonName = PersonName;
        this.PersonPassword = PersonPassword;
        this.PersonTel = PersonTel;
        this.PersonType = PersonType;
    }

    public int getPersonID(int id) {
        int Pid = 0;
        for (int i = 0; i < PersonId.length; i++) {
            if (id == PersonId[i]) {
                Pid = PersonId[i];
            }
        }
        return Pid;
    }

    public String getPersonName(int id) {
        String Pname = "";
        for (int i = 0; i < PersonId.length; i++) {
            if (id == PersonId[i]) {
                Pname = PersonName[i];
            }
        }
        return Pname;
    }

    public int getPersonPassword(int id) {
        int PPass = 0;
        for (int i = 0; i < PersonId.length; i++) {
            if (id == PersonId[i]) {
                PPass = PersonPassword[i];
            }
        }
        return PPass;
    }

    public String getPersonTel(int id) {
        String PTel = "";
        for (int i = 0; i < PersonId.length; i++) {
            if (id == PersonId[i]) {
                PTel = PersonTel[i];
            }
        }
        return PTel;
    }

    public String getPersonType(int id) {
        String PType = "";
        for (int i = 0; i < PersonId.length; i++) {
            if (id == PersonId[i]) {
                PType = PersonType[i];
            }
        }
        return PType;
    }

    public int getid(String name) {
        int Pid = 0;
        for (int i = 0; i < PersonId.length; i++) {
            if (name.equals(PersonName[i]) == true) {
                Pid = PersonId[i];
            }
        }
        return Pid;
    }

    public String getTel(int pass) {
        String PTel = "";
        for (int i = 0; i < PersonId.length; i++) {
            if (pass == PersonPassword[i]) {
                PTel = PersonTel[i];
            }
        }
        return PTel;
    }

    public String getDetailUser() {
        String PUser = "";
        for (int i = 0; i < PersonId.length; i++) {
            PUser = "User ID : " + PersonId[i] + "\nUsername : " + PersonName[i] + "\nPassword : "
                    + PersonPassword[i] + "\nTel : " + PersonTel[i] + "\nStatus type : " + PersonType[i];
            System.out.println(PUser);
            System.out.println("+----------------------------------+");
        }
        return PUser;
    }

}
