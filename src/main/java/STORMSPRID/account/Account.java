package STORMSPRID.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private final long id;
    private final long userId;
    private int balance;
    //
}
