package com.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletionService {
    @Autowired
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    DeletionService(AccountRepository accountRepository,UserRepository userRepository){
        this.accountRepository=accountRepository;
        this.userRepository=userRepository;
    }

    public String deleteUserById(int id){
        if(userRepository.getUsers().containsKey(id)){
            User user=userRepository.getUserById(id);
            for(Account acc:user.getAccountList()){
                boolean temp=accountRepository.deleteAccount(acc.getAccId());
                //optional(lambda function):
                //user.getAccountsList().forEach(acc -> accRepo.deleteAcc(acc.getAccId()));
                // lambda function can ignore return type
            }
            boolean temp= userRepository.deleteUser(id);
            return "Successfully deleted user.";
        }
        return "User deletion failed!";
    }
    public String deleteAccountById(int id){
        if(accountRepository.getAccountList().containsKey(id)){
            Account account=accountRepository.getAccountList().get(id);
            User user=userRepository.getUserById(account.getUserId());
            for(Account acc:user.getAccountList()){
                if(acc.getAccId()==id){
                    user.getAccountList().remove(acc);
                    break;
                }
            }
            for(Account acc:user.getWatchList()){
                if(acc.getAccId()==id){
                    user.getWatchList().remove(acc);
                    break;
                }
            }
            // above code can give ConcurrentException with iteration,so use lambda function:
            // u.getAccountList().removeIf(a->a.getAccId()==id);
            // or you can use for-index loop i.e,. for(int i=0;i..) but after deleting do i--; so that we cant next index
            boolean temp=accountRepository.deleteAccount(id);
            return "Account deleted successfully.";
        }
        return "Account deletion failed!";
    }
}
