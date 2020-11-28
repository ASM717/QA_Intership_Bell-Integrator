package api.data;

public class DateYears {
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;

    public DateYears() {
        super();
    }

    public DateYears(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public String getPantone_value() {
        return pantone_value;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }
}
