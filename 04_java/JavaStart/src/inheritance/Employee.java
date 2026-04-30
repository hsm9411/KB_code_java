package inheritance;

public class Employee {
    protected String name;
    protected int employeeId;

    public void goToWork(){
        System.out.println(this.name + "님 출근합니다.");
    }

    public void showInfo(){
        System.out.println();
        System.out.println();
    }

}
