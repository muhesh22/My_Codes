public class passenger {
    String name;
    int age;
    static int id = 1000;
    String BerthPreference;
    int PNR;
    String Alloted;
    int SeatNumber;
    public passenger(String name, int age,  String BerthPreference){
        this.name = name;
        this.age = age;
        this.BerthPreference = BerthPreference;
        this.PNR=id++;
        Alloted = "";
        SeatNumber = -1;
    }
}
