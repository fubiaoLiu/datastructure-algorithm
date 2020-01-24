package datastructure.unionfind;

public class Country {
    private int code;
    private String name;

    public Country(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return code * 31 + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        Country o = (Country) obj;
        return code == o.code && name.equals(o.name);
    }
}
