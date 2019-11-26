package com.worldhosteling.go.persistance_test;

import com.worldhosteling.go.WorldhostelingApplication;
import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.Hostel;
import com.worldhosteling.go.domain.Person;
import com.worldhosteling.go.repository.AccountRepository;
import com.worldhosteling.go.repository.HostelRepository;
import com.worldhosteling.go.repository.PersonRepository;
import com.worldhosteling.go.service.AccountService;
import com.worldhosteling.go.service.HostelService;
import com.worldhosteling.go.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WorldhostelingApplication.class)
public class AccountTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private HostelService hostelService;


//    AccountRepository accountRepository, PersonRepository personRepository, HostelRepository hostelRepository
//        this.accountRepository = accountRepository;
//        this.personRepository = personRepository;
//        this.hostelRepository = hostelRepository;

    public AccountTest() {

    }

    @Test
    public void testAccountRepository() {

        // set main account
        Account account = new Account();
        account.setFirstName("Michael");
        account.setLastName("Rolfe");
        account.setUserName("MRolfe");
        account.setAboutMe("This is my about me!");
        account.setAccountType("Developer Of WorldHosteling");
        account.setBackgroundPicture("This is the background pic to be found in file");
        account.setProfilePicture("This is the profile pic to be found in file");
        account.setPassword("Password");

            // set friends for list
            List<Account> friendsList = new ArrayList<>();
            Account friend1 = new Account();
            friend1.setFirstName("Geraldine");
            friend1.setLastName("Del Rosario");
            friend1.setUserName("GeralDaaaanng");
            friendsList.add(friend1);
            accountRepository.save(friend1);

            Account friend2 = new Account();
            friend2.setFirstName("Bipin");
            friend2.setLastName("Butala");
            friend2.setUserName("BipBip");
            friendsList.add(friend2);
            accountRepository.save(friend2);

            Account friend3 = new Account();
            friend3.setFirstName("Brad");
            friend3.setLastName("Kangaroo");
            friend3.setUserName("BearalRoll");
            friendsList.add(friend3);
            accountRepository.save(friend3);

            account.setFriendList(friendsList);

            // set hostel list
            List<Hostel> hostelList = new ArrayList<>();
            Hostel hostel1 = new Hostel();
            hostel1.setName("New York Hostel");
            hostel1.setCity("New York");
            hostel1.setCountry("USA");
            hostel1.setDescription("This hostel is in New York, New York. So nice they named it twice.");
            hostel1.setBannerImage("Banner Image location");
            hostel1.setLatitude(1.11);
            hostel1.setLongitude(2.22);
            hostel1.setPrice(23.33);
            hostel1.setRating(4);
            hostel1.setRegion("East Coast America");

                // set hostel picture list
                List<String> hostelPicList = new ArrayList<>();
                for (int x = 0; x < 5; x++ ) {
                    hostelPicList.add("hostel Picture: " + x);
                }
                hostel1.setHostelPictureList(hostelPicList);

                // set hostel free list
                List<String> freeList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    freeList.add("free amenity: " + i);
                }
                hostel1.setFreeList(freeList);

                // set hostel general list
                List<String> generalList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    generalList.add("general stuff: " + i);
                }
                hostel1.setGeneralList(generalList);

                // set hostel service list
                List<String> serviceList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    serviceList.add("Service: " + i);
                }
                hostel1.setServicesList(serviceList);

                // set food list
                List<String> foodList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    foodList.add("food/drink item: " + i);
                }
                hostel1.setFoodDrinkList(foodList);

                // set Entertainment list
                List<String> entertainmentList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    entertainmentList.add("entertainment option: " + i);
                }
                hostel1.setEntertainmentList(entertainmentList);
            hostelList.add(hostel1);
        System.out.println(hostel1.toString());
        hostelRepository.save(hostel1);
        account.setHostelList(hostelList);

        // SAVE
        Account savedAccount = accountRepository.save(account);
        Assert.assertNotNull(savedAccount.getId());

        // GET
        Optional<Account> foundAccount = accountRepository.findById(account.getId());
        Assert.assertNotNull(foundAccount);
        System.out.println(foundAccount);

        Iterable<Account> foundAccountBy =  accountRepository.findAll();
        System.out.println(foundAccountBy);

        // UPDATE
        savedAccount.setUserName("MRWhom");
        Account updatedAccount = accountRepository.save(savedAccount);
        Assert.assertEquals("MRWhom", updatedAccount.getUserName());

        // DELETE
        String idToDelete = updatedAccount.getId();
        Assert.assertNotNull(accountRepository.findById(idToDelete));
        accountRepository.delete(updatedAccount);

        System.out.println(accountRepository.findAll());

    }

    @Test
    public void testAccountService() {

        // set main account
        Account account = new Account();
        account.setFirstName("Michael");
        account.setLastName("Rolfe");
        account.setUserName("MRolfe");
        account.setAboutMe("This is my about me!");
        account.setAccountType("Developer Of WorldHosteling");
        account.setBackgroundPicture("This is the background pic to be found in file");
        account.setProfilePicture("This is the profile pic to be found in file");
        account.setPassword("Password");

            // set friends for list
            List<Account> friendsList = new ArrayList<>();
            Account friend1 = new Account();
            friend1.setFirstName("Geraldine");
            friend1.setLastName("Del Rosario");
            friend1.setUserName("GeralDaaaanng");
            friendsList.add(friend1);
            accountService.saveAccount(friend1);

            Account friend2 = new Account();
            friend2.setFirstName("Bipin");
            friend2.setLastName("Butala");
            friend2.setUserName("BipBip");
            friendsList.add(friend2);
            accountService.saveAccount(friend2);

            Account friend3 = new Account();
            friend3.setFirstName("Brad");
            friend3.setLastName("Kangaroo");
            friend3.setUserName("BearalRoll");
            friendsList.add(friend3);
            accountService.saveAccount(friend3);

            account.setFriendList(friendsList);

            // set hostel list
            List<Hostel> hostelList = new ArrayList<>();
            Hostel hostel1 = new Hostel();
            hostel1.setName("New York Hostel");
            hostel1.setCity("New York");
            hostel1.setCountry("USA");
            hostel1.setDescription("This hostel is in New York, New York. So nice they named it twice.");
            hostel1.setBannerImage("Banner Image location");
            hostel1.setLatitude(1.11);
            hostel1.setLongitude(2.22);
            hostel1.setPrice(23.33);
            hostel1.setRating(4);
            hostel1.setRegion("East Coast America");

                // set hostel picture list
                List<String> hostelPicList = new ArrayList<>();
                for (int x = 0; x < 5; x++ ) {
                    hostelPicList.add("hostel Picture: " + x);
                }
                hostel1.setHostelPictureList(hostelPicList);

                // set hostel free list
                List<String> freeList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    freeList.add("free amenity: " + i);
                }
                hostel1.setFreeList(freeList);

                // set hostel general list
                List<String> generalList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    generalList.add("general stuff: " + i);
                }
                hostel1.setGeneralList(generalList);

                // set hostel service list
                List<String> serviceList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    serviceList.add("Service: " + i);
                }
                hostel1.setServicesList(serviceList);

                // set food list
                List<String> foodList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    foodList.add("food/drink item: " + i);
                }
                hostel1.setFoodDrinkList(foodList);

                // set Entertainment list
                List<String> entertainmentList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    entertainmentList.add("entertainment option: " + i);
                }
                hostel1.setEntertainmentList(entertainmentList);

            System.out.println(hostel1.toString());
        hostelService.saveHostel(hostel1);
        hostelList.add(hostel1);
        System.out.println(hostel1.toString());
        account.setHostelList(hostelList);

        // SAVE
        Account savedAccount = accountService.saveAccount(account);
        System.out.println(account.toString());
        Assert.assertNotNull(savedAccount.getId());

        // GET
        Optional<Account> foundAccount = accountService.findAccountById(account.getId());
        Assert.assertNotNull(foundAccount);
        System.out.println(foundAccount);

        Iterable<Account> foundAccountBy =  accountRepository.findAll();
        System.out.println(foundAccountBy);

        // UPDATE
        savedAccount.setUserName("MRWhom");
        Account updatedAccount = accountService.saveAccount(savedAccount);
        Assert.assertEquals("MRWhom", updatedAccount.getUserName());

        // DELETE
        String idToDelete = updatedAccount.getId();
        Assert.assertNotNull(accountService.findAccountById(idToDelete));
        accountService.deleteAccount(updatedAccount);

        System.out.println(accountService.findAllAccounts());

    }

}