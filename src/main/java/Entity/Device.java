package Entity;

public class Device {

  private String name;
  private String value;

    public Device(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Device(Object value, Object name) {
        this.name = this.value.toString();
        this.value = this.value.toString();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
