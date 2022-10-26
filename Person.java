public class Person {
    // Admin_User :0 / Owner_User :1 / Customer_User :10++
    int[] PersonId = { 0, 1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
    String[] PersonName = { "kan", "ken", "jom", "na", "mon", "god", "gas", "fan", "fan", "ten", "lio", "mon", "cin",
            "fit", "jun", "jan", "mo", "zee", "rot", "tan" };
    int[] PersonPassword = { 1234, 4567, 9876, 1122, 1123, 1124, 1235, 1236, 1347, 1358, 1459, 0234, 1238, 1239, 9652,
            1248, 3365, 4562, 2584, 5546 };
    String[] PersonTel = { "083xxxxxx", "0845555555", "0876542139", "0987561234", "0215896437", "0125496358",
            "0654123879", "0235468549", "0365986234", "0154254258", "0326541879", "0154268379", "0178956231",
            "0203014588", "0909506428", "0912056400", "0584685129", "0909090505", "0121015035", "0845909040",
            "0906060408", "null" };
    String[] PersonType = { "Admin", "Owner", "Customer", "Customer", "Customer", "Customer", "Customer", "Customer",
            "Customer", "Customer", "Customer", "Customer", "Customer", "Customer", "Customer", "Customer", "Customer",
            "Customer", "Customer", "Customer" };

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
