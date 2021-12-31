import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private int type;
    private int id;
    private String name;
    private long price;
    private int quantity;
    private LocalDate buy_date;

    public Product(int id, int type, String name, long price, int quantity, LocalDate buy_date){
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }
    
    // START FUNCTION GET DATA

    public int get_id() {
        return this.id;
    }

    public int get_type() {
        return this.type;
    }

    public String get_name() {
        return this.name;
    }

    public long get_price() {
        return this.price;
    }

    public int get_quantity() {
        return this.quantity;
    }

    public LocalDate get_buy_date() {
        return this.buy_date;
    }

    public String get_name_type() {
        if (this.type == 0)
            return "Thuc pham";
        if (this.type == 1)
            return "Sanh su";
        return "Dien may";
    }

    public long get_total_price(){
        return this.quantity * this.price;
    }

    public String get_string_from_buy_date() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.buy_date.format(dateFormatter);
    }

    // END FUNCTION GET DATA

    // START FUNCTION SET DATA

    public void set_type(int type) {
        this.type = type;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_price(long price) {
        this.price = price;
    }

    public void set_quantity(int quantity) {
        this.quantity = quantity;
    }

    public void set_buy_date(LocalDate buy_date) {
        this.buy_date = buy_date;
    }

    // END FUNCTION SET DATA

}
