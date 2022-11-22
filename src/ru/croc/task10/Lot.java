package ru.croc.task10;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.imageio.IIOException;

/**
 * ЛОТ
 * 
 * @param price - текущую стоимость
 * @param name  - имя пользователя, предложившего ее,
 * @param time  - время окончания торгов по этому лоту.
 * 
 */
public class Lot {

    private int price;
    private String name;
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
    public void rates(int price, String name) throws IIOException {
        if(this.price<price){
            this.name = name;
            this.price = price;
        } else throw new IIOException("rate should be higher ");
            
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
}
