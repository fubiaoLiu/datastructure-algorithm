package other.queue;

/**
 * @description: 病人
 * @author: FuBiaoLiu
 * @date: 2020/1/14
 */
public class Patient implements Comparable {
    private String name;
    // 严重程度
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Object o) {
        return severity - ((Patient) o).getSeverity();
    }
}
