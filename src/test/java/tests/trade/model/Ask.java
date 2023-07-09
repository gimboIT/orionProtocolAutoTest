package tests.trade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ask {
    private double price;
    private double amount;
    private List<String> exchanges;
    private List<Path> path;
}
