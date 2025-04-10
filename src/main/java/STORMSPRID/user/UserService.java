package STORMSPRID.user;

import STORMSPRID.account.Account;
import STORMSPRID.account.AccountService;

import java.util.*;

public class UserService {
    private final AccountService accountService;
    private final Map<Long,User> userMap;
    private int idCounter;
    private final Set<String> takenLogins;

    public UserService(AccountService accountService) {
        this.accountService = accountService;
        this.userMap = new HashMap<>();
        this.idCounter=0;
        this.takenLogins = new HashSet<>();
    }

    public User createUser(String login){
        if (takenLogins.contains(login)){
            throw new IllegalArgumentException("This user Already exist");
        }

        takenLogins.add(login);
        idCounter++;


        User newUser = new User(idCounter,login,new ArrayList<>());
        var newAccount = accountService.createAccount(newUser);
        newUser.getAccountList().add(newAccount);

        userMap.put(newUser.getId(),newUser);
        return newUser;
    }

    public Optional<User> findUserById(long id){
        return Optional.ofNullable(userMap.get(id));
    }
    public List<User> getAllUsers(){
        return userMap.values().stream().toList();
    }

}
