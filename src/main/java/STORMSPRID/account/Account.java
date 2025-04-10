package STORMSPRID.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
    private final long id;
    private final long userId;
    private int balance;
    //


}
