package B_Java_Fundamentals.F_ObjectsAndClasses.L04_Songs;

public class Songs {

    private String typeList;
    private String name;
    private String time;

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Songs(String typeList, String name, String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }
}