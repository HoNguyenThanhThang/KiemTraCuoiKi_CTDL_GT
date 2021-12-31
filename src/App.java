import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    private static LinkedList<Product> product = new LinkedList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        create_data();
        while (true) {
            try {
                System.out.println("\n===   MENU   ===\n");
                System.out.println("1 : Xem san pham");
                System.out.println("2 : Them san pham");
                System.out.println("3 : Sua san pham");
                System.out.println("4 : Xoa san pham");
                System.out.println("5 : Tim san pham");
                System.out.println("6 : Sap xep san pham");
                System.out.println("7 : Thong ke san pham");
                System.out.println("Khac : Dung chuong trinh");
                System.out.print("\nChon chuc nang : ");

                int select = scanner.nextInt();

                switch (select) {
                    case 1:
                        view_product();
                        break;
                    case 2:
                        create_product();
                        break;
                    case 3:
                        edit_product();
                        break;
                    case 4:
                        delete_product();
                        break;
                    case 5:
                        search_product();
                        break;
                    case 6:
                        sort_product();
                        break;
                    case 7:
                        statistical_product();
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
            }
        }
    }

    // START CREATE DATA PRODUCT

    public static void create_data() {
        product.addLast(new Product(0, 0, "Banh Gao One One", 21000, 200, convert_string_to_date("10-10-2021")));
        product.addLast(new Product(1, 0, "Banh Sandwich", 10000, 100, convert_string_to_date("11-10-2021")));
        product.addLast(new Product(2, 0, "Banh Chocopie", 34000, 500, convert_string_to_date("10-09-2021")));
        product.addLast(new Product(3, 0, "Banh Cosy", 21000, 200, convert_string_to_date("05-10-2021")));
        product.addLast(new Product(4, 0, "Banh Danisa", 30000, 300, convert_string_to_date("12-11-2021")));
        product.addLast(new Product(5, 0, "Banh Gao Ichi", 20000, 350, convert_string_to_date("21-10-2021")));
        product.addLast(new Product(6, 0, "Sua Dutch Lady", 3500, 1000, convert_string_to_date("11-04-2021")));
        product.addLast(new Product(7, 0, "Sua TH True Milk", 25000, 1000, convert_string_to_date("10-05-2021")));
        product.addLast(new Product(8, 1, "Lo hoa", 100000, 100, convert_string_to_date("10-07-2021")));
        product.addLast(new Product(9, 1, "Gat tan thuoc la", 50000, 100, convert_string_to_date("10-09-2021")));
        product.addLast(new Product(10, 1, "Guong co nho", 15000, 250, convert_string_to_date("10-10-2020")));
        product.addLast(new Product(11, 1, "Guong co vua", 45000, 200, convert_string_to_date("10-11-2021")));
        product.addLast(new Product(12, 1, "Bo bat thuy tinh", 200000, 100, convert_string_to_date("05-01-2021")));
        product.addLast(new Product(13, 1, "Coc thuy tinh", 20000, 100, convert_string_to_date("21-11-2021")));
        product.addLast(new Product(14, 2, "Quat dien co nho", 300000, 100, convert_string_to_date("22-02-2021")));
        product.addLast(new Product(15, 2, "Quat dien cay", 1250000, 100, convert_string_to_date("12-02-2021")));
        product.addLast(new Product(16, 2, "Quat dien mini", 190000, 200, convert_string_to_date("15-12-2021")));
        product.addLast(new Product(17, 2, "Noi com dien Cuckoo", 3390000, 150, convert_string_to_date("14-07-2021")));
        product.addLast(new Product(18, 2, "Noi chien khong dau Camel", 1450000, 100, convert_string_to_date("16-10-2021")));
        product.addLast(new Product(19, 2, "Lo vi song Panasonic", 2650000, 100, convert_string_to_date("09-11-2021")));
        product.addLast(new Product(20, 2, "Tu lanh LG", 37510000, 100, convert_string_to_date("12-12-2021")));
    }

    // END CREATE DATA PRODUCT

    // START FUNCTION VIEW PRODUCT

    public static void view_product() {
        if (product.size() == 0){
            System.out.println("\n>> Chua co san pham nao !");
            return;
        }

        System.out.println("\n===   DANH SACH SAN PHAM   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");
        for (Product product2 : product) {
            System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
        }
    }

    public static void view_product_by_id(int id) {
        if (product.size() == 0){
            System.out.println("\n>> Chua co san pham nao !");
            return;
        }

        System.out.println("\n===   SAN PHAM DA CHON   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");
        for (Product product2 : product) {
            if (product2.get_id() == id)
                System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
        }
    }
   
    // END FUNCTION VIEW PRODUCT

    // START FUNCTION CREATE PRODUCT

    public static void create_product(){
        try {
            System.out.println("\n\n===   BAT DAU THEM SAN PHAM   ===\n");
            scanner.nextLine();
            System.out.print("Nhap ten san pham : ");
            String name = scanner.nextLine();

            System.out.print("Nhap loai san pham ( 0 : Thuc pham - 1 : Sanh su - 2 : Dien may) : ");
            int type = scanner.nextInt();

            System.out.print("Nhap gia : ");
            long price = scanner.nextLong();

            System.out.print("Nhap so luong : ");
            int quantity = scanner.nextInt();

            scanner.nextLine();
            System.out.print("Nhap ngay nhap kho (dd-MM-yyyy): ");
            String buy_date = scanner.nextLine();

            if (!isDate(buy_date)){
                System.out.print("\n>> Dinh dang ngay sai. Vui long thu lai !");
                return;
            }

            int id = product.size();
            Product tempProduct = new Product(id, type, name, price, quantity, convert_string_to_date(buy_date));

            product.addLast(tempProduct);

            System.out.println("\n===   Da tao san pham    ===\nMa san pham : "+product.getLast().get_id()+"\nTen san pham : "+product.getLast().get_name()+"\nLoai san pham : "+product.getLast().get_name_type()+"\nGia nhap : "+product.getLast().get_price()+"\nSo luong : "+product.getLast().get_quantity()+"\nNgay nhap kho : "+product.getLast().get_string_from_buy_date()+"\n>> Tong gia : "+product.getLast().get_total_price()+"\n");
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    // END FUNCTION CREATE PRODUCT
    
    // START FUNCTION EDIT PRODUCT

    public static void edit_product() {
        try {
            view_product();
            System.out.print("\n>> Nhap ma san phan can sua : ");
            int num = scanner.nextInt();
            
            if (!search_product_by_id(num)){
                System.out.println("\n>> Khong tim thay san pham nay\n");
                return;
            }
            while (true) {
                try {
                    view_product_by_id(num);
                    System.out.print("\n\t1 : Sua ten");
                    System.out.print("\n\t2 : Sua loai san pham");
                    System.out.print("\n\t3 : Sua gia");
                    System.out.print("\n\t4 : Sua so luong");
                    System.out.print("\n\t5 : Sua ngay nhap kho");
                    System.out.print("\n\tKhac : Thoat");

                    System.out.print("\n\tChon chuc nang : ");
                    int select = scanner.nextInt();

                    Product tempProduct = get_product_by_id(num);

                    switch (select) {
                        case 1:
                            edit_name_product(tempProduct);
                            break;
                        case 2:
                            edit_type_product(tempProduct);
                            break;
                        case 3:
                            edit_price_product(tempProduct);
                            break;
                        case 4:
                            edit_quantity_product(tempProduct);
                            break;
                        case 5:
                            edit_buy_date_product(tempProduct);
                            break;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
                }
            }

        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void edit_name_product(Product param) {
        try {
            System.out.print("\nNhap ten moi cua san pham : ");
            scanner.nextLine();
            String name = scanner.nextLine();

            param.set_name(name);
            System.out.println("\n>> Da doi ten san pham thanh "+name+" !");
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void edit_type_product(Product param) {
        try {
            System.out.print("\nNhap loai moi cua san pham ( 0 : Thuc pham - 1 : Sanh su - 2 : Dien may) : ");
            int type = scanner.nextInt();
            if (type < 0 || type > 2)
            {
                System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
                return;
            }
            param.set_type(type);
            System.out.println("\n>> Da doi loai san pham thanh "+param.get_name_type()+" !");
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void edit_price_product(Product param) {
        try {
            System.out.print("\nNhap gia moi cua san pham : ");
            long price = scanner.nextLong();

            param.set_price(price);
            System.out.println("\n>> Da doi gia san pham thanh "+param.get_price()+" !");
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void edit_quantity_product(Product param) {
        try {
            System.out.print("\nNhap so luong moi cua san pham : ");
            int quantity = scanner.nextInt();

            param.set_quantity(quantity);
            System.out.println("\n>> Da doi so luong san pham thanh "+param.get_quantity()+" !");
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void edit_buy_date_product(Product param) {
        try {
            System.out.print("\nNhap ngay nhap kho moi cua san pham : ");
            scanner.nextLine();
            String buy_date = scanner.nextLine();

            if (!isDate(buy_date)){
                System.out.print("\n>> Dinh dang ngay sai. Vui long thu lai !");
                return;
            }

            param.set_buy_date(convert_string_to_date(buy_date));

            System.out.println("\n>> Da doi gia san pham thanh "+param.get_string_from_buy_date()+" !");
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    // END FUNCTION EDIT PRODUCT

    // START FUNCTION DELETE PRODUCT

    public static void delete_product() {
        try {
            view_product();
            System.out.print("\n>> Nhap ma san phan can xoa : ");
            int num = scanner.nextInt();
            for (Product product2 : product) {
                if (num == product2.get_id())
                {
                    product.remove(product2);
                    System.out.println("\n>> Da xoa san pham ID = "+num+" !");
                    return;
                }
            }
            System.out.println("\n>> Khong tim thay san pham !");
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    // END FUNCTION DELETE PRODUCT

    // START FUNCTION SEARCH PRODUCT

    public static void search_product() {
        try {
            while (true) {
                try {
                    System.out.print("\n===   TIM KIEM SAN PHAM   ===");
                    System.out.print("\n\t1 : Loai thuc pham");
                    System.out.print("\n\t2 : Loai sanh su");
                    System.out.print("\n\t3 : Loai dien may");
                    System.out.print("\n\t4 : Theo gia");
                    System.out.print("\n\t5 : Theo ngay");
                    System.out.print("\n\tKhac : Thoat");

                    System.out.print("\n\tChon chuc nang : ");
                    int select = scanner.nextInt();

                    switch (select) {
                        case 1:
                            search_product_by_type(0);
                            break;
                        case 2:
                            search_product_by_type(1);
                            break;
                        case 3:
                            search_product_by_type(2);
                            break;
                        case 4:
                            search_product_by_price();
                            break;
                        case 5:
                            search_product_by_buy_date();
                            break;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
                }
            }
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void search_product_by_type(int type) {
        System.out.println("\n===   SAN PHAM DA CHON   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");

        for (Product product2 : product) {
            if (product2.get_type() == type)
                System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
        }
    }

    public static void search_product_by_price() {
        try {
            System.out.print("\nNhap gia thu nhat : ");
            long param1 = scanner.nextLong();
            System.out.print("\nNhap gia thu hai : ");
            long param2 = scanner.nextLong();

            if (param1 > param2)
            {
                long temp = param1;
                param1 = param2;
                param2 = temp;
            }

            System.out.println("\n===   SAN PHAM DA CHON   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");

            for (Product product2 : product) {
                if (product2.get_price() >= param1 && product2.get_price() <= param2)
                    System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
            }
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void search_product_by_buy_date() {
        try {
            System.out.print("\nNhap ngay thu nhat : ");
            scanner.nextLine();
            String date1 = scanner.nextLine();

            if (!isDate(date1)){
                System.out.print("\n>> Dinh dang ngay sai. Vui long thu lai !");
                return;
            }

            System.out.print("\nNhap ngay thu hai : ");
            String date2 = scanner.nextLine();

            if (!isDate(date2)){
                System.out.print("\n>> Dinh dang ngay sai. Vui long thu lai !");
                return;
            }

            LocalDate param1 =  convert_string_to_date(date1);
            LocalDate param2 =  convert_string_to_date(date2);

            if (param1.isAfter(param2))
            {
                LocalDate temp = param1;
                param1 = param2;
                param2 = temp;
            }

            System.out.println("\n===   SAN PHAM DA CHON   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");

            for (Product product2 : product) {
                if ((product2.get_buy_date().isEqual(param1) || product2.get_buy_date().isAfter(param1)) && (product2.get_buy_date().isEqual(param2) || product2.get_buy_date().isBefore(param2)))
                    System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
            }
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }
    
    public static boolean search_product_by_id(int id) {
        for (Product product2 : product) {
            if (product2.get_id() == id)
                return true;
        }
        return false;
    }
 
    // END FUNCTION SEARCH PRODUCT

    // START FUNCTION FIND PRODUCT

    public static void sort_product() {
        try {
            System.out.print("\n===   SAP XEP SAN PHAM   ===");
            System.out.print("\n\t1 : Theo gia");
            System.out.print("\n\t2 : Theo ngay nhap kho");
            System.out.print("\n\tKhac : Thoat");

            System.out.print("\n\tChon chuc nang : ");
            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    sort_product_price();
                    break;
                case 2:
                    sort_product_buy_date();
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void sort_product_price() {
        try {
            System.out.print("\n===   SAP XEP SAN PHAM THEO GIA  ===");
            System.out.print("\n\t1 : Tang dan");
            System.out.print("\n\t2 : Giam dan");
            System.out.print("\n\tKhac : Thoat");

            System.out.print("\n\tChon chuc nang : ");
            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    sort_product_price_asc();
                    break;
                case 2:
                    sort_product_price_dec();
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void sort_product_price_asc() {
        LinkedList<Product> tempLinkedList = product;

        for (int i = 0; i < tempLinkedList.size()-1; i++) {
            for (int j = 0; j < tempLinkedList.size(); j++) {
                if (tempLinkedList.get(i).get_price() < tempLinkedList.get(j).get_price()){
                    Product tempProduct = tempLinkedList.get(i);
                    tempLinkedList.set(i,tempLinkedList.get(j));
                    tempLinkedList.set(j, tempProduct);
                }
            }
        }

        System.out.println("\n===   SAP XEP TANG DAN   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");
        for (Product product2 : tempLinkedList) {
            System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
        }
    }

    public static void sort_product_price_dec() {
        LinkedList<Product> tempLinkedList = product;

        for (int i = 0; i < tempLinkedList.size()-1; i++) {
            for (int j = 0; j < tempLinkedList.size(); j++) {
                if (tempLinkedList.get(i).get_price() > tempLinkedList.get(j).get_price()){
                    Product tempProduct = tempLinkedList.get(i);
                    tempLinkedList.set(i,tempLinkedList.get(j));
                    tempLinkedList.set(j, tempProduct);
                }
            }
        }

        System.out.println("\n===   SAP XEP GIAM DAN   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");
        for (Product product2 : tempLinkedList) {
            System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
        }
    }

    public static void sort_product_buy_date() {
        try {
            System.out.print("\n===   SAP XEP SAN PHAM THEO NGAY NHAP KHO  ===");
            System.out.print("\n\t1 : Tang dan");
            System.out.print("\n\t2 : Giam dan");
            System.out.print("\n\tKhac : Thoat");

            System.out.print("\n\tChon chuc nang : ");
            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    sort_product_buy_date_asc();
                    break;
                case 2:
                    sort_product_buy_date_dec();
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            System.out.println("\n>> Nhap sai dinh dang. Vui long thu lai !");
        }
    }

    public static void sort_product_buy_date_asc() {
        LinkedList<Product> tempLinkedList = product;

        for (int i = 0; i < tempLinkedList.size()-1; i++) {
            for (int j = 0; j < tempLinkedList.size(); j++) {
                if (tempLinkedList.get(i).get_buy_date().isBefore(tempLinkedList.get(j).get_buy_date())){
                    Product tempProduct = tempLinkedList.get(i);
                    tempLinkedList.set(i,tempLinkedList.get(j));
                    tempLinkedList.set(j, tempProduct);
                }
            }
        }

        System.out.println("\n===   SAP XEP TANG DAN   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");
        for (Product product2 : tempLinkedList) {
            System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
        }
    }

    public static void sort_product_buy_date_dec() {
        LinkedList<Product> tempLinkedList = product;

        for (int i = 0; i < tempLinkedList.size()-1; i++) {
            for (int j = 0; j < tempLinkedList.size(); j++) {
                if (tempLinkedList.get(i).get_buy_date().isAfter(tempLinkedList.get(j).get_buy_date())){
                    Product tempProduct = tempLinkedList.get(i);
                    tempLinkedList.set(i,tempLinkedList.get(j));
                    tempLinkedList.set(j, tempProduct);
                }
            }
        }

        System.out.println("\n===   SAP XEP GIAM DAN   ===\nMa SP\tTen SP\tLoai SP\tGia SP\tSo luong\tNgay nhap kho\tTong gia tien\n");
        for (Product product2 : tempLinkedList) {
            System.out.print(product2.get_id()+"\t"+product2.get_name()+"\t"+product2.get_name_type()+"\t"+product2.get_price()+"\t"+product2.get_quantity()+"\t"+product2.get_string_from_buy_date()+"\t"+product2.get_total_price()+"\n");
        }
    }

    // END FUNCTION FIND PRODUCT

    // START FUNCITON STATISTICAL PRODUCT

    public static void statistical_product() {
        long total_price = 0;
        int total_quantity = 0;
        int num_1 = 0;
        int num_2 = 0;
        int num_3 = 0;

        for (Product product2 : product) {
            total_price += product2.get_total_price();
            total_quantity += product2.get_quantity();
            if (product2.get_type() == 0)
                num_1++;
            else if (product2.get_type() == 1)
                num_2++;
            else num_3++;
        }

        System.out.println("\n===   THONG KE SAN PHAM   ===\n");
        System.out.println("Tong so luong : "+total_quantity);
        System.out.println("Tong gia tri nhap kho : "+total_price);
        System.out.println("Tong so luong loai thuc pham : "+num_1);
        System.out.println("Tong so luong loai sanh su : "+num_2);
        System.out.println("Tong so luong loai dien may : "+num_3);
    }

    // END FUNCITON STATISTICAL PRODUCT

    public static boolean isDate(String paramString){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        LocalDate date = LocalDate.parse(paramString, formatter);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static LocalDate convert_string_to_date(String paramString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(paramString, formatter);
    }

    public static Product get_product_by_id(int id) {
        Product tempProduct = product.getFirst();
        for (Product product2 : product) {
            if (product2.get_id() == id)
                tempProduct = product2;
        }
        return tempProduct;
    }
}