package ru.croc.task10;

import java.time.LocalDateTime;

/**
 * ЛОТ
 * 
 * @param price - текущую стоимость
 * @param name  - имя пользователя, предложившего ее,
 * @param time  - время окончания торгов по этому лоту.
 * 
 */
public class Lot {

    private volatile int price;
    private volatile String name;
    private LocalDateTime time;

    public Lot(int price, LocalDateTime time) {
        this.price = price;
        this.time = time;
    }

    /*
     * который обновляет текущую стоимость лота
     * и сохраняет предложившего ее пользователя,
     * если торги по лоту еще ведутся по времени и предложенная цена выше текущей.
     */
    public boolean rates(int price, String name) {
        if (time.isAfter(LocalDateTime.now())) {
            if (this.price < price) {
                this.name = name;
                this.price = price;
                System.out.println(LocalDateTime.now() + " Ставка принята от: " + name + " ставка: " + price);
                return true;
            } else {
                System.out.println("rate should be higher ");
                return false;
            }
        } else {
            System.out.println("время вышло");
            return false;
        }
    }

    /*
     * метод получения имени пользователя победителя.
     */
    public String getName() {
        return this.name;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public int getPrice() {
        return this.price;
    }
}
